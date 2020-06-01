package ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.*;
import java.lang.instrument.IllegalClassFormatException;





public class Main {
public static void main(String[] args) throws IOException, IllegalClassFormatException {

try {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the author name: ");
	String author = reader.readLine();
	System.out.println("Enter the title of the book: ");
	String title = reader.readLine();
	System.out.println("Enter the price: ");
	double price = Double.parseDouble(reader.readLine());
	Book book  = new Book();
	GoldenEditionBook goldenBook = new GoldenEditionBook();
	book.setAuthor(author);
	book.setTitle(title);
	book.setPrice(price);
	goldenBook.setAuthor(author);
	goldenBook.setTitle(title);
	goldenBook.setPrice(price);
	Method[] bookMethods = Book.class.getDeclaredMethods();
	Method[] goldenBookMethods = GoldenEditionBook.class.getDeclaredMethods();
	System.out.println(book.toString());
	System.out.println(goldenBook.toString());
	if(goldenBookMethods.length > 1) {
		throw new IllegalClassFormatException("Code duplication in GoldenEditionBook");
	}
	
	
} catch(IllegalArgumentException error) {
	System.out.println(error.getMessage());
}
}
}
