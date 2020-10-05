package com.capgemini.tictactoegame;
import java.util.*;

public class TicTacToe {
	private char[] board;

	TicTacToe() {
		board = new char[9];
	}

	//initializing board..
	private void initializeGame() {
			Arrays.fill(board, '.');	
	}

	//taking input from user..
	private char takeInput() {
		Scanner s = new Scanner(System.in);
		char userChoice;

		System.out.println("Pease enter your input(X/O)");
		userChoice = s.next().charAt(0);

		s.close();
		return userChoice;
	}
    
	//presenting current state of board...
	private void showBoard() {
		
		System.out.println("Presenting current state of board");
		
		System.out.println(board[0]+"|"+board[1]+"|"+board[2]);
		System.out.println("______");
		System.out.println(board[3]+"|"+board[4]+"|"+board[5]);
		System.out.println("______");
		System.out.println(board[6]+"|"+board[7]+"|"+board[8]);
			
	}
	
	//checking if move if valid...
	private boolean getMakeMove(int position) {
		if(board[position-1]=='.')
			return true;
		else return false;
	}
	
	//making move...
	public void makeMove(int position,char value) {

		boolean ans=getMakeMove(position);
		if(ans==true)
			board[position-1]=value;	
		else 
			System.out.println("This position is not empty,choose valid position");
		
	}

	//checking who plays first...

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		TicTacToe game = new TicTacToe();
		game.initializeGame();
		game.showBoard();
		
		System.out.println("Enter position ");
		int position=s.nextInt();
		System.out.println("Enter value(X/O)");
		char value=s.next().charAt(0);
		
		
		game.makeMove(position,value);
		game.showBoard();
	}
}
