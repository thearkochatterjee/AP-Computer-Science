import com.gawdl3y.util.DynamicValue;
import com.gawdl3y.util.ModifiableInteger;
import com.gawdl3y.util.ModifiableLocation;
import com.sun.nio.sctp.PeerAddressChangeNotification;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import org.masonacm.actorwars.*;
import org.masonacm.actorwars.Action;

import javax.swing.*;
import java.util.ArrayList;

public class Arko extends Peon{
    private ArrayList<Location> arrpath = new ArrayList<Location>();
    private ArrayList<Location> arrtravel = new ArrayList<Location>();

    public Arko(){
        super();
        arrpath = new ArrayList<Location>();
        arrtravel = new ArrayList<Location>();
    }

    @Override
    public void peonAct() {
        int i = 0;
        try{
            hunting(Wheat.class);
//            wheathunting();
////            if(i == 0) {
////                hunting(Wheat.class);
////            }
////            else if(i==1){
////                hunting(Peon.class);
////            }
        }
        catch (Exception e){
            i++;

        }
    }

    private void hunting(Class<?> e){
        ModifiableLocation m = new ModifiableLocation();
        if(arrpath.isEmpty()){
            arrpath = Pathfinder.findPath(getLocation(), LocationFinder.findClosestInstanceLocation(getLocation(), e, getGrid()), getGrid());
        }
        else {
            m.setValue(getLocation());
            setDirection(m.directionTo(arrpath.get(0)));
            move();
            arrpath.remove(0);
        }
        if(close(e)){
            setDirection(m.directionTo(LocationFinder.findClosestInstanceLocation(getLocation(), e,getGrid())));
            myactions.clear();
            myactions.add(Action.attackHP(5));
        }
        survive();
    }

    private boolean error(){
        for(int i = 2;i<arrtravel.size();i++){
            if(arrtravel.get(i) == arrtravel.get(i - 2)){
                return true;
            }
        }
        for(int i = 3;i<arrtravel.size();i++){
            if(arrtravel.get(i) == arrtravel.get(i - 3)){
                return true;
            }
        }
        return false;
    }

    private void followpath(ArrayList<Location> path, int i){
        moveTo(arrpath.get(i));
    }

    public void removepath(){
        for(Location l: getGrid().getOccupiedLocations()){
            if(getGrid().get(l) instanceof Flower){
                getGrid().remove(l);
            }
        }
    }

    public void showpath(){
        for(Location l: arrpath){
//            JOptionPane.showMessageDialog(null,l.toString());
            getGrid().put(l,new Flower());
        }
    }

    public Location searchfor(int radius, Class<?> e){
        int startr = getLocation().getRow()-radius;
        int startc = getLocation().getCol()-radius;
        ModifiableLocation m = new ModifiableLocation();
        for(int r = startr; r<(startr + 2 * radius); r++){
            for(int c = startc; c<(startc + 2 * radius); c++){
                m.setValue(getLocation());
                for(Actor a: getGrid().getNeighbors(new Location(r,c))){
                    if(e.isInstance(a)){
                        return a.getLocation();
                    }
                }
            }
        }
        return null;
    }

    public void adjust(){
        ModifiableLocation m = new ModifiableLocation();
        if(arrpath.size()==2){
            for(int i = 0;i<2;i++){
                m.setValue(getLocation());
                for(Actor a: getGrid().getNeighbors(arrpath.get(i))){
                    if(a instanceof Wheat){
                        setDirection(m.directionTo(arrpath.get(i)));
                        myactions.clear();
                        myactions.add(Action.attackHP(5));
                    }
                }
            }
        }
    }

    private void wheathunting(){
        ModifiableLocation m = new ModifiableLocation();
        if(arrpath.size() < 1){
            arrpath = Pathfinder.findPath(getLocation(), LocationFinder.findClosestInstanceLocation(getLocation(), Wheat.class, getGrid()), getGrid());
        }
        else {
            m.setValue(getLocation());
            setDirection(m.directionTo(arrpath.get(0)));
            move();
            arrpath.remove(0);
        }
        if(closetowheat()){
            setDirection(m.directionTo(LocationFinder.findClosestInstanceLocation(getLocation(),Wheat.class,getGrid())));
            myactions.clear();
            myactions.add(Action.attackHP(5));
        }
        survive();
    }

    private void survive(){
        if(energylow() || healthlow()){
            eatwheat();
        }
    }

    public ModifiableLocation modifiableLocation(Peon p){
        ModifiableLocation m = new ModifiableLocation();
        m.setValue(p.getDynamicLocation());
        return m;
    }

    public boolean hasWheat(){
        for(Location l: getGrid().getOccupiedLocations()){
            if(getGrid().get(l) instanceof Wheat){
                return true;
            }
        }
        return false;
    }

    private boolean close(Class<?> e){
        for(Actor a: getGrid().getNeighbors(getLocation())){
            if(e.isInstance(a)){
                return true;
            }
        }
        return false;
    }

    public boolean closetowheat(){
        for(Actor a: getGrid().getNeighbors(getLocation())){
            if(a instanceof Wheat){
                return true;
            }
        }
        return false;
    }

    private boolean hasWheatinvent(){
        return amountofwheatinvent() > 0;
    }

    private boolean hasironinvent(){
        return amountofiron() > 0;
    }

    private void eatwheat(){
        if(hasWheatinvent()){
            myactions.add(Action.use(Wheat.class));
        }
    }

    public int amountofwheatinvent(){
        return getItemCount(Wheat.class);
    }

    public int amountofiron(){
        return getItemCount(Iron.class);
    }

    private boolean healthlow(){
        return getHealth() < 7;
    }

    private boolean energylow(){
        return getEnergy() < 30;
    }
}
