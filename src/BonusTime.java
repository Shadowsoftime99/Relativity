import java.awt.Color;

public class BonusTime extends Pickup
{
	public BonusTime(int x, int y)
	{
		super(x, y, new Color(255, 255, 255));
	}
	
	public void impact(Player p)
	{
		//Levels.timer += 30;
	}
}
