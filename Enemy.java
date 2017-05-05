import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Entity 
{
	public Enemy(int w, int h, int initX, int initY, int min, int max, double baseMS, boolean isVertical)
	{
		super(w,h);
		this.isVertical = isVertical;
		this.min = min;
		this.max = max;
		this.baseMS = baseMS;
		setPos(initX, initY);
	}
	
	public void draw(Graphics g)
	{
		{
			g.setColor(new Color(0,0,155));
			g.fillRect((int)x-w/2 - GameWindow.camX, (int)(GameWindow.GAME_HEIGHT - y - h/2 + GameWindow.camY), w, h);
		}
	}
	
	public void impact(Player p)
	{
		if(!p.HPBar.isMercy)
		p.HPBar.takeDmg();
	}
}
