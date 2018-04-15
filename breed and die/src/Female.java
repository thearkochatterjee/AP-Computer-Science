import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Female extends BreednDieBase{
    private boolean infected;

    public Female()
    {
        setColor(Color.CYAN);
        setDeathage(200);
    }

    public boolean canbreed(){
        return isMature() && closetoMale();
    }

    public boolean closetoMale(){
        for(Actor a: getActors()){
            if ((a instanceof Male) && (((Male) a).isMature())){
                return true;
            }
        }
        return false;
    }

    public boolean isMature(){
        return age > 20 && age < 150;
    }

    @Override
    public void action() {
//        if(closetodonjohn()){
//            moveTo(getActors().get(nearestDonJohn()).getLocation());
//        }
        if(canbreed()){
            Random r = new Random();
            int numkid = r.nextInt(possibleloc().size())+1;
            for(int i = 0; i < numkid; i++){
                try {
                    if(r.nextBoolean()){
                        Male m = new Male();
                        m.putSelfInGrid(getGrid(), possibleloc().get(i));
                    }
                    else{
                        if(r.nextBoolean()){
                            Female f = new Female();
                            f.putSelfInGrid(getGrid(), possibleloc().get(i));
                        }
                        else {
                            BlackWidow b = new BlackWidow();
                            b.putSelfInGrid(getGrid(), possibleloc().get(i));
                        }
                    }
                }
                catch (Exception e){

                }
            }
        }
    }

    private ArrayList<Location> possibleloc(){
        ArrayList<Location> arrpossible = new ArrayList<Location>();
        for(int i = 0;i<9;i++){
            arrpossible.add(getLocation().getAdjacentLocation(i * 45));
        }
        arrpossible.add(new Location(getLocation().getRow() +2, getLocation().getCol()));
        arrpossible.add(new Location(getLocation().getRow() -2, getLocation().getCol()));
        arrpossible.add(new Location(getLocation().getRow(), getLocation().getCol()-2));
        arrpossible.add(new Location(getLocation().getRow(), getLocation().getCol()+2));
        for(int i = 0; i < arrpossible.size(); i++){
            if(!getGrid().isValid(arrpossible.get(i)) || arrpossible.get(i).getRow()< 1 || arrpossible.get(i).getCol() < 1 || arrpossible.get(i).getCol() > getGrid().getNumCols() || arrpossible.get(i).getRow() > getGrid().getNumRows()){
                arrpossible.remove(arrpossible.get(i));
            }
        }
        return arrpossible;
    }

//    public boolean closetodonjohn(){
//        boolean close = false;
//        for(Actor a: getActors()){
//            if((distance(a) < 10) && (a instanceof DonJohn)){
//                close = true;
//            }
//        }
//        return close;
//    }
//
//    private int directionto(Actor a){
//        if(a.getLocation().getRow() > getLocation().getRow()){
//            return Location.SOUTH;
//        }
//        else if (a.getLocation().getRow() < getLocation().getRow()){
//            return Location.NORTH;
//        }
//        else if (a.getLocation().getCol() > getLocation().getCol()){
//            return Location.WEST;
//        }
//        else if (a.getLocation().getCol() < getLocation().getCol()){
//            return Location.EAST;
//        }
//        return 0;
//    }
//
//    public int nearestDonJohn(){
//        int pos = 0;
//        double dist = 10000000.0;
//        for(int i = 0; i < getActors().size();i++){
//            if(getActors().get(i) instanceof DonJohn){
//                if (distance(getActors().get(i)) < dist){
//                    dist = distance(getActors().get(i));
//                    pos = i;
//                }
//            }
//        }
//        return pos;
//    }
}
