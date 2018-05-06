
public class collidinfo extends colliddata{
	private colliddata c = new colliddata();
	private int mode = 0;
	
	collidinfo(paddle pad, int mode) {
		super(pad);
		c = new colliddata(pad);
		this.mode = mode;
		// TODO Auto-generated constructor stub
	}

	public boolean hascollided(ball b)
	{
		boolean check = false;
		if(b.getcx()<=c.getright() && b.getcx()>=c.getleft())
		{
			if (mode == 1)
			{
				if(b.getcy()+b.getradius()>=c.gettop())
				{
					check = true;
				}
			}
			else if(mode == 2)
			{
				if(b.getcy()+b.getradius()<=c.getbottom())
				{
					check = true;
				}
			}
		}
		return check;
	}
}
