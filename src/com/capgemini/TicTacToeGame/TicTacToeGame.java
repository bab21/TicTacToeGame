package com.capgemini.TicTacToeGame;
import java.util.*;


public class TicTacToeGame {	
	private char[][] board;
	TicTacToeGame(){
		board=new char[4][4];
	}
	private void initializeGame() {
		for (char[] row : board) 
            Arrays.fill(row,'.'); 
		
	}
	private char takeInput() {
		Scanner s=new Scanner(System.in);
		char user_choice;
		
		System.out.println("Pease enter your input(X/O)");
		user_choice=s.next().charAt(0);
		
	    s.close();
	    return user_choice;	
	}
	private void show_board() {
		int i,j,n;
		n=board.length;
		System.out.println("Presenting current state of board");
		for(i=1;i<n;i++) {
			for(j=1;j<n;j++)
				System.out.print(board[i][j]+" ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		TicTacToeGame game=new TicTacToeGame();
		game.initializeGame();
		char user_choice=game.takeInput();
		char computer_choice=(user_choice=='X')?'O':'X';
		System.out.println("computer choice:"+computer_choice);
		game.show_board();
	}
}
