package AI;

import java.util.Scanner;

import game.DataStructure.GAMEINPUT;
import game.DataStructure.GameState;

public class UserInput implements NextStep{

	@Override
	public GAMEINPUT getInput(GameState inGameState) {
		Scanner scan=new Scanner(System.in);
		String input=scan.nextLine();
		if (input.compareToIgnoreCase("U")==0)
			return GAMEINPUT.UP;
		else if (input.compareToIgnoreCase("L")==0)
			return GAMEINPUT.LEFT;
		else if (input.compareToIgnoreCase("D")==0)
			return GAMEINPUT.DOWN;
		else return GAMEINPUT.RIGHT;
	}
	
}
