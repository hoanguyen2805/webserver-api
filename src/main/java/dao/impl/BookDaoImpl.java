package dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import dao.BookDao;
import entity.Book;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addBook(Book book) {
		Session session = sessionFactory.openSession(); // mở một session mới
		Transaction t = session.beginTransaction(); // bắt đầu điều khiển transaction
		try {
			session.save(book);
			t.commit(); // chấp nhận thay đổi dữ liệu
		} catch (Exception e) {
			t.rollback(); // hủy bỏ thay đổi dữ liệu
		} finally {
			session.close(); // đóng session
		}

	}

	public void updateBook(Book book) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(book);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}

	}

	public void deleteBook(int id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Book b = new Book();
		b.setId(id);
		try {
			session.delete(b);
			t.commit();
			System.out.println("Xóa thành công!");
		} catch (Exception e) {
			t.rollback();
			System.out.println("xóa thất bại, lỗi: " + e.getMessage());
		} finally {
			session.close();
		}

	}

	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Book> getAllBooks() {
//		Session session = sessionFactory.getCurrentSession();
//		String sql = "FROM Book";
//		Query query = session.createQuery(sql);
//		List<Book> list = query.list();
//		return list;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class);
		return criteria.list();
	}

}
