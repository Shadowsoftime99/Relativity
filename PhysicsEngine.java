
public class PhysicsEngine
{	
	public static void updatePos(Block e)
	{
		e.setPos(e.x + e.Vx, e.y + e.Vy);		
	}
	
	public static void updatePos(Player p)
	{
		enforceAllCollision(p, GameWindow.currentLvl.layout);
		p.setPos(p.x + p.Vx, p.y + p.Vy);
		
	}
	
	public static void updatePlayerVy(Player p)
	{
		/*if (p.isGrounded) p.Vy = 0;
		else*/ if(!p.jumping) p.Vy -= p.g * 0.5;
	}
	
	public static void updatePlayerVx(Player p, boolean isAccel, boolean isRightward)
	{	
		double origVx = p.Vx;
		double accel = isAccel ? p.accel : p.friction * Math.signum(p.Vx);
		
		if(!p.isGrounded && !isAccel) accel = p.friction * Math.signum(p.Vx)/1.5;
		
		if(!isRightward) accel *= -1;
		
		p.Vx = p.Vx + accel;
		
		if(Math.abs(p.Vx) > Math.abs(origVx) && !isAccel)
			p.Vx = 0;
		
		if(Math.abs(p.Vx) > p.maxSpeed)
			p.Vx = Math.signum(p.Vx) * Math.min(p.maxSpeed, Math.abs(p.Vx)); 
		
	}
	
	private static double timeInTicks = 0;
	
	public static void playerJump(Player p)
	{
		//if(p.y <= 400 && timeInTicks > 1) p.isGrounded = true;
		if(p.isGrounded && p.jumping)
		{
			timeInTicks = 0;
			p.jumping = false;
			p.Vy = 0;
			//p.y = 400;
			return;
		}
		
		double t = timeInTicks*p.g;
		
		double velo = -.10*t+2.8+p.g*2.5;
		
		timeInTicks++;
			
		p.Vy = velo;
	}
	
	public static void updateEntity(Entity e)
	{
		if(e.isVertical)
			{
			if(e.y > e.max) e.direction = -1;
			if(e.y < e.min) e.direction = 1;
			e.y += e.baseMS * e.direction * Relativity.gameSpeed;		
			}
		else  
			{
			if(e.x > e.max) e.direction = -1;
			if(e.x < e.min) e.direction = 1;
			e.x += e.baseMS * e.direction * Relativity.gameSpeed;
			
			}
	}
	
	/**
	 * Compares the Player's position to all objects in the level and acts accordingly
	 * @param p Player
	 * @param layout Current level's objects
	 */
	public static void enforceAllCollision(Player p, Block[] layout)
	{
		double newXCtr = p.x + p.Vx;
		Range pXRange = new Range(newXCtr-p.w/2.0, newXCtr+p.w/2.0);
		double newYCtr = p.y + p.Vy;
		Range pYRange = new Range(newYCtr-p.h/2.0, newYCtr+p.h/2.0);
		p.isGrounded = false;
		for(Block b : layout)
		{
			if(b.checkCollision(p))
			{
				
				Range[] ECB = b.getECB();
			
				if(Range.doRangesCross(ECB[1], pYRange) && Math.abs(b.x - newXCtr) < Math.abs(b.x - p.x))
				{
					if(b instanceof Ground)
					p.Vx = 0;
					b.impact(p);
				}
				if(Range.doRangesCross(ECB[0], pXRange) && Math.abs(b.y - newYCtr) < Math.abs(b.y - p.y))
				{
					p.Vy = 0;
					if(b instanceof Ground){
					if(p.y > b.y)
					p.y = b.y + b.h/2.0+p.h/2.0;
					else if(p.y < b.y)
					p.y = b.y - b.h/2.0-p.h/2.0;
					p.isGrounded = true;
					p.jumping = false;
					timeInTicks = 0;
					}
					
					b.impact(p);
				}
				
			}
		}
	}
}