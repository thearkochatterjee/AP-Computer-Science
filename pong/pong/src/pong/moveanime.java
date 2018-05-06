package pong;

public class moveanime {
	private int x = 0;
	private int y = 0;
	
	moveanime()
	{
		x = 0;
		y = 0;
	}
	
	moveanime(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getx()
	{
		return x;
	}
	public int gety()
	{
		return y;
	}
	
	public void setx(int x)
	{
		this.x = x;
	}
	public void sety(int y)
	{
		this.y = y;
	}
	
	public void reversex()
	{
		x = x * -1;
	}
	
	public void reversey()
	{
		y = y * -1;
	}
}
