package tn.sagemcom.Entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;
@Entity
@EntityScan
@Table(name = "user")
public class User{

    private long id;
    private String nom;
    private String prenom;
    private String mail;
    private String password;
 public User() {
        
       
    }

    public User(String nom, String prenom, String mail, String password,Role role) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.password = password;
        //this.role = role;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return this.id;
    }

    /*public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}*/

	public void setId(long id) {
        this.id = id;
    }
    @Column(name = "nom", nullable = false)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    @Column(name = "prenom", nullable = false)
    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    @Column(name = "mail", nullable = false)
    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 /*   @ManyToOne
    private Role role;*/

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", mail='" + getMail() + "'" +
            ", password='" + getPassword() + "'" +
            ", role='" /*+ getRole() */+ "'" +
            "}";
    }

}