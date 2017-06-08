import java.awt.Color;

public class ManaRefill extends Pickup
{
	public ManaRefill(int x, int y)
	{
		super(x, y, Color.blue);
	}
	
	public void impact(Player p)
	{
		if(!isPickedUp)
		{
			p.SDBar.changeMana(100);
			isPickedUp = true;
		}		
	}
}