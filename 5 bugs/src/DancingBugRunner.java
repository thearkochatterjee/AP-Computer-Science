import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.Random;

public class DancingBugRunner {
    public static void main(String args[]){
        int dance1[] = new int[100];
        int dance2[] = new int[100];
        Random r = new Random();
        for(int i = 0;i<100;i++){
            dance1[i] = r.nextInt(8)+1;
            dance2[i] = r.nextInt(8)+1;
        }
        ActorWorld world = new ActorWorld();
        DancingBug alice = new DancingBug(6, dance1);
        alice.setColor(Color.ORANGE);
        DancingBug bob = new DancingBug(3, dance2);
        world.add(new Location(7, 8), alice);
        world.add(new Location(5, 5), bob);
        world.show();
    }
}
