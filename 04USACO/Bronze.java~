import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Bronze{
    public int rows;
    public int cols;
    public int depth;
    public int commandNumber;
    public int[][] lake;
    public int solution;

    //!! print result, 7, Last, First
    //possibly no spaces
    
    public static void main(String[]args){
	Bronze br1 = new Bronze();//constructor runs the stomping
	br1.volume();
	//br1.printLake();
	System.out.println(br1.solution + ",7,Regula,Karol");
    }
    
    public Bronze(){
	File file = new File("makelake.in");
	
	try{
	    Scanner s1 = new Scanner(file);
	    rows = s1.nextInt();
	    cols = s1.nextInt();
	    depth = s1.nextInt();
	    commandNumber = s1.nextInt();
	    lake = new int[rows][cols];
	    for (int i = 0; i < rows; i ++){
		for (int j = 0; j < cols; j++){
		    lake[i][j] = s1.nextInt();
		}
	    }
	    for (int x = 0; x < commandNumber; x++){
		stomp(s1.nextInt(), s1.nextInt(), s1.nextInt());
	    }
	}catch (FileNotFoundException e){
	    System.out.println("File not found.");
	}
    }

    public void executeCommand(){
	
    }

    public void printLake(){
	for (int i = 0; i < rows; i++){
	    for (int j = 0; j < cols; j++){
		System.out.print(" " + lake[i][j]);
	    }
	    System.out.println();
	}
    }  

    public void stomp(int row, int col, int level){
	//System.out.println("Stomping");
	int max = lake[row - 1][col - 1];
	for (int i = row; i < row + 3; i++){
	    for (int j = col; j < col + 3; j++){
		if (lake[i - 1][j - 1] > max){
		    //System.out.println("here");
		    // -1 because they appenrently number their columns and rows starting from 1...
		    max = lake[i - 1][j - 1];
		}
	    }
	}
	//System.out.println(" " + max);
	for (int i = row; i < row + 3; i++){
	    for (int j = col; j < col + 3; j++){
		if (lake[i - 1][j - 1] > max - level){
		    lake[i - 1][j - 1] = max - level;
		}
	    }
	}  
    }

    public void volume(){
	for (int i = 0; i < rows; i++){
	    for (int j = 0; j < cols; j++){
		if (! (lake[i][j] > depth)){
		    solution += depth - lake[i][j];
		}
	    }
	}
	solution = solution * 72 * 72;
    }
}
