import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class gui {

	private static JFrame gui = new JFrame();
	private static ColorPanel panel = new ColorPanel(Color.WHITE);
	private static Timer time = new Timer(10, new t());
	private static Timer timescore = new Timer(500, new score());
	private static stats player = new stats();
	private static stats arrp[] = new stats[100];
	private static int pnum = 0;
	private static highscores hs = new highscores();
	public static JMenuBar mnubar = new JMenuBar();
	public static JMenuItem mnureset = new JMenuItem("Reset");
	public static JMenuItem mnuquit = new JMenuItem("Quit");
	public static JMenuItem mnuhigh = new JMenuItem("High Scores");
	public static JMenuItem mnugetid = new JMenuItem("Get Game ID");
	public static JMenu mnumenu = new JMenu("Menu");
//	private static continueinfo arrcon[] = new continueinfo[100];
//	private static int connum = 0;
	private static continueinfo cinfo[] = new continueinfo[100];
	private static int cnum = 0;
	private static int cgid = 0;
	private static boolean con = true;
	private static gameover gg = new gameover(hs);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		int cong = 0;
		gui.setTitle("Pong");
		gui.setSize(500, 500);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.getContentPane().add(panel);
		for(int i = 0;i<100;i++)
		{
			arrp[i] = new stats();
		}
//		for(int i = 0;i<100;i++)
//		{
//			arrcon[i] = new continueinfo();
//		}
		mnumenu.add(mnuhigh);
		mnumenu.add(mnugetid);
		mnumenu.add(mnureset);
		mnumenu.add(mnuquit);
		mnubar.add(mnumenu);
		gui.setJMenuBar(mnubar);
		open("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\pong\\scores.txt");
		opencon("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\pong\\pongcon.txt");
		cong = JOptionPane.showConfirmDialog(null, "Do you want to continue a previous game?");
		if(cong==JOptionPane.YES_OPTION)
		{
			cgid = Integer.valueOf(JOptionPane.showInputDialog("What is the game id?"));
			if(cinfo[cgid].getend()==1)
			{
				do
				{
					cgid = Integer.valueOf(JOptionPane.showInputDialog("Sorry that game has already ended. Please enter another Game ID."));
				}while(cinfo[cgid].getend()==1);
			}
			JOptionPane.showMessageDialog(null, "Welcome back "+cinfo[cgid].getplayer().getname());
			panel.setball(cinfo[cgid].getball());
			panel.setpad(cinfo[cgid].getpaddle());
			player = cinfo[cgid].getplayer();
//			for(int i = 0;i<pnum;i++)
//			{
//				if(player == arrp[i])
//				{
//					cinfo[cgid].setpos(i);
//				}
//			}
		}
		else
		{
			player.setname(JOptionPane.showInputDialog("What is your name?"));
			pnum++;
			cnum++;
			cgid = cnum-1;
			cinfo[cgid].setpos(pnum-1);
			arrp[cinfo[cgid].getpos()] = new stats(player);
		}
		hs.setallp(arrp);
		hs.setpnum(pnum);
		gg = new gameover(hs);
		JOptionPane.showMessageDialog(null, "Press 'p' to start playing");
		gui.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_P)
				{
					if (time.isRunning())
					{
						time.stop();
						timescore.stop();
					}
					else
					{
						time.start();
						timescore.start();
					}
					JOptionPane.showMessageDialog(null, "Your Game ID is "+cgid);
					savecon("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\pong\\pongcon.txt");
				}
				if (e.getKeyCode()==KeyEvent.VK_LEFT)
				{
					panel.setkeyx(-10);
				}
				else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
				{
					panel.setkeyx(10);
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				panel.setkeyx(0);
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
		});
		gui.setVisible(true);
		mnuhigh.addActionListener(new highs());
		mnureset.addActionListener(new reset());
		mnuquit.addActionListener(new quit());
		mnugetid.addActionListener(new gid());
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	static class t implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			colliddata pc = new colliddata(panel.getpad());
			gameover gg = new gameover(hs);
			continueinfo temp = new continueinfo();
			panel.repaint();
			if (panel.getball().getcy()+panel.getball().getradius()>pc.getbottom())
			{
				//arrp[cgid] = player;
				arrp[cinfo[cgid].getpos()] = cinfo[cgid].getplayer();
				cinfo[cgid].setend(1);
				hs.setallp(arrp);
				hs.setpnum(pnum);
				gg = new gameover(hs);
				gg.show();
				con= false;
				timescore.stop();
				time.stop();
			}
		}
	}
	
	static class score implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			player.addpoint();
			panel.setplayer(player);
			panel.repaint();
		}
	}
	
	static void open(String path)
	{
		String arrin[] = new String[100];
		int i=0;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       arrin[i] = line;
//		       System.out.println(line);
		       i++;
		    }
		    br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pnum = i;
		for(int x = 0;x<i;x++)
		{
			String parts[] = arrin[x].split(",");
			arrp[x].setname(parts[0]);
			arrp[x].setscore(Integer.valueOf(parts[1]));
		}
	}
	
	static void save(String path)
	{
		arrp[cgid] = player;
//		JOptionPane.showMessageDialog(null, cgid);
//		JOptionPane.showMessageDialog(null, arrp[cgid-1].tostr());
//		arrp[cgid-1].setname(player.getname());
//		arrp[cgid-1].setscore(player.getscore());
//		for(int i = 0;i<pnum;i++)
//		{
//			JOptionPane.showMessageDialog(null, arrp[i].tostr());
//		}
		try(PrintWriter out = new PrintWriter(path)  ){
			for(int i = 0; i<pnum;i++)
			{
//				JOptionPane.showMessageDialog(null, cgid);
//				JOptionPane.showMessageDialog(null, player.tostr());
//				JOptionPane.showMessageDialog(null, arrp[cgid].tostr());
//				JOptionPane.showMessageDialog(null, arrp[i].tostr());
				out.println(arrp[i].getname()+","+arrp[i].getscore());
			}
			out.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	static void savecon(String path)
	{
		String outcon = "";
		paddle temppad = new paddle();
		ball tempb = new ball();
		stats tempp = new stats();
		temppad.setcx(panel.getpad().getcx());
		temppad.setcy(panel.getpad().getcy());
		temppad.setlength(panel.getpad().getlength());
		temppad.setwidth(panel.getpad().getwidth());
		tempb.setvelocity(panel.getball().getvelocity());
		tempb.setdireciton(panel.getball().getdirection());
		tempb.setcx(panel.getball().getcx());
		tempb.setcy(panel.getball().getcy());
		tempp.setname(player.getname());
		tempp.setscore(player.getscore());
//		cinfo[cgid].setpaddle(new paddle(panel.getpad().getcx(), panel.getpad().getcy(), 100, 20, Color.BLACK));
//		cinfo[cgid].setball(new ball(panel.getball().getvelocity(),panel.getball().getdirection(),15,panel.getball().getcx(),panel.getball().getcy()));
//		cinfo[cgid].setplayer(new stats(player.getname(),player.getscore()));
		cinfo[cgid].setball(tempb);
		cinfo[cgid].setpaddle(temppad);
		cinfo[cgid].setplayer(tempp);
//		JOptionPane.showMessageDialog(null, cgid);
//		JOptionPane.showMessageDialog(null, cnum);
		try(PrintWriter out = new PrintWriter(path)) {
			for(int i = 0;i<cnum;i++)
			{
				outcon = cinfo[i].getpaddle().getcx() + ","+cinfo[i].getpaddle().getcy()+","+cinfo[i].getball().getvelocity()+","+cinfo[i].getball().getdirection()+","+cinfo[i].getball().getcx()+","+cinfo[i].getball().getcy()+",";
				outcon = outcon + cinfo[i].getplayer().getname()+","+cinfo[i].getplayer().getscore()+","+cinfo[i].getend()+","+cinfo[i].getpos();
//				JOptionPane.showMessageDialog(null, outcon);
				out.println(outcon);
			}
		}
		catch(FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
	}
	
	static void opencon(String path)
	{
		String arrin[] = new String[100];
		int i=0;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       arrin[i] = line;
		       i++;
		    }
		    br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		cnum = i;
		for(int i1 = 0;i1<100;i1++)
		{
			cinfo[i1] = new continueinfo();
		}
		for(int i1 = 0;i1<cnum;i1++)
		{
			String parts[] = arrin[i1].split(",");
			cinfo[i1].setpaddle(new paddle(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]), 100, 20, Color.BLACK));
			cinfo[i1].setball(new ball(Integer.valueOf(parts[2]),Integer.valueOf(parts[3]),15,Integer.valueOf(parts[4]),Integer.valueOf(parts[5])));
			cinfo[i1].setplayer(new stats(parts[6], Integer.valueOf(parts[7])));
			cinfo[i1].setend(Integer.valueOf(parts[8]));
			cinfo[i1].setpos(Integer.valueOf(parts[9]));
		}
//		connum=i;
//		for(int x = 0;x<i;x++)
//		{
//			String parts[] = arrin[x].split(",");
//			
////			arrcon[x] = new continueinfo(parts);
//		}
	}
	
	static class reset implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			panel.reset();
		}
	}
	
	static class highs implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			arrp[cinfo[cgid].getpos()] = cinfo[cgid].getplayer();
			cinfo[cgid].setend(1);
			hs.setallp(arrp);
			hs.setpnum(pnum);
			gg = new gameover(hs);
			gg.setpnum(pnum);
			gg.show();
//			gg.showscores();
		}
	}
	
	static class quit implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(con==true)
			{
				JOptionPane.showMessageDialog(null, "Your game id is " + cgid);
			}
			else
			{
				save("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\pong\\scores.txt");
			}
//			savecon("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\pong\\pongcon.txt");
			gui.dispose();
		}
	}
	
	static class gid implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(con==true)
			{
				JOptionPane.showMessageDialog(null, "Your Game ID is "+cgid);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Not Valid you already lost.");
			}
		}
	}
}
