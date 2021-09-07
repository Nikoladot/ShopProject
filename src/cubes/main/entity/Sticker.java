package cubes.main.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "stickers")
public class Sticker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String title;
	@Column
	private String color;
	
	public Sticker() {
		
	}
	
	public Sticker(String title, String color) {
		
		this.title=title;
		this.color=color;
		
	}
	
	public Sticker(String id) {
		this.id = Integer.valueOf(id);
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {

		return title + " - "+color+" - " + id;
	}

}
