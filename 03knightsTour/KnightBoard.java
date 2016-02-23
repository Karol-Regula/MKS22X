import java.io.*;//make this specific later
public class KnightBoard{
    int[][] board;
    int rows;
    int cols;
    int counter;
    
    public static void main(String[]args){
	/*
	KnightBoard b1 = new KnightBoard(5,5);
	b1.solve();
	b1.printSolution();
	KnightBoard b2 = new KnightBoard(6,6);
	b2.solve();
	b2.printSolution();
	KnightBoard b3 = new KnightBoard(5,7);
	b3.solve();
	b3.printSolution();
	KnightBoard b4 = new KnightBoard(3,5);
	b4.solve();
	b4.printSolution();
	KnightBoard b5 = new KnightBoard(3,7);
	b5.solve();
	b5.printSolution();
	KnightBoard b6 = new KnightBoard(5,6);
	b6.solve();
	b6.printSolution();
	*/
    }

    public KnightBoard(int rowsNum, int colsNum){
	rows = rowsNum;
	cols = colsNum;
	board = new int[rows][cols];
	fillBoard();
	counter = 1;
    }

    public void fillBoard(){
	for (int i = 0; i < rows; i++){
	    for (int j = 0; j < cols; j++){
		board[i][j] = 0;
	    }
	}
    }

    public boolean solve(){
	return (solveHelper(0, 0));
    }

    public boolean solveHelper(int row, int col){
	if (! onBoard(row, col)){
	    return false;
	}
	//printSolution();
	//System.out.println(counter);
	//System.out.println("----------------------------");
	board[row][col] = counter;
	counter++;
	if (counter == (rows * cols) + 1){//check counter increments, if errors occur, probably is one off
	    //System.out.println(counter + " " + row + " "  + col);
	    return true;//this means the entire board has been filled
	}
	//up left
	if(onBoard(row + 2, col - 1) && board[row + 2][col - 1] ==0 && solveHelper(row + 2, col - 1)){
	    return true;
	}
	//up right
	if(onBoard(row + 2, col + 1) && board[row + 2][col + 1] ==0 && solveHelper(row + 2, col + 1)){
	    return true;
	}
	//down left
	if(onBoard(row - 2, col - 1) && board[row - 2][col - 1] ==0 && solveHelper(row - 2, col - 1)){
	    return true;
	}
	//down right
	if(onBoard(row - 2, col + 1) && board[row - 2][col + 1] ==0 && solveHelper(row - 2, col + 1)){
	    return true;
	}
	//right up
	if(onBoard(row + 1, col + 2) && board[row + 1][col + 2] ==0 && solveHelper(row + 1, col + 2)){
	    return true;
	}
	//right down
	if(onBoard(row - 1, col + 2) && board[row - 1][col + 2] ==0 && solveHelper(row - 1, col + 2)){
	    return true;
	}
	//left up
	if(onBoard(row + 1, col - 2) && board[row + 1][col - 2] ==0 && solveHelper(row + 1, col - 2)){
	    return true;
	}
	//left down
	if(onBoard(row - 1, col - 2) && board[row - 1][col - 2] ==0 && solveHelper(row - 1, col - 2)){
	    return true;
	}
	board[row][col] = 0;
	counter--;
	return false;
	/*
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board.length; j++){
		if (board[i][j] == counter){
		    row = i;
		    col = j;
		}
	    }
	}
	//need to somehow stop if from trying the same one again and then undoing over and over again, this is badly written logically
	solveHelper(row, col, counter);
	*/
    }

    public boolean onBoard(int row, int col){
	try{
	    board[row][col] = board[row][col];
	    return true;
	}catch (ArrayIndexOutOfBoundsException e){
	    //System.out.println("Out of bounds.");
	    return false;
	}
	//try - catch checks if new spot is on the board
    }
    
    public void printSolution(){
	for (int i = 0; i < rows; i++){
	    for (int j = 0; j < cols; j++){
		if (board[i][j] < 10){
		    System.out.print("_" + board[i][j] + " ");
		}else{
		    System.out.print(board[i][j] + " ");
		}
	    }
	    System.out.println();
	}
	System.out.println();
    }
}
