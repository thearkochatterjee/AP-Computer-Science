import info.gridworld.actor.Bug;

public class ZBug extends Bug{
    private int steps;
    private int sideLength;
    private int tcount = 0;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else if(tcount==0)
        {
            turn();
            turn();
            turn();
            steps = 0;
            tcount = 1;
        }
        else if(tcount==1) {
            turn();
            turn();
            turn();
            turn();
            turn();
            steps = 0;
            tcount = 2;
        }
    }
}
