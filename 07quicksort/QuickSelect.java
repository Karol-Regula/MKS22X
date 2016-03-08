public class QuickSelect{
    
    public static void main(String[]args){
	int[] data = new int[]{-89,4,7,8,2,99,1,0,45,6};
	select(data, 3);
    }
    
    public static void select(int[] data, int k){
	int number = 0;
	int endL = 0;
	int endR = data.length;
	int random;
	int hold = 0;
	int position;
	while (position != k){
	    random = Math.random() * data.length;
	    number = data[random];
	    hold = data[data.length];
	    data[data.length] = number;
	    data[random] = hold;
	    position = k;//remove this after done with debigging
	}
    }

    public static void printArray(int[] data){
	for (int i = 0; i < data.length; i++){
	    System.out.println(data[i]);
	}
    }
    
}
