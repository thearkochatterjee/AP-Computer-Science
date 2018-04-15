import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

public class Terminator extends BreednDieBase{
    public Terminator(){
        setDeathage(500);
        setColor(Color.BLACK);
    }

    @Override
    public void action() {
        attack();
    }

    public void attack(){
        for(int i = 0; i < attackloc().size(); i++){
            if (!(getGrid().get(attackloc().get(i)) instanceof Terminator) && !(getGrid().get(attackloc().get(i)) instanceof Rock)) {
                getGrid().get(attackloc().get(i)).removeSelfFromGrid();
//                getGrid().put(attackloc().get(i), new Male());
            }
        }
    }

    private ArrayList<Location> attackloc(){
        ArrayList<Location> arrattack = new ArrayList<Location>();
        try {
            for (int i = 0; i < getGrid().getNeighbors(getLocation()).size(); i++) {
                arrattack.add(getGrid().getNeighbors(getLocation()).get(i).getLocation());
            }
        }
        catch (Exception e){

        }
        return arrattack;
    }
}
