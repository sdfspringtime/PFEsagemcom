package tn.sagemcom.Entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@EntityScan
@Table(name = "Audit")
public class Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String auteur;
private Date date;
private String type_modification;

@ManyToOne(cascade = CascadeType.ALL)
private ChaineProd chaine;
@ManyToOne(cascade = CascadeType.ALL)
private Ressource ressource;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getAuteur() {
	return auteur;
}

public void setAuteur(String auteur) {
	this.auteur = auteur;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getType_modification() {
	return type_modification;
}

public void setType_modification(String type_modification) {
	this.type_modification = type_modification;
}

public ChaineProd getChaine() {
	return chaine;
}

public void setChaine(ChaineProd chaine) {
	this.chaine = chaine;
}

public Ressource getRessource() {
	return ressource;
}

public void setRessource(Ressource ressource) {
	this.ressource = ressource;
}

public Audit() {
	super();
}

public Audit( String auteur, Date date, String type_modification, ChaineProd chaine) {
	super();
	
	this.auteur = auteur;
	this.date = date;
	this.type_modification = type_modification;
	this.chaine = chaine;
}

public Audit( String auteur, Date date, String type_modification, ChaineProd chaine, Ressource ressource) {
	super();
	
	this.auteur = auteur;
	this.date = date;
	this.type_modification = type_modification;
	this.chaine = chaine;
	this.ressource = ressource;
}

	
}
