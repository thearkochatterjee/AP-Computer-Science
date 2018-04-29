import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import org.masonacm.actorwars.*;
import org.masonacm.actorwars.Action;

import java.util.ArrayList;
import java.util.Random;

public class newarko extends Peon{
    private ArrayList<Location> arrpath = new ArrayList<Location>();
    private ArrayList<Class> arrattackorder = new ArrayList<Class>();
    private ArrayList<Class> arrsearch = new ArrayList<Class>();
    private ArrayList<Integer> arrhealth = new ArrayList<Integer>();
    private int i = 0;
    private int age = 0;
    private Location shelter = null;

    public  newarko(){
        super();
        age = 0;
        arrattackorder.add(Wheat.class);
        arrattackorder.add(Tree.class);
        arrattackorder.add(Peon.class);
        arrhealth.add(4);
        arrhealth.add(10);
        arrhealth.add(50);
        arrhealth.add(50);
        arrhealth.add(20);
    }

    @Override
    public void peonAct() {
        try{
            age++;
            if(hasdesire(Wheat.class) && desirecount(Wheat.class) > 1) {
                hunt(Wheat.class);
            }
            else if(hasdesire(Tree.class) && desirecount(Tree.class) > 1 && getItemCount(Wood.class) < 4 && !hastool(Axe.class)){
                hunt(Tree.class);
                craftitem(Axe.class);
            }
            else if(hasdesire(Tree.class) && desirecount(Tree.class) > 1 && getItemCount(Wood.class) < 4 && hastool(Axe.class) && getItemCount(Fence.class) < 9 && shelter == null){
                toolhunt(Tree.class,Axe.class);
                craftitem(Fence.class);
            }
            else{
                createshelter();
            }
            showstats();
        }
        catch (Exception e){

        }
    }

    private boolean cancreatebarrier(){
        return getItemCount(Fence.class) < 8;
    }

    private boolean barrierbroken(){
        return getGrid().getEmptyAdjacentLocations(getLocation()).size() != 0;
    }

    private void createshelter(){
        if(shelter == null) {
            shelter = getLocation();
        }
        for(Location l: getGrid().getEmptyAdjacentLocations(getLocation())){
            setDirection(LocationFinder.directionTo(getLocation(),l));
            myactions.add(Action.place(Fence.class));
        }
    }

    public int fencecount(){
        return getItemCount(Fence.class);
    }

    public int woodcount(){
        return getItemCount(Wood.class);
    }

    public int treecount(){
        return getItemCount(Tree.class);
    }

    public int rockcount(){
        return getItemCount(Rock.class);
    }

    public int ironcount(){
        return getItemCount(Iron.class);
    }

    public int holycount(){
        return getItemCount(HolyPin.class);
    }

    public int wheatcount(){
        return getItemCount(Wheat.class);
    }

    public boolean hastool(Class<?> e){
        return getItemCount(e) > 0;
    }

    public boolean haspickaxe(){
        return hastool(Pickaxe.class);
    }

    private void craftitem(Class<?> e){
        if(e.getName().equals(Fence.class.getName()) && canCraft(e)){
            myactions.add(Action.craft(e));
        }
        else if(getItemCount(e) == 0 && canCraft(e)){
            myactions.add(Action.craft(e));
        }
    }

    private void showstats(){
        System.out.println("Health: " + getHealth() + " , Energy: " + getEnergy() + " , Age: " + age + " , Arko");
    }

    private void toolhunt(Class<?> e, Class<?> t){
        if(hasdesire(e) && (desirecount(e) > 1) && getItemCount(t) > 0) {
            movetoclosest(e);
            if(closeto(e)) {
                face(e);
                if (isFacing(e)) {
                    myactions.clear();
                    myactions.add(Action.use(t));
                }
            }
            survive();
        }
    }

