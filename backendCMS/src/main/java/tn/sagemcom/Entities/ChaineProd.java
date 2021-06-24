package tn.sagemcom.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@EntityScan
@Table(name = "chaineprod")
public class ChaineProd {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private String name;
	
	 public ChaineProd(String description, String name) {
		super();
		this.description = description;
		this.name = name;
	}

	public ChaineProd(String description, String name, List<Ressource> ressources) {
		super();
		this.description = description;
		this.name = name;
		this.ressources = ressources;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy="chaine")
	private List<Ressource> ressources;
	 
	public List<Ressource> getRessources() {
		return ressources;
	}
	
	public void setRessources(List<Ressource> ressources) {
		this.ressources = ressources;
	}

	public ChaineProd() {
		super();
	}

	public ChaineProd(List<Ressource> ressources) {
		super();
		this.ressources = ressources;
	}
     
     
}
