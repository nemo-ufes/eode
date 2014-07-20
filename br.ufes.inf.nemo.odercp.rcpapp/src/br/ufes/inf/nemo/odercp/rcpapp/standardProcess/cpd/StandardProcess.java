package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd;

import java.util.HashSet;
import java.util.Set;

public abstract class StandardProcess {

	private String name;
	private boolean isDefine;
	private String description;
	private Organization organization;
	private Set<StandardProcess> specialization;

	/** Constructor. */
	public StandardProcess() {
		super();
		specialization = new HashSet<StandardProcess>();
	}

	/** Getter for name. */
	public String getName() {
		return name;
	}

	/** Setter for name. */
	public void setName(String name) {
		this.name = name;
	}

	/** Getter for ehDefine. */
	public boolean isDefine() {
		return isDefine;
	}

	/** Setter for ehDefine. */
	public void setIsDefine(boolean isDefine) {
		this.isDefine = isDefine;
	}

	/** Getter for description. */
	public String getDescription() {
		return description;
	}

	/** Setter for description. */
	public void setDescription(String description) {
		this.description = description;
	}

	/** Getter for organization. */
	public Organization getOrganization() {
		return organization;
	}

	/** Setter for organization. */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	/** Getter for specialization. */
	public Set<StandardProcess> getSpecialization() {
		return specialization;
	}

	/** Setter for specialization. */
	public void setSpecialization(Set<StandardProcess> specialization) {
		this.specialization = specialization;
	}

}
