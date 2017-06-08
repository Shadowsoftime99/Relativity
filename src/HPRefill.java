import java.awt.Color;

public class HPRefill extends Pickup
{
	public HPRefill(int x, int y)
	{
		super(25, 25, new Color(255, 0, 0));
	}
	
	public void impact(Player p)
	{
		p.HPBar.changeHP(1);
	}
}
