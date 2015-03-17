package AI.sss_pattern.user_define;
import java.util.ArrayList;

import AI.sss_pattern.core.datastructure.Condition;
import AI.sss_pattern.core.datastructure.Move;
import AI.sss_pattern.core.datastructure.State;
import AI.sss_pattern.core.datastructure.StateNext;

public class Setting {
	public ArrayList<Move> ruleOfMove;
	public State stateInit;
	public State stateGoal;
	public Setting(State stateInit, State stateGoal)
	{
		this.stateInit=stateInit;
		this.stateGoal=stateGoal;
		
		//Implement rule of moving
		ruleOfMove=new ArrayList<Move>();
		initRules();
	}
	
	private boolean checkState(State state)
	{
		
		int X=state.params[0];
		int Y=state.params[1];
		int Z=state.params[2];
		int T=state.params[3];
		
		if ((X >= Y && Z >= T) ||
			(X==0 && Z >= T) ||
			(X >= Y && Z==0))
			return true;
		return false;
				
	}
	public void initRules()
	{
		//***************
		//Rule1
		//***************
		Condition condition=new Condition() {
			public boolean isLegal(State state) {
				if ((state.params[0]-state.params[4])>-1 &&
						(state.params[1]-state.params[4])>-1 &&
						(state.params[2]+state.params[4])>-1 &&
						(state.params[3]+state.params[4])>-1)
				{
					int[] params=new int[state.params.length];
					params[0]=state.params[0]-state.params[4];
					params[1]=state.params[1]-state.params[4];
					params[2]=state.params[2]+state.params[4];
					params[3]=state.params[3]+state.params[4];
					params[4]=-state.params[4];
					State s=new State(params);
					if (checkState(s)) return true;
				}
				return false;
			}
		};
		StateNext child=new StateNext() {
			public State getNext(State state) {
				int[] params=new int[state.params.length];
				params[0]=state.params[0]-state.params[4];
				params[1]=state.params[1]-state.params[4];
				params[2]=state.params[2]+state.params[4];
				params[3]=state.params[3]+state.params[4];
				params[4]=-state.params[4];
				State s=new State(params);
				
				return s;
			}
		};
		
		Move m=new Move(condition, child);
		ruleOfMove.add(m);
		
		
		
		//***************
		//Rule4
		//***************
		condition=new Condition() {
			public boolean isLegal(State state) {
				int[] params=new int[state.params.length];
				params[0]=state.params[0]-state.params[4];
				if (params[0]<=-1) return false;
				params[1]=state.params[1];
				params[2]=state.params[2]+state.params[4];
				if (params[2]<=-1) return false;
				params[3]=state.params[3];
				params[4]=-state.params[4];
				State s=new State(params);
				
				if (!checkState(s)) return false;
				return true;
			}
		};
		child=new StateNext() {
			public State getNext(State state) {
				int[] params=new int[state.params.length];
				params[0]=state.params[0]-state.params[4];
				params[1]=state.params[1];
				params[2]=state.params[2]+state.params[4];
				params[3]=state.params[3];
				params[4]=-state.params[4];
				State s=new State(params);
				
				return s;
			}
		};
		
		m=new Move(condition, child);
		ruleOfMove.add(m);
	
		
		//***************
		//Rule3
		//***************
		condition=new Condition() {
			public boolean isLegal(State state) {
				int[] params=new int[state.params.length];
				params[0]=state.params[0];
				params[1]=state.params[1]-2*state.params[4];
				if (params[1]<=-1) return false;
				params[2]=state.params[2];
				params[3]=state.params[3]+2*state.params[4];
				if (params[3]<=-1) return false;
				params[4]=-params[4];
				State s=new State(params);
				if (!checkState(s)) return false;
				
				return true;
			}
		};
		child=new StateNext() {
			public State getNext(State state) {
				int[] params=new int[state.params.length];
				params[0]=state.params[0];
				params[1]=state.params[1]-2*state.params[4];
				params[2]=state.params[2];
				params[3]=state.params[3]+2*state.params[4];
				params[4]=-state.params[4];
				State s=new State(params);
				
				return s;
			}
		};
		
		m=new Move(condition, child);
		ruleOfMove.add(m);
		
		//***************
		//Rule5
		//***************
		condition=new Condition() {
			public boolean isLegal(State state) {
				int[] params=new int[state.params.length];
				params[0]=state.params[0]-2*state.params[4];
				if (params[0]<=-1) return false;
				params[1]=state.params[1];
				params[2]=state.params[2]+2*state.params[4];
				if (params[2]<=-1) return false;
				params[3]=state.params[3];
				params[4]=-state.params[4];
				State s=new State(params);
				
				if (!checkState(s)) return false;
				return true;
			}
		};
		child=new StateNext() {
			public State getNext(State state) {
				int[] params=new int[state.params.length];
				params[0]=state.params[0]-2*state.params[4];
				params[1]=state.params[1];
				params[2]=state.params[2]+2*state.params[4];
				params[3]=state.params[3];
				params[4]=-state.params[4];
				State s=new State(params);
				
				return s;
			}
		};
		m=new Move(condition, child);
		ruleOfMove.add(m);
		
		//***************
		//Rule2
		//***************
		condition=new Condition() {
			public boolean isLegal(State state) {
				int[] params=new int[state.params.length];
				params[0]=state.params[0];
				params[1]=state.params[1]-state.params[4];
				if (params[1]<=-1) return false;
				params[2]=state.params[2];
				params[3]=state.params[3]+state.params[4];
				if (params[3]<=-1) return false;
				params[4]=-params[4];
				State s=new State(params);
				if (!checkState(s)) return false;
				
				return true;
			}
		};
		child=new StateNext() {
			public State getNext(State state) {
				int[] params=new int[state.params.length];
				params[0]=state.params[0];
				params[1]=state.params[1]-state.params[4];
				params[2]=state.params[2];
				params[3]=state.params[3]+state.params[4];
				params[4]=-state.params[4];
				State s=new State(params);
				
				return s;
			}
		};
		
		m=new Move(condition, child);
		ruleOfMove.add(m);

	
	}
	
	public boolean isGoal(State state)
	{
		if (stateGoal.equal(state))
			return true;
		else return false;
	}

	public void myWrite(State state)
	{
		System.out.println(state.params[0]+","+state.params[1]+","+
				state.params[2]+","+state.params[3]+bo(state.params[4])+" with index="+state.index);
	}
	private String bo(int t)
	{
		if (t>0) return " :Dang o bo A";
		else return " :Dang o bo B";
	}
	
	public State[] moves(State state)
	{
		ArrayList<State> legalMoves=new ArrayList<State>();
		for (Move i:ruleOfMove)
		{
			if (i.con.isLegal(state))
				legalMoves.add(i.child.getNext(state));
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
