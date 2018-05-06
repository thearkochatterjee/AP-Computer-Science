import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel{
	private paddle pad, ai;
	private ball b;
	private stats player;
	private int keyx;
	
	public ColorPanel(Color backcolor)
	{
		setBackground(backcolor);
		pad = new paddle(20, 400, 100, 20, Color.BLACK);
		ai = new paddle( 20, 20, 100, 20, Color.BLACK);
		b = new ball(-5,135,15,100,200);
		player = new stats();
		keyx = 0;
	}
	
	public stats getplayer()
	{
		return player;
	}
	public void setplayer(stats player)
	{
		this.player = player;
	}
	public ball getball()
	{
		return b;
	}
	public void setball(ball b)
	{
		this.b = b;
	}
	public paddle getpad()
	{
		return pad;
	}
	public void setpad(paddle pad)
	{
		this.pad = pad;
	}
	public int getkeyx()
	{
		return keyx;
	}
	public paddle getai()
	{
		return ai;
	}
	public void setkeyx(int keyx)
	{
		this.keyx = keyx;
	}
	
	public void paintComponent(Graphics g)
	{
		collidinfo c = new collidinfo(pad, 1);
		collidinfo c2 = new collidinfo(ai, 2);
		super.paintComponent(g);
		pad.fill(g);
		ai.fill(g);
		b.fill(g);
		b.move();
		if(b.getcx()+b.getradius()<0)
		{
			b.setdireciton(oldreflect(2));
//			b.setdireciton(reflect(false));
		}
		if(b.getcy()+b.getradius()>500)
		{
			b.setdireciton(oldreflect(3));
//			b.setdireciton(reflect(true));
		}
		if (b.getcx()+b.getradius()>500)
		{
			b.setdireciton(oldreflect(4));
		}
		if(b.getcy()+b.getradius()<ai.getcy()+ai.getwidth()+20)
		{
			b.setdireciton(oldreflect(1));
			
		}
//		pad.move(MouseInfo.getPointerInfo().getLocation().x);
		pad.keymove(keyx);
		ai.setcx(b.getcx()-50);
		if(c.hascollided(b)==true)
		{
			b.setdireciton(oldreflect(3));
		}
		if (b.getdirection()==0)
		{
			b.setdireciton(45);
		}
//		if(c2.hascollided(b)==true)
//		{
//			b.setdireciton(oldreflect(1));
//		}
		g.drawString(player.tostr(), 10, 10);
	}
	
	private int reflect(boolean v)
	{
		int reflect = 0;
		double bx = 0.0;
		double by = 0.0;
		bx = Math.cos(Math.toRadians(b.getdirection()));
		by = Math.sin(Math.toRadians(b.getdirection()));
		if(v==true)
		{
			by = by * -1;
		}
		else
		{
			bx = bx * -1;
		}
		reflect = (int)(Math.toDegrees(Math.atan(by/bx)));
		return reflect;
	}
	
	private int oldreflect(int side)
	{
		int reflect = 0;
		if(side == 1)
		{
			if (quad() == 1)
			{
				reflect = 270 + b.getdirection();
			}
			else if (quad()==2)
			{
				reflect = 90 + b.getdirection();
			}
		}
		else if (side == 2)
		{
			if (quad()==1)
			{
				reflect = 180 - b.getdirection();
			}
			else if (quad()==4)
			{
				reflect = 180 + (b.getdirection()%90);
			}
		}
		else if (side == 3)
		{
			if(quad()==3)
			{
				reflect = (b.getdirection()%90)+90;
			}
			else if (quad()==4)
			{
				reflect = (b.getdirection()%90);
			}
		}
		else if (side == 4)
		{
			if(quad()==2)
			{
				reflect = (b.getdirection()%90);
			}
			else if (quad()==3)
			{
				reflect = (b.getdirection()%90)+270;
			}
		}
		return reflect;
	}
	
	private int quad()
	{
		int quad = 0;
		if(b.getdirection()<=90)
		{
			quad = 1;
		}
		else if (b.getdirection()<=180)
		{
			quad = 2;
		}
		else if (b.getdirection()<=270)
		{
			quad = 3;
		}
		else if(b.getdirection()<360)
		{
			quad = 4;
		}
		return quad;
	}
	
	public void reset()
	{
		b.setcx(100);
		b.setcy(200);
	}
}
