package AI.sss_pattern.core.datastructure;
import java.util.ArrayList;


public class Road {
	public ArrayList<State> road;
	public Road()
	{
		road=new ArrayList<State>();
	}
	
	public void addState(State state)
	{
		if (!road.isEmpty())
		{
			while (road.get(road.size()-1).index>=state.index)
			{
				road.remove(road.size()-1);
			}
			road.add(state);
		}
		else road.add(state);
	}
}
