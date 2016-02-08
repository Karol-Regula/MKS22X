public class Recursion implements hw01{

    public static void main(String[]args){
	/*
	Recursion r1 = new Recursion();
	System.out.println(r1.name());
	System.out.println(r1.sqrt(625));
	System.out.println(r1.sqrt(4));
	System.out.println(r1.sqrt(1000000));
	System.out.println(r1.sqrt(0.0000001));
	System.out.println(Math.sqrt(0.0000001));
	System.out.println(r1.sqrt(81));
	//System.out.println(r1.sqrt(-5));
	*/
    }
    
    public String name(){
    	return "Regula,Karol";
    }
    
    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException("n must be >= 0");
	}
	double guess = 1;
	
	return sqrtHelper(n, guess);
    }

    public double sqrtHelper(double n, double guess){
	if (n / guess >=  guess - 0.000000001 && n / guess <= guess + 0.000000001){
	    return guess;
	}
	return sqrtHelper(n, (n / guess + guess) / 2);
    }

}
