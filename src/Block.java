import java.awt.Graphics;

public abstract class Block 
{
	double x = 0, y = 0;
	double Vx = 0, Vy = 0;

	int w, h;
	boolean isTriangle;
	
	public Block(int w, int h)
	{
		this.w = w;
		this.h = h;
	}
	
	public abstract void draw(Graphics g);
	
	public void setPos(DecPoint pt)
	{
		x = pt.getX();
		y = pt.getY();
	}
	
	public void setPos(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public DecPoint getCtr()
	{
		return new DecPoint(x, y);
	}
	
	/**
	 * Run whenever a player comes into contact with the Block
	 */
	public abstract void impact(Player p);
	
	/**
	 * Generates the ECB (Environmental Collision Box) for this Block
	 * @return a <code> Range[] </code> covering the entire area of the Block, in the order of horizontal, vertical
	 */
	public Range[] getECB()
	{
		double left = x-w/2.0;
		double right = x+w/2.0;
		double top = y-h/2.0;
		double bot = y+h/2.0;
		
		Range horiz = new Range(left, right);
		Range vertical = new Range(top, bot);
		
		return new Range[]{horiz, vertical};
	}
	
	public boolean checkCollision(Entity p)
	{
		double left = x-w/2.0;
		double right = x+w/2.0;
		double top = y-h/2.0;
		double bot = y+h/2.0;
		double leftP = p.x-p.w/2.0;
		double rightP = p.x+p.w/2.0;
		double topP = p.y-p.h/2.0;
		double botP = p.y+p.h/2.0;
		
		Range horiz;
		if(isTriangle) horiz = new Range(left, right+w);
		else horiz = new Range(left, right);
		Range vertical = new Range(top, bot);
		Range horizP = new Range(leftP, rightP);
		Range verticalP = new Range(topP, botP);
		
		return Range.doRangesCross(horizP, horiz) && Range.doRangesCross(vertical, verticalP);
	}
	
	public boolean isOnscreen()
	{
		return Range.doRangesCross((new Range (x-w/2, x+w/2)), new Range(GameWindow.camX, GameWindow.camX + GameWindow.GAME_WIDTH)) &&
			   Range.doRangesCross((new Range (y-h/2, y+h/2)), new Range(GameWindow.camY, GameWindow.camY + GameWindow.GAME_HEIGHT));
	}
}
