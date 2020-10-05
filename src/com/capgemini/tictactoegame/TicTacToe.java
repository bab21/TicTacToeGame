package com.capgemini.tictactoegame;
import java.util.*;

public class TicTacToe {
	private char[] board;

	TicTacToe() {
		board = new char[9];
	}

	private void initializeGame() {
			Arrays.fill(board, '.');
	}

	private char takeInput() {
		Scanner s = new Scanner(System.in);
		char userChoice;

		System.out.println("Pease enter your input(X/O)");
		userChoice = s.next().charAt(0);

		s.close();
		return userChoice;
	}

	private void showBoard() {
		
		System.out.println("Presenting current state of board");
		
		System.out.println(board[0]+"|"+board[1]+"|"+board[2]);
		System.out.println("______");
		System.out.println(board[3]+"|"+board[4]+"|"+board[5]);
		System.out.println("______");
		System.out.println(board[6]+"|"+board[7]+"|"+board[8]);
			
	}
	private boolean getMakeMove(int position) {
//		System.out.println("Make your move,Enter the index(1-9)");
		boolean ans=false;
		
		if(board[position-1]!='.') {
			System.out.println("This position is not empty,Please choose a empty psition");
			ans=false;
		}
		else ans=false;
		
		return ans;
	}
	public void makeMove() {
		Scanner s=new Scanner(System.in);
		System.out.println("Make your move,Enter the index(1-9)");
		int position=s.nextInt();
		boolean ans=getMakeMove(position);
		if(ans==true);
			board[position-1]='&';	
	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.initializeGame();
		game.showBoard();
		game.makeMove();
		
//		char userChoice = game.takeInput();
//		char computerChoice = (userChoice == 'X') ? 'O' : 'X';
//		System.out.println("position you made current move:" + movePosition);
		game.showBoard();
	}
}
