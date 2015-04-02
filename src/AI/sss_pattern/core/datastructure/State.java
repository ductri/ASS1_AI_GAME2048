package AI.sss_pattern.core.datastructure;

public class State {
	public int[][] params;
	public int index;
	public State(int[][] param_array)
	{
		params=param_array;
	}
	
	public State(int[][] param_array, int index)
	{
		params=param_array;
		this.index=index;
	}
	
	@Override
    public boolean equals(Object object)
	{
		State state1=(State)object;
		int numParam=params.length;
		for (int i=0;i<numParam;i++)
		{
			if (params[i]!=state1.params[i]) return false;
		}
		return true;
	}
	
	public State clone()
	{
		return new State(params.clone());
	}
}
