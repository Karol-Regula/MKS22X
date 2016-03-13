import java.util.Arrays;

public class Driver{
    
    public static void main(String[]args){
	int[] ary1 = new int[4000000];
	int[] ary1c = new int[4000000];
	for (int i = 0; i < ary1.length; i++){
	    int sign = (int)(Math.random() * 2);
	    if (sign == 0){
		ary1[i] = (int)(Math.random() * Integer.MAX_VALUE);
	    }else{
		ary1[i] = (int)(Math.random() * Integer.MIN_VALUE);
	    }
	    
	}
	copyArray(ary1, ary1c);
	//Quick.quickSort(ary1);
	//Arrays.sort(ary1c);
	//System.out.println(Arrays.equals(ary1, ary1c));
	System.out.println(Arrays.equals(ary1, ary1c));
	


	int[] ary2 = new int[40000];
	int[] ary2c = new int[40000];
	for (int i = 0; i < ary2.length; i++){
	    ary2[i] = (int)(Math.random() * 4);
	}
	copyArray(ary2, ary2c);
	Quick.quickSort(ary2);
	Arrays.sort(ary2c);
	System.out.println(Arrays.equals(ary2, ary2c));
	System.out.println(Arrays.equals(ary2, ary2c));

	//Quick.quickSortOld(ary1);
	
    }

    public static void printArray(int[] data){
	for (int i = 0; i < data.length; i++){
	    System.out.println(data[i] + ", ");
	}
    }
    
    public static void copyArray(int[] data1,int[] data2){
	for (int i = 0; i < data1.length; i++){
	    data2[i] = data1[i];
	}
    }

}
