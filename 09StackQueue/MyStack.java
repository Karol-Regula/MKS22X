import java.util.NoSuchElementException;

public class MyStack<T> extends MyLinkedList{
    public MyLinkedList<T> m1;
    
    public static void main(String[]args){
	MyStack<Integer> s1 = new MyStack<Integer>();
	System.out.println(s1.size());
	System.out.println(s1.isEmpty());
	s1.push(4);
	s1.push(3);
	s1.push(55);
	System.out.println(s1.size());
	System.out.println(s1.isEmpty());
	System.out.println(s1.peek());
	System.out.println(s1.pop());
	System.out.println(s1.size());
	System.out.println(s1.pop());
	System.out.println(s1.pop());
	System.out.println(s1.isEmpty());
	
    }

    public MyStack(){
	m1 = new MyLinkedList<T>();
    }
    
    public void push(T item){
	m1.add(0, item);
    }
    
    public T pop(){
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
