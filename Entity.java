import java.awt.Graphics;

public abstract class Entity extends Block
{
	double baseMS;
	boolean isVertical;
	int direction;
	int max, min;
	
	public Entity(int w, int h)
	{
		super(w,h);
	}
	
	
	public abstract void draw(Graphics g);
	
	
}
