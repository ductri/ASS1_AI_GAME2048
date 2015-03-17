package game.Function;

import game.DataStructure.GameState;

public interface Roles {
	public GameState checkStateUP(GameState inGameState);
	public GameState checkStateDOWN(GameState inGameState);
	public GameState checkStateLEFT(GameState inGameState);
	public GameState checkStateRIGHT(GameState inGameState);
}
