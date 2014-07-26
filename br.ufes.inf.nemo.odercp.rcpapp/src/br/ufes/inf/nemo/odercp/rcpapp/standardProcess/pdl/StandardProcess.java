package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.pdl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class StandardProcess {

	private String name;
	private boolean isDefine;
	private String description;
	private Set<StandardProcess> specialization;

	/** Constructor. */
	public StandardProcess() {
		super();
		specialization = new LinkedHashSet<StandardProcess>();
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

	/** Getter for specialization. */
	public Set<StandardProcess> getSpecialization() {
		return specialization;
	}

	/** Setter for specialization. */
	public void setSpecialization(Set<StandardProcess> specialization) {
		this.specialization = specialization;
	}

}
