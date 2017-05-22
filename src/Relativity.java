import java.awt.Color;

public class Relativity 
{
	public static double gameSpeed = 1;
	public static void main(String[] args)
	{
		//Player p1 = new Player(50, 50, 5, 400, 3.0, 7, 1.0, 0.7, "Albert");
		//Levels.initialize();
		
		Button[] buttons = {new Button(100, 100, 100, 100, "test", Button.ButtonType.test, Color.red, Color.black),
		new Button(444, 666, 100, 100, "fuk u gerg", Button.ButtonType.backToLevel, Color.blue, Color.cyan)
		};
		
		Menu m = new Menu("Test", buttons);
		
		GameWindow gw = new GameWindow();
		gw.setVisible(true);
		
		//gw.startLvl(1);
		gw.showMenu(m);
		while(true)
		{
			gw.advance();
		}
	}
}