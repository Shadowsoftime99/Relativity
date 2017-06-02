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
	public enum ButtonType {levelSelect, nextLevel, characterSelect, backToLevel, test, test2}; //Needs rest of button types
	
	private int x, y, width, height;
	private String label;
	private ButtonType type;
	private Color color, textColor;
	
	public Button(int x, int y, int w, int h, String l, ButtonType t, Color c, Color c2)
	{
		this.x = x;
		this.y = y;
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
			case test:
				System.out.println("Type: test");
				break;
				
			case test2:
				System.out.println("Type: test2");
				break;
				
			case backToLevel:
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
	