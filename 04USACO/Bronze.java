import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Bronze{
    public int rows;
    public int cols;
    public int depth;
    public int commandNumber;
    public int[][] lake;
    
    public static void main(String[]args){
	Bronze br1 = new Bronze();
	br1.printLake();
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
}
