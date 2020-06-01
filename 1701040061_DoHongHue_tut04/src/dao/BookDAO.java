package dao;
import model.Book;
import java.util.List;
public interface BookDAO {
List<Book> getAllBooks();
boolean insertBook(Book book);
boolean deleteBook(int id);
boolean updateBook(Book book);
Book getBook(int id);
boolean checkBook(String name);
}