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
	for (int i = 0; i < s.length(); i++){
	    if (isOpening(s.charAt(i))){
		m.push(s.charAt(i));
	    }else{
		//System.out.println(m.size());
		if (isClosing(s.charAt(i)) && m.size() == 0){
		    return false;
		}
		//System.out.println(s.charAt(i) + " " + m.peek());
		if (isClosing(s.charAt(i)) && convert(s.charAt(i)) != m.pop()){
		    return false;
		}
	    }
	}
	//System.out.println(m.size());
	return m.size() == 0;
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
	    return '[';
	}
	System.out.println("This should never print.");
	return'-';
    }
    
    public static boolean isOpening(char c){
	return c == '(' || c == '{' || c == '<' || c == '[';
    }

    public static boolean isClosing(char c){
	return c == ')' || c == '}' || c == '>' || c == ']';
    }
    
}
