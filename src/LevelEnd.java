import java.awt.Color;
import java.awt.Graphics;

public class LevelEnd extends Block
{
	public LevelEnd(int x, int y)
	{
		super(25, 25);
		setPos(x, y);
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.green);
		g.fillRect((int)x-w/2 - GameWindow.camX, (int)(GameWindow.GAME_HEIGHT - (y+h/2) + GameWindow.camY), w, h);
	}
	
	public void impact(Player p)
	{
		Relativity.gw.advanceLvl();
	}
}