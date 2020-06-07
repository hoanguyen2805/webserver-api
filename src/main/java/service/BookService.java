package service;

import java.util.List;

import entity.*;

public interface BookService {
	public void addBook(Book book);

	public void updateBook(Book book);

	public void deleteBook(int id);

	public Book getBookById(int id);

	public List<Book> getAllBooks();
}
