package dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import dao.UserDao;
import entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(User User) {
		Session session = sessionFactory.openSession(); // mở một session mới
		Transaction t = session.beginTransaction(); // bắt đầu điều khiển transaction
		try {
			session.save(User);
			t.commit(); // chấp nhận thay đổi dữ liệu
		} catch (Exception e) {
			t.rollback(); // hủy bỏ thay đổi dữ liệu
		} finally {
			session.close(); // đóng session
		}

	}

	public void updateUser(User User) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(User);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}

	}

	public void deleteUser(int id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		User b = new User();
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

	public User getUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}
	public User getUserByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM User WHERE username = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", name);
		@SuppressWarnings("unchecked")
		List<User> user = query.list();
		if(user.isEmpty()) {
			return null;
		}
		return user.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		System.out.println("1");
		return criteria.list();
	}

}
