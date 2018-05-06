import java.awt.Color;

public class ball extends circle{
	private int velocity;
	private int direction;
	
	ball()
	{
		super(0,0,15,Color.BLUE);
		velocity = 0;
		direction = 0;
	}
	
	public ball(int velocity, int direction, int radius, int x, int y)
	{
		super(x, y, radius, Color.BLUE);
		this.velocity = velocity;
		this.direction= direction;
	}
	
	public ball(int x, int y, int r, Color c) {
		super(x, y, r, c);
	}
	
	public int getvelocity()
	{
		return velocity;
	}
	
	public int getdirection()
	{
		return direction;
	}
	
	public void setvelocity(int velocity)
	{
		this.velocity = velocity;
	}
	
	public void setdireciton(int direction)
	{
		this.direction = direction;
	}
	
	public void move() {
        move((int)(velocity * Math.cos(Math.toRadians(direction))),(int)(velocity * Math.sin(Math.toRadians(direction))));
    }
	
	public String tostr()
	{
		String out = "";
		out = velocity + "," + direction + "," + super.getcx() + "," + super.getcy();
		return out;
	}
}
