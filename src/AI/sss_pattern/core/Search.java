package AI.sss_pattern.core;
import java.util.Stack;

import AI.sss_pattern.core.datastructure.Road;
import AI.sss_pattern.core.datastructure.State;
import AI.sss_pattern.user_define.Setting;

public class Search {
	Stack<State> open;
	Stack<State> closed;
	Road road;
	Setting setting;
	int index=0;
	public Search(Setting setting)
	{
		open=new Stack<State>();
		closed=new Stack<State>();
		road=new Road();
		
		this.setting=setting;
	}
	public void go()
	{
		State state=setting.stateInit;
		state.index=index;
		open.add(state);
		path();
	}
	
	private void path()
	{
		if (open.isEmpty()) {
			System.out.print("No solution");
			return;
		}
		
		if (checkGoal()) return;
		
		State state=open.pop();
		
		road.addState(state);
		closed.push(state);
		getChildren(state);
		path();
	}
	
	private boolean checkGoal()
	{
		State state=open.peek();
		if (setting.isGoal(state))
		{
			for (State i:road.road)
				setting.myWrite(i);
			setting.myWrite(state);
			System.out.println("Solution found");
			return true;
		}
		else return false;
	}
	private void getChildren(State state)
	{
		State[] legalStates=setting.moves(state);
		
		if (legalStates==null) 
			return;
		
		index=state.index+1;
		for (State i:legalStates)
		{
			boolean exist=false;
			for (int j=0;j<closed.size();j++)
				if (closed.get(j).equal(i))
				{
					exist=true;
					break;
				}
			if (!exist)
				for (int j=0;j<open.size();j++)
					if (open.get(j).equal(i))
					{
						exist=true;
						break;
					}
			if (!exist)
			{
				i.index=index;
				open.push(i);
			}
		}
	}
}
