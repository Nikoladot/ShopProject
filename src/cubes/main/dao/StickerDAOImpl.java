package cubes.main.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cubes.main.entity.Sticker;


@Repository
public class StickerDAOImpl implements StickerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<Sticker> getStickerList() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Sticker> stickers = session.createQuery("from Sticker", Sticker.class).getResultList();

		return stickers;
	}

	
	@Override
	public void saveSticker(Sticker sticker) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(sticker);
		
	}



	
	@Override
	public Sticker getStickerById(int id) {

		Session session = sessionFactory.getCurrentSession();
		
		Sticker stick = session.get(Sticker.class, id);
		
		return stick;
	}

	
	@Override
	public void getStickerDelete(int id) {
		
				Session session = sessionFactory.getCurrentSession();
				
				Query query = session.createQuery("Delete from Sticker where id=:id");
				query.setParameter("id", id);
				query.executeUpdate();
		
	}


	

}
