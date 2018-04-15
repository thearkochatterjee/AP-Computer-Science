import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Zombie extends BreednDieBase{
    public Zombie(){
        setColor(Color.green);
        setDeathage(300);
    }

    @Override
    public void action() {
        attack();
    }

    //    public void makeMove(Location loc)
//    {
//        age++;
//        if (loc.equals(getLocation()))
//        {
//            double r = Math.random();
//            int angle;
//            if (r < 0.5)
//                angle = Location.LEFT;
//            else
//                angle = Location.RIGHT;
//            setDirection(getDirection() + angle);
//        }
//        else
//            super.makeMove(loc);
//        if(age > deathage){
//            removeSelfFromGrid();
//        }
//        attack();
//    }

    public void attack(){
        if (attackloc().size() > 0) {
            for (int i = 0; i < attackloc().size(); i++) {
                if (!(getGrid().get(attackloc().get(i)) instanceof Zombie) && !(getGrid().get(attackloc().get(i)) instanceof Rock) && !(getGrid().get(attackloc().get(i)) instanceof Terminator)) {
                    getGrid().get(attackloc().get(i)).removeSelfFromGrid();
                    Zombie z = new Zombie();
                    try {
                        z.putSelfInGrid(getGrid(), attackloc().get(i));
                    }
                    catch (Exception e){
                        z.putSelfInGrid(getGrid(), avaliblepos());
                    }
                }
            }
        }
    }

    private ArrayList<Location> attackloc(){
        ArrayList<Location> arrattack = new ArrayList<Location>();
        try {
            if (getGrid().getNeighbors(getLocation()).size() > 0) {
                for (int i = 0; i < getGrid().getNeighbors(getLocation()).size(); i++) {
                    arrattack.add(getGrid().getNeighbors(getLocation()).get(i).getLocation());
                }
            }
        }
        catch (Exception e){

        }
        return arrattack;
    }

    private Location avaliblepos(){
        Location loc = new Location(0,0);
        int rpos = 0;
        int cpos = 0;
        Random r = new Random();
        do{
            rpos = r.nextInt(getGrid().getNumRows())+1;
            cpos = r.nextInt(getGrid().getNumCols())+1;
            loc = new Location(rpos, cpos);
        }while (!getGrid().isValid(loc));
        return loc;
    }
}
