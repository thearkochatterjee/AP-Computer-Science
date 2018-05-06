package pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorPanel extends JPanel{
	private ball b;
	
	public ColorPanel(Color backColor, int width, int height)
	{
		setBackground(backColor);
		setPreferredSize(new Dimension(width, height));
		b = new ball(10, 45, width/2, height/2, 25, Color.RED);
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		b.draw(g);
	}
	
	private class MouseListener extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			b.move();
		}
	}
}
