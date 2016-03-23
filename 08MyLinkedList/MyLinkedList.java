public class MyLinkedList<T>{
    LNode start;
    int size;
    LNode end;
    
    public static void main(String[]args){
	MyLinkedList<Integer> m1 = new MyLinkedList<Integer>();
	m1.add(2);
	m1.add(3);
	m1.add(56);
	m1.add(7);
	m1.add(-2);
	System.out.println(m1.toString());
	System.out.println(m1.indexOf(87));
	System.out.println(m1.indexOf(3));
	System.out.println(m1.get(0));
	System.out.println(m1.get(4));
	System.out.println(m1.set(4,1000));
	System.out.println(m1.toString());
	System.out.println(m1.remove(2));
	System.out.println(m1.remove(3));
	System.out.println(m1.toString());
	System.out.println(m1.add(0,33));
	System.out.println(m1.add(3,44));
	System.out.println(m1.add(5,66));
	System.out.println(m1.add(100,55));
	System.out.println(m1.toString());

	MyLinkedList<String> m2 = new MyLinkedList<String>();
	m2.add("a");
	m2.add("b");
	m2.add("c");
	m2.add("abcdef");
	m2.add("-2");
	System.out.println(m2.toString());
	System.out.println(m2.indexOf("b"));
	System.out.println(m2.indexOf("-2"));
	System.out.println(m2.get(0));
	System.out.println(m2.get(4));
	System.out.println(m2.set(4,"aaaaaaaaaaaaaa"));
	System.out.println(m2.toString());
	System.out.println(m2.remove(2));
	System.out.println(m2.remove(3));
	System.out.println(m2.toString());
	System.out.println(m2.add(0,"z"));
	System.out.println(m2.add(3,"y"));
	System.out.println(m2.add(5,"x"));
	System.out.println(m2.add(100,"w"));
	System.out.println(m2.toString());
    }

    public MyLinkedList(){
	start = null;
	size = 0;
	end = null;
    }

    public int size(){
	return size;
    }

    public T get(int n){
	LNode current = start;
	for (int i = 0; i < n; i++){
	    current = current.getNext();
	}
	return current.getValue();
    }

    public T set(int index, T n){
	if (index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = start;
	for (int i = 0; i < index; i++){
	    current = current.getNext();
	}
	T out = current.getValue();
	current.setValue(n);
	return out;
    }

    public boolean add(T input){//adds to end
	LNode current = start;
	if (current == null){
	    current = new LNode(input);
	    start = current;
	    end = current;
	    return true;
	}
	while (current.getNext() != null){
	    current = current.getNext();
	}
	current.next = new LNode(input);
	end = current.getNext();
	size++;
	return true;
    }

    public boolean add(int index, T n){
	if (index > size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = start;
	if (current == null){
	    current = new LNode(n);
	    start = current;
	    end = current;
	    size++;
	    return true;
	}
	LNode current2;
	LNode insert = new LNode(n);
	if (index == 0){
	    insert.setNext(current);
	    start = insert;
	}else if (index == size){
	    current = end;
	    current.setNext(insert);
	    end = insert;
	}else{
	    for (int i = 0; i < index - 1; i++){
		current = current.getNext();
	    }
	    current2 = current.getNext();
	    current.setNext(insert);
	    insert.setNext(current2);
	    end = current2;
	}
	size++;
	return true;
    }

    public T remove(int index){
	if (index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	T out;
	LNode current = start;
	LNode current2;
	if (index == 0){
	    out = current.getValue();
	    current = current.getNext();
	    start = current;
	}else if (index != size - 1){
	    for (int i = 0; i < index - 1; i++){
		current = current.getNext();
	    }
	    //fix this for removing last element goes too far
	    current2 = current.getNext().getNext();
	    out = current.getNext().getValue();
	    current.setNext(current2);
	}else{
	    for (int i = 0; i < index - 2; i++){
		current = current.getNext();
	    }
	    out = current.getNext().getValue();
	    end = current;////////////////////
	}
	return out;
    }

    public int indexOf(T n){
	LNode current = start;
	int count = 0;
	while (current != null){
	    if (current.getValue() == n){
		return count;
	    }
	    count++;
	    current = current.getNext();
	}
	return -1;
    }

    public String toString(){	
	LNode current = start;
	String out = "[";
	while (current != null){
	    out += current.getValue();
	    out += ", ";
	    current = current.getNext();
	}
	out = out.substring(0, out.length() - 2);
	out += "]";
	return out;
    }

    private class LNode{
	
	private T data;
	private LNode next;
	
	public LNode(T input){
	    data = input;
	    next = null;
	}
	
	public LNode getNext(){
	    return next;
	}
	
	public T getValue(){
	    return data;
	}
	
	public boolean setNext(LNode input){
	    next = input;
	    return true;
	}
	
	public boolean setValue(T input){
	    data = input;
	    return true;
	}
    }
}
//.equals for index of
//not ==
