package AI.sss_pattern.run;

import AI.sss_pattern.core.Search;
import AI.sss_pattern.core.datastructure.State;
import AI.sss_pattern.user_define.Setting;


public class Main {
	public static void main(String[] argc)
	{
		int[][] params1={{0,0,0,0},
					{2,0,2,0},
					{0,0,0,0},
					{0,0,0,0}};
		
		State stateInit=new State(params1,0);
		int[][] params2={{0,0,0,0},
						{0,0,0,0},
						{0,0,0,0},
						{0,0,0,0}};
		State stateGoal=new State(params2);
		Setting setting=new Setting(stateInit, stateGoal,false);
		
		Search search=new Search(setting);
		
		System.out.print("Start with: ");
		setting.myWrite(stateInit);
	
		System.out.print("End with: ");
		setting.myWrite(stateGoal);
		
		System.out.println("");
		System.out.println("************************");
		System.out.println("GO!");
		System.out.println("************************");
		search.go();
	}
	
	
}
