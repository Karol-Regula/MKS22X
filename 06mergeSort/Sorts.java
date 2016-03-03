import java.util.Arrays;
public class Sorts{

    public static void main(String[]args){
	int[] ary1 = new int[]{1,3,7,16,67,765,765};
	int[] ary2 = new int[]{2,3,3,8,78,764,766};
	merge(ary1, ary2);
	/*
	  int[] data1 = new int[10];
	  fillRandom(data1);
	 int[] data2 = data1.clone();
	 int[] data3 = data1.clone();
	 int[] data4 = data1.clone();
	 Arrays.sort(data1);
	 swap(data1);
	 System.out.println(printArray(data1));
	 insertionSort(data2);//about 16.2 seconds on average
	 */
	 //selectionSort(data3);//about 18.5 seconds on average
	 //bubbleSort(data4);
	 /*
	 //testing if sorting works
	 Arrays.sort(data1);
	 insertionSort(data2);
	 selectionSort(data3);
	 System.out.println(data1.equals(data2));
	 System.out.println(data1.equals(data3));
	 //well, when I look at the arrays they are exactly the same but equals() disagrees. I disagree with equals().
	 System.out.println(printArray(data1));
	 System.out.println(printArray(data2));
	 System.out.println(printArray(data3));
	 */	 
     }

    public static void insertionSort(int[] data){
	int end = 0; //last number in array that is sorted
        while(end < data.length - 1){
	    int next = data[end + 1];
	    //System.out.println("next:"+next);
	    //System.out.println(printArray(data));
	    for (int x = end; x >= 0; x--){
		if (next < data[x]){
		    data[x + 1] = data[x];
		}
		if (next >= data[x]){
		    data[x + 1] = next;
		    break;
		}
		if (x == 0){
		    data[x] = next;
		}
	    }
	    end++;
	}
    }

     public static void selectionSort(int[] data){
	 int end = 0;
	 int min = 0;
	 int minPosition = 0;
	 int tempValue = 0;
	 while(end < data.length - 1){
	     min = Integer.MAX_VALUE;
	     minPosition = 0;
	     tempValue = 0;
	     for (int x = end; x < data.length; x++){
		 if (data[x] < min){
		     min = data[x];
		     minPosition = x;
		 }
	     }
	     tempValue = data[end];
	     data[end] = data[minPosition];
	     data[minPosition] = tempValue;
	     end++;
	     //System.out.println(printArray(data));
	 }
     }

    public static void bubbleSort(int[]data){
	int end = data.length;
	int temp = 0;
	while (end > 1){
	    for (int x = 0; x < end - 1; x++){
		temp = 0;
		if (data[x] > data[x+1]){
		    temp = data[x+1];
		    data[x+1] = data[x];
		    data[x] = temp;
		}
	    }
	    //System.out.println(printArray(data));
	    end--;
	}	
    }

    public static void swap(int[] data){
	int temp = 0;
	for (int x = 0; x < data.length / 2; x++){
	    temp = data[x];
	    data[x] = data[data.length - 1 - x];
	    data[data.length - 1 - x] = temp;
	}
    }

    public static String printArray(int[] ary){
	String out = "{";
	for(int x = 0; x < ary.length; x++){
	    out += ary[x]+", ";
	}
	return out.substring(0,out.length() - 1)+"}";
    }

    public static void fillRandom(int[] ary){
	for(int x = 0; x < ary.length; x++){
	    ary[x] = 0 + (int)(Math.random() * 10000);
	}
    }

      public static int[] merge(int[] ary1, int[] ary2){
	int a = 0;
	int b = 0;
	int[] out = new int[ary1.length + ary2.length];
	while (a < ary1.length - 1 && b < ary2.length - 1){
	    if (ary1[a] <= ary2[b]){
		out[a + b] = ary1[a];
		a++;
	    }
	    if (ary2[b] < ary1[a]){
		out[a + b] = ary2[b];
		b++;
	    }
	} 
	//if it gets to here that means that one of the arrays ended
	while (a < ary1.length){
	    out[a + b] = ary1[a];
	    a++;
	}
	while (b < ary1.length){
	    out[a + b] = ary2[b];
	    b++;
	}
	for (int i = 0; i < out.length; i++){
	    System.out.println(out[i]);
	}
	return out;
    }
}
