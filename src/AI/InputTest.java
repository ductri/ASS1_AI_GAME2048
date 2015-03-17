package AI;

import game.DataStructure.GAMEINPUT;
import game.DataStructure.GameState;

public class InputTest  implements NextStep{

	@Override
	public GAMEINPUT getInput(GameState inGameState) {
		return GAMEINPUT.DOWN;
	}
	 
}
