/**
 * The class that creates the various menus in the game
 * @author Matt Davison
 *
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menu
{	
	public static Menu[] menus = new Menu[11];
	Button[] buttons;
	String name;
	int x, y;
	private static boolean hasRun = false;
	
	public Menu(String title, Button[] buttons)
	{
		this.buttons = buttons;
		name = title;
	}
	
	private Color bg = new Color(150,150,150);
	public void drawMenu(Graphics g)
	{
		g.clearRect(0,  0,  1000, 1000);
		g.setColor(bg);
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.black);
		g.setFont(new Font("Comic Sans MS", 1, 20));
		g.drawString(name, 475, 100);
		g.setFont(new Font("Comic Sans MS", 0, 16));
		for(Button b : buttons)
		{
			b.drawButton(g);
		}
	}
	
	public static void initialize()
	{
		if(hasRun) return;
		
		hasRun = true;
		Button[] buttons1 = {new Button(100, 100, 100, 100, "Play", Button.ButtonType.backToLevel, Color.blue, Color.cyan)
		};
		Menu m1 = new Menu("Test", buttons1);
		
		menus[1] = m1;
	}
}