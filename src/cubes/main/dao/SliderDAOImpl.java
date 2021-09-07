package cubes.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import cubes.main.entity.Slider;

@Repository
public class SliderDAOImpl implements SliderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<Slider> getSliderList() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Slider> list = session.createQuery("from Slider", Slider.class).getResultList();

		
		return list;
	}

	@Transactional
	@Override
	public void saveSlider(Slider slider) {
		
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(slider);
		
	}

	@Transactional
	@Override
	public void getSliderDelete(int id) {

		Session session = sessionFactory.getCurrentSession();
//
//		Slider s = session.get(Slider.class, id);
//		
//		session.delete(s);
		
		Query q = session.createQuery("delete Slider s where s.id = :id");
		q.setParameter("id", id);
		q.executeUpdate();
	}

	@Transactional
	@Override
	public Slider getSliderById(int id) {
		Session session = sessionFactory.getCurrentSession();

		Slider s = session.get(Slider.class, id);
		
		return session.get(Slider.class, id);
	}

}
