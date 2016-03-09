public class Quick{
    
    public static void main(String[]args){
	int[] data = new int[]{8,4,2,5,9,7,1,3,6,0};
	System.out.println(partition(data, 0, data.length - 1));
    }
    
    public static int partition(int[] data, int left, int right){
	int number = 0;
	int random;
	int hold = 0;
	random = (int)(Math.random() * data.length);
	number = data[random];
	hold = data[data.length - 1];
	data[data.length - 1] = number;
	data[random] = hold;
	right--;
	System.out.println(number + " " + random + " " + hold);
	//number at random position moved to end of array
	while (left < right){
	    printArray(data);
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
	    data[data.length - 1] = data[left];
	    data[left] = number;
	}
	if (data[left] < number){
	    data[data.length - 1] = data[left + 1];
	    data[left + 1] = number;
	}
	printArray(data);
	return left;
    }

    public static void printArray(int[] data){
	for (int i = 0; i < data.length; i++){
	    System.out.print(data[i] + ", ");
	}
	System.out.println();
    }
    
}
