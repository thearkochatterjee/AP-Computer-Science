import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import org.masonacm.actorwars.*;

public class Tester {
    public static void main(String args[]){
        ActorWarWorld world = new ActorWarWorld();
        world.add(new thearko());
        world.add(new Peon() {
            @Override
            public void peonAct() {

            }
        });
        world.show();
    }
}
