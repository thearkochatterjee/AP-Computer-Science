package pong;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class gui {

	private static JFrame gui = new JFrame();
	private static JLabel player1 = new JLabel();
	private static JLabel player2 = new JLabel();
	private static JLabel ball = new JLabel();
	private static Container pane = new Container();
	private static ColorPanel panel = new ColorPanel(Color.white);
	private static stats p1 = new stats();
	private static stats p2 = new stats();
	private static Timer time = new Timer(10, null);
	private static moveanime p1move = new moveanime();
	private static moveanime p2move = new moveanime();
	private static moveanime ballmove = new moveanime();
	private static JLabel lblscore = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String name = "";
		gui.setTitle("Pong");
		gui.setSize(500,500);
		gui.getContentPane().add(pane);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		name = JOptionPane.showInputDialog("What is player 1 name?");
		p1 = new stats(name,0);
		name = JOptionPane.showInputDialog("What is player 2 name?");
		p2 = new stats(name,0);
		pane.add(player1);
		pane.add(player2);
		pane.add(ball);
		pane.add(lblscore);
		ballmove.setx(5);
		ballmove.sety(5);
		time.start();
		player1.setBounds(27, 47, 30, 100);
		player2.setBounds(426, 22, 30, 100);
		ball.setBounds(107, 193, 20, 20);
		lblscore.setBounds(0,0,1000,20);
		gui.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_W)
				{
					p1move.sety(-10);
				}
				else if(e.getKeyCode()==KeyEvent.VK_S)
				{
					p1move.sety(10);
				}
				if(e.getKeyCode()==KeyEvent.VK_UP)
				{
					p2move.sety(-10);
				}
				else if(e.getKeyCode()==KeyEvent.VK_DOWN)
				{
					p2move.sety(10);
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				p1move.sety(0);
				p2move.sety(0);
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
		});
		lblscore.setText(p1.tostr()+" "+p2.tostr());
		player1.setBackground(Color.BLACK);
		player2.setBackground(Color.black);
		ball.setBackground(Color.black);
		player1.setOpaque(true);
		player2.setOpaque(true);
		ball.setOpaque(true);
		gui.setVisible(true);
		time.addActionListener(new movement());
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
	
	static void hitwall()
	{
		if (ball.getX()<=0)
		{
			ballmove.reversex();
			p2.win();
		}
		if (ball.getY()<=15)
		{
			ballmove.reversey();
		}
		if (ball.getX()>=460)
		{
			ballmove.reversex();
			p1.win();
		}
		if (ball.getY()>=450)
		{
			ballmove.reversey();
		}
		if(collid(ball,player1)==true)
		{
			ballmove.reversex();
		}
		if (collid(ball,player2)==true)
		{
			ballmove.reversex();
		}
		lblscore.setText(p1.tostr()+" "+p2.tostr());
	}
	
	static boolean collid(JLabel obj1, JLabel obj2)
	{
		boolean collid = false;
		objcolliddata p1c = new objcolliddata(obj1);
		objcolliddata p2c = new objcolliddata(obj2);
		if((p1c.getleft()<p2c.getright())&&(p2c.getleft()<p1c.getright()))
		{
			if((p1c.gettop()<p2c.getbottom())&&(p2c.gettop()<p1c.getbottom()))
			{
				collid = true;
			}
		}
		return collid;
	}
	
	static class movement implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			hitwall();
			ball.setBounds(ball.getX()+ballmove.getx(), ball.getY()+ballmove.gety(), 20, 20);
			player1.setBounds(player1.getX()+p1move.getx(), player1.getY()+p1move.gety(), 30, 100);
			player2.setBounds(player2.getX()+p2move.getx(), player2.getY()+p2move.gety(), 30, 100);
		}
	}
}
