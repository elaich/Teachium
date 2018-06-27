package Teachium.Teachium.domain;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
public class Formation {
	
	@Id
	private String id;
	private String name;
	private String userId;
	private Date date;
	private String description;
	private String salle;
	private List<String> files;
	private Boolean confirme = false;
	
	public Formation(String name, String userId) {
		this.name = name;
		this.userId = userId;
		this.files = new ArrayList<String>();
		this.confirme = false;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSalle() {
		return salle;
	}

	public void setSalle(String salle) {
		this.salle = salle;
	}

	
	public List<String> getFiles() {
		return files;
	}

	public void setFiles(List<String> files) {
		this.files = files;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Boolean getConfirme() {
		return confirme;
	}

	public void setConfirme(Boolean confirme) {
		this.confirme = confirme;
	}

}
