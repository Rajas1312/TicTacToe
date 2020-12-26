import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		char [] board=createBoard();
		char userLetter= chooseSymbol(scanner);			//user input letter
		char compLetter=(userLetter=='X')?'O':'X';		//computer input letter
		showBoard(board);
		int start=startingMove();
		System.out.println(start);
		if(start==0) {
		int index=selectPlayerIndex(board,scanner);
		makeMove(board,userLetter,index);
		showBoard(board);
		}
		checkWinner(board);
		

	}
	//UC1
	public static char[] createBoard() {
		
		char [] board=new char[10];
		for(int i=1;i<board.length;i++) {
			board[i]=' ';						//Initializing the board with blank space
		}
		return board;
	}
	//UC2
	public static char chooseSymbol(Scanner scanner) {
		
		System.out.println("Choose your letter ");
		return scanner.next().toUpperCase().charAt(0);	//returning the character at 0th to upper case
	}
	//UC3
	public static void showBoard(char [] board) {
		
		System.out.println("\n" +board[1] +"|" + board[2] + "|" + board[3] + "|");
		System.out.println("--------");
		System.out.println("\n" +board[4] +"|" + board[5] + "|" + board[6] + "|");			//printing the board
		System.out.println("--------");
		System.out.println("\n" +board[7] +"|" + board[8] + "|" + board[9] + "|");
	}
	//UC4
	public static int selectPlayerIndex(char [] board,Scanner scanner) {
		
		System.out.println("Enter a the index 1 to 9");
		 int index=scanner.nextInt();
		if(index>=1 && index<=9 && board[index]==' ') {						//Selecting player index 
			
			return index;
		}
		else {
			System.out.println("Re-enter");
			return selectPlayerIndex(board,scanner);
			}
	}
	public static boolean checkPosition(char [] board,int index) {
		if(board[index]==' ')
			return true;													//checking if position is free
		else
		return false;
	}
	public static void makeMove(char [] board,char letter,int index) {
		
		boolean isFree= checkPosition(board,index);							//making the move if position is free
		if (isFree==true)
		board[index]=letter;
	}
	//UC6
	public static int startingMove() {
		
		int turn=(int)(Math.random()*10)%2;
		if(turn==0) {
			System.out.println("player starts first");
			return 0;
		}
		else {
			System.out.println("computer starts first");
			return 1;
			}		
		}
	public void compMove(char[] board,char compLetter) {
		for(int i=1;i<=board.length;i=i+3) {
		if(board[i]==compLetter && board[i+1]==compLetter){
			boolean isFree=checkPosition(board,i+2);
			if(isFree) {
				board[i+2]=compLetter;	
				break;
				}
			}
		}
		for(int i=1;i<=board.length;i=i+3) {
			if(board[i]==compLetter && board[i+3]==compLetter){
				boolean isFree=checkPosition(board,i+2);
				if(isFree) {
					board[i+2]=compLetter;	
					break;
					}
				}
			}
		
	}
	
	public static void checkWinner(char [] board) {

		if (board[1]=='X'&&board[2]=='X'&&board[3]=='X')
			System.out.println("X is winning combo ");
		if(board[1]=='X'&&board[4]=='X'&&board[7]=='X')
			System.out.println("X is winning combo ");
		if(board[7]=='X'&&board[8]=='X'&&board[9]=='X')
			System.out.println("X is winning combo");
		if(board[3]=='X'&&board[6]=='X'&&board[9]=='X')
			System.out.println("X is winning commbo");
		if(board[1]=='X'&board[5]=='X'&&board[9]=='X')
			System.out.println("X is winning combo");
		if(board[3]=='X'&&board[5]=='X'&&board[7]=='X')
			System.out.println("X is winning combo");
		if(board[4]=='X'&&board[5]=='X'&&board[6]=='X')
			System.out.println("X is winning combo");
		if(board[2]=='X'&&board[5]=='X'&&board[8]=='X')
			System.out.println("X is winning combo");
			
		
		
		if (board[1]=='O'&&board[2]=='O'&&board[3]=='O')
			System.out.println(" O is winning combo ");
		if(board[1]=='O'&&board[4]=='O'&&board[7]=='O')
			System.out.println("O is winning combo ");
		if(board[7]=='O'&&board[8]=='O'&&board[9]=='O')
			System.out.println("O is winning combo");
		if(board[3]=='O'&&board[6]=='O'&&board[9]=='O')
			System.out.println("O is winning commbo");
		if(board[1]=='O'&board[5]=='O'&&board[9]=='O')
			System.out.println("O is winning combo");
		if(board[3]=='O'&&board[5]=='O'&&board[7]=='O')
			System.out.println("O is winning combo");
		if(board[4]=='O'&&board[5]=='O'&&board[6]=='O')
			System.out.println("O is winning combo");
		if(board[2]=='O'&&board[5]=='O'&&board[8]=='O')
			System.out.println("O is winning combo");
	}
	
}
