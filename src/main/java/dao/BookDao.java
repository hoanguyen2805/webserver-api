package dao;

import java.util.List;
import entity.*;;

public interface BookDao {
	public void addBook(Book book);

	public void updateBook(Book book);

	public void deleteBook(int id);

	public Book getBookById(int id);

	public List<Book> getAllBooks();
}
