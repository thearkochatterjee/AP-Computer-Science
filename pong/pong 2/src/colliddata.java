
public class colliddata {
	private int left = 0;
	private int right = 0;
	private int top = 0;
	private int bottom = 0;
	
	colliddata()
	{
		left = 0;
		right = 0;
		top = 0;
		bottom = 0;
	}
	
	colliddata(paddle pad)
	{
		left = pad.getcx();
		right = pad.getcx() + pad.getlength();
		top = pad.getcy();
		bottom = pad.getcy()+pad.getwidth();
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
}
