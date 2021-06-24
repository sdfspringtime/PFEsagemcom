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
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	  
	
	@OneToMany(targetEntity=User.class,cascade=CascadeType.ALL)
	  private List<User> users;
	
	
	 public enum RoleTag {
	        ADMIN,
	        MACHINIST,
	        EMPLOYEE;
	    }
      private boolean CanADDMACHINE;
      private boolean CanADDChain;
      private boolean CanADDRole;
      
	public int getId(){
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public boolean isCanADDMACHINE() {
		return CanADDMACHINE;
	}
	public void setCanADDMACHINE(boolean canADDMACHINE) {
		CanADDMACHINE = canADDMACHINE;
	}
	public boolean isCanADDChain() {
		return CanADDChain;
	}
	public void setCanADDChain(boolean canADDChain) {
		CanADDChain = canADDChain;
	}
	public boolean isCanADDRole() {
		return CanADDRole;
	}
	public void setCanADDRole(boolean canADDRole) {
		CanADDRole = canADDRole;
	}
	
	public Role() {
		super();
	}
	public Role(int id, boolean canADDMACHINE, boolean canADDChain, boolean canADDRole) {
		super();
		this.id = id;
		this.users = users;
		CanADDMACHINE = canADDMACHINE;
		CanADDChain = canADDChain;
		CanADDRole = canADDRole;
	}
    
}
