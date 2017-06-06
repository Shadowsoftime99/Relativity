import java.awt.Color;
import java.awt.Graphics;

public class Ice extends Ground
{
	public Ice(int w, int h, int x, int y)
	{
		super(w, h, x, y);
	}
	
	public void draw(Graphics g) 
	{
		g.setColor(Color.cyan);
		g.fillRect((int)x-w/2 - GameWindow.camX, (int)(GameWindow.GAME_HEIGHT - (y+h/2) + GameWindow.camY), w, h);
	}
	
	public void impact(Player p)
	{
		p.friction = 0.35; 
		double newXCtr = p.x + p.Vx;
		Range pXRange = new Range(newXCtr-p.w/2.0, newXCtr+p.w/2.0);
		double newYCtr = p.y + p.Vy;
		Range pYRange = new Range(newYCtr-p.h/2.0, newYCtr+p.h/2.0);
		
		Range[] ECB = getECB();
		
		if(Range.doRangesCross(ECB[1], pYRange) && Math.abs(x - newXCtr) < Math.abs(x - p.x))
		{
			
			if(p.y < y + h/2 && p.y > y - h/2)
			{
				p.Vx = 0;
				if(p.x > x)
					p.x = x + w/2.0+p.w/2.0;
				else if(p.x < x)
					p.x = x - w/2.0-p.w/2.0;
				
			}
		}
		if(Range.doRangesCross(ECB[0], pXRange) && Math.abs(y - newYCtr) < Math.abs(y - p.y))
		{
			if(p.x - p.w/2 < x + w/2 && x + p.w/2 > x - h/2)
			{
				p.Vy = 0;
				if(p.y > y)
					p.y = y + h/2.0+p.h/2.0;
				else if(p.y < y)
					p.y = y - h/2.0-p.h/2.0;
				
				if(ECB[0].contains(p.x)) p.isGrounded = true;
				p.jumping = false;
				PhysicsEngine.jumpTimeInTicks = 0;
				
			}
		}		
	}
}
