import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Silver{
    public int rows;
    public int cols;
    public int steps;
    public int[][] pasture;
    public int startX;
    public int startY;
    public int endX;
    public int endY;
    public int solution;
    
    
    public static void main(String[]args){
	Silver s1 = new Silver();
	//s1.printPasture();
	//System.out.println(s1.startX + " " + s1.startY + " " + s1.endX + " " + s1.endY + " " + s1.steps);
	System.out.println(s1.solution + ",7,Regula,Karol");
    }

    public Silver(){
	File file = new File("ctravel.in");
	
	try{
	    Scanner s1 = new Scanner(file);
	    rows = s1.nextInt();
	    cols = s1.nextInt();
	    steps = s1.nextInt();
	    String current = "";
	    pasture = new int[rows][cols];
	    for (int i = 0; i < rows; i ++){
		current = s1.next();
		for (int j = 0; j < cols; j++){
		    if (current.charAt(j) == '.'){
			pasture[i][j] = 0;
		    }else{
			pasture[i][j] = -1;
		    }
		}
	    }
	    startX = s1.nextInt() - 1;
	    startY = s1.nextInt() - 1;
	    endX = s1.nextInt() - 1;
	    endY = s1.nextInt() - 1;
	    solve();
	}catch (FileNotFoundException e){
	    System.out.println("File not found.");
	}
    }


    public void printPasture(){
	for (int i = 0; i < rows; i++){
	    for (int j = 0; j < cols; j++){
		System.out.print(" " + pasture[i][j]);
	    }
	    System.out.println();
	}
    }

    public void solve(){
	int[][] temp = new int[rows][cols];
	for (int a = 0; a < rows; a++){
	    for (int b = 0; b < cols; b++){
		temp[a][b] = pasture[a][b];
	    }
	}
	pasture[startX][startY] = 1;
	//loop goes through entire array and sets value in each place equal to sum of values in surrounding places, exclusing -1 (trees)
	int up = 0;
	int down = 0;
	int right = 0;
	int left = 0;
	//printPasture();
	for (int i = 0; i < steps; i++){
	    for (int j = 0; j < cols; j++){
		for (int k = 0; k < rows; k++){
		    if (pasture[j][k] != -1){
			up = 0;
			down = 0;
			right = 0;
			left = 0;
			if (j > 0 && pasture[j - 1][k] != -1){
			    up = pasture[j - 1][k];//up
			}
			if (j < rows - 1 && pasture[j + 1][k] != -1){
			    down = pasture[j + 1][k];//down
			}
			if (k < cols - 1 && pasture[j][k + 1] != -1){
			    right = pasture[j][k + 1];//right
			}
			if (k > 0 && pasture[j][k - 1] != -1){
			    left = pasture[j][k - 1];//left
			}
			temp[j][k] = up + down + left + right;
			//System.out.println(up+" "+down+" "+left+" "+right);
		    }
		}
	    }
	    for (int y = 0; y < cols; y++){
		for (int z = 0; z < rows; z++){
		    pasture[y][z] = temp[y][z];
		}
	    }
	    //printPasture();
	    //System.out.println("------------------------");
	}
	solution = pasture[endX][endY];
    }
}
