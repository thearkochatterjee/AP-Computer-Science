import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

public class Male extends BreednDieBase{
    private boolean infected;

    public Male()
    {
        setColor(Color.GRAY);
        setDeathage(200);
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
//    }


    @Override
    public void action() {

    }

    public boolean isMature(){
        return age > 20;
    }
}
