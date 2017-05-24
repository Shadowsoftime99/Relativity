import java.awt.Color;
import java.awt.Graphics;

public class HealthBar 
{
	int maxHP, currentHP, shadowHP;
	Color color, shadowColor;
	int q = 0;
	int mercyInv = 75;
	int flash = 0;
	boolean isMercy = false;
	//Clip dmgSound = ShadowsUtilities.importSoundClip("sound/oof.wav");
	
	public HealthBar(int maxHP, int initialHP, Color color, Color shadowColor)
	{
		if(initialHP <= 0 ) initialHP = 1;
		if(initialHP > maxHP) initialHP = maxHP;
		this.maxHP = maxHP;
		currentHP = initialHP;
		this.color = color;
		this.shadowColor = shadowColor;
	}
	
	public void drawBar(Graphics g, int x, int y)
	{
		g.setColor(color);
		for(int c = 1; c <= currentHP; c++)
		{
			g.fillRect(x, y, 30, 20);
			x+=30;
		}
		g.setColor(shadowColor);
		for(int c = currentHP+1; c <= shadowHP; c++)
		{
			g.fillRect(x, y, 30, 20);
			x+=30;
		}
		q++;
		if(q == 15) //used to make sure the shadow HP stays for a bit
		{
			q = 0;
			shadowHP = currentHP;
		}
	}
	
	public void changeHP(int amt)
	{
		shadowHP = currentHP;
		currentHP += amt;
		if(currentHP > maxHP) currentHP = maxHP;
		if(currentHP < 0) currentHP = 0;
	}
	
	public void takeDmg()
	{
		changeHP(-1);
		if(currentHP == 0) return; //(isDead)
		playDMGsound();
		isMercy = true;
	}
	
	public void fullHeal()
	{
		changeHP(maxHP);
	}
	
	private void playDMGsound()
	{
		//dmgSound = ShadowsUtilities.importSoundClip("sound/oof.wav");
		//dmgSound.start();
	}
}
