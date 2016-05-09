import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;

    public static void main(String[]args){
	MyHeap<Integer> h1 = new MyHeap<Integer>();
	//System.out.println(2 / 2);
	h1.add(1);
	h1.add(2);
	h1.add(3);
	h1.add(1);
	h1.add(4);
	h1.add(5);
	h1.add(2);
	h1.add(1);
	h1.add(11);	
	System.out.println(h1.toString());

	Integer[] temp =  new Integer[]{1,4,6,2,7,4,9,2,5,0,10};
	MyHeap<Integer> h2 = new MyHeap<Integer>(temp);
	System.out.println(h2.toString());
	
	
    }
    
    public MyHeap(){
	data = (T[]) new Comparable[2];
	size = 0;
	heapify();
    }
    
    public MyHeap(T[] array){
	data = (T[]) new Comparable[array.length + 1];
	System.out.println(data.length);
	for (int i = 0; i < data.length - 1; i++){
	    data[i + 1] = array[i];
	}
	//System.out.println(toString());
	size = array.length;
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
	T a = data[k * 2];
	T b = data[k * 2 + 1];
	if (a.compareTo(b) >= 0){
	    //a is greater
	    T temp = data[k];
	    data[k] = a;
	    data[k * 2] = temp;
	}else{
	    //b is greater
	    T temp = data[k];
	    data[k] = b;
	    data[k * 2 + 1] = temp;
	}
    }
    
    /**pushUp
       precondition: data is a heap with at most one item
       out of place (element at k)
       postconditions:-the element at index k has been 
       shifted to the correct spot.
       -data is a valid heap
    **/
    private void pushUp(int k){
	T a = data[k / 2];
	T temp = data[k];
	data[k] = a;
	data[k / 2] = temp;
    }
    
    private void heapify(){
	//not really sure how to implement O(n) runtime
	T[] temp = (T[]) new Comparable[data.length];
	for (int i = 1; i < data.length; i++){
	    temp[i] = data[i];
	    data[i] = null;
	}
	size = 0;
	for (int i = 1; i < data.length; i++){
	    add(temp[i]);
	}
		
	
    }
    
    public T delete(){
	return data[0];
    }
    
    public void add(T x){
	if (size >= data.length - 1){
	    doubleSize();
	}
	//System.out.println(size);
	data[size] = x;
	int pos = size;
	//System.out.println(data[pos] + " " + pos + " " + pos/2 + " " + data[pos/2]);
	//System.out.println(toString() + "-----");
	while (size >= 1 && pos >= 2 && data[pos].compareTo(data[pos / 2]) == 1){
	    pushUp(pos);
	    pos = pos / 2;
	}
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
    }
    public MyHeap(T[] array, boolean isMax){
    }
	
}
