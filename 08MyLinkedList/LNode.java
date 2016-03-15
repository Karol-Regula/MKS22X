public class LNode{

    public int data;
    public LNode next;

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
