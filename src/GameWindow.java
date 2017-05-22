import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class GameWindow extends JFrame implements KeyListener, MouseListener
{
	private static final long serialVersionUID = 1L;
	//private Player p1; private Levels[] lvls = Levels.levels;
	//protected static Levels currentLvl;
	protected static Menu currentMenu;
	public static boolean isMenu = false;
	
	public static int camX, camY;
	public static final int GAME_WIDTH = 1000, GAME_HEIGHT = 750;

	public GameWindow(/*Player p1*/)
	{
		super("Games!");
		setSize(GAME_WIDTH,GAME_HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(this);
		addMouseListener(this);
		//this.p1 = p1;
		camX = 0; camY = 0;
	}
	
	public void showMenu(Menu m)
	{
		currentMenu = m;
		isMenu = true;
	}
	
	public void hideMenu()
	{
		isMenu = false;
	}
	
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, 1000, 1000);
		setBackground(new Color(150,150,150));
		if(isMenu)
		{
			currentMenu.drawMenu(g);
			return;
		}
		/*
	
	
		p1.draw(g);
		for(Block b : currentLvl.layout)
		b.draw(g);*/
	}
	
	
	/**
	 * Starts the given level
	 * @param lvl
	 *
	public void startLvl(int lvl)
	{
		currentLvl = lvls[lvl];
		camX = currentLvl.startingX;
		camY = currentLvl.startingY;
		//currentLvl.song.start();
		p1.setPos(currentLvl.spawnX, currentLvl.spawnY);
		//other crap
	}
	
	/**
	 * Runs one frame of the game, should be continously called
	 */
	public void advance()
	{
		System.out.println(isMenu);
		/*updatePlayer();
		updateEntities();
		processAbility();
		updateCamera();
		useLastInput();
		this.repaint();
		ShadowsUtilities.delay(16);*/
	}
	/*
	private void updatePlayer()
	{
		PhysicsEngine.updatePlayerVx(p1, (p1.goingLeft || p1.goingRight), p1.goingRight);
		PhysicsEngine.freeFall(p1);
		PhysicsEngine.updatePos(p1);
		if(p1.jumping)
		{
			//System.out.println("Trying to jump");
			PhysicsEngine.playerJump(p1);
		}
		
	}
	
	private void updateEntities()
	{
		for(Block b : currentLvl.layout)
		{
			if(b instanceof Entity && b.isOnscreen())
			{
				PhysicsEngine.updateEntity((Entity) b);
			}
			PhysicsEngine.updatePos(b);
		}
	}
	
	public void processAbility()
	{
		
		if(Relativity.gameSpeed == 0.25)
		{
			p1.SDBar.cast();
		}
		else p1.SDBar.regen();
		if(p1.SDBar.blockout && p1.SDBar.isManaFull()) p1.SDBar.blockout = false;
		
		if(p1.HPBar.isMercy)
		{
			p1.SDBar.blockout = true;
			Relativity.gameSpeed = 1.0;
			p1.HPBar.flash++;
			if(p1.HPBar.flash-1 > p1.HPBar.mercyInv)
			{
				p1.HPBar.flash = 0;
				p1.HPBar.isMercy = false;
				p1.SDBar.blockout = false;
			}
		}
	}
	
	public void updateCamera()
	{
		if(p1.x - camX > 800) camX+= 7;
		if(p1.x - camX < 200) camX-= 7;
		if(camX < currentLvl.ranges[0][0]) camX = currentLvl.ranges[0][0];
		if(camX + GAME_WIDTH > currentLvl.ranges[0][1]) camX = currentLvl.ranges[0][1] - GAME_WIDTH;
	}*/
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Integer> pressed = new ArrayList<Integer>();
	int curProfile = 0;
	int[][] ctrlProfiles = {{KeyEvent.VK_D, KeyEvent.VK_A, KeyEvent.VK_SPACE, KeyEvent.VK_SHIFT},
							{}};
	@Override
	public void keyPressed(KeyEvent e) {
		if(!pressed.contains(e.getKeyCode()))
		{
			pressed.add(e.getKeyCode());
		}
	}
	
	/*public void useLastInput()
	{
		if (pressed.size() == 0) return;
		int last = pressed.get(pressed.size()-1);
		if(last == ctrlProfiles[curProfile][0])
		{
			p1.goingRight = true;
			p1.goingLeft = false;
		}
		else if(last == ctrlProfiles[curProfile][1])
		{
			p1.goingLeft = true;
			p1.goingRight = false;
		}
		if(last == ctrlProfiles[curProfile][2])
		{
			p1.jumping = true;
			p1.isGrounded = false;
		}
		if(last == ctrlProfiles[curProfile][3] && !p1.SDBar.isOOM)
		{
			if(!p1.SDBar.blockout)
				Relativity.gameSpeed = 0.25;
			else 
				Relativity.gameSpeed = 1.0;
		}
	}*/

	@Override
	public void keyReleased(KeyEvent e) {

		while(pressed.contains(e.getKeyCode()))
			pressed.remove((Integer)e.getKeyCode());
			if(e.getKeyCode() == ctrlProfiles[curProfile][3])
			{
				Relativity.gameSpeed = 1.0;
			}
			else if(e.getKeyCode() != ctrlProfiles[curProfile][2] && !pressed.contains(ctrlProfiles[curProfile][0]) && !pressed.contains(ctrlProfiles[curProfile][1]))
			{
				//p1.goingLeft = false;
				//p1.goingRight = false;
			}
			
		
	}
	
	
	
	public void mouseClicked(MouseEvent e)
	{
		//System.out.println("x: " + e.getX());
		//System.out.println("y: " + e.getY());
		for(Button b : currentMenu.buttons)
		{
			if(b.contains(e.getX(), e.getY()))
			{
				b.doThing();
			}
		}
	}
	public void mousePressed(MouseEvent e) {}
	
	public void mouseReleased(MouseEvent e) {}
	
	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {}
}