import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

abstract public class BreednDieBase extends Critter{
    protected int age;
    protected  int deathage;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDeathage(int deathage) {
        this.deathage = deathage;
    }

    public boolean isMature(){
        return age > 5;
    }

    abstract public void action();

    /**
     * A crab gets the actors in the three locations immediately in front, to its
     * front-right and to its front-left
     * @return a list of actors occupying these locations
     */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        int[] dirs = {Location.NORTH, Location.NORTHEAST, Location.EAST, Location.SOUTHEAST, Location.SOUTH, Location.SOUTHWEST, Location.WEST, Location.NORTHWEST};
        for (Location loc : getLocationsInDirections(dirs))
        {
            Actor a = getGrid().get(loc);
            if (a != null)
                actors.add(a);
        }
        return actors;
    }

    /**
     * @return list of empty locations immediately to the right and to the left
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
                {Location.NORTH, Location.NORTHEAST, Location.EAST, Location.SOUTHEAST, Location.SOUTH, Location.SOUTHWEST, Location.WEST, Location.NORTHWEST};
        for (Location loc : getLocationsInDirections(dirs))
            if (getGrid().get(loc) == null)
                locs.add(loc);
        return locs;
    }

    /**
     * If the crab critter doesn't move, it randomly turns left or right.
     */
    public void makeMove(Location loc)
    {
        age++;
        if (loc.equals(getLocation()))
        {
            double r = Math.random();
            int angle;
            if (r < 0.5)
                angle = Location.LEFT;
            else
                angle = Location.RIGHT;
            setDirection(getDirection() + angle);
        }
        else
            super.makeMove(loc);
        if(age > deathage){
            removeSelfFromGrid();
        }
        action();
    }

    /**
     * Finds the valid adjacent locations of this critter in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @return a set of valid locations that are neighbors of the current
     * location in the given directions
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();

        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc))
                locs.add(neighborLoc);
        }
        return locs;
    }

    public double distance(Actor a){
        return Math.pow(Math.pow(getLocation().getCol() + a.getLocation().getCol(), 2) + Math.pow(getLocation().getRow() + a.getLocation().getRow(), 2), 0.5);
    }
}
