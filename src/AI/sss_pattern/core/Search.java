package AI.sss_pattern.core;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import AI.sss_pattern.core.datastructure.Road;
import AI.sss_pattern.core.datastructure.State;
import AI.sss_pattern.user_define.Setting;

public class Search {
	Stack<State> open;
	LinkedBlockingQueue<State> open_q;
	Stack<State> closed;
	Road road;
	Setting setting;
	int index=0;
	
	int step=0;
	public Search(Setting setting)
	{
		if (setting.isDfs)
			open=new Stack<State>();
		else open_q=new LinkedBlockingQueue<State>();
		closed=new Stack<State>();
		road=new Road();
		
		this.setting=setting;
	}
	public void go()
	{
		State state=setting.stateInit;
		state.index=index;
		if (setting.isDfs)
			open.push(state);
		else open_q.add(state);
		path();
	}
	
	private void path()
	{
		
		if (setting.isDfs)
		{
			if (open.isEmpty()) {
				System.out.print("No solution");
				return;
			}
		}
		else 
		{
			if (open_q.isEmpty()) {
				System.out.print("No solution");
				return;
			}
		}
		
		
		if (checkGoal()) return;
		
		State state;
		if (setting.isDfs)
			state=open.pop();
		else state=open_q.remove();
		
		setting.myWrite(state);
		
		road.addState(state);
		closed.push(state);
		getChildren(state);
		
		path();
	}
	
	private boolean checkGoal()
	{
		State state;
		if (setting.isDfs)
			state=open.peek();
		else state=open_q.peek();
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
				if (closed.get(j).equals(i))
				{
					exist=true;
					break;
				}
			if (!exist)
				if (setting.isDfs)
				{
					for (int j=0;j<open.size();j++)
						if (open.get(j).equals(i))
						{
							exist=true;
							break;
						}
				}
				else {
					if (open_q.contains(i))
					{
						exist=true;
						break;
					}
				}
			if (!exist)
			{
				i.index=index;
				if (setting.isDfs)
					open.push(i);
				else open_q.add(i);
			}
		}
	}
}
