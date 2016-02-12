public class QueenBoard{
    int[][] board;
    int size;

    public static void main(String[]args){
	/*
	for (int i = 0; i < 30; i++){
	    QueenBoard bi = new Board(i);
	    bi.solve();
	}
	*/
	//QueenBoard b1 = new QueenBoard(25);
	/*
	b1.printBoard();
	b1.addQueen(3,3);
	b1.addQueen(0,9);
	b1.addQueen(8,0);
	b1.printBoard();
	b1.printBoardFancy();
	b1.removeQueen(0,9);
	b1.printBoard();
	b1.printBoardFancy();
	*/
	//b1.solve();
	//b1.printSolution();
    }

    public QueenBoard(int side){
	size = side;
	board = new int[size][size];
	fillBoard();
    }

    public void fillBoard(){
	for(int i = 0; i < size; i++){
	    for(int j = 0; j < size; j++){
		board[i][j] = 0;
	    }
	}
    }

    public boolean solve(){
	return solveHelper(0);
    }
    
    //for some reason everything is sideways and I can't find the place where I switched the rows and cols
    public boolean solveHelper(int row){
	if (row == size){
	    return true;
	    //this seems to go past the solution...
	}
	for (int i = 0; i < size; i++){
	    if (addQueen(row,i)){
		//printBoardFancy();
		if (solveHelper(row + 1)){
		    return true;
		    //this should finish
		}
		removeQueen(row, i);
	    }
	}
	return false;
    }

    public boolean addQueen(int row, int col){
	//make this private
	if (board[row][col] != 0){
            return false;
	}
	board[row][col] = 1;
	for(int i = 0; i < size; i++){
	    if(board[i][col] != 1){
		board[i][col]--;
	    }
	}
	for(int i = 0; i < size; i++){
	    if(board[row][i] != 1){
		board[row][i]--;
	    }
	}
	//need 4 loops that go in 4 diagonal directions and stop at edge, while loops, I don't a simpler way to do this
	int newcol = col;
	int newrow = row;
	while(newcol < size && newrow < size){//down-right
	    if(board[newrow][newcol] != 1){
		board[newrow][newcol]--;
	    }
	    newcol++;
	    newrow++;
	}
	newcol = col;
	newrow = row;
	while(newcol >= 0 && newrow < size){//down-left
	    if(board[newrow][newcol] != 1){
		board[newrow][newcol]--;
	    }
	    newcol--;
	    newrow++;
	}
	newcol = col;
	newrow = row;
	while(newcol < size && newrow >= 0){//up-left
	    if(board[newrow][newcol] != 1){
		board[newrow][newcol]--;
	    }
	    newcol++;
	    newrow--;
	}
	newcol = col;
	newrow = row;
	while(newcol >= 0 && newrow >= 0){//up-right
	    if(board[newrow][newcol] != 1){
		board[newrow][newcol]--;
	    }
	    newcol--;
	    newrow--;
	}
	return true;
	//don't really need the loops going back, can make this much shorter
    }

    public boolean removeQueen(int row, int col){//make this private
	if (board[row][col] != 1){
            return false;
	}
	for(int i = 0; i < size; i++){
	    if(board[i][col] != 1){
		board[i][col]++;
	    }
	}
	for(int i = 0; i < size; i++){
	    if(board[row][i] != 1){
		board[row][i]++;
	    }
	}
	//need 4 loops that go in 4 diagonal directions and stop at edge, while loops, I don't a simpler way to do this
	int newcol = col;
	int newrow = row;
	while(newcol < size && newrow < size){//down-right
	    if(board[newrow][newcol] != 1){
		board[newrow][newcol]++;
	    }
	    newcol++;
	    newrow++;
	}
	newcol = col;
	newrow = row;
	while(newcol >= 0 && newrow < size){//down-left
	    if(board[newrow][newcol] != 1){
		board[newrow][newcol]++;
	    }
	    newcol--;
	    newrow++;
	}
	newcol = col;
	newrow = row;
	while(newcol < size && newrow >= 0){//up-left
	    if(board[newrow][newcol] != 1){
		board[newrow][newcol]++;
	    }
	    newcol++;
	    newrow--;
	}
	newcol = col;
	newrow = row;
	while(newcol >= 0 && newrow >= 0){//up-right
	    if(board[newrow][newcol] != 1){
		board[newrow][newcol]++;
	    }
	    newcol--;
	    newrow--;
	}
	board[row][col] = 0;
	return true;
    }
	
    public void printBoard(){
	for(int i = 0; i < size; i++){
	    for(int j = 0; j < size; j++){
		if (board[i][j] < 0){
		    System.out.print(board[i][j]);
		}else{
		    System.out.print(" " + board[i][j]);
		}
	    }
	    System.out.println();
	}
	System.out.println();
    }

    public void printSolution(){
	for(int i = 0; i < size; i++){
	    for(int j = 0; j < size; j++){
		if(board[i][j] == 1){
		    System.out.print("Q ");
		}
		else if(board[i][j] < 0){
		    System.out.print("- ");
		}
		else if(i!= 0 && board[i - 1][j] == 1){
		    System.out.print(" ");
		}else{
		    System.out.print("  ");
		}
	    }
	    System.out.println();
	}
	System.out.println();
    }

}
