import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import org.masonacm.actorwars.ActorWarWorld;
import org.masonacm.actorwars.HolyHandGrenadeBearer;
import org.masonacm.actorwars.Iron;
import org.masonacm.actorwars.Peon;

public class Tester {
    public static void main(String args[]){
        ActorWarWorld world = new ActorWarWorld();
        world.add(new Arko());
        world.add(new Arko());
        world.show();
    }
}
