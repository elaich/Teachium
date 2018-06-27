package Teachium.Teachium.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Utilisateur {
	@Id
	private String id;
	private String username;
	private boolean accepted = false;
	private String nom;
	private String prenom;
	private String type;
	private String email;

	private List<String> formations;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	
	@Override
	public String toString() {
		return this.nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public Utilisateur(String nom, String prenom, String type) {
		// TODO Auto-generated constructor stub
		this.nom = nom;
		this.prenom = prenom;
		this.formations = new ArrayList<String>();
		this.accepted = false;
		this.type = type;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public List<String> getFormations() {
		return this.formations;
	}

	public void setFormations(List<String> formations) {
		this.formations = formations;
	}


}
