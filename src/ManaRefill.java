import java.awt.Color;

public class ManaRefill extends Pickup
{
	public ManaRefill(int x, int y)
	{
		super(x, y, Color.blue);
	}
	
	public void impact(Player p)
	{
		p.SDBar.changeMana(100);
	}
}
