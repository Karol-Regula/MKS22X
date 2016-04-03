import java.util.NoSuchElementException;

public class MyDeque<T>{
    public int start;
    public int end;
    public T[] data;
    public int filled;
    public boolean debug = true;
    
    public static void main (String[]args){
	MyDeque<Integer> d1 =  new MyDeque<Integer>();
	for (int i = 0; i < 4; i++){
	    d1.addLast(i);
	    d1.toString();
	}
	d1.addFirst(100);
	d1.toString();
	d1.addFirst(101);
	d1.toString();
	for (int i = 0; i < 2; i++){
	    d1.addLast(i);
	    d1.toString();
	}
	d1.removeFirst();
	d1.removeFirst();
	d1.removeFirst();
	d1.toString();
	/*
	for (int i = 0; i < 10; i++){
	    d1.addLast(i);
	    d1.toString();
	}
	*/
	/*
	d1.toString();
	d1.addLast(0);
	d1.toString();
	d1.addLast(1);
	d1.toString();
	d1.addLast(2);
	d1.toString();
	d1.addLast(3);
	d1.toString();
	System.out.println("--------");
	d1.addLast(4);
	d1.toString();
	d1.addLast(5);
	d1.toString();
	d1.addLast(6);
	d1.toString();
	d1.addLast(7);
	d1.toString();
	d1.addLast(8);
	d1.toString();
	d1.addLast(9);
	d1.toString();
	*/
    }
    @SuppressWarnings("unchecked")	
    public MyDeque(){
	data = (T[]) new Object[0];
	//data = new Object[0];
	grow();
	start = 0;
	end = 0;
    }

    public void debug(String s){
	if (debug){
	    System.out.println(s);
	}
    }
    
    @SuppressWarnings("unchecked")
    private void grow(){
	if (data.length == 0){
	    debug("growCase1");
	    T[] dataNew = (T[]) new Object[1];
	    data = dataNew;
	}else if (data.length == 1){
	    debug("growCase2");
	    T[] dataNew = (T[]) new Object[data.length * 2];
	    dataNew[0] = data[0];
	    data = dataNew;
	}else{
	    debug("growCase3");
	    T[] dataNew = (T[]) new Object[data.length * 2];
	    int i = start;
	    int count = 0;
	    while (i != end){
		if (i == data.length - 1 && start != 0){
		    debug("wraparound");
		    dataNew[count] = data[i];
		    i = 0;
		    count++;
		}else{
		    dataNew[count] = data[i];
		    i++;
		    count++;
		}
	    }
	    dataNew[count] = data[i]; //this copies over the last value
	    data = dataNew;
	    end = count;
	    start = 0;
	}
    }

    public void addFirst(T value){
	if (filled == 0){//if no values have yet been added
	    debug("addFirstCase1");
	    data[0] = value;
	    start = 0;
	    end = 0;
	}else if (filled == data.length){//if array is full
	    debug("addFirstCase2");
	    grow();
	    data[data.length - 1] = value;
	    start = data.length - 1;
	}else if (filled < data.length && start == 0){//if the first place in the array is full but there is space in the end
	    debug("addFirstCase3");
	    start = data.length - 1;
	    data[start] = value;
	}else{//normal case
	    debug("addFirstCase4");
	    data[start - 1] = value;
	    start--;
	}
	filled++;
    }
    
    public void addLast(T value){
	if (filled == 0){//if no values have yet been added
	    debug("addLastCase1");
	    data[0] = value;
	    start = 0;
	    end = 0;
	}else if (filled == data.length){//if array is full
	    debug("addLastCase2");
	    grow();
	    data[end + 1] = value;
	    end++;
	}else if (filled < data.length && end == data.length){//if the last place in the array is full but there is space in the begnning
	    debug("addLastCase3");
	    end = 0;
	    data[end] = value;
	}else{//normal case
	    debug("addLastCase4");
	    data[end + 1] = value;
	    end++;
	}
	filled++;
    }
    
    public T removeFirst(){
	if (filled == 0){//if no values have yet been added
	    throw new NoSuchElementException();
	}
	T out;
	if (filled == 1){// if only one element left
	    debug("removeFirstCase1");
	    out = data[start];//these typecasts may be a bad idea
	    data[start] = null;
	    start = 0;
	    end = 0;
	    filled--;
	    return out;
	}else if (start == data.length - 1 && filled > 1){// if the first element is at the end of the array and there are more than 1 elements in the array
	    debug("removeFirstCase2");
	    out = data[start];
	    data[start] = null;
	    start = 0;
	    filled--;
	    return out;
	}else{//standard case
	    debug("removeFirstCase3");
	    out = data[start];
	    data[start] = null;
	    start++;
	    filled--;
	    return out;
	}
    }
    

    public String toString(){
	for (int i = 0; i < data.length; i++){
	    System.out.print(data[i] + ", "); 
	}
	System.out.println();
	return "";
    }
}
