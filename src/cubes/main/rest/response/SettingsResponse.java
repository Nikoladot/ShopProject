package cubes.main.rest.response;

import java.util.List;

import cubes.main.entity.Category;
import cubes.main.entity.Sticker;

public class SettingsResponse {
	
	private List<Sticker> stickers;
	private List<Category> categories;
	
	
	
	
	
	public List<Sticker> getStickers() {
		return stickers;
	}
	public void setStickers(List<Sticker> stickers) {
		this.stickers = stickers;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
	

}
