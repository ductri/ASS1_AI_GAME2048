package game.PagekageMain;
import game.DataStructure.MainGame;

/*
 * Init game interface
 */
public class GameStart {
	
	public GameStart()
	{
		System.out.println("Welcome to game 2048 ...");
	}
	
	public void begin()
	{
		System.out.println("Now let start!");
		
		MainGame mainGame=new MainGame();
		mainGame.run();
	}
	
}
