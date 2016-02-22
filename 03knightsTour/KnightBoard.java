import java.io.*;//make this specific later
public class KnightBoard{
    int[][] board;
    int size;
    int counter;
    
    public static void main(String[]args){
	KnightBoard b1 = new KnightBoard(4);
	b1.solve();
	b1.printSolution();
    }

    public KnightBoard(int side){
	size = side;
	board = new int[size][size];
	fillBoard();
	counter = 0;
    }

    public void fillBoard(){
	for (int i = 0; i < size; i++){
	    for (int j = 0; j < size; j++){
		board[i][j] = 0;
	    }
	}
    }

    public boolean solve(){
	return (solveHelper(0, 0));
    }

    public boolean solveHelper(int row, int col){
	//somehow backtracking doesn't work at all, not even once...
	//!!!???
	if (! onBoard(row, col)){
	    return false;
	}
	printSolution();
	System.out.println(counter);
	if (counter == size * size && board[row][col] == 1){//check counter increments, if errors occur, probably is one off
	    System.out.println(counter + " " + row + " "  + col);
	    return true;//this means the entire board has been filled
	}
	//also make sure the rows and cols are not switched, althought that shouldn't make that much of a difference
	//commence the eight 'if' statements
	//up left
	if(onBoard(row + 2, col - 1) && board[row + 2][col - 1] ==0){
	    board[row + 2][col - 1] = counter;
	    counter++;
	    return(solveHelper(row + 2, col - 1));
	}
	//up right
	if(onBoard(row + 2, col + 1) && board[row + 2][col + 1] ==0){
	    board[row + 2][col + 1] = counter;
	    counter++;
	    return(solveHelper(row + 2, col + 1));
	}
	//down left
	if(onBoard(row - 2, col - 1) && board[row - 2][col - 1] ==0){
	    board[row - 2][col - 1] = counter;
	    counter++;
	    return(solveHelper(row - 2, col - 1));
	}
	//down right
	if(onBoard(row - 2, col + 1) && board[row - 2][col + 1] ==0){
	    board[row - 2][col + 1] = counter;
	    counter++;
	    return(solveHelper(row - 2, col + 1));
	}
	//right up
	if(onBoard(row + 1, col + 2) && board[row + 1][col + 2] ==0){
	    board[row + 1][col + 2] = counter;
	    counter++;
	    return(solveHelper(row + 1, col + 2));
	}
	//right down
	if(onBoard(row - 1, col + 2) && board[row - 1][col + 2] ==0){
	    board[row - 1][col + 2] = counter;
	    counter++;
	    return(solveHelper(row - 1, col + 2));
	}
	//left up
	if(onBoard(row + 1, col - 2) && board[row + 1][col - 2] ==0){
	    board[row + 1][col - 2] = counter;
	    counter++;
	    return(solveHelper(row + 1, col - 2));
	}
	//left down
	if(onBoard(row - 1, col - 2) && board[row - 1][col - 2] ==0){
	    board[row - 1][col - 2] = counter;
	    counter++;
	    return(solveHelper(row - 1, col - 2));
	}
	//need the backtracking part
	board[row][col] = 0;
	counter--;
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
	return false;
    }

    public boolean onBoard(int row, int col){
	try{
	    board[row][col] = board[row][col];
	    return true;
	}catch (ArrayIndexOutOfBoundsException e){
	    System.out.println("Out of bounds.");
	    return false;
	}
	//try - catch checks if new spot is on the board
    }
    
    public void printSolution(){
	for (int i = 0; i < size; i++){
	    for (int j = 0; j < size; j++){
		System.out.print(board[i][j] + " ");
	    }
	    System.out.println();
	}
    }
}
