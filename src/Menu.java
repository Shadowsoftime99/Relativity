/**
 * The class that creates the various menus in the game
 * @author Matt Davison
 *
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menu extends JFrame implements MouseListener
{
	private static final long serialVersionUID = 1L;
	
	Button[] buttons;
	String name;
	int x, y;
	
	public Menu(String title, Button[] buttons)
	{
		super(title);
		this.buttons = buttons;
		name = title;
		setSize(1000, 1000);
		addMouseListener(this);
	}
	
	public void drawMenu(Graphics g)
	{
		g.clearRect(0,  0,  2000, 2000);
		setBackground(Color.lightGray);
		g.setFont(new Font("Comic Sans MS", 1, 20));
		g.drawString(name, 475, 100);
		g.setFont(new Font("Comic Sans MS", 0, 16));
		for(Button b : buttons)
		{
			b.drawButton(g);
		}
	}
	public void paint(Graphics g)
	{
		drawMenu(g);
	}
	
	public void mouseClicked(MouseEvent e)
	{
		//System.out.println("x: " + e.getX());
		//System.out.println("y: " + e.getY());
		for(Button b : buttons)
		{
			if(b.contains(e.getX(), e.getY()))
			{
				b.doThing();
			}
		}
	}
	public void mousePressed(MouseEvent e) {}
	
	public void mouseReleased(MouseEvent e) {}
	
	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {}
	
}
