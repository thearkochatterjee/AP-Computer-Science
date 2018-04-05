import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class JumperBugRunner {
    public static void main(String args[]){
        UnboundedGrid ugrid = new UnboundedGrid<Actor>();
        BoundedGrid bgrid = new BoundedGrid(60,60);
        int dance1[] = new int[100];
        int dance2[] = new int[100];
        Random r = new Random();
        for(int i = 0;i<100;i++){
            dance1[i] = r.nextInt(8)+1;
            dance2[i] = r.nextInt(8)+1;
        }
        ActorWorld world = new ActorWorld(bgrid);
        BoxBug alice = new BoxBug(6);
        alice.setColor(Color.ORANGE);
        CircleBug c = new CircleBug(10);
        JumperBug bob = new JumperBug(6);
        ZBug z = new ZBug(10);
        SpiralBug s = new SpiralBug(10);
        DancingBug d = new DancingBug(10, dance1);

        bob.setDirection(90);
        z.setDirection(90);
//        world.add(new Location(6, 8), alice);
        world.add(new Location(2, 3), bob);
        world.add(new Location(10,10), alice);
        world.add(new Location(30,30), z);
        world.add(new Location(40,40),s);
        world.add(new Location(50,50), d);
        world.add(new Location(20,20), c);
        world.show();
    }
}
