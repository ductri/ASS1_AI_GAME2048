package AI;

import game.DataStructure.GAMEINPUT;
import game.DataStructure.GameState;

public interface NextStep {
	public GAMEINPUT getInput(GameState inGameState);
}
