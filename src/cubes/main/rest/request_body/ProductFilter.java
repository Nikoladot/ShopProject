package cubes.main.rest.request_body;

public class ProductFilter {
	
	private Integer category;
	private Integer price;
	private Integer[] stickers;
	
	
	
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer[] getStickers() {
		return stickers;
	}
	public void setStickers(Integer[] stickers) {
		this.stickers = stickers;
	}
	
	
	

}
