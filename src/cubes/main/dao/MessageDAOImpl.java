package cubes.main.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import cubes.main.entity.Message;



@Repository
public class MessageDAOImpl implements MessageDAO {
	
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<Message> getAllMessages() {
		
		Session session = sessionFactory.getCurrentSession();
		
		List<Message> list = session.createQuery("from Message", Message.class).getResultList();
		
		
		return list;
	}

	@Transactional
	@Override
	public void saveMessage(Message message) {

	Session session = sessionFactory.getCurrentSession();
	
	session.saveOrUpdate(message);
		
	}
	
	@Transactional
	@Override
	public void markAsSeen(int id) {
		
		

		
	}
	
	
	@Transactional
	@Override
	public long getUnreadMessagesCount() {

		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select count(*) from Message m where m.isSeen = 0");
		
		return (long) query.executeUpdate();
	}

	@Transactional
	@Override
	public Message getMessageById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Message message = session.get(Message.class, id);

		return message;
	}



}
