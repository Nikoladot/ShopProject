package cubes.main.dao;

import java.util.Optional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cubes.main.entity.StaticPage;
import cubes.main.entity.Message;

@Repository
public class StaticPageDAOImpl implements StaticPageDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public String getAboutUsPageContent() {
		
		Session session = sessionFactory.getCurrentSession();
		
		StaticPage aboutUsPage = session.get(StaticPage.class, 1);		

		return aboutUsPage.getContent();
	}

	@Transactional
	@Override
	public String getLocationPageContent() {
		
		Session session = sessionFactory.getCurrentSession();
		
		StaticPage locationPage = session.get(StaticPage.class, 2);		

		return locationPage.getContent();
	}
	

	@Transactional
	@Override
	public StaticPage getStaticPage(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(StaticPage.class, id);
	}

	@Transactional
	@Override
	public void saveStaticPage(StaticPage staticPage) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(staticPage);
		
	}

	


	

	

}
