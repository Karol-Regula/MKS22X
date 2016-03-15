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
	m1.toString();
    }

    public MyLinkedList(){
	start = null;
	size = 0;
    }

    public int size(){
	return size;
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
	return true;
    }

    public boolean get(){//fix toString when this is done
    }

    public String toString(){	
	LNode current = start;
	while (current.getNext() != null){
	    System.out.println(current.data);
	    current = current.getNext();
	}
	System.out.println(current.data);
	return "";
    }

}
