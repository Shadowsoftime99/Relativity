import java.awt.Color;
import java.awt.Graphics;

import javax.sound.sampled.Clip;

import java.awt.Font;

public class Player extends Entity
{
	public static byte lives; // :D
	double g;
	double maxSpeed;
	double accel;
	double friction;
	String name;
	boolean goingRight = false, goingLeft = false, jumping = false;
	boolean isGrounded = true;
	HealthBar HPBar;
	AbilityBar SDBar;
	
	public Player(int w, int h, int HP, int SP, double fallSpeed, double topSpeed, double accel, double friction, String name)
	{
		super(w, h);
		g = fallSpeed;
		maxSpeed = topSpeed;
		this.friction = friction;
		this.accel = accel;
		this.name = name;
		HPBar = new HealthBar(HP, HP, Color.red, Color.GRAY);
		SDBar = new AbilityBar(SP, Color.blue, 3, 1);
		lives = 3;
	}
	
	private int k = 0;
	private Font lifeFont = new Font("TimesRoman",Font.PLAIN, 30);
	public void draw(Graphics g)
	{
		if(HPBar.isMercy) k++;
		else k = 0;
		
		g.setColor(new Color(155,0,0));
		if (k%4==0)
		g.fillRect((int)x-w/2  - GameWindow.camX, (int)(GameWindow.GAME_HEIGHT - y-h/2 + GameWindow.camY), w, h);
		HPBar.drawBar(g, 70, 50);
		SDBar.drawBar(g, 700, 50);
		
		g.setColor(Color.RED);
		g.setFont(lifeFont);
		g.drawString("x" + lives, 37, 70);
	}	
	
	public void impact(Player p)
	{
		//nothing
	}
	
	//private static Clip deathSound = ShadowsUtilities.importSoundClip("./music/death.wav");
	public static void die()
	{
		//GameWindow.currentLvl.song.stop();
		//deathSound.start();
		Relativity.gw.animateDeath();
		//show died screen.menu
		Player.lives--;
		Relativity.gw.restartLvl();
		//deathSound.setMicrosecondPosition(0);
		if(Player.lives==0)
		{
			Relativity.gw.showMenu(Menu.menus[5]);
		}
	}
	
	public void lifeUp()
	{
		lives++;
	}
}