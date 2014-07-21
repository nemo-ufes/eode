package br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd;

import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.StandardProcess;

public abstract class ProjectProcess {

	private String name;
	private StandardProcess standardProcess;

	/** Constructor. */
	public ProjectProcess() {
		super();
	}

	/** Getter for name. */
	public String getName() {
		return name;
	}

	/** Setter for name. */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the standardProcess
	 */
	public StandardProcess getStandardProcess() {
		return standardProcess;
	}

	/**
	 * @param standardProcess
	 *            the standardProcess to set
	 */
	public void setStandardProcess(StandardProcess standardProcess) {
		this.standardProcess = standardProcess;
	}

}
