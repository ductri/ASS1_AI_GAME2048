package AI;

import game.DataStructure.GAMEINPUT;
import game.DataStructure.GameState;
import game.Function.Roles;
import game.Function.RolesImplement;
import game.Setting.GAME_SETTING;

public class SHC implements NextStep{
	Roles roles;
	int _direction=-1;
	
	public SHC(GameState stateInitial)
	{
		
	}
	
	@Override
	public GAMEINPUT getInput(GameState inGameState) {
		
		GameState gameState=new GameState(inGameState);
		
		RolesImplement role=new RolesImplement(GAME_SETTING.GAME_SIZE);
		int numOfChild=4;
		GameState[] gameStateArr=new GameState[numOfChild];
		
		gameStateArr[0]=role.checkStateUP(gameState);
		gameStateArr[1]=role.checkStateLEFT(gameState);
		gameStateArr[2]=role.checkStateDOWN(gameState);
		gameStateArr[3]=role.checkStateRIGHT(gameState);
		
		double[] stateValues=new double[numOfChild];
		
		for (int i=0;i<numOfChild;i++)
		{
			if (gameStateArr[i]==null) {
				stateValues[i]=Double.MAX_VALUE;
				continue;
			}
			//Số ô trống
			double f1=f1(gameStateArr[i]);
			double f01=f1(inGameState);
			
			//Ô lớn nhất
			double f2=f2(gameStateArr[i]);
			double f02=f2(inGameState);
			
			//Cân bằng
			double f3=f3(gameStateArr[i]);
			double f03=f3(inGameState);
			
			//Hướng số lớn nhất xuống góc dưới bên trái
			double f4=f4(gameStateArr[i]);
			double f04=f4(inGameState);
			stateValues[i]=(f1)*0+
							(f2)*1+
							(f3)*0+
							(f4)*1;
		}
		
		for (int i=0;i<numOfChild;i++)
		{
			
		}
		
/*		switch (getIndexMin(stateValues))
		{
			case 0:return GAMEINPUT.UP;
			case 1:return GAMEINPUT.LEFT;
			case 2:return GAMEINPUT.DOWN;
			case 3:return GAMEINPUT.RIGHT;
			default:return GAMEINPUT.UP;
		}*/
		return GAMEINPUT.UP;
	}
	private double f1(GameState i)
	{
		return (16-getValueState1(i))*(16-getValueState1(i))/(16.0*16.0);
	}
	
	private double f2(GameState i)
	{
		return (2048-getValueState2(i))*(2048-getValueState2(i))/(2048.0*2048.0);
	}
	
	private double f3(GameState i)
	{
		return (1048576-balanceFactor(i.data))*(1048576-balanceFactor(i.data))/(1048576.0*1048576.0);
	}
	
	private double f4(GameState i)
	{
		return distance(i.data)/18.0;
	}
	/*
	 * Limit direction DOWN
	 */
	float limitDirection(int i)
	{
		if (i==2)
			return -0.5f;
		else if (i==1)
			return 0.5f;
		else if (i==0)
			return 1;
		else return 0;
		
	}
	/*
	 * Đếm số lượng các ô trống
	 */
	private int getValueState1(GameState gameState)
	{
		int value=0;
		if (gameState==null)
			return -1;
		for (int[] i:gameState.data)
			for (int j:i)
				if (j==0) value++;
		
		
		for (int[] i:gameState.data)
			for (int j:i)
				if (j==0) value++;
		
		return value;
	}
	
	/*
	 * Trả về số lớn nhất
	 */
	private int getValueState2(GameState gameState)
	{
		if (gameState==null)
			return -1;
		int max=gameState.data[0][0];
		
		for (int i=0;i<gameState.data.length;i++)
			for (int j=0;j<gameState.data.length;j++)
				if (gameState.data[i][j]>max)
					max=gameState.data[i][j];
		return max;
	}
	
	 
	private int getIndexMax(int[] a)
	{
		int indexMax=0;
		for (int i=1;i<a.length;i++)
			if (a[i]>a[indexMax])
				indexMax=i;
		return indexMax;
	}
	
	private int getIndexMax(double[] a)
	{
		int indexMax=0;
		for (int i=1;i<a.length;i++)
			if (a[i]>a[indexMax])
				indexMax=i;
		return indexMax;
	}
	
	private int getIndexMin(double[] a)
	{
		int indexMin=0;
		for (int i=1;i<a.length;i++)
			if (a[i]<a[indexMin])
				indexMin=i;
		return indexMin;
	}

	private boolean greatThan(int[][] a, int[][] b)
	{
		int maxa=a[0][0];
		int ia=0,ja=0;
		for (int i=0;i<a.length;i++)
			for (int j=0;j<a.length;j++)
				if (a[i][j]>maxa)
				{
					ia=i;ja=j;
					maxa=a[i][j];
				}
		
		int maxb=a[0][0];
		int ib=0,jb=0;
		for (int i=0;i<b.length;i++)
			for (int j=0;j<b.length;j++)
				if (b[i][j]>maxb)
				{
					ib=i;jb=j;
					maxb=b[i][j];
				}
		if (maxa>maxb)
			return true;
		else if (maxa<maxb)
			return false;
		else {
			if (maxa==0) return false;
			else 
			{
				a[ia][ja]=0;
				b[ib][jb]=0;
				return greatThan(a, b);
			}
		}
	}
	
	private float balanceFactor(int[][] a)
	{
		int sum=0;
		for (int i=0;i<a.length;i++)
			for (int j=0;j<a.length;j++)
				sum+=a[i][j];
		float avg=sum/a.length*a.length;
		float balance=0;
		for (int i=0;i<a.length;i++)
			for (int j=0;j<a.length;j++)
				balance+=(avg-a[i][j])*(avg-a[i][j]);
		return balance;
	}
	
	private int distance(int[][] a)
	{
		int maxa=a[0][0];
		int ia=0,ja=0;
		for (int i=0;i<a.length;i++)
			for (int j=0;j<a.length;j++)
				if (a[i][j]>maxa)
				{
					ia=i;ja=j;
					maxa=a[i][j];
				}
		return (3-ia)*(3-ia)+ja*ja;
	}
	private static int distancea(int[][] a)
	{
		int maxa=a[0][0];
		int ia=0,ja=0;
		for (int i=0;i<a.length;i++)
			for (int j=0;j<a.length;j++)
				if (a[i][j]>maxa)
				{
					ia=i;ja=j;
					maxa=a[i][j];
				}
		return (3-ia)*(3-ia)+ja*ja;
	}
/*	public static void main(String[] args)
	{
		int a[][]={{0,0,0,32},
				{4,2,0,16},
				{0,0,8,0},
				{0,0,2,0}};
		
		System.out.println(distancea(a));
	}*/
	
}
