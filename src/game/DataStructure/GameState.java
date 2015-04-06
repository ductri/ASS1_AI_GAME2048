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
	
	public int[][] cloneData()
	{
		int[][] temp=new int[data.length][];
		for (int i=0;i<temp.length;i++)
			temp[i]=new int[data.length];
		
		for (int i=0;i<data.length;i++)
			for (int j=0;j<data.length;j++)
				temp[i][j]=data[i][j];
		return temp;
				
	}
	
	@Override
	public boolean equals(Object o)
	{
		GameState g=(GameState)o;
		for (int i=0;i<data.length;i++)
			for (int j=0;j<data.length;j++)
				if (data[i][j]!=g.data[i][j])
					return false;
		return true;
	}
}
