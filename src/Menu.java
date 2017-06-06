/**
 * The class that creates the various menus in the game
 * @author Matt Davison
 *
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
	private BufferedImage img;
	private JFrame obs = Relativity.gw;
	
	public Menu(String title, Button[] buttons, int size, int titleSize)
	{
		this.buttons = buttons;
		name = title;
		f = size;
		t = titleSize;
		img = null;
	}
	
	public Menu(String title, Button[] buttons, int size, int titleSize, BufferedImage image)
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
		if(img != null) g.drawImage(img, 0, 0, GameWindow.GAME_WIDTH, GameWindow.GAME_HEIGHT, obs);
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
		//BufferedImage bi = new BufferedImage(GameWindow.GAME_WIDTH, GameWindow.GAME_HEIGHT, BufferedImage.TYPE_BYTE_INDEXED);
		//bi.setData(new Raster());
		Menu m1 = new Menu("Relativity", buttons1, 48, 36);
		
		menus[1] = m1;
	}
}