package hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;


public class Regex {
	Pattern pat;
	Matcher mat;
public boolean regex(String s) {
	String k = "([01]?\\d{1,2}|2[0-4]\\d|25[0-5])";
	String pattern = k + "." + k + "." + k + "." + k;
	pat = Pattern.compile(pattern);
	if(pat.matcher(s).matches()) {
		return true;
	} else {
		return false;
	}
}
public static void main(String args[]) {
	
	Scanner in = new Scanner(System.in);
	Regex r = new Regex();
		
		
		while (true) {
			System.out.println("Enter the ip address: ");
			String line = in.nextLine();
			if (line.equals(""))
				break;
			if (r.regex(line) == true) {
				System.out.println("true");

			} else {
				System.out.println("false");
			}
		}
		in.close();
		 
		
	
}
}
