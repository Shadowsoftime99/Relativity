import java.awt.Color;
import java.awt.Graphics;

public abstract class Pickup extends Block
{
	Color c;
	public Pickup(int x, int y, Color c)
	{
		super(25, 25);
		setPos(x, y);
		this.c = c;
	}

	public void draw(Graphics g)
	{
		g.setColor(c);
		g.fillOval((int)x-w/2 - GameWindow.camX, (int)(GameWindow.GAME_HEIGHT - (y+h/2) + GameWindow.camY), w, h);
	}
	
	public abstract void impact(Player p);
}
