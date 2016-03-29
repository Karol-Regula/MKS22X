public class ParenDemo extends MyStack{

    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println(isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
    }

    public static boolean isMatching(String s){
	MyStack<Character> m = new MyStack<Character>();
	for (int i = 0; i < s.length() - 1; i++){
	    if (isOpening(s.charAt(i))){
		m.push(s.charAt(i));
	    }else{
		if (m.size() == 0){
		    return false;
		}
		if (!isOpening(s.charAt(i)) && convert(s.charAt(i)) != m.pop()){
		    return false;
		}
	    }
	}
	return true;
    } 
    
    public static Character convert(char c){
	if (c == ')'){
	    return '(';
	}
	if (c == '}'){
	    return '{';
	}
	if (c == '>'){
	    return '<';
	}
	if (c == ']'){
	    return ']';
	}
	System.out.println("This should never print.");
	return'-';
    }
    
    public static boolean isOpening(char c){
	return c == '(' || c == '{' || c == '<' || c == '[';
    }
    
}
