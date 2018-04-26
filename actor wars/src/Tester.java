import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import org.masonacm.actorwars.*;

public class Tester {
    public static void main(String args[]){
        ActorWarWorld world = new ActorWarWorld();
        world.add(new Arko());
        world.add(new Peon() {
            @Override
            public void peonAct() {

            }
        });
//        for(int i = 0;i<50;i++){
//            world.add(new Wheat());
//        }
        world.show();
    }
}
