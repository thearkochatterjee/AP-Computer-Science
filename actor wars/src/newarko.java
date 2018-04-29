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
    private int i = 0;

    public  newarko(){
        super();
        arrattackorder.add(Wheat.class);
        arrattackorder.add(Tree.class);
        arrattackorder.add(Peon.class);
    }

    @Override
    public void peonAct() {
        try{
            hunt(arrattackorder.get(i));
            showstats();
        }
        catch (Exception e){

        }
    }

    private void showstats(){
        System.out.println(getHealth() + " , " + getEnergy());
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
            myactions.add(Action.attackEP(32));
        }
        else{
            avoidclass(getFacing().getClass());
        }
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
//        if(healthlow()){
////            myactions.clear();
////            myactions.add(Action.healSelfHP(10));
//            System.out.println("Needs to heal");
//        }
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
