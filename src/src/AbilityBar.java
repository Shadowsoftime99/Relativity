import java.awt.Color;
import java.awt.Graphics;

public class AbilityBar 
{
	int maxMana;
	int mana;
	Color color;
	int cost; //cost per tick
	int regenRate;
	boolean isOOM = false;
	boolean blockout = false;
	
	public AbilityBar(int maxMana, Color c, int manaCost, int regen)
	{
		mana = maxMana;
		this.maxMana = maxMana;
		color = c;
		cost = manaCost;
		regenRate = regen;
	}
	
	public void cast()
	{
		if(blockout)
			return;
		if(mana < cost)
		{
			isOOM = true;
			blockout = true;
			Relativity.gameSpeed = 1.0;
		}
		else
		{
			mana -= cost;
			isOOM = false;
		}
		
	}
	
	public void drawBar(Graphics g, double x, double y) 
	{
		g.setColor(color);
		g.fillRect((int)x,(int)y,(int)(mana/2.0),15);
		
		g.setColor(Color.white);
		g.drawString(mana + "/" + maxMana, (int)x+10, (int)y+12);	
	}	
	
	public void regen()
	{
		mana+=regenRate;
		if(mana > cost) isOOM = false;
		if(mana > maxMana) mana = maxMana;
	}
	
	public boolean isManaFull()
	{
		if(mana == maxMana) return true;
			
		return false;
	}

}
