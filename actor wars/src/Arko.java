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
            myactions.add(Action.attackHP(5));
        }
        if(energylow()){
            if(getItemCount(Wheat.class) > 0) {
                myactions.add(Action.use(Wheat.class));
            }
        }
//        if(healthlow()||energylow()){
//            movetoward(nearestwheat());
//        }
//        else if(hasOtherPlayers()){
//            movetoward(nearestplayer());
//        }

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

    public void directwheat(){
        int direct[] = {Location.NORTH, Location.NORTHEAST, Location.EAST, Location.SOUTHEAST, Location.SOUTH, Location.SOUTHWEST, Location.WEST, Location.NORTHWEST};
        for(int i = 0;i<direct.length;i++){
            setDirection(direct[i]);
            if(isFacing(Wheat.class)){
                break;
            }
        }
    }

    public int amountofwheatinvent(){
        return getItemCount(Wheat.class);
    }

    public boolean hasOtherPlayers(){
        return locplayer().size()>1;
    }

    private boolean healthlow(){
        return getHealth() < 5;
    }

    private boolean energylow(){
        return getEnergy() < 50;
    }

    private ArrayList<Location> locwheat(){
        ArrayList<Location> arrwheat = new ArrayList<Location>();
        for(Location l: getGrid().getOccupiedLocations()){
            if(getGrid().get(l) instanceof Wheat){
                arrwheat.add(l);
            }
        }
        return arrwheat;
    }

    private ArrayList<Location> locplayer(){
        ArrayList<Location> arrwheat = new ArrayList<Location>();
        for(Location l: getGrid().getOccupiedLocations()){
            if(getGrid().get(l) instanceof Peon){
                arrwheat.add(l);
            }
        }
        return arrwheat;
    }

    private Location nearestwheat(){
        if(locwheat().size() > 0) {
            Location neat = locwheat().get(0);
            double n = distance(neat);
            for (Location l : locwheat()) {
                if(distance(l) < n){
                    n = distance(l);
                    neat = l;
                }
            }
            return neat;
        }
        else {
            return null;
        }
    }

    private double distance(Location l){
        double d1 = 0.0;
        double d2 = 0.0;
        d1 = getLocation().getCol() - l.getCol();
        d1 = d1 * d1;
        d2 = getLocation().getRow() - l.getRow();
        d2 = d2 * d2;
        d1 = d1 + d2;
        d1 = Math.pow(d1, 0.5);
        return d1;
    }

    private Location nearestplayer(){
        if(locplayer().size() > 0) {
            Location neat = locplayer().get(0);
            double n = distance(neat);
            for (Location l : locplayer()) {
                if(distance(l) < n && distance(l) != 0.0){
                    n = distance(l);
                    neat = l;
                }
            }
            return neat;
        }
        else {
            return null;
        }
    }

    private void movetoward(Location loc){
        double leg1 = 0.0;
        double leg2 = 0.0;
        leg1 = getLocation().getCol() - loc.getCol();
        leg2 = getLocation().getRow() - loc.getRow();
        setDirection(rounddirection(leg1, leg2));
        move();
    }

    private int rounddirection(double leg1, double leg2){
        double angle = 0.0;
        int rang = 0;
        angle = Math.atan(leg1/leg2);
        angle = Math.toDegrees(angle);
        if(angle<22.5){
            rang = Location.EAST;
        }
        else if(angle < 67.5){
            rang = Location.NORTHEAST;
        }
        else if(angle<112.5){
            rang = Location.NORTH;
        }
        else if(angle<157.5){
            rang = Location.NORTHWEST;
        }
        else if(angle<202.5){
            rang = Location.WEST;
        }
        else if(angle<247.5){
            rang = Location.SOUTHWEST;
        }
        else if(angle<292.5){
            rang = Location.SOUTH;
        }
        else{
            rang = Location.SOUTHEAST;
        }
        return rang;
    }

//    private boolean hasConflict(Location player){
//        for(Location l: getGrid().getOccupiedLocations()){
//
//        }
//    }
}
