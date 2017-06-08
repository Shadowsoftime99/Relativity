/**
 * The class that creates the various menus in the game
 * @author Matt Davison
 *
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

import javax.swing.JFrame;

public class Menu
{	
	public static Menu[] menus = new Menu[11];
	Button[] buttons;
	String name;
	int x, y, f, t;
	private static boolean hasRun = false;
	private Image img;
	
	public Menu(String title, Button[] buttons, int size, int titleSize)
	{
		this.buttons = buttons;
		name = title;
		f = size;
		t = titleSize;
		img = null;
	}
	
	public Menu(String title, Button[] buttons, int size, int titleSize, Image image)
	{
		this.buttons = buttons;
		name = title;
		f = size;
		t = titleSize;
		img = image;
	}
	
	private Color bg = new Color(150,150,150);
	public void drawMenu(Graphics g)
	{
		g.clearRect(0,  0,  1000, 1000);
		g.setColor(bg);
		g.fillRect(0, 0, 1000, 1000);
		if(img != null) g.drawImage(img, 0, 0, GameWindow.GAME_WIDTH, GameWindow.GAME_HEIGHT, Relativity.gw);
		g.setColor(Color.black);
		g.setFont(new Font("Comic Sans MS", 1, t));
		g.drawString(name, GameWindow.GAME_WIDTH/2 - name.length()*9, 100);
		g.setFont(new Font("Comic Sans MS", 0, f));
		for(Button b : buttons)
		{
			b.drawButton(g);
		}
	}
	
	public static void initialize()
	{
		if(hasRun) return;
		
		hasRun = true;
		Button[] buttons1 = {new Button(GameWindow.GAME_WIDTH/5, GameWindow.GAME_HEIGHT/2, 300, 300, "Play", Button.ButtonType.backToLevel, Color.blue, Color.cyan)
		};
		Menu start = new Menu("Relativity", buttons1, 48, 36);
		menus[1] = start;
		
		Button[] buttons2 = {new Button(GameWindow.GAME_WIDTH/5, GameWindow.GAME_HEIGHT/3, 200, 200, "Next\nLevel", Button.ButtonType.backToLevel, Color.blue, Color.cyan),
		new Button(GameWindow.GAME_WIDTH/5, 2*(GameWindow.GAME_HEIGHT/3), 200, 200, "Back to\nTitle", Button.ButtonType.backToTitle, Color.red, Color.black)};
		Menu nextLvl = new Menu("Level complete!", buttons2, 36, 24);
		menus[2] = nextLvl;
	}
}