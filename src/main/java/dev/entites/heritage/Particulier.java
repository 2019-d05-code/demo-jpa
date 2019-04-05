package dev.entites.heritage;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrePersist;

@Entity
//@DiscriminatorValue("PART")
public class Particulier extends AbstractClient {
	
	private String nom;
	
	private String prenom;
	
	private String nomComplet;
	
	@PrePersist
	public void onInsert() {
		this.nomComplet = this.nom.toUpperCase() + " " + this.prenom;
	}
	

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
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
	
	

}
