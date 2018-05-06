package pong;

import java.awt.*;

public class circle {
	private int cx = 0;
	private int cy = 0;
	private int radius = 0;
	private Color color;
	
	circle()
	{
		cx = 0;
		cy = 0;
		radius = 0;
	}
	
	circle(int x, int y,int radius, Color color)
	{
		this.cx = x;
		this.cy = y;
		this.radius = radius;
		this.color = color;
	}
	
	public int getcx()
	{
		return cx;
	}
	public int getcy()
	{
		return cy;
	}
	public int getradius()
	{
		return radius;
	}
	
	public void setcx(int cx)
	{
		this.cx = cx;
	}
	public void setcy(int cy)
	{
		this.cy = cy;
	}
	public void setradius(int radius)
	{
		this.radius = radius;
	}
	
	public void fill(Graphics g)
	{
		Color oldcolor = g.getColor();
		g.setColor(color);
		g.fillOval(cx-radius, cy-radius, radius * 2, radius *2);
		g.setColor(oldcolor);
	}
	
	public void draw(Graphics g) {
		Color oldcolr = g.getColor();
		g.setColor(color);
		g.drawOval(cx-radius, cy-radius, radius * 2, radius *2);
		g.setColor(oldcolr);
	}
	
	public boolean containspoint(int x, int y)
	{
		int xsr = (int) Math.pow((x-cx), 2);
		int ysr = (int)Math.pow(y-cy, 2);
		int radsr = (int)Math.pow(radius, 2);
		return xsr+ysr-radsr<=0;
	}
	
	public void move(int x, int y)
	{
		cx += x;
		cy += y;
	}
}
