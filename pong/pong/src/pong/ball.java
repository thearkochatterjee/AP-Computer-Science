package pong;

import java.awt.*;

public class ball extends circle{
	int speed = 0;
	int degrees = 0;
	int direction = 0;
	
	ball()
	{
		
	}
	
	ball(int velocity, int direction, int radius, int x, int y, Color c)
	{
		super(x, y, radius, c);
		
	}
	
	public void setspeed(int s)
	{
		speed = s;
	}
	
	public void setDirection(int degrees)
	{
		direction = degrees % 360;
	}
	
	public void turn(int degrees)
	{
		direction = (direction + degrees) % 360;
	}
	
	public void move()
	{
		move((int)(speed * Math.cos(Math.toRadians(direction))), (int)(speed * Math.sin(Math.toRadians(direction))));
	}
}
