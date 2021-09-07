package cubes.main.dao;



import cubes.main.entity.StaticPage;
import cubes.main.entity.Message;

public interface StaticPageDAO {
	
	public String getAboutUsPageContent();
	public String getLocationPageContent();
	public StaticPage getStaticPage(int id);
	public void saveStaticPage(StaticPage staticPage);


}
