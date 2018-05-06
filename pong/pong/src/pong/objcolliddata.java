package pong;

import javax.swing.*;

public class objcolliddata {
	private int left = 0;
	private int right = 0;
	private int top = 0;
	private int bottom = 0;
	
	objcolliddata()
	{
		left = 0;
		right = 0;
		top = 0;
		bottom = 0;
	}
	
	objcolliddata(JLabel obj)
	{
		left = obj.getX();
		top = obj.getY();
		right = obj.getX()+obj.getWidth();
		bottom = obj.getY()+obj.getHeight();
	}
	
	public int getleft()
	{
		return left;
	}
	public int getright()
	{
		return right;
	}
	public int gettop()
	{
		return top;
	}
	public int getbottom()
	{
		return bottom;
	}
	
	public void setleft(int left)
	{
		this.left = left;
	}
	public void setright(int right)
	{
		this.right = right;
	}
	public void settop(int top)
	{
		this.top = top;
	}
	public void setbottom(int bottom)
	{
		this.bottom = bottom;
	}
}
