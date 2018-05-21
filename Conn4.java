import java.util.Scanner;


public class Conn4 {
	public static int [][] arr = new int [6][7];

			@SuppressWarnings("resource")
			public static void main(String[] args) {
				int i;
				printArray(arr);//this method is used to display the grid
				Scanner in = new Scanner(System.in);
				int c, x, d, y;
			    int r = 0;
			    int k = 0;
				for(i = 0; i < 21; i++)
				{
					//player 1 turn
					System.out.println("PLAYER 1 \n");
					c = in.nextInt();
					while( c<0 || c>6 )
					{//the loop is used to prevent the game from crashing if a player entered an invalid column number
						System.out.println("unvalid column enter number 0-6");
						c = in.nextInt();
					}
					x = markRed(c); //this method is used to mark a specific place in the array as full
					
						while (x == -1) {//the loop is used to prevent the game from crashing if a player choose a full column
							System.out.println("column full choose again \n PLAYER 1");
							c = in.nextInt();
							x = markRed(c);
						}
					printArray(arr);
					r = solveRed(x,c);//this method is used to find a series of four continuous similar inputs
					if (r == 1)
					{
						System.out.println("PLAYER 1 WINS \n CONGRATULATIONS");
						break;
					}
					//player 2 turn
					System.out.println("PLAYER 2\n");
					d = in.nextInt();
					while( d<0 || d>6 )
					{
						System.out.println("unvalid column enter number 0-6");
						d = in.nextInt();
					}
					y = markYel( d);
					while(y == -1)
					{
						System.out.println("column full choose again \n PLAYER 2");
						d = in.nextInt();
						y = markYel(d);
					}
					
					printArray(arr);
					k = solveYel(y, d);
					if(k == 1)
					{
						System.out.println("PLAYER 2 WINS \n CONGRATULATIONS");
						break;
					}
					
					
				}
				if (i == 21)
					System.out.println("THE GAME IS A DRAW");
				
				
		}
			public static void printArray(int [][] arr){
			int i,j ;
			for(i = 0; i < 7; i++)
			{
				System.out.print("  "+i+"  |");
			}
			System.out.print("\n");
			System.out.print("------------------------------------------\n");
			for(i = 0; i < 6; i++)
			{
				for(j = 0; j < 7; j++)
				{
					System.out.print("  "+arr[i][j]+"  |");
				}
				System.out.print("\n");
			}
			
			}
			
			public static int markRed( int m)
			{
				if (arr[0][m] != 0)
					return -1;
				int x = check( 0, m);
				arr[x][m] = 1;
				return x;
					
			}
			
			
			
			
			//gets the row number to insert the tile
			public static int check( int n, int m)
			{
				if ( ( n== 6) || (arr[n][m] == 2) || (arr[n][m] == 1))  
					return n-1;
				else return check( n+1, m);
			}
			
			
			
			public static int markYel( int m)
			{
				if(arr[0][m] != 0)
					return -1;
				int x;
				x = check(0, m);
				arr[x][m] = 2;
				return x;
			}
			
			public static int solveRed( int n ,int m)
			{
				int i;
				int count = 0;
				//horizontal check
				for (i = 0; i < 4; i++)
				{
					if(m+i <= 6)
					{
						if (arr[n][m+i] != 1)
							break;
						else count++;
						if (count == 4)
							return 1;
					}
					
				}
				for(i = 1; i < 4; i++)
				{
					if(m-i >= 0)
					{
						if(arr[n][m-i] != 1)
							break;
						else count++;
						if(count == 4)
							return 1;
					}
					
				}
				//obtuse diagonal
				count = 0;
				for(i = 0; i < 4; i++)
				{
					if(n+i <= 5 && m+i <= 6)
					{
						if(arr[n+i][m+i] != 1)
							break;
						else count++;
						if(count == 4 )
							return 1;
					}
					
				}
				for(i = 1; i < 4; i++)
				{
					if(n-i >= 0 && m-i >= 0)
					{
						if(arr[n-i][m-i] != 1)
							break;
						else count++;
						if (count == 4)
							return 1;
					}
					
				}
				//acute diagonal
				count = 0;
				for(i = 0; i < 4; i++)
				{
					if(n-i >= 0 && m+i <= 6)
					{
						if(arr[n-i][m+i] != 1)
							break;
						else count++;
						if(count == 4)
							return 1;
					}
					
				}
				for(i = 1; i < 4; i++)
				{
					if(n+i <= 5 && m-i >= 0)
					{
						if(arr[n+i][m-i] != 1)
							break;
						else count++;
						if(count == 4)
							return 1;
					}
					
				}
				//vertical
				count = 0;
				for(i = 0; i < 4; i++)
				{
					if(n+i <= 5)
					{
						if(arr[n+i][m] == 1)
							count ++;
						if(count == 4)
							return 1;
					}
					
				}
				return 0;
				
				
			}

			
			public static int solveYel( int n ,int m)
			{
				int i;
				int count = 0;
				//horizontal check
				for (i = 0; i < 4; i++)
				{
					if(m+i <= 6)
					{
						if (arr[n][m+i] != 2)
							break;
						else count ++;
						if (count == 4)
							return 1;
					}
					
				}
				for(i = 1; i < 4; i++)
				{
					if(m-i >= 0)
					{
						if(arr[n][m-i] != 2)
							break;
						else count ++;
						if(count == 4)
							return 1;
					}
					
				}
				//obtuse diagonal
				count = 0;
				for(i = 0; i < 4; i++)
				{
					if(n+i <= 5 && m+i <= 6)
					{
						if(arr[n+i][m+i] != 2)
							break;
						else count ++;
						if(count == 4)
							return 1;
					}
					
				}
				for(i = 1; i < 4; i++)
				{
					if(n-i >= 0 && m-i >= 0)
					{
						if(arr[n-i][m-i] != 2)
							break;
						else count ++;
						if (count == 4)
							return 1;
					}
					
				}
				//acute diagonal
				count = 0;
				for(i = 0; i < 4; i++)
				{
					if(n-i >= 0 && m+i <= 6)
					{
						if(arr[n-i][m+i] != 2)
							break;
						else count ++;
						if(count == 4)
							return 1;
					}
					
				}
				for(i = 1; i < 4; i++)
				{
					if(n+i <= 5 && m-i >= 0)
					{
						if(arr[n+i][m-i] != 2)
							break;
						else count ++;
						if(count == 4)
							return 1;
					}
					
				}
				//vertical
				count = 0;
				for(i = 0; i < 4; i++)
				{
					if(n+i <= 5)
					{
						if(arr[n+i][m] == 2)
							count ++;
						if(count == 4)
							return 1;
					}
					
				}
				return 0;
				
				
			}

}
