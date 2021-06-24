package tn.sagemcom.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@EntityScan
@Table(name = "ressource")
public class Ressource {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

public enum type {
    AOI3D
    ,SPI;
	}
@ManyToOne
@JoinColumn(name="chaineId")
private ChaineProd chaine;

private String description;
private boolean status;

public Ressource(ChaineProd chaine, String description, boolean status, boolean fEFS) {
	super();
	this.chaine = chaine;
	this.description = description;
	this.status = status;
	this.FEFS = fEFS;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public ChaineProd getChaine() {
	return chaine;
}
public void setChaine(ChaineProd chaine) {
	this.chaine = chaine;
}
private boolean FEFS;
public Ressource() {
	super();
}
public Ressource( boolean fEFS) {
	super();
	
	FEFS = fEFS;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public boolean isFEFS() {
	return FEFS;
}
public void setFEFS(boolean fEFS) {
	FEFS = fEFS;
}
}
