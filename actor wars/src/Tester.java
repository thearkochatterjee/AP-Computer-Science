import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import org.masonacm.actorwars.*;

public class Tester {
    public static void main(String args[]){
        ActorWarWorld world = new ActorWarWorld();
        world.add(new newarko());
        world.add(new newarko());
        world.show();
    }
}
