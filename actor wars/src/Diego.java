import org.masonacm.actorwars.*;

import com.gawdl3y.util.ModifiableLocation;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class Diego extends Peon {
	private ArrayList<Location> arrpath;
	
	public Diego() {
		super();
		arrpath = new ArrayList<Location>();
		setColor(Color.RED);
	}

	@Override
	public void peonAct() {
		try {
			ModifiableLocation m = new ModifiableLocation();
			if (arrpath.size() < 1) {
				if (getItemCount(Wheat.class) > 1 && !energyLow()) {
					arrpath = pathTowards(Peon.class);
				} else {
					arrpath = pathTowards(Wheat.class);
				}
			} else {
				m.setValue(getLocation());
				setDirection(m.directionTo(arrpath.get(0)));
				move();
				arrpath.remove(0);
				if (nearTo(Wheat.class)) {
					//harvest
					setDirection(LocationFinder.directionTo(getLocation(),LocationFinder.findClosestInstanceLocation(getLocation(),Wheat.class,getGrid())));
					myactions.add(Action.attackHP(4));
				}	
				if (nearTo(Peon.class)) {
					//attempt to kill
					setDirection(LocationFinder.directionTo(getLocation(),LocationFinder.findClosestInstanceLocation(getLocation(),Peon.class,getGrid())));
					myactions.add(Action.attackHP(10));
				}
				if (nearTo(Iron.class)) {
					//attempt to kill
					setDirection(LocationFinder.directionTo(getLocation(),LocationFinder.findClosestInstanceLocation(getLocation(),Iron.class,getGrid())));
					myactions.add(Action.attackHP(10));
				}
			}
			if (energyLow()) {
				if (getItemCount(Wheat.class) > 0) {
					myactions.add(Action.use(Wheat.class));
				}
			}
			if (healthLow() && getEnergy() > 50) {
				myactions.add(Action.healSelfEP(5));
			}
		} catch (Exception e) {
        	
        }
	}
	
	public void showpath(){
        for(Location l: arrpath){
            getGrid().put(l,new Flower());
        }
    }
	
	private ArrayList<Location> pathTowards(Class<?> e) {
		return Pathfinder.findPath(getLocation(), LocationFinder.findClosestInstanceLocation(getLocation(), e, getGrid()), getGrid());
	}
	
	private boolean nearTo(Class<?> e) {
		for (Actor a: getGrid().getNeighbors(getLocation())) {
			if (e.isInstance(a)) {
				return true;
			}
		}
		return false;
	}
	
	private ArrayList<Location> neighborEntities(Class<?> e) {
		ArrayList<Location> locations = new ArrayList<Location>();
		for (Actor a: getGrid().getNeighbors(getLocation())) {
			if (e.isInstance(a)) {
				locations.add(a.getLocation());
			}
		}
		return locations;
	}
	
	private boolean energyLow() {
		return getEnergy() < 50;
	}
	
	private boolean healthLow() {
		return getHealth() < 15;
	}
}
