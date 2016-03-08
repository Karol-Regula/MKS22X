import java.util.Arrays;
public class Sorts{

    public static void main(String[]args){
	int[] ary = new int[]{1,3,7,16,67,765,7652,3,3,8,78,764,766};
	//merge(ary, 0, 6, 7, 12);
	int[] ary1 = new int[]{0,0,0,34623,0,2,5,7,3,1,6,8,4,2,5,6,8,9,44,22,1,0,0,0,0,0,43,1234,12315,34623,2,2,0,1};
	
	mergeSort(ary1);
	System.out.println(name());
	//System.out.println("---------------------");
	for (int i = 0; i < ary1.length; i++){
	    System.out.println(ary1[i]);
	}
	/*
	  //test cases for old merge method
	int[] ary1 = new int[]{1,3,7,16,67,765,765};
	int[] ary2 = new int[]{2,3,3,8,78,764,766};
	merge(ary1, ary2);
	*/
	/*
	  //test cases for older sorts
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

    public static void mergeSort(int[] data){
	mergeSortHelper(data, 0, data.length - 1);
    }

    private static void mergeSortHelper(int[] data, int start, int end){
	if (end - start > 1){
	    //System.out.println(start + " " + end);
	    mergeSortHelper(data, start, (end + start) / 2);
	    mergeSortHelper(data, ((end + start) / 2) + 1, end);
	}
	merge(data, start,start +  (end - start)/2, start + (end - start)/2 + 1, end);

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

    public static void merge(int[] ary, int sA, int eA, int sB, int eB){
	//System.out.println(sA + " " + eA + " " + sB + " " + eB);
	int origSA = sA;
	int origSB = sB;
	int[] out = new int[ary.length];
	while (sA <= eA && sB <= eB){
	    if (ary[sA] <= ary[sB]){
		//System.out.println("here1");
		out[origSA + (sA - origSA) + (sB - origSB)] = ary[sA];
		sA++;
	    }
	    if (ary[sB] < ary[sA]){
		//System.out.println("here2");
		out[origSA + (sA - origSA) + (sB - origSB)] = ary[sB];
		sB++;
	    }
	} 
	//if it gets here that means that one of the segements ended
	while (sA <= eA){
	    out[origSA + (sA - origSA) + (sB - origSB)] = ary[sA];
	    sA++;
	}
	while (sB <= eB){
	    //System.out.println(sA + " " + sB);
	    out[origSA + (sA - origSA) + (sB - origSB)] = ary[sB];
	    sB++;
	}
	for (int i = origSA; i <= eB; i++){
	    //System.out.println(out[i]);
	    ary[i] = out[i];
	}
    }

    public static String name(){
	return "7,Regula,Karol";
    }
}
