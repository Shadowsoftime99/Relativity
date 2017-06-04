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

	public void draw(Graphics g) 
	{
		g.setColor(new Color(35, 35, 35));
		g.fillRect((int)x-w/2 - GameWindow.camX, (int)(GameWindow.GAME_HEIGHT - (y+h/2) + GameWindow.camY), w, h);
	}
		
	public void impact(Player p)
	{
		double newXCtr = p.x + p.Vx;
		Range pXRange = new Range(newXCtr-p.w/2.0, newXCtr+p.w/2.0);
		double newYCtr = p.y + p.Vy;
		Range pYRange = new Range(newYCtr-p.h/2.0, newYCtr+p.h/2.0);
		
		Range[] ECB = getECB();
		
		if(Range.doRangesCross(ECB[1], pYRange) && Math.abs(x - newXCtr) < Math.abs(x - p.x))
		{
			if(p.y < y + h/2 && p.y + p.h/2 > y - h/2) 
			{
				if(Range.doRangesCross(ECB[0], pXRange))
				{
					if(p.x > x + w/2)
					{
						p.x = x + w/2.0+p.w/2.0;
						p.Vx = 0;
					}
					else if(p.x < x - w/2)
					{
						p.x = x - w/2.0-p.w/2.0;
						p.Vx = 0;
					}	
				}
			}
		}
		if(Range.doRangesCross(ECB[0], pXRange) && Math.abs(y - newYCtr) < Math.abs(y - p.y))
		{
			if(p.x - p.w/2 < x + w/2 && p.x + p.w/2 > x - w/2)
			{
				if(Range.doRangesCross(ECB[1], pYRange))
				{
					if(p.y - p.h/2 > y)
					{
						p.y = y + h/2.0+p.h/2.0;
						p.Vy = 0;
						p.isGrounded = true;
						p.jumping = false;
						PhysicsEngine.jumpTimeInTicks = 0;
					}
					else if(p.y + p.h/2 < y)
					{
						p.y = y - h/2.0-p.h/2.0;
						p.Vy = 0;
						p.isGrounded = true;
						p.jumping = false;
						PhysicsEngine.jumpTimeInTicks = 0;
					}
				}	
			}
		}		
	}
}
