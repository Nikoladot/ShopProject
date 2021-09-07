package cubes.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String image;
	@Column
	private boolean homepage;
	
	public Category() {
		
	}
	
	
	
	public Category(int id, String name, String image, boolean homepage) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.homepage = homepage;
	}



	public Category(String name) {
		
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean getHomepage() {
		return homepage;
	}

	public void setHomepage(boolean homepage) {
		this.homepage = homepage;
	}

	@Override
	public String toString() {

		return name+" - "+id;
	}
	
	

}
