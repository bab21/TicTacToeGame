package com.capgemini.tictactoegame;
import java.util.*;

public class TicTacToe {
	private char[] board;
	private char userSymbol,computerSymbol;
	public static Scanner s = new Scanner(System.in);
	
    private enum PLAYER{
    	USER,COMPUTER
    }
    
	TicTacToe() {
		board = new char[9];
	}

	//initializing board..
	private void initializeGame() {
			Arrays.fill(board, '.');	
	}

	//determining  input symbol  for user and computer..
	private void takeInput(PLAYER player) {

		if(player==PLAYER.USER)
		{    System.out.println("Pease enter your input(X/O)");
			 userSymbol = s.next().charAt(0);
			 computerSymbol=(userSymbol=='X')?'O':'X';
		}
		else 
		{
			computerSymbol=((int)Math.floor(Math.random()*10)%2)==1?'O':'X';
			userSymbol=(computerSymbol=='X')?'O':'X';
		}

		
	}
    
	//presenting current state of board...
	private void showBoard() {
		
		System.out.println("Current state of board");
		
		System.out.println(board[0]+"|"+board[1]+"|"+board[2]);
		System.out.println("______");
		System.out.println(board[3]+"|"+board[4]+"|"+board[5]);
		System.out.println("______");
		System.out.println(board[6]+"|"+board[7]+"|"+board[8]);
			
	}
	
	//checking if move if valid...
	private boolean validMove(int position) {
		if(board[position-1]=='.')
			return true;
		else {
			System.out.println("This position is not empty,choose valid position");
			return false;
		}
	}
	
	//user making move and  checking if he/she wins
	private boolean userMakeMove(int position) {

		if(validMove(position))
			board[position-1]=userSymbol;
		
		if(checkWinner(userSymbol)) {
			System.out.println("User wins..");
			return true;
		}
		else return false;
	}

	//computer makes move and checking if it wins
	private boolean computerMakeMove() {
		int position=-1;
		
		if(checkBlockingPosition(computerSymbol)>=0)
			position=checkBlockingPosition(computerSymbol);
		
		else if(checkBlockingPosition(userSymbol)>=0) {
			position=checkBlockingPosition(userSymbol);	
		}
		else if(getCorner()>=0 && getCorner()<=8)
			position=getCorner();
		else if(getCentre()>0)
			position=getCentre();
		else {
			ArrayList<Integer> emptyPositions=new ArrayList<Integer>();
			for(int i=0;i<board.length;i++) {
				if(board[i]=='.')
					emptyPositions.add(i);
			}
			if(emptyPositions.size()==0)
				return false;
			
			int randomIndex = (int) (Math.random() * emptyPositions.size());
		    position=emptyPositions.get( randomIndex );
		}
		board[position]=computerSymbol;
		
		if(checkWinner(computerSymbol)) {
			System.out.println("Computer wins..");
			return true;
		}
		else return false;
		
	}
	
	//checking who plays first...
	private PLAYER doToss() {
		int result=(int)Math.floor(Math.random()*10)%2;
		System.out.println("Toss Result");
		if(result==1){
			System.out.println("User plays first");
			return PLAYER.USER;
			}
		else {
			System.out.println("Computer plays first");
			return PLAYER.COMPUTER;	
		}
	}
	
	//checking for winning condition..
	private boolean checkWinner(char c) {
	
		if((board[0]==c && board[1]==c && board[2]==c)||
		  (board[3]==c && board[4]==c && board[5]==c)||
		  (board[6]==c && board[7]==c && board[8]==c)||
	      (board[0]==c && board[4]==c && board[8]==c)||
		  (board[2]==c && board[4]==c && board[6]==c)||
		  (board[0]==c && board[3]==c && board[6]==c)||
		  (board[1]==c && board[4]==c && board[7]==c)||
		  (board[2]==c && board[5]==c && board[8]==c))
			return true;
		else return false;
			
	}
	
	//checking if board is completely filled....
	private boolean allFill() {
		
		for(int i=0;i<board.length;i++)
			if(board[i]=='.')
				return false;
		System.out.println("Entire board is filled");
		return true;
	}
	
