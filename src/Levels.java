import javax.sound.sampled.Clip;

public class Levels
{
	public static Levels[] levels = new Levels[11];
	private static boolean hasRun = false;
	
	public Block[] layout;
	public Clip song;
	public int startingX, startingY;
	public int spawnX, spawnY;
	public int[][] ranges;
	
	/**
	 * To be run at the beginning of the game; sets up this class' static <code>levels</code> array
	 */
	public static void initialize() 
	{
		if(hasRun) return; //singleton implementation; prevents code from running more than once
		
		hasRun = true;
		/*Levels l1 = new Levels();
		Block[] layout1 = {
				new Ground(1000, 600, 0, 375),
				new Ground(50, 50, 200, 425),
				new Enemy(50, 50, 700, 500, 400, 500, 8.0, true),
				new Enemy(50, 50, 1400, 425, 1400, 1600, 24.0, false),
				new Ground(500, 50, 300, 575), //power-up on the edge of this platform
				new Ground(400, 50, 900, 600),
				new Ground(50, 100, 1000, 700),
				new Enemy(50, 50, 1050, 650, 1250, 1050, 16, false),
				new Ground(1300, 600, 1200, 375),//spikes in pit
				new Ground(50, 100, 1350, 475),
				new Ground(50, 100, 1600, 475),
				new Ground(300, 50, 1750, 550),
				new Enemy(50, 50, 1750, 450, 1750, 2050, 16, false),
				new Ground(500, 50, 2200, 700),
				new LevelEnd(2490, 500),
				new Ground(500, 50, 2900, 400)//extra life goes here
		};
		
		l1.layout = layout1;
		l1.startingX = 0;
		l1.startingY = 100;
		l1.spawnX = 50;
		l1.spawnY = 400;
		int[][] ranges1 = {{0,6000},{0, 3000}};
		l1.ranges = ranges1;
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
		//l1.song = ShadowsUtilities.importSoundClip("./music/stage1.wav");
		
		levels[3] = l3;*/
		
		
		Levels l4 = new Levels();
		Block[] layout4 = {
				new Ground(850, 600, 0, 375),//ice
				new Ground(200, 50, 300, 550),//ice
				new Enemy(50, 50, 550, 800, 800, 400, 16, true),
				new Enemy(50, 50, 600, 400, 400, 800, 16, true),
				new Ground(200, 50, 650, 650),//ice
				new Ground(500, 50, 1000, 650),//moving/(only 200 long)
				new Ground(100, 50, 1700, 500),//ice
				new Ground(500, 50, 2000, 300),//moving
				new Ground(200, 600, 2700, 375),//ice/spikes in pit
				new Ground(50, 50, 3100, 475),//ice
				new LevelEnd(3125, 550)
		};
		
		l4.layout = layout4;
		l4.startingX = 0;
		l4.startingY = 100;
		l4.spawnX = 50;
		l4.spawnY = 400;
		int[][] ranges4 = {{0,6000},{0, 3000}};
		l4.ranges = ranges4;
		//l1.song = ShadowsUtilities.importSoundClip("./music/stage1.wav");
		
		levels[1] = l4;
	}
}