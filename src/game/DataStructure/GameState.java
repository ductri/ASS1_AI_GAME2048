package game.DataStructure;
import game.Setting.GAME_SETTING;
import game.Support.HelperClass;

/*
 * Optimise for binary number
 */
public class GameState {
	public int[][] data;
	public GameState()
	{
		data=HelperClass.initArray2();
	}
	
	public GameState(int[][] v)
	{
		data=v;
	}
	
	public GameState(GameState gameState)
	{
		data=HelperClass.initArray2();
		for (int i=0;i<GAME_SETTING.GAME_SIZE;i++)
			for (int j=0;j<GAME_SETTING.GAME_SIZE;j++)
				data[i][j]=gameState.data[i][j];
	}
	
}
