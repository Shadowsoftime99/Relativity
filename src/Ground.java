import java.awt.Color;
import java.awt.Graphics;

public class Ground extends Block
{
	public Ground(int w, int h, int x, int y)
	{
		super(25,25);
		this.x = x+w/2;
		this.y = y-h/2;
		this.w = w;
		this.h = h;
	}

	@Override
	public void draw(Graphics g) 
	{
		g.setColor(new Color(35, 35, 35));
		g.fillRect((int)x-w/2 - GameWindow.camX, (int)(GameWindow.GAME_HEIGHT - (y+h/2) + GameWindow.camY), w, h);
	}
	
	/*
	public boolean checkCollision(Block ent)
	{
		double left1 = ent.x-ent.w/2.0;
		double right1 = ent.x+ent.w/2.0;
		double top1 = ent.y-ent.h/2.0;
		double bot1 = ent.y+ent.h/2.0;
		double left2 = x-w/2;
		double right2 = x+w/2;
		double top2 = y+h/2;
		double bot2 = y-h/2;
		
		Range horiz1 = new Range(left1, right1);
		Range vertic1 = new Range(top1, bot1);
		Range horiz2 = new Range(left2, right2);
		Range vertic2 = new Range(top2, bot2);
		
		return Range.doRangesCross(horiz1, horiz2) && Range.doRangesCross(vertic1, vertic2);
	}*/
	
	public void impact(Player p)
	{
		//nothing
	}
}
