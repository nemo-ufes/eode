package br.ufes.inf.nemo.eode.rcpapp.standardProcess.pdl;

import java.util.LinkedHashSet;
import java.util.Set;

public class GeneralStandardProcess extends StandardProcess {

	private Set<SpecificStandardProcess> specificStandardProcesses;

	/** Constructor. */
	public GeneralStandardProcess() {
		super();
		specificStandardProcesses = new LinkedHashSet<SpecificStandardProcess>();
	}

	/** Getter for specificStandardProcesses. */
	public Set<SpecificStandardProcess> getSpecificStandardProcesses() {
		return specificStandardProcesses;
	}

	/** Setter for specificStandardProcesses. */
	public void setSpecificStandardProcesses(
			Set<SpecificStandardProcess> specificStandardProcesses) {
		this.specificStandardProcesses = specificStandardProcesses;
	}

}
