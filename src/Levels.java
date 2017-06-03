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
				new Enemy(50, 50, 700, 500, 400, 450, 24.0, true),
				new Enemy(50, 50, 1400, 425, 1400, 1600, 24.0, false),
				new Ground(1000, 600, 0, 375),
				new Ground(50, 50, 200, 425),
				new Ground(500, 50, 300, 500), //power-up on the edge of this platform
				new Ground(400, 50, 900, 600),
				new Ground(50, 100, 1000, 700),
				new Enemy(50, 50, 1050, 650, 1250, 1050, 16, false),
				new Ground(1800, 600, 1200, 375),//spikes in pit
				new Ground(50, 100, 1350, 475),
				new Ground(50, 100, 1600, 475),
				new LevelEnd(2990, 500)
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
				//new Enemy(50, 50, 700, 600, 400, 600, 4.0, true),
				new Ground(1000, 600, 0, 375),
				new Ground(50, 50, 200, 425),
				new LevelEnd(1100, 500)
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