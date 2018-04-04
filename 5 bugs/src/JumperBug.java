import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class JumperBug extends Bug {
    private int steps;
    private int sideLength;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public JumperBug(int length)
    {
        steps = 0;
        sideLength = length/2;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (canMove() && steps < sideLength)
        {
            move();
            moveTo(getLocation().getAdjacentLocation(getDirection()));
            steps++;
        }
        else
        {
            turn();
            turn();
            steps = 0;
        }
    }
}
