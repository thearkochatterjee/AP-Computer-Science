import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

import java.awt.*;
import java.util.Random;

public class Tester {
    public static void main(String args[]){
        int rbound = 60;
        int cbound = 60;
        Random r = new Random();
        int rpos = 0;
        int cpos = 0;
        int rocknum = 0;
        int intialzombie = 10;
        int intialmale = 60;
        int intialfemale = 60;
        int intialterminator = 10;
        int intialblackwidow = 10;
        int intialflock = 4;
        ActorWorld world = new ActorWorld(new BoundedGrid<>(rbound, cbound));
        rocknum = r.nextInt(20)+1;
        for(int i = 0;i<rocknum;i++){
            rpos = r.nextInt(rbound);
            cpos = r.nextInt(cbound);
            world.add(new Location(rpos, cpos), new Rock(Color.darkGray));
        }
        for(int i = 0; i < intialmale;i++){
            world.add(avaliblepos(world, rbound, cbound), new Male());
        }
        for(int i = 0; i < intialfemale; i++){
            world.add(avaliblepos(world, rbound, cbound), new Female());
        }
        for(int i = 0; i < intialzombie; i++){
            world.add(avaliblepos(world, rbound, cbound), new Zombie());
        }
        for(int i = 0; i <intialterminator; i++){
            world.add(avaliblepos(world, rbound, cbound), new Terminator());
        }
        for(int i = 0; i < intialblackwidow; i++){
            world.add(avaliblepos(world, rbound, cbound), new BlackWidow());
        }
        for(int i = 0;i<intialflock;i++){
            world.add(avaliblepos(world, rbound, cbound), new Flocking(i));
        }
        world.add(avaliblepos(world, rbound, cbound), new Leader());
        world.add(avaliblepos(world, rbound, cbound), new DonJohn());
        world.show();
    }

    private static Location avaliblepos(ActorWorld world, int rbound, int cbound){
        Location loc = new Location(0,0);
        int rpos = 0;
        int cpos = 0;
        Random r = new Random();
        do{
            rpos = r.nextInt(rbound)+1;
            cpos = r.nextInt(cbound)+1;
            loc = new Location(rpos, cpos);
        }while (!world.getGrid().isValid(loc));
        return loc;
    }
}
