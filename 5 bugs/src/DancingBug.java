import info.gridworld.actor.Bug;

public class DancingBug extends Bug {
    private int steps;
    private int sideLength;
    private int dance[];
    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public DancingBug(int length, int dance[])
    {
        steps = 0;
        sideLength = length;
        this.dance = dance;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < sideLength && canMove())
        {
            for(int i = 0;i<dance[steps];i++){
                turn();
            }
            move();
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
