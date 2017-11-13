package grid;
import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Scanner;
import java.util.Random;

public class grid {

	public static void main(String[] args) {
		JPanel p[] = new JPanel[10000];
		Scanner reader= new Scanner(System.in);
		JFrame thegui=new JFrame();
		Container pane = thegui.getContentPane();
		Random rand= new Random();
		int box = 0;
		int row = 0;
		int column = 0;
		int ans=1;
		thegui.setTitle("Grid Program");
		thegui.setSize(600,400);
		thegui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.print("How Many Rows would you like?");
		row = reader.nextInt();
		System.out.print("How many columns would you like?");
		column= reader.nextInt();
		box=row*column;
		pane.setLayout(new GridLayout(row, column));
		JOptionPane.showMessageDialog(null, "Warning: flashing colors", "Warning", JOptionPane.INFORMATION_MESSAGE);
		
		for (int x=1;x<=box;x++)
		{
			p[x]=new JPanel();
			Color c = new Color(rand.nextInt(255) + 0,rand.nextInt(255) + 0,rand.nextInt(255) + 0);
			p[x].setBackground(c);
		}
		for (int x=1;x<=box;x++)
		{
			pane.add(p[x]);
		}
		thegui.setVisible(true);
		do
		{
			for (int x=1;x<=box;x++)
			{
				Color c = new Color(rand.nextInt(255) + 0,rand.nextInt(255) + 0,rand.nextInt(255) + 0);
				p[x].setBackground(c);
			}
			thegui.setVisible(true);
		}while (ans==1);
	}

}
