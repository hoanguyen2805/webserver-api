package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BookDao;
import entity.*;
import service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;

	public void addBook(Book book) {
		bookDao.addBook(book);

	}

	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	public void deleteBook(int id) {
		bookDao.deleteBook(id);
	}

	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}
}
