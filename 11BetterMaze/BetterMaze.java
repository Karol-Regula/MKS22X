import java.util.*;
import java.io.*;

public class BetterMaze{

    public static void main(String[]args){
	BetterMaze m1 = new BetterMaze("data1.dat");
	m1.setAnimate(true);
	System.out.println(m1.solveBFS());
	for (int i = 0; i < m1.solution.length; i++){
	    System.out.print(m1.solution[i] + ", ");
	}
	System.out.println();
	//m1.toString();
    }
    
    private class Node{
	private int[] value;
	private Node prev;
	
	public Node (int col, int row, Node prev){
	    value = new int[2];
	    value[0] = col;
	    value[1] = row;
	    this.prev = prev;
	}
	
	public Node getPrev(){
	    return prev;
	}

	public int[] getValue(){
	    return value;
	}
    }
    
    private interface Frontier<T>{
	public void add(T element);
	public T next();
	public boolean hasNext();
    }
    
    public class FrontierQueue<Node> implements Frontier<Node>{
	public ArrayDeque<Node> values = new ArrayDeque<Node>();
	
	public void add(Node element){
	    values.addFirst(element);
	}
	
	public Node next(){
	    return values.removeLast();
	}
	
	public boolean hasNext(){
	    return values.size() != 0;
	} 
    }

    public class FrontierStack<Node> implements Frontier<Node>{
	public ArrayDeque<Node> values = new ArrayDeque<Node>();
	
	public void add(Node element){
	    values.addFirst(element);
	}
	
	public Node next(){
	    return values.removeFirst();
	}
	
	public boolean hasNext(){
	    return values.size() != 0;
	} 
    }
    
    
    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false

   /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     **/
    public int[] solutionCoordinates(){
	return solution;
    }    

    public boolean solveBFS(){  
	placesToGo = new FrontierQueue<Node>();
	return solve();
    }   

    public boolean solveDFS(){
	placesToGo = new FrontierStack<Node>();
	return solve();
    }    

    private boolean solve(){//=======================================================================
	Node current = new Node(startCol, startRow, null);
	placesToGo.add(current);
	int[] coords;
	int col;
	int row;
	while (placesToGo.hasNext()){
	    System.out.println(toString());
	    current = placesToGo.next();
	    coords = current.value;
	    col = coords[0];
	    row = coords[1];
	    //System.out.println(col + " " + row);
	    if (maze[col][row] == 'E'){//yay found exit
		int count = 0;
		int[] temp = new int[1];
		while (current.prev != null){
		    coords = current.value;
		    col = coords[0];
		    row = coords[1];
		    //
		    if (count >= temp.length - 2){
			//grow
			int[] nTemp = new int[temp.length * 2];
			for (int i = 0; i < temp.length; i++){
			    nTemp[i] = temp[i];
			}
			temp = nTemp;
		    }
		    temp[count] = row;
		    temp[count + 1] = col;
		    count += 2;
		    //need to grow
		    //
		    if (maze[col][row] != 'E'){
			maze[col][row] = '@';
		    }
		    current = current.prev;
		}
		count--;
		solution = new int[count];
		for (int i = 0; i < solution.length; i++){
		    solution[i] = temp[count];
		    count--;
		}
		//System.out.println("Solved");
		//System.out.println(toString());
		for (int i = 0; i < temp.length; i++){
		    //System.out.print(temp[i] + ", ");
		}
		//System.out.println();
		for (int i = 0; i < solution.length; i++){
		    //System.out.print(solution[i] + ", ");
		}
		return true;
	    }
	    //will now check all directions and add Nodes as necessary
	    if (isViable(col + 1, row)){
		Node n1 = new Node(col + 1, row, current);
		placesToGo.add(n1);
	    }
	    if (isViable(col, row + 1)){
		Node n1 = new Node(col, row + 1, current);
		placesToGo.add(n1);
	    }
	    if (isViable(col - 1, row)){
		Node n1 = new Node(col - 1, row, current);
		placesToGo.add(n1);
	    }
	    if (isViable(col, row - 1)){
		Node n1 = new Node(col, row - 1, current);
		placesToGo.add(n1);
	    }
	    if (maze[col][row] == ' '){
		maze[col][row] = '.'; 
	    }
	}	
	return false;
    }
    
    private boolean isViable(int col, int row){
	//System.out.println (col + " " + row);
	return row < maze.length && col < maze[0].length && maze[col][row] == ' ' || maze[col][row] == 'E';
    }
    
   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){
	animate = b;
    }    


    public BetterMaze(String filename){
	animate = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	//System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S'){
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }






    
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	wait(100);
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    }
}
