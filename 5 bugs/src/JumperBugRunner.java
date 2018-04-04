import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.*;

public class JumperBugRunner {
    public static void main(String args[]){
        ActorWorld world = new ActorWorld();
        JumperBug alice = new JumperBug(6);
        alice.setColor(Color.ORANGE);
        JumperBug bob = new JumperBug(6);
        bob.setDirection(90);
//        world.add(new Location(6, 8), alice);
        world.add(new Location(2, 3), bob);
        world.show();
    }
}
