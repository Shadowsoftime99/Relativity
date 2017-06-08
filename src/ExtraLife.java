import java.awt.Color;

public class ExtraLife extends Pickup
{
	public ExtraLife(int x, int y)
	{
		super(x, y, Color.green);
	}
	
	public void impact(Player p)
	{
		if(!isPickedUp)
		{
			if(Player.lives < 5) Player.lives++;
			isPickedUp = true;
		}	
	}
}
