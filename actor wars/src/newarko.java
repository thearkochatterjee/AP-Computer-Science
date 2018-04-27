import com.gawdl3y.util.ModifiableLocation;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import org.masonacm.actorwars.*;

import java.util.ArrayList;

public class newarko extends Peon{
    private ArrayList<Location> arrpath = new ArrayList<Location>();
    private int i = 0;
    public  newarko(){

    }

    @Override
    public void peonAct() {
        try{
            hunt(Wheat.class);
        }
        catch (Exception e){

        }
    }

    private void hunt(Class<?> e){
//        ModifiableLocation m = new ModifiableLocation();
//        moveToGradual(LocationFinder.findClosestInstanceDynamicLocation(getLocation(),e,getGrid()));
//        if(closetowheat()){
//            setDirection(m.directionTo(LocationFinder.findClosestInstanceDynamicLocation(getLocation(),e,getGrid())));
////            myactions.clear();
//            myactions.add(Action.attackHP(5));
//        }
        ModifiableLocation m = new ModifiableLocation();
        if(arrpath.isEmpty() || i == arrpath.size()){
            arrpath = Pathfinder.findPath(getLocation(), LocationFinder.findClosestInstanceLocation(getLocation(),e,getGrid()),getGrid());
            i=0;
        }else {
            m.setValue(getLocation());
            setDirection(m.directionTo(arrpath.get(i)));
            move();
        }
        i++;
    }

    private void eatclosewheat(){

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
}
