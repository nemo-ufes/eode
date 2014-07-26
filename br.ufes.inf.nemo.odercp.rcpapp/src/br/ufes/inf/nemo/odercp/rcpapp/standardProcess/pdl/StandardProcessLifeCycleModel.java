package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.pdl;

import java.util.HashSet;
import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KLifeCycleModel;

public class StandardProcessLifeCycleModel {

	private SpecificStandardProcess specificStandardProcess;
	private KLifeCycleModel kLifeCycleModel;
	private Set<Combination> combinations;
	
	/** Constructor. */
	public StandardProcessLifeCycleModel() {
		super();
		combinations = new HashSet<Combination>();
	}
	/** Getter for specificStandardProcess. */
	public SpecificStandardProcess getSpecificStandardProcess() {
		return specificStandardProcess;
	}
	/** Setter for specificStandardProcess. */
	public void setSpecificStandardProcess(SpecificStandardProcess specificStandardProcess) {
		this.specificStandardProcess = specificStandardProcess;
	}
	/** Getter for kLifeCycleModel. */
	public KLifeCycleModel getkLifeCycleModel() {
		return kLifeCycleModel;
	}
	/** Setter for kLifeCycleModel. */
	public void setkLifeCycleModel(KLifeCycleModel kLifeCycleModel) {
		this.kLifeCycleModel = kLifeCycleModel;
	}
	/** Getter for combinations. */
	public Set<Combination> getCombinations() {
		return combinations;
	}
	/** Setter for combinations. */
	public void setCombinations(Set<Combination> combinations) {
		this.combinations = combinations;
	}

}
