public class BSTree<T extends Comparable<T>>{

    public static void main(String[]args){
	BSTree<Integer> t1 = new BSTree<Integer>();
	t1.add(7);
	t1.add(1);
	t1.add(19);
	t1.add(22);
	t1.add(20);
	System.out.println(t1.toString());
    }
    
    private class Node{
	T data;
	Node left;
	Node right;
	// set/get: data/left/right
	//completely ignore duplicates
	
	public int height(){ 
	    if (left == null && right == null){
		return 1;
	    }else if (left == null){
		return 1 + right.height();
	    }else if (right == null){
		return 1 + left.height();
	    }else{
		if (right.height() >= left.height()){
		    return 1 + right.height();
		}else{
		    return 1 + left.height();
		}
	    }
	}
	public void add(T value){
	    if (value.compareTo(data) < 0 && left == null){
		left = new Node();
		left.data = value;
	    }else if (value.compareTo(data) > 0 && right == null){
		right = new Node();
		right.data = value;
	    }else if (value.compareTo(data) < 0 && left != null){
		left.add(value);
	    }else if (value.compareTo(data) > 0 && right != null){
		right.add(value);
	    }
	    //dont't do anything if the value is equal to data
	}
	
	public String toString(){
	    if (left == null && right == null){
		return data + " " + "_" + " " + "_"  + " ";
	    }else if (left == null){
		return data + " " + "_" + " " + right.toString() + " ";
	    }else if (right == null){
		return data + " "  + left.toString() + " " + "_" + " ";
	    }else{
		return data + " " + left.toString() + " " + right.toString() + " ";
	    }
	}
	public boolean contains(T value){
	    if (value.compareTo(data) == 0){
		return true;
	    }else if (value.compareTo(data) > 0 && left != null){
		return left.contains(value);
	    }else if (value.compareTo(data) < 0 && right != null){
		return right.contains(value);
	    }else{
		return false;
	    }
	}	
    }
    
    private Node root;

    public int getHeight(){
	if (root == null){
	    return 0;
	}
	return root.height();
    }
    
    public void add(T value){
	if (root == null){
	    root = new Node();
	    root.data = value;
	}else{
	    root.add(value);
	}
    }
    public String toString(){
	if (root == null){
	    return "";
	}
	return root.toString();
    }
    public boolean contains(T value){
	if (root == null){
	    return false;
	}
	return root.contains(value);
    }
}
