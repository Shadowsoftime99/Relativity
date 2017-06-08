import javax.sound.sampled.Clip;

public class Levels
{
	public static Levels[] levels = new Levels[11];
	private static boolean hasRun = false;
	public static int timer = 0;
	
	public Block[] layout;
	public Clip song;
	public int startingX, startingY;
	public int spawnX, spawnY;
	public int[][] ranges;
	public int maxTime;
	
	private static int frameC = 0;
	public static void runTimer()
	{
		frameC++;
		if(frameC >= 30)
		{
			timer--;
			frameC = 0;
		}
		if(timer == 0)
		{
			Player.die();
		}
	}
	/**
	 * To be run at the beginning of the game; sets up this class' static <code>levels</code> array
	 */
	public static void initialize() 
	{
		if(hasRun) return; //singleton implementation; prevents code from running more than once
		
		hasRun = true;
		Levels l1 = new Levels();
		Block[] layout1 = {
				new Ground(1000, 600, 0, 375),
				new Ground(50, 50, 200, 425),
				new Enemy(50, 50, 700, 500, 400, 500, 8.0, true),
				new Enemy(50, 50, 1400, 425, 1400, 1600, 24.0, false),
				new Ground(500, 50, 300, 575), //power-up on the edge of this platform
				new Ground(400, 50, 900, 600),
				new Ground(50, 100, 1000, 700),
				new Enemy(50, 50, 1050, 650, 1250, 1050, 16, false),
				new Spike(50, 100, 1000, 175),
				new Spike(50, 100, 1100, 175),
				new Ground(1300, 600, 1200, 375),//spikes in pit
				new Ground(50, 100, 1350, 475),
				new Ground(50, 100, 1600, 475),
				new Ground(300, 50, 1750, 550),
				new Enemy(50, 50, 1750, 450, 1750, 2050, 16, false),
				new Ground(500, 50, 2200, 700),
				new LevelEnd(2490, 500),
				new Ground(500, 50, 2900, 400),//extra life goes here
				new Spike(1000, 50, 2500, 100)
		};
		
		l1.layout = layout1;
		l1.startingX = 0;
		l1.startingY = 100;
		l1.spawnX = 50;
		l1.spawnY = 400;
		int[][] ranges1 = {{0,6000},{0, 3000}};
		l1.ranges = ranges1;
		l1.maxTime = 75;
		//l1.song = ShadowsUtilities.importSoundClip("./music/stage1.wav");
		
		levels[1] = l1;
		
		
		Levels l2 = new Levels();
		Block[] layout2 = {
				new Ground(3200, 600, 0, 375),
				new Ground(3200, 300, 0, 910),
				new Enemy(50, 50, 700, 550, 700, 200, 16, false),
				new Enemy(50, 50, 200, 425, 200, 700, 16, false),
				new Ground(500, 50, 900, 425),//moving platform, slows down with ability/crushed= death
				new Ground(50, 50, 1650, 425),
				new Ground(50, 50, 1700, 475),
				new Ground(400, 50, 1750, 525),
				new Enemy(50, 50, 2150, 425, 600, 375, 24, true),//guards a power up
				new Ground(650, 50, 2400, 425),//moving platform
				new LevelEnd(3190, 500),
				new Ground(700, 1000, 3200, 1000)
		};
		
		l2.layout = layout2;
		l2.startingX = 0;
		l2.startingY = 100;
		l2.spawnX = 50;
		l2.spawnY = 400;
		int[][] ranges2 = {{0,6000},{0, 3000}};
		l2.ranges = ranges2;
		l2.maxTime = 100;
		//l1.song = ShadowsUtilities.importSoundClip("./music/stage1.wav");
		
		levels[2] = l2;
		
		
		Levels l3 = new Levels();
		Block[] layout3 = {
				new Ground(3200, 600, 0, 375),
				new Ground(3200, 300, 0, 910),
				new Ground(450, 50, 0, 500),
				new Enemy(50, 50, 300, 550, 575, 400, 24, true),
				new Enemy(50, 50, 400, 425, 450, 700, 12, false),
				new Enemy(50, 50, 700, 550, 575, 400, 24, true),
				new Ground(500, 50, 550, 500),
				new Ground(750, 50, 900, 500),
				new Enemy(50, 50, 1100, 550, 575, 400, 24, true),
				new Enemy(50, 50, 1500, 550, 575, 400, 24, true),
				new Ground(700, 50, 1750, 500),
				new Enemy(50, 50, 1900, 550, 575, 400, 24, true),
				new Enemy(50, 50, 1600, 550, 1400, 2000, 12, false),
				new Enemy(50, 50, 2300, 550, 575, 400, 24, true),
				new Ground(1000, 50, 2550, 500),
				new Enemy(50, 50, 2700, 550, 575, 400, 24, true),
				new LevelEnd(3150, 550),//1-up should go beneath this
				new Ground(700, 1000, 3200, 1000)
		};
		
		l3.layout = layout3;
		l3.startingX = 0;
		l3.startingY = 100;
		l3.spawnX = 50;
		l3.spawnY = 400;
		int[][] ranges3 = {{0,6000},{0, 3000}};
		l3.ranges = ranges3;
		l3.maxTime = 100;
		//l1.song = ShadowsUtilities.importSoundClip("./music/stage1.wav");
		
		levels[3] = l3;
		
		
		Levels l4 = new Levels();
		Block[] layout4 = {
				new Ice(850, 600, 0, 375),
				new Ice(200, 50, 300, 550),
				new Enemy(50, 50, 550, 800, 800, 400, 16, true),
				new Enemy(50, 50, 600, 400, 400, 800, 16, true),
				new Ice(200, 50, 650, 650),
				new Spike(3000, 50, 850, 100),
				new Ground(500, 50, 1000, 650),//moving/(only 200 long)
				new Ice(100, 50, 1700, 500),
				new Ground(500, 50, 2000, 300),//moving
				new Ice(200, 600, 2700, 375),//spikes in pit
				new Ice(50, 50, 3100, 475),
				new LevelEnd(3120, 550)
		};
		
		l4.layout = layout4;
		l4.startingX = 0;
		l4.startingY = 100;
		l4.spawnX = 50;
		l4.spawnY = 400;
		int[][] ranges4 = {{0,6000},{0, 3000}};
		l4.ranges = ranges4;
		l4.maxTime = 140;
		//l1.song = ShadowsUtilities.importSoundClip("./music/stage1.wav");
		
		levels[4] = l4;
		
		Levels l5 = new Levels();
		Block[] layout5 = {
				new Ground(500, 600, 0, 375),
				new Spike(5000, 50, 500, 100),
				new Ice(200, 50, 650, 500),
				new Enemy(50, 50, 925, 350, 800, 350, 32, true),
				new Ice(300, 50, 1025, 300),//power-up on edge
				new Ground(200, 50, 1050, 600), 
				new Enemy(50, 50, 1250, 375, 1100, 1600, 16, false),
				new Ground(350, 50, 1350, 550),
				new Ice(400, 50, 1400, 250),//power-up(?) on ledge
				new Enemy(50, 50, 1800, 500, 800, 350, 32, true),
				new Ground(400, 50, 1900, 700),
				new Ice(200, 50, 1900, 400),//power-up
				new Ground(200, 50, 2300, 375),
				new Enemy(50, 50, 1900, 450, 2100, 2300, 24, false),
				new Ground(500, 50, 2600, 500),
				new Enemy(50, 50, 2800, 525, 535, 800, 32, true),
				new LevelEnd(3090, 550)
		};
		
		l5.layout = layout5;
		l5.startingX = 0;
		l5.startingY = 100;
		l5.spawnX = 50;
		l5.spawnY = 400;
		int[][] ranges5 = {{0,6000},{0, 3000}};
		l5.ranges = ranges5;
		l5.maxTime = 150;
		//l1.song = ShadowsUtilities.importSoundClip("./music/stage1.wav");
		
		levels[5] = l5;
	}
}