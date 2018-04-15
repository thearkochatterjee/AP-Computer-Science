import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

public class Female extends BreednDieBase{
    public Female()
    {
        setColor(Color.RED);
        setDeathage(200);
    }

    private ArrayList<Male> close(){
        ArrayList<Male> arrmale = new ArrayList<Male>();
        for(int i = 0; i < getActors().size(); i++){
            if (getActors().get(i) instanceof Male) {
                for (int d = 0; d < 9; i++) {
                    if (getLocation().getAdjacentLocation(d).compareTo(getActors().get(i).getLocation()) == 0) {
                        arrmale.add(new Male());
                    }
                }
                if (above(getActors().get(i)) || below(getActors().get(i)) || left(getActors().get(i)) || right(getActors().get(i))) {
                    arrmale.add(new Male());
                }
            }
        }
        return arrmale;
    }

    public boolean canbreed(){
        return close().size() > 0;
    }

    @Override
    public void action() {

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
//        if(age > deathage && getActors().contains(this)){
//            removeSelfFromGrid();
//        }
//    }

    private boolean hasMature(){
        boolean mature = false;
        for(int i = 0; i < close().size();i++){

        }
        return mature;
    }

    private boolean above(Actor a){
        return ((getLocation().getRow() + 2) == a .getLocation().getRow()) && (getLocation().getCol() == a.getLocation().getCol());
    }

    private boolean below(Actor a){
        return ((getLocation().getRow() - 2) == a .getLocation().getRow()) && (getLocation().getCol() == a.getLocation().getCol());
    }

    private boolean left(Actor a){
        return ((getLocation().getRow()) == a .getLocation().getRow()) && ((getLocation().getCol() + 2) == a.getLocation().getCol());
    }

    private boolean right(Actor a){
        return ((getLocation().getRow()) == a .getLocation().getRow()) && ((getLocation().getCol() - 2) == a.getLocation().getCol());
    }
}
