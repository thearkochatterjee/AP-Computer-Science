import info.gridworld.actor.Actor;
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
        setColor(Color.RED);
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
                        Female f = new Female();
                        f.putSelfInGrid(getGrid(), possibleloc().get(i));
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

    private boolean hasMature(){
        boolean mature = false;

        return mature;
    }
}
