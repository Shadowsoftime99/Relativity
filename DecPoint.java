import java.awt.Point;

public class DecPoint extends Point
{
	private static final long serialVersionUID = 1L;
	private double x, y;
	
	public DecPoint(double x, double y)
	{
		super();
		this.x = x;
		this.y = y;
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
}
