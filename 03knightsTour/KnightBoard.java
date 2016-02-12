public class KnightBoard{
    int[][] board;
    int size;
    
    public static void main(String[]args){
	KnightBoard b1 = new KnightBoard(4);
	b1.printSolution();
    }

    public KnightBoard(int side){
	size = side;
	board = new int[size][size];
	fillBoard();
    }

    public void fillBoard(){
	for (int i = 0; i < size; i++){
	    for (int j = 0; j < size; j++){
		board[i][j] = 0;
	    }
	}
    }

    public boolean solve ();{

	if (solveHelper(row, col)){
	    return true;
	}
    }

    public boolean solveHelper(){
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
