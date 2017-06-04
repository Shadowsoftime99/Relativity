import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class VisualPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private boolean isMenu;
	private Menu currentMenu;
	private Player p1;
	private Levels currentLvl;
	public VisualPanel() 
	{
		super(true);
	}
	
	public void passIn(boolean isMenu, Menu menu, Player p1, Levels lvl)
	{
		this.isMenu = isMenu;
		currentMenu = menu;
		this.p1 = p1;
		currentLvl = lvl;
	}

	private Color bg = new Color(150,150,150);
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, 1000, 1000);
		g.setColor(bg);
		g.fillRect(0, 0, 1000, 1000);
		if(isMenu)
		{
			currentMenu.drawMenu(g);
			return;
		}
		else
		{
			for(Block b : currentLvl.layout)
				if(b.isOnscreen())
					b.draw(g);
			p1.draw(g);
		}
	}

}
