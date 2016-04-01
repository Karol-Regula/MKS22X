public class MyDeque{
    public int start;
    public int end;
    public Object[] data;
    
    public static void main (String[]args){
	MyDeque d1 =  new MyDeque();
	d1.toString();
    }

    public MyDeque(){
	data = new Object[0];
	grow();
    }

    private void grow(){
	if (data.length == 0){
	    Object[] dataNew = new Object[1];
	    data = dataNew;
	}else{
	    Object[] dataNew = new Object[data.length * 2];
	    data = dataNew;
	}
    }
    //need to make thing wrap around efficiently and clearly somehow
    public void addFirst(T value){
	
    }

    public String toString(){
	for (int i = 0; i < data.length; i++){
	    System.out.print(data[i] + ", "); 
	}
	return "";
    }
    
}
