package ex2;

public class GoldenEditionBook extends Book {
	public GoldenEditionBook() {
		super();
	}
public GoldenEditionBook(String title, String author, double price) {
	super(title, author, price);
}
@Override
public double getPrice() {
	return super.getPrice() + super.getPrice() * 0.3;
}

}
