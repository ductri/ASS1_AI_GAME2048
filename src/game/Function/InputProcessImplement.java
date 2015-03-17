package game.Function;
//package DataStructure;
//
//public class InputProcessImplement implements InputProcess{
//	@Override
//	public GameState processInput(GAMEINPUT gameInput) {
//		GameState top=undoList.peek();
//		GameState currentGameState=new GameState(top);
//		
//		switch (gameInput) {
//		case UP:
//			System.out.println("UP");
//			GameState temp=checkStateUP(currentGameState);
//			if (temp!=null)
//				currentGameState=temp;
//			break;
//		case DOWN:
//			System.out.println("DOWN");
//			temp=checkStateDOWN(currentGameState);
//			if (temp!=null)
//				currentGameState=temp;
//			break;
//		case LEFT:
//			System.out.println("LEFT");
//			temp=checkStateLEFT(currentGameState);
//			if (temp!=null)
//				currentGameState=temp;
//			break;
//		case RIGHT:
//			System.out.println("RIGHT");
//			temp=checkStateRIGHT(currentGameState);
//			if (temp!=null)
//				currentGameState=temp;
//			break;
//		default:
//			break;
//		}
//		return currentGameState;
//	}
//
//}
