package br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd;

import java.util.LinkedHashSet;
import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cpd.Project;

public class GeneralProjectProcess extends ProjectProcess {

	private Set<SpecificProjectProcess> subProcesses;
	private Project project;

	/** Constructor. */
	public GeneralProjectProcess() {
		super();
		subProcesses = new LinkedHashSet<SpecificProjectProcess>();
	}

	/**
	 * @return the subProcesses
	 */
	public Set<SpecificProjectProcess> getSubProcesses() {
		return subProcesses;
	}

	/**
	 * @param subProcesses the subProcesses to set
	 */
	public void setSubProcesses(Set<SpecificProjectProcess> subProcesses) {
		this.subProcesses = subProcesses;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

}
