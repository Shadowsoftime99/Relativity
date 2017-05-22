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

public class Menu
{
	private static final long serialVersionUID = 1L;
	
	Button[] buttons;
	String name;
	int x, y;
	
	public Menu(String title, Button[] buttons)
	{
		this.buttons = buttons;
		name = title;
	}
	
	public void drawMenu(Graphics g)
	{
		//g.clearRect(0,  0,  2000, 2000);
		//setBackground(Color.lightGray);
		g.setFont(new Font("Comic Sans MS", 1, 20));
		g.drawString(name, 475, 100);
		g.setFont(new Font("Comic Sans MS", 0, 16));
		for(Button b : buttons)
		{
			b.drawButton(g);
		}
	}
	
}