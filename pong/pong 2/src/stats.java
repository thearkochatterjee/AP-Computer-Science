
public class stats {
	private String name = "";
	private int score = 0;
	
	stats()
	{
		name = "";
		score = 0;
	}
	
	stats(stats p)
	{
		this.name = p.getname();
		this.score = p.getscore();
	}
	
	stats(String name, int score)
	{
		this.name = name;
		this.score = score;
	}
	
	public String getname()
	{
		return name;
	}
	public int getscore()
	{
		return score;
	}
	
	public void setname(String name)
	{
		this.name = name;
	}
	
	public void setscore(int score)
	{
		this.score = score;
	}
	
	public void addpoint()
	{
		score++;
	}
	
	public String tostr()
	{
		String out = "";
		out = name + ","+score;
		return out;
	}
}
