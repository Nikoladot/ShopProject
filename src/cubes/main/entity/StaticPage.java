package cubes.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "static_pages")
public class StaticPage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String content;
	@Column(name = "content_type")
	private int contentType;
	
	public StaticPage() {
		
	}
	
	public StaticPage(int id, String content, int contentType) {
		
		this.id = id;
		this.content = content;
		this.contentType = contentType;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String text) {
		this.content = text;
	}
	public int getContentType() {
		return contentType;
	}
	public void setContentType(int contentType) {
		this.contentType = contentType;
	}

	
	@Override
	public String toString() {
	
		return content;
	}
	
}
