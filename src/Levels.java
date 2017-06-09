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
				new Ground(500, 50, 300, 575),
				new BonusTime(775, 600),
				new Ground(400, 50, 900, 600),
				new Ground(50, 100, 1000, 700),
				new Enemy(50, 50, 1050, 650, 1250, 1050, 16, false),
				new Spike(50, 100, 1000, 175),
				new Spike(50, 100, 1100, 175),
				new Ground(1300, 600, 1200, 375),
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
		l1.maxTime = 100;
		//l1.song = ShadowsUtilities.importSoundClip("./music/stage1.wav");
		
		levels[1] = l1;
		
		
		Levels l2 = new Levels();
		Block[] layout2 = {
				new Ground(3200, 600, 0, 375),
				new Ground(3200, 300, 0, 910),
				new Enemy(50, 50, 700, 550, 700, 200, 16, false),
				new Enemy(50, 50, 200, 425, 200, 700, 16, false),
				new MovingPlatform(500, 50, 1200, 425, 550, 325, 8, true),
				new Enemy(50, 50, 1300, 500, 500, 500, 0, true),
				new Ground(50, 50, 1650, 425),
				new Ground(50, 50, 1700, 475),
				new Ground(400, 50, 1750, 525),
				new HPRefill(1750, 400),
				new Enemy(50, 50, 2150, 425, 600, 375, 24, true),
				new MovingPlatform(650, 50, 2700, 425, 550, 325, 8, true),
				new Enemy(50, 50, 2500, 500, 500, 500, 0, true),
				new Enemy(50, 50, 2800, 500, 500, 500, 0, true),
				new LevelEnd(3180, 500),
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
				new HPRefill(100, 550),
				new Enemy(50, 50, 300, 550, 575, 400, 24, true),
				new Enemy(50, 50, 400, 425, 450, 700, 12, false),
				new Enemy(50, 50, 700, 550, 575, 400, 24, true),
				new Ground(500, 50, 550, 500),
				new Ground(750, 50, 900, 500),
				new ManaRefill(1000, 550),
				new Enemy(50, 50, 1100, 550, 575, 400, 24, true),
				new BonusTime(1250, 400),
				new HPRefill(1450, 400),
				new Enemy(50, 50, 1500, 550, 575, 400, 24, true),
				new Ground(700, 50, 1750, 500),
				new Enemy(50, 50, 1900, 550, 575, 400, 24, true),
				new Enemy(50, 50, 1600, 550, 1400, 2000, 12, false),
				new Enemy(50, 50, 2300, 550, 575, 400, 24, true),
				new Ground(1000, 50, 2550, 500),
				new HPRefill(2750, 550),//1-up
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
				new MovingPlatform(200, 50, 1000, 650, 1000, 1300, 4, false),
				new Ice(100, 50, 1700, 500),
				new MovingPlatform(200, 50, 2000, 300, 2000, 2300, 4, false),
				new Ice(200, 600, 2700, 375),
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
		l4.maxTime = 100;
		//l1.song = ShadowsUtilities.importSoundClip("./music/stage1.wav");
		
		levels[4] = l4;
		
		
		Levels l5 = new Levels();
		Block[] layout5 = {
				new Ground(500, 600, 0, 375),
				new Spike(5000, 50, 500, 100),
				new Ice(200, 50, 650, 500),
				new Enemy(50, 50, 925, 350, 800, 350, 32, true),
				new Ice(300, 50, 1025, 300),
				new BonusTime(1300, 325),
				new Ground(200, 50, 1050, 600), 
				new Enemy(50, 50, 1250, 375, 1100, 1600, 16, false),
				new Ground(350, 50, 1350, 550),
				new Ice(400, 50, 1400, 250),//1-up on ledge
				new Enemy(50, 50, 1800, 500, 800, 350, 32, true),
				new Ground(400, 50, 1900, 700),
				new Ice(200, 50, 1900, 400),
				new HPRefill(2075, 425),
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
		l5.maxTime = 100;
		//l1.song = ShadowsUtilities.importSoundClip("./music/stage1.wav");
		
		levels[5] = l5;
		
		
		Levels l6 = new Levels();
		Block[] layout6 = {
				new Ground(500, 600, 0, 375),
				new Spike(7000, 50, 500, 100),
				new Ice(200, 50, 300, 525),
				new Ice(400, 50, 700, 325),
				new Ground(300, 50, 1050, 725),
				new BonusTime(1100, 750),
				new Ground(200, 50, 1500, 800),
				new MovingPlatform(200, 50, 1300, 350, 1300, 1700, 16, false),
				new MovingPlatform(300, 50, 1900, 350, 350, 800, 12, true),
				new Ice(50, 50, 2200, 800),
				new BonusTime(2225, 825),
				new Ice(50, 50, 2300, 700),
				new Ice(50, 50, 2500, 750),
				new Ice(50, 50, 2800, 800),
				new BonusTime(2825, 825),
				new Ground(200, 50, 2800, 600),
				new Ice(500, 600, 3000, 375),
				new LevelEnd(3480, 425)
		};
		
		l6.layout = layout6;
		l6.startingX = 0;
		l6.startingY = 100;
		l6.spawnX = 50;
		l6.spawnY = 400;
		int[][] ranges6 = {{0,6000},{0, 3000}};
		l6.ranges = ranges6;
		l6.maxTime = 100;
		//l1.song = ShadowsUtilities.importSoundClip("./music/stage1.wav");
		
		levels[6] = l6;
		
		
		Levels l7 = new Levels();
		Block[] layout7 = {
				new Ground(2500, 600, 0, 375),
				new Enemy(50, 50, 300, 500, 600, 375, 16, true),
				new Ground(50, 50, 500, 500),
				new Ground(50, 50, 600, 600),
				new Ground(750, 50, 600, 425),
				new Ground(200, 50, 700, 750),
				new Enemy(50, 50, 800, 800, 800, 1000, 16, false),
				new Ground(300, 50, 1000, 700),
				new Ground(200, 50, 1400, 650),
				new Enemy(50, 50, 1375, 700, 1375, 1525, 16, false),
				new Enemy(50, 50, 1675, 600, 600, 800, 16, true), 
				new Ground(300, 50, 1750, 550),
				new LevelEnd(2480, 425)
		};
		
		l7.layout = layout7;
		l7.startingX = 0;
		l7.startingY = 100;
		l7.spawnX = 50;
		l7.spawnY = 400;
		int[][] ranges7 = {{0,6000},{0, 3000}};
		l7.ranges = ranges7;
		l7.maxTime = 100;
		//l1.song = ShadowsUtilities.importSoundClip("./music/stage1.wav");
		
		levels[7] = l7;
		
		
		Levels l8 = new Levels();
		Block[] layout8 = {
				new Ground(300, 600, 0, 375),
				new Spike(8000, 50, 300, 100),
				new Ground(50, 50, 400, 450),
				new Fire(25, 50, 400, 500),
				new Ground(300, 50, 600, 450),
				new MovingPlatform(300, 50, 1000, 500, 1075, 1600, 4, false),
				new Ground(400, 50, 1800, 400),
				new Ground(200, 50, 2400, 500),
				new Fire(100, 50, 2400, 550),
				new Ground(300, 50, 2700, 600),
				new Ground(50, 50, 500, 600),
				new Ground(50, 50, 600, 700),
				new Fire(25, 50, 600, 750),
				new Ground(100, 50, 750, 700),
				new Fire(50, 50, 750, 750),
				new Ground(50, 50, 1000, 800),
				new ExtraLife(1025, 825),
				new LevelEnd(2980, 650)
		};
		
		l8.layout = layout8;
		l8.startingX = 0;
		l8.startingY = 100;
		l8.spawnX = 50;
		l8.spawnY = 400;
		int[][] ranges8 = {{0,6000},{0, 3000}};
		l8.ranges = ranges8;
		l8.maxTime = 100;
		//l1.song = ShadowsUtilities.importSoundClip("./music/stage1.wav");
		
		levels[8] = l8;
		
		
		Levels l9 = new Levels();
		Block[] layout9 = {
				new Ground(1000, 600, 0, 375),
				new Enemy(50, 50, 400, 700, 700, 400, 28, true),
				new Ground(300, 50, 450, 550),
				new Fire(150, 50, 450, 600),
				new Ground(200, 50, 850, 650),
				new Fire(100, 50, 850, 700),
				new Ground(50, 50, 1200, 750),
				new ExtraLife(1225, 775),
				new Spike(400, 50, 1000, 100),
				new Ground(2000, 600, 1300, 375),
				new Enemy(50, 50, 1500, 800, 800, 450, 16, true),
				new Fire(750, 100, 1500, 475),
				new Ground(350, 50, 1600, 550),
				new BonusTime(1925, 575),
				new Ground(400, 50, 2200, 600),
				new Enemy(50, 50, 2675, 800, 800, 450, 16, true),
				new LevelEnd(3280, 425)
		};
		
		l9.layout = layout9;
		l9.startingX = 0;
		l9.startingY = 100;
		l9.spawnX = 50;
		l9.spawnY = 400;
		int[][] ranges9 = {{0,6000},{0, 3000}};
		l9.ranges = ranges9;
		l9.maxTime = 100;
		//l1.song = ShadowsUtilities.importSoundClip("./music/stage1.wav");
		
		levels[9] = l9;
		
		
		Levels l10 = new Levels();
		Block[] layout10 = {
				new Ground(1500, 600, 0, 325),
				new Enemy(50, 50, 25, 875, 800, 325, 8, true),
				new Enemy(50, 50, 75, 925, 800, 325, 8, true),
				new Enemy(50, 50, 125, 975, 800, 325, 8, true),
				new Enemy(50, 50, 175, 1025, 800, 325, 8, true),
				new Enemy(50, 50, 225, 1075, 800, 325, 8, true),
				new Enemy(50, 50, 275, 1125, 800, 325, 8, true),
				new Enemy(50, 50, 325, 1175, 800, 325, 8, true),
				new Enemy(50, 50, 375, 1225, 800, 325, 8, true),
				new Enemy(50, 50, 425, 1275, 800, 325, 8, true),
				new Enemy(50, 50, 475, 1325, 800, 325, 8, true),
				new Enemy(50, 50, 525, 1375, 800, 325, 8, true),
				new Enemy(50, 50, 575, 1425, 800, 325, 8, true),
				new Enemy(50, 50, 625, 1475, 900, 325, 8, true),
				new Enemy(50, 50, 675, 1525, 900, 325, 8, true),
				new Enemy(50, 50, 725, 1575, 900, 325, 8, true),
				new Enemy(50, 50, 775, 1625, 900, 325, 8, true),
				new Enemy(50, 50, 825, 1675, 900, 325, 8, true),
				new Enemy(50, 50, 875, 1725, 900, 325, 8, true),
				new Enemy(50, 50, 925, 1775, 900, 325, 8, true),
				new Enemy(50, 50, 975, 1825, 900, 325, 8, true),
				new Enemy(50, 50, 1025, 1875, 900, 325, 8, true),
				new Enemy(50, 50, 1075, 1925, 900, 325, 8, true),
				new Enemy(50, 50, 1125, 1975, 900, 325, 8, true),
				new Enemy(50, 50, 1175, 2025, 900, 325, 8, true),
				new Enemy(50, 50, 1225, 2075, 900, 325, 8, true),
				new Enemy(50, 50, 1275, 2125, 900, 325, 8, true),
				new Enemy(50, 50, 1325, 2175, 900, 325, 8, true),
				new Enemy(50, 50, 1375, 2225, 900, 325, 8, true),
				new Ice(1000, 600, 1800, 375),
				new Ice(200, 50, 2000, 475),
				new Fire(100, 50, 2000, 525),
				new Ice(200, 50, 2350, 625),
				new Fire(100, 50, 2350, 675),
				new Ice(50, 50, 2650, 700),
				new MovingPlatform(300, 50, 3000, 700, 3000, 3500, 16, false),
				new MovingPlatform(300, 50, 3700, 600, 3700, 4000, 16, false),
				new LevelEnd(4400, 650)
		};
		
		l10.layout = layout10;
		l10.startingX = 0;
		l10.startingY = 100;
		l10.spawnX = 50;
		l10.spawnY = 400;
		int[][] ranges10 = {{0,6000},{0, 3000}};
		l10.ranges = ranges10;
		l10.maxTime = 100;
		//l1.song = ShadowsUtilities.importSoundClip("./music/stage1.wav");
		
		levels[10] = l10;
	}
}