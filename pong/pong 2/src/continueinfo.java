import java.awt.Color;

public class continueinfo {
	private ball b;
	private paddle pad;
	private stats p;
	private int end;
	private int pos;
	
	continueinfo()
	{
		pad = new paddle(0, 0, 100, 20, Color.BLACK);
		b = new ball(0,0,15,100,200);
		p = new stats("", 0);
		end = 0;
		pos = 0;
	}
	
	continueinfo(String parts[])
	{
//		panel.setpad(new paddle(Integer.valueOf(parts[0]),Integer.valueOf(parts[1]), 100, 20, Color.BLACK));
		pad  = new paddle(Integer.valueOf(parts[0]),Integer.valueOf(parts[1]), 100, 20, Color.BLACK);
//		panel.setball(new ball(Integer.valueOf(parts[2]), Integer.valueOf(parts[3]), 15, Integer.valueOf(parts[4]), Integer.valueOf(parts[5])));
		b = new ball(Integer.valueOf(parts[2]), Integer.valueOf(parts[3]), 15, Integer.valueOf(parts[4]), Integer.valueOf(parts[5]));
//		player.setname(parts[6]);
//		player.setscore(Integer.valueOf(parts[7]));
		p.setname(parts[6]);
		p.setscore(Integer.valueOf(parts[7]));
	}
	
	public ball getball()
	{
		return b;
	}
	public void setball(ball b)
	{
		this.b = b;
	}
	public paddle getpaddle()
	{
		return pad;
	}
	public void setpaddle(paddle pad)
	{
		this.pad = pad;
	}
	public stats getplayer()
	{
		return p;
	}
	public void setplayer(stats p)
	{
		this.p = p;
	}
	public int getend()
	{
		return end;
	}
	public void setend(int end)
	{
		this.end = end;
	}
	public int getpos()
	{
		return pos;
	}
	public void setpos(int pos)
	{
		this.pos = pos;
	}
	
	public String tostr()
	{
		String out = "";
		out = pad.getcx() + ","+pad.getcy()+","+b.getvelocity()+","+b.getdirection()+","+b.getcx()+","+b.getcy()+",";
		out = out + p.getname()+","+p.getscore()+","+end+","+pos;
		return out;
	}
}
