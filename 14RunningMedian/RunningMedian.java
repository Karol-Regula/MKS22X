import java.util.NoSuchElementException;

public class RunningMedian{
    public int size;
    public MyHeap<Integer> min;
    public MyHeap<Integer> max;

    public static void main(String[]args){
	RunningMedian r1 = new RunningMedian();
	r1.add(6);
	r1.add(12);
	r1.add(20);
	r1.add(21);
	r1.add(0);
	r1.add(1);
	System.out.println(r1.getMedian());
	//test all previous homeworks
    }
    
    public RunningMedian(){
	min = new MyHeap<Integer>(true);
	max = new MyHeap<Integer>(false);
	size = 0;
	//Create an empty running median set.
    }
    
    public double getMedian(){
	if (size == 0){
	    throw new NoSuchElementException();
	}else if (size == 1){
	    return min.peek();
	}else{	    
	    return (min.peek() + max.peek()) / 2.0;
	}
	//When empty: throws new NoSuchElementException()
	//Returns the median value
    }
	
    public void add(Integer x){
	if (size == 0){
	    min.add(x);
	    size++;
	}else if (x < getMedian()){
	    min.add(x);
	    size++;
	    if (min.size - max.size > 1){
		int temp = min.delete();
		max.add(temp);
	    }
	}else{
	    max.add(x);
	    size++;
	    if (max.size - min.size > 1){
		int temp = max.delete();
		min.add(temp);
	    }
	}
	//System.out.println(min.size + " " + max.size);
	//System.out.println(min.toString() + " " + max.toString());
	//add to the "SmallValue" heap if  x < median, 
	//add to the "BigValue" heap otherwise. 
	//balance the two heaps so that their size differ by no more than 1.
    }
}
