import java.awt.*;
import javax.swing.*;

public class circle extends JPanel{
	private Color color;
	private int cx = 0;
	private int cy = 0;
	private int radius = 0;
	
	public circle(int x, int y, int r, Color c)
	{
		cx = x;
		cy = y;
		radius = r;
		color = c;
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
	
	public void draw (Graphics g)
	{
		Color oldcolor = g.getColor();
		g.setColor(color);
		g.drawOval(cx - radius, cy-radius, radius * 2, radius *2);
		g.setColor(oldcolor);
	}
	
	public void fill(Graphics g)
	{
		Color oldcolor = g.getColor();
		g.setColor(color);
		g.fillOval(cx-radius, cy-radius, radius*2, radius*2);
		g.setColor(oldcolor);
	}
	
	public boolean containspoint(int x, int y)
	{
		int xsqr = (x-cx)*(x-cx);
		int ysqr = (y-cy)*(y-cy);
		int radsqr = radius * radius;
		return xsqr+ysqr-radsqr<=0;
	}
	
	public void move(int xamount, int yamount)
	{
		cx += xamount;
		cy += yamount;
	}
}
