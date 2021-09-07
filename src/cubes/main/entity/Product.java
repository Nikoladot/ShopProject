package cubes.main.entity;

import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String image;
	@Column
	private double price;
	@Column
	private int quantity;
	@Column
	private boolean homepage;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "products_stickers", joinColumns = @JoinColumn(name="product_id"), inverseJoinColumns = @JoinColumn(name="sticker_id"))
	private List<Sticker> stickers;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manual_id")
	private Manual manual;

	
	public Product() {
		
	}
	
	
	
	public Product(String title, String description, String image, double price) {

		this.title = title;
		this.description = description;
		this.image = image;
		this.price = price;
		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category categoryId) {
		this.category = categoryId;
	}
	
	
			
		public List<Sticker> getStickers() {
		return stickers;
	}


	public void setStickers(List<Sticker> stickers) {
		this.stickers = stickers;
	}

	
	

		public Manual getManual() {
		return manual;
	}


	public void setManual(Manual manual) {
		this.manual = manual;
	}
	
	


		public boolean getHomepage() {
		return homepage;
	}


	public void setHomepage(boolean homepage) {
		this.homepage = homepage;
	}
	
	public Sticker getRandomSticker() {
		if(stickers==null||stickers.size() ==0) {
			
			return null;
		}
		
		Random random = new Random();
		
		return stickers.get(random.nextInt(stickers.size()));
		
	}
	
	public String getFormattedPrice() {
		
		return String.valueOf(price);
	}

	
	public String getCeoTitle() {
		
		
		return title.replaceAll(" ", "-").toLowerCase();
	}

		@Override
		public String toString() {
			
			return title+" - "+id;
		}
	
}
