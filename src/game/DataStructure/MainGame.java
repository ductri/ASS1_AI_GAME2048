package game.DataStructure;
import game.Function.InputProcess;
import game.Function.Roles;
import game.Function.RolesImplement;
import game.Setting.GAME_SETTING;
import game.Support.HelperClass;

import java.util.Random;
import java.util.Stack;

import AI.InputTest;
import AI.NextStep;
import AI.SHC;


public class MainGame {
	//GameState currentGameState;
	Stack<GameState> undoList;
	Random randomGenerator;
	int gameSize;
	NextStep simpleHillClimbing;
	InputProcess inputProcess;
	Roles roles;
	/*
	 * Initial value for globe variables
	 */
	public MainGame()
	{
		randomGenerator=new Random();
		
		GameState stateInitial=initGameState();
		/*16	2	64	16	
		256	32	16	8	
		2	8	2	4	
		2	4	16	8	
		UP
		int[][] data={{4,64,4,2},{64,128,16,8},{4,32,8,4},{16,8,2,4}};
		GameState stateInitial=new GameState(data);*/
		
		undoList=new Stack<GameState>();
		undoList.push(stateInitial);
		gameSize=GAME_SETTING.GAME_SIZE;
		simpleHillClimbing=new SHC(stateInitial);
		System.out.println("Using SHC");
		roles=new RolesImplement(gameSize);
		
		drawState();
	}
	
	public void run()
	{
		while (true)
		{
			
			HelperClass.doGameSlowly2();
			
			GAMEINPUT gameInput=simpleHillClimbing.getInput(undoList.peek());
			
			/*InputTest inputTest=new InputTest();
			GAMEINPUT gameInput=inputTest.getInput(undoList.peek());*/
			
			/*
			 * GameInput include: 
			 * - Up, down, left, right key
			 * - Undo key
			 * - Redo key
			 * - Reset key
			 */
			
			GameState currentGameState=processInput(gameInput);
			

			if (currentGameState.equals(undoList.peek()))
				continue;

			
			currentGameState=getRandomNextState(currentGameState);
			
			undoList.push(currentGameState);
			
			drawState();
			
			if (isWin())
			{
				noticeWin();
				break;
			}
			
			if (isLose())
			{
				noticeLose();
				break;
			}
		}
	}
	
	private GameState initGameState()
	{
		int pos1=randomGenerator.nextInt(GAME_SETTING.GAME_SIZE*GAME_SETTING.GAME_SIZE-1);
		int pos2=randomGenerator.nextInt(GAME_SETTING.GAME_SIZE*GAME_SETTING.GAME_SIZE-1);
		while (pos2==pos1)
			pos2=randomGenerator.nextInt(GAME_SETTING.GAME_SIZE*GAME_SETTING.GAME_SIZE-1);
		
		int[][] data=HelperClass.initArray2();
		
		int j=pos1%GAME_SETTING.GAME_SIZE;
		int i=(pos1-j)/GAME_SETTING.GAME_SIZE;
		data[i][j]=randomGenerator.nextInt(2)*2+2;
		
		j=pos2%GAME_SETTING.GAME_SIZE;
		i=(pos2-j)/GAME_SETTING.GAME_SIZE;
		data[i][j]=randomGenerator.nextInt(2)*2+2;
		
		return new GameState(data);
	}
	
	private void drawState()
	{
		System.out.println("******************************");
		GameState currentGameState=undoList.peek();
		int len=currentGameState.data.length;
		for (int i=0;i<len;i++)
		{
			for (int j=0;j<len;j++)
			{
				if (currentGameState.data[i][j]!=0)
					System.out.print(currentGameState.data[i][j]);
				else System.out.print('_');
				System.out.print('\t');
			}
			System.out.println("");
		}
	}
	
	public GameState processInput(GAMEINPUT gameInput)
	{
		GameState top=undoList.peek();
		GameState currentGameState=new GameState(top);
		
		switch (gameInput) {
		case UP:
			System.out.println("UP");
			GameState temp=roles.checkStateUP(currentGameState);
			if (temp!=null)
				currentGameState=temp;
			break;
		case DOWN:
			System.out.println("DOWN");
			temp=roles.checkStateDOWN(currentGameState);
			if (temp!=null)
				currentGameState=temp;
			break;
		case LEFT:
			System.out.println("LEFT");
			temp=roles.checkStateLEFT(currentGameState);
			if (temp!=null)
				currentGameState=temp;
			break;
		case RIGHT:
			System.out.println("RIGHT");
			temp=roles.checkStateRIGHT(currentGameState);
			if (temp!=null)
				currentGameState=temp;
			break;
		default:
			break;
		}
		return currentGameState;
	}
	
	
	private GameState getRandomNextState(GameState inGameState)
	{
		GameState gameState=new GameState(inGameState);
		int i=randomGenerator.nextInt(4);
		int j=randomGenerator.nextInt(4);
		while (gameState.data[i][j]!=0)
		{
			i=randomGenerator.nextInt(4);
			j=randomGenerator.nextInt(4);
		}
		
		//2 or 4
		int value=randomGenerator.nextInt(2)*2+2;
		gameState.data[i][j]=value;
		System.out.println("i= "+i+";"+"j= "+j+";value="+value);
		
		return gameState;
	}

	private boolean isLose()
	{
		GameState gameState=undoList.peek();
		boolean loose=true;
		if (roles.checkStateUP(gameState)!=null)
			loose=false;
		if (roles.checkStateDOWN(gameState)!=null)
			loose=false;
		if (roles.checkStateLEFT(gameState)!=null)
			loose=false;
		if (roles.checkStateRIGHT(gameState)!=null)
			loose=false;
		return loose;
	}

	private void noticeLose()
	{
		System.out.println("You lost!");
	}

	private boolean isWin()
	{
		GameState gameState=undoList.peek();
		for (int i=0;i<gameSize;i++)
			for (int j=0;j<gameSize;j++)
				if (gameState.data[i][j]==2048)
					return true;
		return false;
	}
	
	private void noticeWin()
	{
		System.out.println("Congratilation! You won!!!");
	}
}
