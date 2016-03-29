import java.util.NoSuchElementException;

public class MyQueue<T> extends MyLinkedList{
    public MyLinkedList<T> m1;
    
    public static void main(String[]args){
	MyQueue<Integer> q1 = new MyQueue<Integer>();
	System.out.println(q1.size());
	System.out.println(q1.isEmpty());
	q1.enqueue(4);
	q1.enqueue(3);
	q1.enqueue(55);
	System.out.println(q1.size());
	System.out.println(q1.isEmpty());
	System.out.println(q1.peek());
	System.out.println(q1.dequeue());
	System.out.println(q1.size());
	System.out.println(q1.dequeue());
	System.out.println(q1.dequeue());
	System.out.println(q1.isEmpty());
	
    }

    public MyQueue(){
	m1 = new MyLinkedList<T>();
    }
    
    public void enqueue(T item){
	m1.add(m1.size(), item);
    }
    
    
    public T dequeue(){
	if (m1.size == 0){
	    throw new NoSuchElementException();
	}
	T out = m1.get(0);
	m1.remove(0);
	return out;
    }
    
    public T peek(){
	if (m1.size == 0){
	    throw new NoSuchElementException();
	}
	T out = m1.get(0);
	return out;
    }
    
    public int size(){
	return m1.size();
    }
    
    public boolean isEmpty(){
	return m1.size() == 0;
    }
}