    private void hunt(Class<?> e){
        if(hasdesire(e) && (desirecount(e) > 1)) {
            movetoclosest(e);
            if(closeto(e)) {
                face(e);
                if (isFacing(e)) {
                    attack(e);
                }
            }
            survive();
        }
        else{
            i++;
        }
    }

    private int healthnumber(Class<?> e){
        if(e.getName() == Wheat.class.getName()){
            return 0;
        }
        else if(e.getName() == Tree.class.getName()){
            return 1;
        }
        else if(e.getName() == Rock.class.getName()){
            return 2;
        }
        else if(e.getName() == Iron.class.getName()){
            return 3;
        }
        else {
            return 4;
        }
    }

    private int desirecount(Class<?> e){
        int c = 0;
        for(Location l: getGrid().getOccupiedLocations()){
            if(e.isInstance(getGrid().get(l))){
                c++;
            }
        }
        return c;
    }

    private void removefacing(){
        getGrid().remove(getFacing().getLocation());
    }

    private boolean hasdesire(Class<?> e){
        for(Location l: getGrid().getOccupiedLocations()){
            if(e.isInstance(getGrid().get(l))){
                return true;
            }
        }
        return false;
    }

    private void attack(Class<?> e){
        if(e.getName() == getFacing().getClass().getName()){
            myactions.add(Action.attackEP(energyneeded(arrhealth.get(healthnumber(e)))));
        }
        else{
            avoidclass(getFacing().getClass());
        }
    }

    private int energyneeded(int health){
        return (int)(Math.pow(health + 2, 2) - 4);
    }

    private void avoidclass(Class<?> e){
        ArrayList<Location> possible = getGrid().getEmptyAdjacentLocations(getLocation());
        Random r = new Random();
        setDirection(LocationFinder.directionTo(getLocation(),possible.get(r.nextInt(possible.size()))));
        move();
    }

    private void movetoclosest(Class<?> e){
        if(!closeto(e)) {
            myactions.add(moveToGradual(LocationFinder.findClosestInstanceDynamicLocation(getDynamicLocation(), e, getGrid())));
        }
        else {
            myactions.clear();
        }
    }

    private boolean energylow(){
        return getEnergy() < 30;
    }

    private boolean healthlow(){
        return getHealth() < 7;
    }

    private void survive(){
        if(healthlow()){
            myactions.clear();
            myactions.add(Action.healSelfHP(10));
        }
        if(energylow()){
            if(getItemCount(Wheat.class) > 0){
                myactions.clear();
                myactions.add(Action.use(Wheat.class));
            }
        }
        if(excesswheat()){
            myactions.clear();
            myactions.add(Action.use(Wheat.class));
        }
        if(excessenergy()){
            myactions.clear();
            myactions.add(Action.spawn(this.getClass()));
        }
    }

    private boolean excesswheat(){
        return getItemCount(Wheat.class) > 10;
    }

    private boolean excessenergy(){
        return getEnergy() > 700;
    }

    private void eatclosewheat(){
        face(Wheat.class);
        if(isFacing(Wheat.class)){
            myactions.add(Action.attackEP(30));
        }
    }

    private void face(Class<?> e){
        setDirection(LocationFinder.directionTo(getLocation(),LocationFinder.findClosestInstanceLocation(getLocation(),e,getGrid())));
    }

    public void showfacing(){
        System.out.println(getFacing().getClass().getName());
    }

    public boolean isfacingwheat(){
        return isFacing(Wheat.class);
    }

    public void showpath(){
        for(Location l: arrpath){
//            JOptionPane.showMessageDialog(null,l.toString());
            getGrid().put(l,new Flower());
        }
    }

    public boolean closetowheat(){
        for(Actor a: getGrid().getNeighbors(getLocation())){
            if(a instanceof Wheat){
                return true;
            }
        }
        return false;
    }

    private boolean closeto(Class<?> e){
        for(Actor a: getGrid().getNeighbors(getLocation())){
            if(e.isInstance(a)){
                return true;
            }
        }
        return false;
    }
}
