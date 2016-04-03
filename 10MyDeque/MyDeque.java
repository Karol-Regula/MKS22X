public class MyDeque<T>{
    public int start;
    public int end;
    public Object[] data;
    public int filled;
    public boolean debug = true;
    
    public static void main (String[]args){
	MyDeque<Integer> d1 =  new MyDeque<Integer>();
	for (int i = 0; i < 10; i++){
	    d1.addLast(i);
	    d1.toString();
	}
	d1.addFirst(100);
	d1.toString();
	d1.addFirst(101);
	d1.toString();
	for (int i = 0; i < 6; i++){
	    d1.addLast(i);
	    d1.toString();
	}
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

    public MyDeque(){
	data = new Object[0];
	grow();
	start = 0;
	end = 0;
    }

    public void debug(String s){
	if (debug){
	    System.out.println(s);
	}
    }

    private void grow(){
	if (data.length == 0){
	    debug("growCase1");
	    Object[] dataNew = new Object[1];
	    data = dataNew;
	}else if (data.length == 1){
	    debug("growCase2");
	    Object[] dataNew = new Object[data.length * 2];
	    dataNew[0] = data[0];
	    data = dataNew;
	}else{
	    debug("growCase3");
	    Object[] dataNew = new Object[data.length * 2];
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
	

    public String toString(){
	for (int i = 0; i < data.length; i++){
	    System.out.print(data[i] + ", "); 
	}
	System.out.println();
	return "";
    }
}
