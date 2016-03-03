public class Merge{

    public static void main(String[]args){
	int[] ary1 = new int[]{1,3,7,16,67,765,765};
	int[] ary2 = new int[]{2,3,3,8,78,764,766};
	merge(ary1, ary2);
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
