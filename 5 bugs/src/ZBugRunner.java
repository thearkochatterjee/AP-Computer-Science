import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.*;

public class ZBugRunner {
    public static void main(String args[]){
        ActorWorld world = new ActorWorld();
        ZBug alice = new ZBug(6);
        alice.setColor(Color.ORANGE);
        ZBug bob = new ZBug(10);
        bob.setDirection(90);
        world.add(new Location(1, 8), alice);
        world.add(new Location(1, 5), bob);
        world.show();
    }
}
