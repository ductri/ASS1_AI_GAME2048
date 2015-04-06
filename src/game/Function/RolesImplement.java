package game.Function;

import game.DataStructure.GameState;

public class RolesImplement implements Roles{
	int gameSize;
	public RolesImplement(int gameSize)
	{
		this.gameSize=gameSize;
	}
	public GameState checkStateUP(GameState inGameState)
	{
		GameState gameState=new GameState(inGameState);
		boolean movable=false;
		for (int j=0;j<gameSize;j++)
		{
			int i=1;
			int pivot=0;
			while (i<gameSize)
			{
				/*
				 * Giữa ô i và ô pivot luôn luôn không có sự cản trở
				 */
				//Nếu 2 ô bằng nhau, nhân đôi ô pivot, reset ô i, vị trí pivot không đổi
				if (gameState.data[i][j]==gameState.data[pivot][j])
				{
					gameState.data[i][j]=0;
					gameState.data[pivot][j]*=2;
				}
				else //Giá trị 2 ô khác nhau
				{
					//Nếu ô pivot bằng 0, chuyển giá trị ô i v�? ô pivot, pivot không đổi
					if (gameState.data[pivot][j]==0)
					{
						int temp=gameState.data[i][j];
						gameState.data[i][j]=0;
						gameState.data[pivot][j]=temp;
						
					}
					//Nếu giá trị pivot khác 0, chuyển ô i về ô trên ô pivot, pivot tăng 1
					else if (gameState.data[i][j]!=0){
						int temp=gameState.data[i][j];
						gameState.data[i][j]=0;
						gameState.data[pivot+1][j]=temp;
						pivot++;
					}
				}
				i++;
			}
			if (pivot<(gameSize-1))
				movable=true;
		}
		if (movable)
			return gameState;
		else return null;
	}

	public GameState checkStateDOWN(GameState inGameState)
	{
		GameState gameState=new GameState(inGameState);
		boolean movable=false;
		for (int j=0;j<gameSize;j++)
		{
			int i=gameSize-2;
			int pivot=gameSize-1;
			while (i>-1)
			{
				/*
				 * Giữa ô i và ô pivot không có sự cản trở nào
				 */
				//Nếu 2 ô bằng nhau, nhân đôi ô pivot, reset ô i, vị trí pivot không đổi
				if (gameState.data[i][j]==gameState.data[pivot][j])
				{
					gameState.data[i][j]=0;
					gameState.data[pivot][j]*=2;
					pivot--;
				}
				else //Giá trị 2 ô khác nhau
				{
					//Nếu ô pivot bằng 0, chuyển giá trị ô i v�? ô pivot, pivot không đổi
					if (gameState.data[pivot][j]==0)
					{
						int temp=gameState.data[i][j];
						gameState.data[i][j]=0;
						gameState.data[pivot][j]=temp;
						
					}
					//Nếu giá trị pivot khác 0, chuyển ô i v�? ô trên ô pivot, pivot giảm xuống 1
					else if (gameState.data[i][j]!=0){
						int temp=gameState.data[i][j];
						gameState.data[i][j]=0;
						gameState.data[pivot-1][j]=temp;
						pivot--;
					}
				}
				i--;
			}
			if (pivot>0)
				movable=true;
		}
		if (movable)
			return gameState;
		else return null;
	}

	public GameState checkStateLEFT(GameState inGameState)
	{
		GameState gameState=new GameState(inGameState);
		boolean movable=false;
		for (int i=0;i<gameSize;i++)
		{
			int j=1;
			int pivot=0;
			while (j<gameSize)
			{
				/*
				 * Giữa ô j và ô pivot không có sự cản trở nào
				 */
				//Nếu 2 ô bằng nhau, nhân đôi ô pivot, reset ô j, vị trí pivot không đổi
				if (gameState.data[i][j]==gameState.data[i][pivot])
				{
					gameState.data[i][j]=0;
					gameState.data[i][pivot]*=2;
					pivot++;
				}
				else //Giá trị 2 ô khác nhau
				{
					//Nếu ô pivot bằng 0, chuyển giá trị ô i v�? ô pivot, pivot không đổi
					if (gameState.data[i][pivot]==0)
					{
						int temp=gameState.data[i][j];
						gameState.data[i][j]=0;
						gameState.data[i][pivot]=temp;
						
					}
					//Nếu giá trị pivot khác 0, chuyển ô i v�? ô trên ô pivot, pivot giảm xuống 1
					else if (gameState.data[i][j]!=0){
						int temp=gameState.data[i][j];
						gameState.data[i][j]=0;
						gameState.data[i][pivot+1]=temp;
						pivot++;
					}
				}
				j++;
			}
			if (pivot<gameSize-1)
				movable=true;
		}
		if (movable)
			return gameState;
		else return null;
	}

	public GameState checkStateRIGHT(GameState inGameState)
	{
		GameState gameState=new GameState(inGameState);
		boolean movable=false;
		for (int i=0;i<gameSize;i++)
		{
			int j=gameSize-2;
			int pivot=gameSize-1;
			while (j>-1)
			{
				/*
				 * Giữa ô j và ô pivot không có sự cản trở nào
				 */
				//Nếu 2 ô bằng nhau, nhân đôi ô pivot, reset ô j, vị trí pivot không đổi
				if (gameState.data[i][j]==gameState.data[i][pivot])
				{
					gameState.data[i][j]=0;
					gameState.data[i][pivot]*=2;
					pivot--;
				}
				else //Giá trị 2 ô khác nhau
				{
					//Nếu ô pivot bằng 0, chuyển giá trị ô i v�? ô pivot, pivot không đổi
					if (gameState.data[i][pivot]==0)
					{
						int temp=gameState.data[i][j];
						gameState.data[i][j]=0;
						gameState.data[i][pivot]=temp;
						
					}
					//Nếu giá trị pivot khác 0, chuyển ô i v�? ô trên ô pivot, pivot giảm xuống 1
					else if (gameState.data[i][j]!=0){
						int temp=gameState.data[i][j];
						gameState.data[i][j]=0;
						gameState.data[i][pivot-1]=temp;
						pivot--;
					}
				}
				j--;
			}
			if (pivot>0)
				movable=true;
		}
		if (movable)
			return gameState;
		else return null;
	}

}
