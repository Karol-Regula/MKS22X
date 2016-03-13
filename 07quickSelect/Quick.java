public class Quick{
    
    public static void main(String[]args){
	int[] data = new int[]{8,4,98,-5,5,9,7,1,3,6,0,5,4,6,8,11,456,23,1,4,6,7};
	int[] data2 = new int[]{8,4,2,5,9,7,1,3,6,0};
	int[] data3 = new int[]{8,4,98,-5,5,9,7,1,3,6,0,5,4,6,8,11,456,23,1,4,6,7};
	//printArray(data2);
	quickSort(data3);
	printArray(data3);
	//System.out.println(quickselect(data, 10));

	int[] data4 = new int[]{1,2,3,4,3,2,1,2,3,2,1,4,2,3,1,2,4,3,1,2};
	partition(data4, 0, data4.length - 1);
	
    }




    public static void quickSort(int[] data){
	quickSort(data, 0, data.length - 1);
    }

    public static void quickSort(int[] data, int left, int right){
	int[] positions = partition(data, left, right);
	//System.out.println(position);
	if (left >= right){
	    return;
	}
	quickSort(data, positions[1], right);
	quickSort(data, left, positions[0]);
    }
    
    public static int quickselectWeird(int[] data, int k){
	return quickselect(data, k, 0, data.length - 1);
    }

    public static int quickselectWeird(int[] data, int k, int left, int right){
	int[] position = partition(data, left, right);
	if (k == position[0]){
	    return data[k];
	}
	if (k > position[0]){
	    return quickselect(data, k, position[1], right);
	}else{
	    return quickselect(data, k, left, position[0]);
	}
    }
    
    public static int[] partition(int[] data, int left, int right){
	int number = 0;
	int random;
	int initialRight = right;
	int initialLeft = left;
	random = (int)(Math.random() * (right + 1 - left));
	number = data[left + random];
	swap(data, initialRight, left + random);	
	right--;
	//System.out.println(number + " " + random);
	//number at random position moved to end of array
	while (left < right){
	    //printArray(data);
	    if (data[left] >= number){
		swap(data, left, right);
		right--;
	    }
	    if (data[left] < number){
		left++;
	    }
	}
	int swap = left;
	if (data[left] >= number){
	    swap(data, initialRight, left);
	}
	if (data[left] < number){
	    swap(data, initialRight, left + 1);
	    //left++;
	    swap++;
	}
	for (int i = initialLeft; i < initialRight; i++){
	    if (data[i] == number){
		swap(data, i, swap);
		swap++;
	    }
	}
	//printArray(data);
	//System.out.println(left);
	int[] out = new int[]{left,swap};
	return out;
    }

    public static void swap(int[] data, int a, int b){
	int hold = 0;
	hold = data[a];
	data[a] = data[b];
	data[b] = hold;	
    }






    public static void quickSortOld(int[] data){
	quickSortOld(data, 0, data.length - 1);
    }

    public static void quickSortOld(int[] data, int left, int right){
	int position = partitionOld(data, left, right);
	//System.out.println(position);
	if (left >= right){
	    return;
	}
	quickSortOld(data, position + 1, right);
	quickSortOld(data, left, position);
    }

    public static int quickselect(int[] data, int k){
	return quickselect(data, k, 0, data.length - 1);
    }

    public static int quickselect(int[] data, int k, int left, int right){
	int position = partitionOld(data, left, right);
	if (k == position){
	    return data[k];
	}
	if (k > position){
	    return quickselect(data, k, position, right);
	}else{
	    return quickselect(data, k, left, position);
	}
    }
    
    public static int partitionOld(int[] data, int left, int right){
	int number = 0;
	int random;
	int hold = 0;
	int initialRight = right;
	random = (int)(Math.random() * (right + 1 - left));
	number = data[left + random];
	hold = data[initialRight];
	data[initialRight] = number;
	data[left + random] = hold;
	right--;
	//System.out.println(number + " " + random + " " + hold);
	//number at random position moved to end of array
	while (left < right){
	    //printArray(data);
	    if (data[left] >= number){
		hold = data[left];
		data[left] = data[right];
		data[right] = hold;
		right--;
	    }
	    if (data[left] < number){
		left++;
	    }
	}
	if (data[left] >= number){
	    data[initialRight] = data[left];
	    data[left] = number;
	}
	if (data[left] < number){
	    //System.out.println("--" + left + " " + initialRight);
	    data[initialRight] = data[left + 1];
	    data[left + 1] = number;
	    //left++;
	    if (left == data.length - 2){
		//left++;//deals with cases where largest number in array is needed
	    }
	}
	//printArray(data);
	//System.out.println(left);
	return left;
    }

    public static void printArray(int[] data){
	for (int i = 0; i < data.length; i++){
	    System.out.print(data[i] + ", ");
	}
	System.out.println();
    }

    public static String name(){
	return "7,Regula,Karol";
    }
    
}
