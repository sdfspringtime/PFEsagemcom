package com.CMSBACK.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(	name = "machines")
public class Machine {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)

	private EMType typemach;

	private String description;
	private boolean allocated;
	private boolean status;
	private boolean FESE;
	@ManyToOne
    @JoinColumn(name="line_id", nullable=false)
    private Line line;
	@OneToMany(mappedBy = "machine")
    Set<MachineAlloc> machineallocs;
	public Integer getId() {
		return id;

	}
	public void setId(Integer id) {
		this.id = id;
	}
	public EMType getTypemach() {
		return typemach;
	}
	public void setTypemach(EMType typemach) {
		this.typemach = typemach;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAllocated() {
		return allocated;
	}
	public void setAllocated(boolean allocated) {
		this.allocated = allocated;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isFESE() {
		return FESE;
	}
	public void setFESE(boolean fESE) {
		FESE = fESE;
	}
	public Machine(EMType typemach, String description, boolean allocated, boolean status, boolean fESE) {
		super();
		this.typemach = typemach;
		this.description = description;
		this.allocated = allocated;
		this.status = status;
		this.FESE = fESE;
	}
	
	
}
