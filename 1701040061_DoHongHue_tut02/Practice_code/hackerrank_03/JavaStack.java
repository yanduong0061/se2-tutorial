package hackerrank_03;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaStack {
	public boolean checkBalance(String s) {
		boolean balanced = false;
		List<String> closingList = Arrays.asList("}", ")", "]");
		Stack stack = new Stack(s.length());
		for(int i = 0; i < s.length(); i++) {
			String str = s.substring(i, i+1);
			if(stack.size() == 0 && closingList.contains(str)) {
				balanced = false;
				break;
			}
			else {
				if(str.equals("{") || str.equals("(") || str.equals("[")) {
					stack.push(str);
				} else {
					String stackString = stack.peek();
					if((stackString.equals("{") && str.equals("}") || (stackString.equals("(") && (( str.equals(")")) ||
					stackString.equals("[") && str.equals("]"))))) {
						stack.pop();
					}
			}
				
		}
			
			
	}
		if(stack.size() > 0) balanced = false;
		return balanced;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		JavaStack jStack = new JavaStack();
		
		
		while(true) {
			System.out.println("Enter your string: ");
			String s = in.nextLine();
			if(s.equals("")) 
				break;
			
			if(jStack.checkBalance(s) == true) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
		}
		in.close();
	}
}