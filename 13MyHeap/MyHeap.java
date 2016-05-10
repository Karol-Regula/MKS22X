import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;
    private boolean max;

    public static void main(String[]args){
	MyHeap<Integer> h1 = new MyHeap<Integer>(true);
	//System.out.println(2 / 2);
	//System.out.println(h1.peek());
	h1.add(1);
	h1.add(2);
	h1.add(3);
	h1.add(1);
	h1.add(4);
	h1.add(5);
	h1.add(2);
	h1.add(1);
	h1.add(11);
	System.out.println(h1.delete());
	System.out.println(h1.peek());
	System.out.println(h1.toString());

	Integer[] temp =  new Integer[]{1,4,6,2,7,4,9,2,5,10};
	MyHeap<Integer> h2 = new MyHeap<Integer>(temp);
	h2.add(14);
	h2.add(-10);
	System.out.println(h2.toString());
	
	
    }
    
    public MyHeap(){
	data = (T[]) new Comparable[2];
	size = 0;
	max = true;
	//heapify();
    }
    
    public MyHeap(T[] array){
	data = (T[]) new Comparable[array.length + 1];
	//System.out.println(data.length);
	for (int i = 0; i < array.length; i++){
	    data[i + 1] = array[i];
	}
	//System.out.println(toString());
	size = array.length;
	//System.out.println("hereerre");
	max = true;
	heapify();
    }
    
    /**pushDown
       precondition: data is a heap with at most one item
       out of place (element at k)
       postconditions:-the element at index k has been 
       shifted to the correct spot.
       -data is a valid heap
    **/


    private void pushDown(int k){
	while (k < size / 2 && compare(data[k], data[k * 2]) || k < size / 2 && compare(data[k], data[k * 2 + 1])){
	    //&& compare(data[k], data[k * 2]) || k < size / 2 && compare(data[k], data[k * 2 + 1])){
	    T a = data[k * 2];
	    T b = data[k * 2 + 1];
	    if (compare(b, a)){
		//a is greater
		T temp = data[k];
		data[k] = a;
		data[k * 2] = temp;
		k = k * 2;
	    }else{
		//b is greater
		T temp = data[k];
		data[k] = b;
		data[k * 2 + 1] = temp;
		k = k * 2 + 1;
	    }
	}
    }

    //need to restructure entire pushDown to make it make sense
    
    /**pushUp
       precondition: data is a heap with at most one item
       out of place (element at k)
       postconditions:-the element at index k has been 
       shifted to the correct spot.
       -data is a valid heap
    **/

    //return true if swap
    //this could be shorter but I wanted to write it down for clarity
    private boolean compare(T a, T b){
	int result = a.compareTo(b);
	boolean out;
	if (result >= 0 && max){
	    return false;
	}
	if (result >= 0 && !max){
	    return true;
	}
	if (result < 0 && max){
	    return true;
	}
	if (result < 0 && !max){
	    return false;
	}
	return false;
	// do I need to convert this to a boolean????
    }

    public T peek(){
	if (size == 0){
	    throw new NoSuchElementException();
	}else{	    
	    return data[1];
	}
    }
    
    private void pushUp(int k){
	while (size >= 1 && k >= 2 && !compare(data[k], data[k / 2])){
	    T a = data[k / 2];
	    T temp = data[k];
	    data[k] = a;
	    data[k / 2] = temp;
	    k = k / 2;
	}
    }
    
    private void heapify(){
	for (int i = size / 2; i > 0; i--){/////////////////////////////////// / 2
	    pushDown(i);
	}
    }
    
    public T delete(){
	if (size == 0){
	    throw new NoSuchElementException();
	}else{
	    T out = data[1];
	    data[1] = null;
	    for (int i = 0; i < data.length - 1; i++){
		data[i] = data[i + 1];
	    }
	    size--;
	    heapify();
	    return out;
	}
    }
    
    public void add(T x){
	if (size >= data.length - 2){
	    doubleSize();
	}
	//System.out.println(size);
	data[size + 1] = x;
	int pos = size + 1;
	//System.out.println(data[pos] + " " + pos + " " + pos/2 + " " + data[pos/2]);
	//System.out.println(toString() + "-----");
	pushUp(pos);
	size++;
    }
    
    private void doubleSize(){
	//System.out.println("doubleSize");
	T[] temp = (T[]) new Comparable[data.length * 2];
	for (int i = 0; i < data.length; i++){
	    temp[i] = data[i];
	}
	data = temp;
    }
    
    public String toString(){
	String out = "[";
	for (int i = 0; i < data.length - 1; i++){
	    out += data[i] + ",";
	}
	out += data[data.length - 1];
	out += "]";
	return out;
    }
	
    //do this last
    public MyHeap(boolean isMax){
	max = isMax;
	data = (T[]) new Comparable[2];
	size = 0;
    }
    public MyHeap(T[] array, boolean isMax){
	data = (T[]) new Comparable[array.length + 1];
	//System.out.println(data.length);
	for (int i = 0; i < array.length; i++){
	    data[i + 1] = array[i];
	}
	//System.out.println(toString());
	size = array.length;
	//System.out.println("hereerre");
	max = isMax;
	heapify();
    }
	
}
