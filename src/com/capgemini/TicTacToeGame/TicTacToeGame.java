package com.capgemini.TicTacToeGame;
import java.util.*;


public class TicTacToeGame {	
	private char[][] board;
	TicTacToeGame(){
		board=new char[4][4];
	}
	private void initializeGame() {
		Arrays.fill(board,' ');
	}
	private char[] takeInput() {
		Scanner s=new Scanner(System.in);
		char user_choice,computer_choice;
		char[] choice=new char[2];
		
		System.out.println("Pease enter your input(X/O)");
		user_choice=s.next().charAt(0);
		computer_choice=' ';
		
		if(user_choice=='X')
			computer_choice='O';
		else if(user_choice=='O')
			computer_choice='X';
		
		choice[0]=user_choice;
		choice[1]=computer_choice;
		
		return choice;	
	}
	public static void main(String[] args) {
		TicTacToeGame game=new TicTacToeGame();
		game.initializeGame();
		char[] choice=game.takeInput();
	}
}
