package AI.sss_pattern.core.datastructure;


public class Move {
	public Condition con; //Define conditions of input;
	public StateNext child; //Define output
	public Move(Condition condition, StateNext child)
	{
		this.con=condition;
		this.child=child;
	}
}
