import java.awt.Color;

public class HPRefill extends Pickup
{
	public HPRefill(int x, int y)
	{
		super(x, y, new Color(155, 0, 0));
	}
	
	public void impact(Player p)
	{
		if(!isPickedUp)
		{
			p.HPBar.changeHP(1);
			isPickedUp = true;	
		}
	}
}