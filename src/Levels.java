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
		Levels l1 = new Levels();
		Block[] layout1 = {
				new Enemy(50, 50, 700, 500, 400, 500, 8.0, true),
				new Enemy(50, 50, 1400, 425, 1400, 1600, 24.0, false),
				new Ground(1000, 600, 0, 375),
				new Ground(50, 50, 200, 425),
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
				new Ground(400, 50, 2700, 400)//extra life goes here
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
				new Ground(3000, 600, 0, 375),
				new Ground(3000, 300, 0, 900),
				new Ground(500, 50, 200, 550),
				new Enemy(50, 50, 200, 425, 200, 700, 16, false),
				new Enemy(50, 50, 725, 425, 600, 375, 24, true),
				new Ground(500, 50, 900, 425),//moving platform, slows down with ability/crushed= death
				new Ground(50, 50, 1650, 425),
				new Ground(50, 50, 1700, 475),
				new Ground(400, 50, 1750, 525),
				new Enemy(50, 50, 2150, 425, 600, 375, 24, true),//guards a power up
				new Ground(650, 50, 2250, 425),//moving platform
				new LevelEnd(2890, 500),
				new Ground(700, 1000, 2950, 1000)
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
		
	}
}