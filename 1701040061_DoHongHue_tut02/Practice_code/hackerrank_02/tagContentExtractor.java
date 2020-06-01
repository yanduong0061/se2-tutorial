package hackerrank;

import java.util.*;

import java.util.regex.*;

public class tagContentExtractor {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int testCases = Integer.parseInt(in.nextLine());
	while(testCases > 0) {
		System.out.println("Enter your string: ");
		String line = in.nextLine();
		if(line.equals("")) {
			break;
		}
		String rehexString = "<(.+)>([^<]+)</\\1>";
		Pattern r = Pattern.compile(rehexString);
		Matcher matcher = r.matcher(line);
		boolean founded = false;
		while(matcher.find()) {
			System.out.println(matcher.group(2));
			founded = true;			
		} 		
		if(!founded) {
			System.out.println("no result");
		}
		testCases--;
	}
	in.close();
}
}