	//UC 10....
	private int getCorner() {
		if(board[0]=='.')return 0;
		if(board[2]=='.')return 2;
		if(board[6]=='.')return 6;
		if(board[8]=='.')return 8;
		return -1;
	}
	
	//UC 11....
	private int getCentre() {
		if(board[4]=='.')return 4;
		else return -1;
	}
	//check for blocking condition....
	private int checkBlockingPosition(char symbol) {
		if(board[0]=='.' &&  board[1]==symbol &&  board[2]==symbol ||
				board[0]=='.' &&  board[3]==symbol  && board[6]==symbol||
				board[0]=='.' &&  board[4]==symbol &&  board[8]==symbol)
		return 0;
		if(board[0]==symbol && board[1]=='.' && board[2]==symbol ||
				board[1]=='.' && board[4]==symbol && board[7]==symbol)
		return 1;
		if(board[0]==symbol && board[1]==symbol && board[2]=='.'||
				board[2]=='.' && board[5]==symbol && board[8]==symbol)
		return 2;
		if(board[0]==symbol && board[3]=='.' && board[6]==symbol ||
				board[3]=='.' && board[4]==symbol && board[5]==symbol)
		return 3;
		if ((board[1] == symbol && board[7] ==symbol) || (board[3] == symbol && board[5] == symbol) || (board[0] == symbol && board[8] == symbol)
				|| (board[2] == symbol && board[6] == symbol) && board[4]=='.') {
				return 4;
		}

		if ((board[2] == symbol && board[8] == symbol) || (board[3] == symbol && board[4] == symbol) && board[5]=='.') {
				return 5;
		}

		if ((board[0] == symbol && board[3] ==symbol ) || (board[7] == symbol && board[8] == symbol) || (board[4] == symbol && board[2] == symbol) && board[6]=='.') {
				return 6;
		}

		if ((board[1] == symbol && board[4] == symbol) || (board[6] == symbol && board[8] == symbol) && board[7]=='.') {
				return 7;
		}

		if ((board[6] == symbol && board[7] == symbol) || (board[2] == symbol && board[5] == symbol) || (board[4] == symbol && board[0] == symbol) && board[8]=='.') {
				return 8;
		}
		
		return -1;
		
	}

	public static void main(String[] args) {
		
		TicTacToe game = new TicTacToe();
		
		game.initializeGame();
		System.out.println("Tossing for who plays first");
	    PLAYER tossWinner=game.doToss();
	    
	    boolean userMoveResult,computerMoveResult;
	    if(tossWinner==PLAYER.USER) {
	    	game.takeInput(PLAYER.USER);
	    	while(true) {
	    		if(game.allFill())
				{
					System.out.println("Match draws");
					return;
				}
	    		int position;
	    		do {
		    	System.out.println("Enter position(1-9)");
			    position=s.nextInt();
			    if(game.allFill())break;
	    		}while(!game.validMove(position));
	    		
			    userMoveResult=game.userMakeMove(position);
			    System.out.println("After user turn");
				game.showBoard();
				if(userMoveResult)
					break;
				
				computerMoveResult=game.computerMakeMove();
				System.out.println("After computer turn");
				game.showBoard();
				if(computerMoveResult)
					break;
				
	    	}
	    }
	    else {
	    	game.takeInput(PLAYER.COMPUTER);
	    	while(true) {
	    		if(game.allFill())
				{
					System.out.println("Match draws");
					break;
				}
				computerMoveResult=game.computerMakeMove();
				System.out.println("After computer turn");
				game.showBoard();
				if(computerMoveResult)
					break;
				int position=0;
				
				do {
				System.out.println("Enter position(1-9) ");
		        position=s.nextInt();
		        if(game.allFill())break;
				}while(!game.validMove(position));
				
	
				userMoveResult=game.userMakeMove(position);
				System.out.println("After user turn");
				game.showBoard();
				if(userMoveResult)
					break;
				
				
		    }
	    }
	    s.close();
	}
}
