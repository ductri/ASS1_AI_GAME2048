package AI.sss_pattern.core.datastructure;

public class State {
	public int[] params;
	public int index;
	public State(int[] param_array)
	{
		params=param_array;
	}
	
	public State(int[] param_array, int index)
	{
		params=param_array;
		this.index=index;
	}
	
	public boolean equal(State state1)
	{
		int numParam=params.length;
		for (int i=0;i<numParam;i++)
		{
			if (params[i]!=state1.params[i]) return false;
		}
		return true;
	}
}
