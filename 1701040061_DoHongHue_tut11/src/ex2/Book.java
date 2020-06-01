package ex2;

public class Book {
	private String title;
private String author;
private double price;
public Book() {
	
}
public Book(String title, String author, double price) {
	super();
	this.title = title;
	this.author = author;
	this.price = price;
}

protected String getTitle() {
		return title;
	}
	protected void setTitle(String title) {
		if(title.length() < 3) {
			throw new IllegalArgumentException("Title not valid!");
		} else {
			this.title = title;
		}
		
	}
	protected String getAuthor() {
		return author;
	}
	protected void setAuthor(String author) {
		String[] array = author.split(" ");
		char[] charArray = array[1].toCharArray();
		
		if(Character.isDigit(charArray[0])) {
			throw new IllegalArgumentException("author not valid!"); 
		} else {
			this.author = author;
		}
	}
	protected double getPrice() {
		
			return price;
		}

	
	protected void setPrice(double price) {
		if(price < 1) {
			throw new IllegalArgumentException("Price not valid!");
			
		} else {
		this.price = price;
		}
	}
	
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Type: ").append(this.getClass().getSimpleName())
				.append(System.lineSeparator())
				.append("Title: ").append(this.getTitle())
				.append(System.lineSeparator())
				.append("Author: ").append(this.getAuthor())
				.append(System.lineSeparator())
				.append("Price: ").append(this.getPrice())
				.append(System.lineSeparator());
		return builder.toString();
	}

}
