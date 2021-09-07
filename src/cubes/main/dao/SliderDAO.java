package cubes.main.dao;

import java.util.List;

import cubes.main.entity.Slider;

public interface SliderDAO {
	
	public List<Slider> getSliderList();
	public void saveSlider(Slider slider);
	public void getSliderDelete(int id);
	public Slider getSliderById(int id);	

}
