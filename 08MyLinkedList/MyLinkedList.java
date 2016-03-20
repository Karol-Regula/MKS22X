public class MyLinkedList{
    LNode start;
    int size;
    
    public static void main(String[]args){
	MyLinkedList m1 = new MyLinkedList();
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
	System.out.println(m1.add(100,55));
	System.out.println(m1.toString());
    }

    public MyLinkedList(){
	start = null;
	size = 0;
    }

    public int size(){
	return size;
    }

    public int get(int n){
	LNode current = start;
	for (int i = 0; i < n; i++){
	    current = current.getNext();
	}
	return current.getValue();
    }

    public int set(int index, int n){
	LNode current = start;
	for (int i = 0; i < index; i++){
	    current = current.getNext();
	}
	int out = current.getValue();
	current.setValue(n);
	return out;
    }

    public boolean add(int input){//adds to end
	LNode current = start;
	if (current == null){
	    current = new LNode(input);
	    start = current;
	    return true;
	}
	while (current.getNext() != null){
	    current = current.getNext();
	}
	current.next = new LNode(input);
	size++;
	return true;
    }

    public boolean add(int index, int n){
	LNode current = start;
	LNode current2;
	LNode insert = new LNode(n);
	if (index >= size){
	    return false;
	}
	if (index == 0){
	    insert.setNext(current);
	    start = insert;
	}else{
	    for (int i = 0; i < index - 1; i++){
		current = current.getNext();
	    }
	    current2 = current.getNext();
	    current.setNext(insert);
	    insert.setNext(current2);
	}
	return true;
    }

    public int remove(int index){
	int out;
	LNode current = start;
	LNode current2;
	if (index >= size){
	    return -1;
	}
	if (index == 0){
	    out = current.getValue();
	    current = current.getNext();
	    start = current;
	}else{
	    for (int i = 0; i < index - 1; i++){
		current = current.getNext();
	    }
	    current2 = current.getNext().getNext();
	    out = current.getNext().getValue();
	    current.setNext(current2);
	}
	return out;
    }

    public int indexOf(int n){
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
	    out += ",";
	    current = current.getNext();
	}
	out = out.substring(0, out.length() - 1);
	out += "]";
	return out;
    }

    private class LNode{
	
	private int data;
	private LNode next;
	
	public LNode(int input){
	    data = input;
	    next = null;
	}
	
	public LNode getNext(){
	    return next;
	}
	
	public int getValue(){
	    return data;
	}
	
	public boolean setNext(LNode input){
	    next = input;
	    return true;
	}
	
	public boolean setValue(int input){
	    data = input;
	    return true;
	}
    }
}
