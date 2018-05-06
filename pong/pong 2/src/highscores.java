
public class highscores {
	private stats allp[] = new stats[100];
	private int pnum = 0;
	
	highscores()
	{
		for(int i = 0;i<100;i++)
		{
			allp[i] = new stats();
		}
		pnum = 0;
	}
	
	highscores(stats allp[], int pnum)
	{
		this.allp = allp;
		this.pnum = pnum;
	}
	
	public stats[] getallp()
	{
		return allp;
	}
	public int getpnum()
	{
		return pnum;
	}
	
	public void setallp(stats allp[])
	{
		this.allp = allp;
	}
	public void setpnum(int pnum)
	{
		this.pnum = pnum;
	}
	
	public stats[] topten()
	{
		stats ten[] = new stats[10];
		sort();
		for(int i = 0;i<10;i++)
		{
			ten[i] = allp[i];
		}
		return ten;
	}
	
	public void sort()
	{
		stats temp = new stats();
		for(int f = 0;f<pnum-1;f++)
		{
			for(int b = f;b<pnum;b++)
			{
				if(allp[f].getscore()<allp[b].getscore())
				{
					temp = allp[f];
					allp[f] = allp[b];
					allp[b] = temp;
				}
			}
		}
	}
}
