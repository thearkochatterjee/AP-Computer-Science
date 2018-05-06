import javax.swing.*;
import java.awt.*;

public class gameover {
	private JFrame game = new JFrame();
	private JList lstallp = new JList();
	private DefaultListModel dlm = new DefaultListModel();
	private JList lstten = new JList();
	private DefaultListModel dlm2 = new DefaultListModel();
	private Container pane = new Container();
	private JLabel lblall = new JLabel();
	private JLabel lblten = new JLabel();
	private highscores hs = new highscores();
	
	gameover(highscores hs)
	{
		game.setTitle("Game Over");
		game.setSize(500,500);
		game.getContentPane().add(pane);
		pane.add(lstallp);
		pane.add(lstten);
		pane.add(lblall);
		pane.add(lblten);
		this.hs = hs;
//		for(int i = 0;i<hs.getpnum();i++)
//		{
//			dlm.addElement(hs.getallp()[i].tostr());
//		}
//		for(int i = 0;i<10;i++)
//		{
//			dlm2.addElement(hs.topten()[i].tostr());
//		}
		lblall.setText("All Players");
		lblten.setText("Top Ten");
		lstallp.setBounds(20, 100, 200, 200);
		lstten.setBounds(270, 100, 200, 200);
		lblall.setBounds(20, 10, 100, 20);
		lblten.setBounds(270, 20, 100, 20);
	}
	
	public highscores getscores()
	{
		return hs;
	}
	
	public void seths(highscores hs)
	{
		this.hs = hs;
	}
	
	public void setpnum(int pnum)
	{
		this.hs.setpnum(pnum);
	}
	
	@SuppressWarnings("unchecked")
	public void show()
	{
//		dlm.clear();
		dlm.clear();
		for(int i = 0;i<=hs.getpnum();i++)
		{
			if(hs.getallp()[i].getname()!="")
			{
				dlm.addElement(hs.getallp()[i].tostr());
			}
		}
		lstallp.setModel(dlm);
		dlm2.clear();
//		lstallp.setModel(dlm);
		lstten.clearSelection();
//		for(int i = 0;i<hs.getpnum();i++)
//		{
//			dlm.addElement(hs.getallp()[i].tostr());
//		}
//		lstallp.setModel(dlm);
		hs.sort();
		hs = new highscores(sort(), hs.getpnum()+1);
		for(int i = 0;i<11;i++)
		{
			if(hs.getallp()[i].getname()!="")
			{
				dlm2.addElement(hs.getallp()[i].tostr());
			}
		}
		lstten.setModel(dlm2);
//		stats temp = new stats();
//		stats arrtemp[] = new stats[100];
//		for(int i = 0;i<100;i++)
//		{
//			arrtemp[i] = new stats();
//		}
//		arrtemp = hs.getallp();
//		for(int f = 0;f<hs.getpnum()-1;f++)
//		{
//			for(int b = f;b<hs.getpnum();b++)
//			{
//				if(arrtemp[f].getscore()<arrtemp[b].getscore())
//				{
//					temp = arrtemp[f];
//					arrtemp[f] = arrtemp[b];
//					arrtemp[b] = temp;
//				}
//			}
//		}
		game.setVisible(true);
	}
	
	public void hide()
	{
		game.setVisible(false);
	}
	
	private stats[] sort()
	{
		stats temp = new stats();
		stats arrtemp[] = new stats[100];
		for(int i = 0;i<100;i++)
			{
				arrtemp[i] = new stats();
			}
			arrtemp = hs.getallp();
		for(int f = 0;f<=hs.getpnum()-1;f++)
			{
				for(int b = f;b<=hs.getpnum();b++)
				{
					if(arrtemp[f].getscore()<arrtemp[b].getscore())
					{
						temp = arrtemp[f];
						arrtemp[f] = arrtemp[b];
						arrtemp[b] = temp;
					}
				}
			}
		return arrtemp;
	}
}
