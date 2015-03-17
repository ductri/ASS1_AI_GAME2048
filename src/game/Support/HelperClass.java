package game.Support;
import java.util.Scanner;

import game.Setting.GAME_SETTING;


public class HelperClass {
	public static int[][] initArray2()
	{
		int[][] data=new int[GAME_SETTING.GAME_SIZE][];
		for (int i=0;i<GAME_SETTING.GAME_SIZE;i++)
			data[i]=new int[GAME_SETTING.GAME_SIZE];
		
		return data;
	}
	
	public static void doGameSlowly1()
	{
		try {
			Thread.sleep(GAME_SETTING.SPEED);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void doGameSlowly2()
	{
		Scanner scan=new Scanner(System.in);
		scan.nextLine();
	}
}
