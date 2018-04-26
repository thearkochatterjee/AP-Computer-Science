import com.gawdl3y.util.DynamicValue;
import com.gawdl3y.util.ModifiableInteger;
import com.gawdl3y.util.ModifiableLocation;
import com.sun.nio.sctp.PeerAddressChangeNotification;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import org.masonacm.actorwars.*;

import java.util.ArrayList;

public class Arko extends Peon{
    private ArrayList<Location> arrpath = new ArrayList<Location>();

    public Arko(){
        super();
        arrpath = new ArrayList<Location>();
    }

    @Override
    public void peonAct() {
        try{
            wheathunting();
        }
        catch (Exception e){
            playerhunting();
        }
    }

    private void playerhunting(){

    }

    private void ironhunting(){

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
        if(energylow()){
            if(getItemCount(Wheat.class) > 0) {
                myactions.add(Action.use(Wheat.class));
            }
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

    public boolean closetowheat(){
        for(Actor a: getGrid().getNeighbors(getLocation())){
            if(a instanceof Wheat){
                return true;
            }
        }
        return false;
    }

    private void eatwheat(){
        myactions.add(Action.use(Wheat.class));
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
