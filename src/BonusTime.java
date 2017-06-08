import java.awt.Color;

public class BonusTime extends Pickup
{
	public BonusTime(int x, int y)
	{
		super(x, y, Color.magenta);
	}
	
	public void impact(Player p)
	{
		if(!isPickedUp)
		{
			Levels.timer += 30;
			isPickedUp = true;
		}
	}
}