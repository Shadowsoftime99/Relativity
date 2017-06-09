import java.awt.Color;
import java.awt.Graphics;

public class Fire extends Ground
{
	public Fire(int w, int h, int x, int y)
	{
		super(w, h, x, y);
		isTriangle = true;
	}
	
	public void draw(Graphics g)
	{
		int[] xPoints = {(int)x-w/2 - GameWindow.camX+w, (int)x-w/2 - GameWindow.camX+2*w, (int)x-w/2 - GameWindow.camX};
		int[] yPoints = {(int)(GameWindow.GAME_HEIGHT - (y+h/2) + GameWindow.camY), (int)(GameWindow.GAME_HEIGHT - (y+h/2) + GameWindow.camY) + h, (int)(GameWindow.GAME_HEIGHT - (y+h/2) + GameWindow.camY) + h};
		g.setColor(new Color(225, 50, 0));
		g.fillPolygon(xPoints, yPoints, 3);
	}
	
	public void impact(Player p)
	{
		if(!p.HPBar.isMercy)
			p.HPBar.takeDmg();
	}
}
