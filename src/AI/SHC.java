package AI;

import game.DataStructure.GAMEINPUT;
import game.DataStructure.GameState;
import game.Function.Roles;
import game.Function.RolesImplement;
import game.Setting.GAME_SETTING;

public class SHC implements NextStep{
	Roles roles;
	int _direction=-1;
	
	public SHC(GameState stateInitial)
	{
		
	}
	
	@Override
	public GAMEINPUT getInput(GameState inGameState) {
		
		GameState gameState=new GameState(inGameState);
		
		RolesImplement role=new RolesImplement(GAME_SETTING.GAME_SIZE);
		int numOfChild=4;
		GameState[] gameStateArr=new GameState[numOfChild];
		
		gameStateArr[0]=role.checkStateUP(gameState);
		gameStateArr[1]=role.checkStateLEFT(gameState);
		gameStateArr[2]=role.checkStateDOWN(gameState);
		gameStateArr[3]=role.checkStateRIGHT(gameState);
		
		float[] stateValues=new float[numOfChild];
		for (int i=0;i<numOfChild;i++)
			stateValues[i]=(float) (getValueState1(gameStateArr[i])/14.0*5+
							getValueState2(gameStateArr[i])/2048.0 + limitDirection(i));
		
		switch (getIndexMax(stateValues))
		{
			case 0:return GAMEINPUT.UP;
			case 1:return GAMEINPUT.LEFT;
			case 2:return GAMEINPUT.DOWN;
			case 3:return GAMEINPUT.RIGHT;
			default:return GAMEINPUT.UP;
		}
	}
	
	/*
	 * Limit direction DOWN
	 */
	float limitDirection(int i)
	{
		if (i==2)
			return -0.5f;
		else if (i==1)
			return 0.5f;
		else if (i==0)
			return 1;
		else return 0;
		
	}
	/*
	 * Đếm số lượng các ô trống
	 */
	private int getValueState1(GameState gameState)
	{
		int value=0;
		if (gameState==null)
			return -1;
		for (int[] i:gameState.data)
			for (int j:i)
				if (j==0) value++;
		
		
		for (int[] i:gameState.data)
			for (int j:i)
				if (j==0) value++;
		
		return value;
	}
	
	/*
	 * Trả về số lớn nhất
	 */
	private int getValueState2(GameState gameState)
	{
		if (gameState==null)
			return -1;
		int max=gameState.data[0][0];
		
		for (int i=0;i<gameState.data.length;i++)
			for (int j=0;j<gameState.data.length;j++)
				if (gameState.data[i][j]>max)
					max=gameState.data[i][j];
		return max;
	}
	
	private int getIndexMax(int[] a)
	{
		int indexMax=0;
		for (int i=1;i<a.length;i++)
			if (a[i]>a[indexMax])
				indexMax=i;
		return indexMax;
	}
	
	private int getIndexMax(float[] a)
	{
		int indexMax=0;
		for (int i=1;i<a.length;i++)
			if (a[i]>a[indexMax])
				indexMax=i;
		return indexMax;
	}

}
