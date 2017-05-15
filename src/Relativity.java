public class Relativity 
{
	public static double gameSpeed = 1;
	public static void main(String[] args)
	{
		Player p1 = new Player(50, 50, 5, 400, 3.0, 7, 1.0, 0.7, "Albert");
		Levels.initialize();
		
		GameWindow gw = new GameWindow(p1);
		gw.setVisible(true);
		
		gw.startLvl(1);
		while(true)
		{
			gw.advance();
		}
	}
}
