import java.awt.Color;
import java.awt.Graphics;

public class Spike extends Ground 
{
	int w, h, x, y;
	
	public Spike(int w, int h, int x, int y)
	{
		super(w, h, x, y);
		this.x = x+w/2;
		this.y = y-h/2;
		this.w = w;
		this.h = h;
	}
	
	
	
	@Override
	public void draw(Graphics g)
	{
		int[] xPoints = {(int)x-w/2 - GameWindow.camX+w, (int)x-w/2 - GameWindow.camX+2*w, (int)x-w/2 - GameWindow.camX};
		int[] yPoints = {(int)(GameWindow.GAME_HEIGHT - (y+h/2) + GameWindow.camY), (int)(GameWindow.GAME_HEIGHT - (y+h/2) + GameWindow.camY) + h, (int)(GameWindow.GAME_HEIGHT - (y+h/2) + GameWindow.camY) + h};
		g.setColor(new Color(70, 70, 70));
		g.fillPolygon(xPoints, yPoints, 3);
	}
	
	public void impact(Player p)
	{
		Player.die();
	}
}
