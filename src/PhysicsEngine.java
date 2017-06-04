
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
		if(p.x < GameWindow.currentLvl.ranges[0][0] + p.w/2.0 + 5) p.x = GameWindow.currentLvl.ranges[0][0] + p.w/2.0 + 5;
		else if(p.x > GameWindow.currentLvl.ranges[0][1] - p.w/2.0 - 5) p.x = GameWindow.currentLvl.ranges[0][1] - p.w/2.0 - 5;
		
	}
	
	public static void freeFall(Player p)
	{
		/*if (p.isGrounded) p.Vy = 0;
		else*/ if(!p.jumping) p.Vy -= p.g * 0.3;
	}
	
	public static void stop(Player p)
	{
		p.Vx = 0;
		p.Vy = 0;
		p.jumping = false;
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
	
	public static double jumpTimeInTicks = 0;
	
	public static void playerJump(Player p)
	{
		//if(p.y <= 400 && timeInTicks > 1) p.isGrounded = true;
		
		if(p.isGrounded && p.jumping)
		{
			jumpTimeInTicks = 0;
			p.jumping = false;
			p.Vy = 0;
			//p.y = 400;
			return;
		}
		
		double t = jumpTimeInTicks*p.g;
		
		double velo = -.10*t+2.8+p.g*2.5; //7.5+2.8 = 10.3
		
		jumpTimeInTicks++;
			
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
		p.isGrounded = false; 
		for(Block b : layout)
		{
			if(b.isOnscreen())
            {
                if(b.checkCollision(p))
                {
                    b.impact(p);
                }
            }
		}
	}
}