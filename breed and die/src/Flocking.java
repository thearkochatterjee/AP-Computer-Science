import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Random;

public class Flocking extends BreednDieBase{
    private int num;

    public Flocking(int num){
        setDeathage(250);
        this.num = num;
    }

    public void setNum(int num){
        this.num = num;
    }

    @Override
    public void action() {
        if(leaderisalive() && possibleloc(posleader()).size() > 0){
            try {
                moveTo(possibleloc(posleader()).get(num));
            }
            catch (Exception e){

            }
        }
        else if (members().size() > 0){
            newleader();
        }
    }

    public boolean leaderisalive(){
        boolean alive = false;
        for(Location l: getGrid().getOccupiedLocations()){
            if(getGrid().get(l) instanceof Leader){
                alive = true;
            }
        }
        return alive;
    }

    public Location posleader(){
        Location pos = new Location(0, 0);
        for(Location l: getGrid().getOccupiedLocations()){
            if(getGrid().get(l) instanceof Leader){
                pos = l;
            }
        }
        return pos;
    }

    public ArrayList<Location> members(){
        ArrayList<Location> arrmember = new ArrayList<Location>();
        for(Location l : getGrid().getOccupiedLocations()){
            if(getGrid().get(l) instanceof Flocking){
                arrmember.add(l);
            }
        }
        return arrmember;
    }

    private void newleader(){
        Random r = new Random();
        int rpos = 0;
        rpos = r.nextInt(members().size()+1);
        Location loc = members().get(rpos);
        getGrid().get(loc).removeSelfFromGrid();
        Leader l = new Leader();
        l.putSelfInGrid(getGrid(), avaliblepos());
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

    private ArrayList<Location> possibleloc(Location l){
        ArrayList<Location> arrpossible = new ArrayList<Location>();
        for(int i = 0;i<9;i++){
            arrpossible.add(l.getAdjacentLocation(i * 45));
        }
        arrpossible.add(new Location(l.getRow() +2, l.getCol()));
        arrpossible.add(new Location(l.getRow() -2, l.getCol()));
        arrpossible.add(new Location(getLocation().getRow(), getLocation().getCol()-2));
        arrpossible.add(new Location(getLocation().getRow(), getLocation().getCol()+2));
        for(int i = 0; i < arrpossible.size(); i++){
            if(!getGrid().isValid(arrpossible.get(i)) || arrpossible.get(i).getRow()< 1 || arrpossible.get(i).getCol() < 1 || arrpossible.get(i).getCol() > getGrid().getNumCols() || arrpossible.get(i).getRow() > getGrid().getNumRows()){
                arrpossible.remove(arrpossible.get(i));
            }
        }
        return arrpossible;
    }
}
