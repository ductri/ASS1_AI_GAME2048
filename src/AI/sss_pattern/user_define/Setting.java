package AI.sss_pattern.user_define;
import game.DataStructure.GameState;
import game.Function.Roles;
import game.Function.RolesImplement;
import game.Setting.GAME_SETTING;

import java.util.ArrayList;

import AI.sss_pattern.core.datastructure.State;


public class Setting {
	public State stateInit;
	public State stateGoal;
	public boolean isDfs;
	public Setting(State stateInit, State stateGoal, boolean isDfs)
	{
		this.stateInit=stateInit;
		this.stateGoal=stateGoal;
		this.isDfs=isDfs;
		//Implement rule of moving
	}
	
	public boolean isGoal(State state)
	{
		int[][] data=state.params;
		for (int[] i:data)
			for (int j:i)
				if (j==16)
					return true;
		return false;		
	}

	public void myWrite(State state)
	{
		System.out.println("******************************");
		
		int len=state.params.length;
		for (int i=0;i<len;i++)
		{
			for (int j=0;j<len;j++)
			{
				if (state.params[i][j]!=0)
					System.out.print(state.params[i][j]);
				else System.out.print('_');
				System.out.print('\t');
			}
			System.out.println("");
		}
	}
	
	public State[] moves(State state)
	{
		ArrayList<State> legalMoves=new ArrayList<State>();
		Roles roles =new RolesImplement(GAME_SETTING.GAME_SIZE);
		
		GameState t=roles.checkStateUP(new GameState(state.params));
		State temp;
		if (t!=null)
		{
			temp=new State(t.cloneData());
			for (int i=0;i<GAME_SETTING.GAME_SIZE;i++)
			{
				for (int j=0;j<GAME_SETTING.GAME_SIZE;j++)
				{
					if (t.data[i][j]==0)
					{
						temp.params[i][j]=2;
						legalMoves.add(temp);
						temp=new State(t.cloneData());
						temp.params[i][j]=4;
						legalMoves.add(temp);
						temp=new State(t.cloneData());
					}
				}
			}
		}
		
		t=roles.checkStateLEFT(new GameState(state.params));
		
		if (t!=null)
		{
			temp=new State(t.cloneData());
			for (int i=0;i<GAME_SETTING.GAME_SIZE;i++)
			{
				for (int j=0;j<GAME_SETTING.GAME_SIZE;j++)
				{
					if (t.data[i][j]==0)
					{
						temp.params[i][j]=2;
						legalMoves.add(temp);
						temp=new State(t.cloneData());
						temp.params[i][j]=4;
						legalMoves.add(temp);
						temp=new State(t.cloneData());
					}
				}
			}
		}
		
		t=roles.checkStateDOWN(new GameState(state.params));
		
		if (t!=null)
		{
			temp=new State(t.cloneData());
			for (int i=0;i<GAME_SETTING.GAME_SIZE;i++)
			{
				for (int j=0;j<GAME_SETTING.GAME_SIZE;j++)
				{
					if (t.data[i][j]==0)
					{
						temp.params[i][j]=2;
						legalMoves.add(temp);
						temp=new State(t.cloneData());
						temp.params[i][j]=4;
						legalMoves.add(temp);
						temp=new State(t.cloneData());
					}
				}
			}
		}
		
		t=roles.checkStateRIGHT(new GameState(state.params));
		
		if (t!=null)
		{
			temp=new State(t.cloneData());
			for (int i=0;i<GAME_SETTING.GAME_SIZE;i++)
			{
				for (int j=0;j<GAME_SETTING.GAME_SIZE;j++)
				{
					if (t.data[i][j]==0)
					{
						temp.params[i][j]=2;
						legalMoves.add(temp);
						temp=new State(t.cloneData());
						temp.params[i][j]=4;
						legalMoves.add(temp);
						temp=new State(t.cloneData());
					}
				}
			}
		}
		if (legalMoves.isEmpty()) return null;
		State[] result=new State[legalMoves.size()];
		for (int i=0;i<legalMoves.size();i++)
		{
			result[i]=legalMoves.get(i);
		}
		return result;
	}
}
