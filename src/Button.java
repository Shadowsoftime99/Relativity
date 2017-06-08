import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Color;
//import javax.swing.*;

/**
 * The class that contains the buttons for menus
 * @author Matt Davison
 *
 */
public class Button extends Rectangle
{
	
	private static final long serialVersionUID = 1L;
	public enum ButtonType {levelSelect, backToLevel, backToTitle, restartLevel}; //Needs rest of button types
	
	private int x, y, width, height;
	private String label;
	private ButtonType type;
	private Color color, textColor;
	
	public Button(int x, int y, int w, int h, String l, ButtonType t, Color c, Color c2)
	{
		this.x = x+w/2;
		this.y = y-h/2;
		width = w;
		height = h;
		label = l;
		type = t;
		color = c;
		textColor = c2;
	}
	
	public void drawButton(Graphics g)
	{
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(textColor);
		g.drawString(label, x + (width/5), y + (height/2));
	}
	
	public void doThing() //Still needs actual functions, waiting on button types
	{
		switch(type)
		{
			case backToLevel:
				GameWindow.isMenu = false;
				break;
				
			case backToTitle:
				Relativity.gw.showMenu(Menu.menus[1]);
				break;
				
			case restartLevel:
				Relativity.gw.restartLvl();
				GameWindow.isMenu = false;
				break;
				
			default:
				System.out.println("Unknown button type");
				break;
		}
		System.out.println(label);
	}
	
	public boolean contains(int x, int y)
	{
		if(x > this.x && y > this.y && x < (this.x + width) && y < (this.y + height)) 
			return true;
		else
			return false;
		
	}
}
	