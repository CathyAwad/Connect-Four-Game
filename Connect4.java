

import javax.swing.*;
import java.awt.GridLayout;
//import java.lang.*;

public class Connect4 extends JFrame {
	static JPanel pan = new JPanel();
	static JButton button [][] = new JButton[6][7];
	static Conn4 connect ;
	
	public static void main(String [] args){
		 connect = new Conn4();

		Connect4 x = new Connect4();
		JOptionPane.showMessageDialog(null, "WELCOME TO OUR CONNECT FOUR GAME");
		String column1, column2;
		int col1, col2, row1, row2, r, k;
		int i;
		for( i = 0; i < 21; i++)
		{
					
			column1 = JOptionPane.showInputDialog(null, "PLAYER 1       ENTER COLUMN NUMBER 1-7");
			col1 = (Integer.parseInt(column1)) - 1;
			while( col1 < 0  ||  col1 > 6)
			{
				column1 = JOptionPane.showInputDialog(null, "UNVALID COLUMN ENTRY TRY AGAIN!\nPLAYER 1       ENTER COLUMN NUMBER 1-7");
				col1 = (Integer.parseInt(column1)) - 1;
			}
				
				 row1 = Conn4.markRed(col1);
				 while(row1 == -1){
					 column1 = JOptionPane.showInputDialog(null, " COLUMN FULL CHOOSE AGAIN\nPLAYER 1       ENTER COLUMN NUMBER 1-7");
						col1 = (Integer.parseInt(column1)) - 1;
						 row1 = Conn4.markRed(col1);
				 }				
				changeButtonRed(x.button[row1][col1]);
				System.out.println(row1+" 'player 1' "+col1);

				r = Conn4.solveRed( row1, col1);
				if(r == 1)
				{
					JOptionPane.showMessageDialog(null, "PLAYER 1 WINS   CONGRATULATIONS");
					break;
				}
			
				//PLAYER 2
				column2 = JOptionPane.showInputDialog(null, "PLAYER 2       ENTER COLUMN NUMBER 1-7");
				col2 = (Integer.parseInt(column2)) - 1;
				while( col2 < 0  ||  col2 > 6)
				{
					column2 = JOptionPane.showInputDialog(null, "UNVALID COLUMN ENTRY TRY AGAIN!\nPLAYER 1       ENTER COLUMN NUMBER 1-7");
					col2 = (Integer.parseInt(column2)) - 1;
				}
				row2 = Conn4.markYel(col2);
				while(row2 == -1){
					 column2 = JOptionPane.showInputDialog(null, " COLUMN FULL CHOOSE AGAIN\nPLAYER 1       ENTER COLUMN NUMBER 1-7");
						col2 = (Integer.parseInt(column2)) - 1;
						 row2 = Conn4.markRed(col2);
				 }
				
				System.out.println(row2+" 'player 2' "+col2);
				ChangeButtonYel(x.button[row2][col2]);
				k = Conn4.solveYel(row2, col2);
				if(k == 1)
				{
					JOptionPane.showMessageDialog(null, "PLAYER 2 WINS   CONGRATULATIONS");
					break;
				}
		}
		
		if(i == 21)
		{
			JOptionPane.showMessageDialog(null, "THIS GAME RESULT IS A DRAW");
		
		}
		
	}
	
	//sets the general display of the game window
	public Connect4(){
		super("Connect Four");
		setSize(700, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pan.setLayout(new GridLayout(6, 7));
		int i, j;
		for ( i = 0; i < 6; i++) {
			for ( j = 0; j < 7; j++) {
				button[i][j] = new JButton();
				ImageIcon c = new ImageIcon(("blank.png"));
				button[i][j].setIcon(c);
				pan.add(button[i][j]);
			}
		}
		add(pan);
		setVisible(true);
	}
	
	//method used to change colour of circle to red
	static void changeButtonRed(JButton b)
	{
		ImageIcon red = new ImageIcon(("red.png"));
		b.setIcon(red);

	}
	
	//method used to change colour of circle to yellow
	static void ChangeButtonYel(JButton b)
	{
		ImageIcon yel;
		yel = new ImageIcon(("yel.png"));
		b.setIcon(yel);
	}

}

