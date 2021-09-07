package cubes.main.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cubes.main.entity.Category;
import cubes.main.entity.Location;


@Repository
public class LocationDAOImpl implements LocationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<Location> getLocationList() {

		Session session = sessionFactory.getCurrentSession();
		
		List<Location> locations = session.createQuery("from Location", Location.class).getResultList();
		
		return locations;
	}

	@Transactional
	@Override
	public void saveLocation(Location location) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(location);
		
	}

	@Transactional
	@Override
	public void deleteLocation(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("Delete from Location where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	@Transactional
	@Override
	public Location getLocationById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Location location = session.get(Location.class, id);
		
		return location;
	}

	

}
