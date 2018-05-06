import java.awt.*;

public class rectangle {
	private int cx, cy, length, width;
	private Color color;
	
	rectangle(int cx, int cy, int length, int width, Color color)
	{
		this.cx = cx;
		this.cy = cy;
		this.length = length;
		this.width = width;
		this.color = color;
	}
	
	public int getcx()
	{
		return cx;
	}
	public void setcx(int cx)
	{
		this.cx = cx;
	}
	public int getcy()
	{
		return cy;
	}
	public void setcy(int cy)
	{
		this.cy = cy;
	}
	public int getlength()
	{
		return length;
	}
	public void setlength(int length)
	{
		this.length = length;
	}
	public int getwidth()
	{
		return width;
	}
	public void setwidth(int width)
	{
		this.width = width;
	}
	
	public void draw(Graphics g)
	{
		Color oldcolor = g.getColor();
		g.drawRect(cx, cy, length, width);
		g.setColor(oldcolor);
	}
	
	public void fill(Graphics g) {
		Color oldcolor = g.getColor();
		g.setColor(color);
		g.fillRect(cx, cy, length, width);
		g.setColor(oldcolor);
	}
	
	public void move(int xamount)
	{
		cx = xamount;
	}
	
	public void keymove(int x)
	{
		cx+=x;
	}
	
	public String tostr()
	{
		String out = "";
		out = cx + ","+cy;
		return out;
	}
}
