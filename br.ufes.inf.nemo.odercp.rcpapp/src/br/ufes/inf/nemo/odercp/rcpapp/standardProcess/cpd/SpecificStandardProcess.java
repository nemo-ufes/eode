package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KProcess;

public class SpecificStandardProcess extends StandardProcess {

	private Set<GeneralStandardProcess> generalStandardProcesses;
	private KProcess kProcess;
	private Set<StandardProcessLifeCycleModel> standardProcessLifeCycleModels;
	private List<ActivityStandardProcess> activitiesStandardProcess;

	/** Constructor. */
	public SpecificStandardProcess() {
		super();
		generalStandardProcesses = new HashSet<GeneralStandardProcess>();
		standardProcessLifeCycleModels = new HashSet<StandardProcessLifeCycleModel>();
		activitiesStandardProcess = new LinkedList<ActivityStandardProcess>();
	}

	/** Getter for generalStandardProcesses. */
	public Set<GeneralStandardProcess> getGeneralStandardProcesses() {
		return generalStandardProcesses;
	}

	/** Setter for generalStandardProcesses. */
	public void setGeneralStandardProcesses(Set<GeneralStandardProcess> generalStandardProcesses) {
		this.generalStandardProcesses = generalStandardProcesses;
	}

	/** Getter for kProcess. */
	public KProcess getkProcess() {
		return kProcess;
	}

	/** Setter for kProcess. */
	public void setkProcess(KProcess kProcess) {
		this.kProcess = kProcess;
	}

	/** Getter for standardProcessLifeCycleModels. */
	public Set<StandardProcessLifeCycleModel> getStandardProcessLifeCycleModels() {
		return standardProcessLifeCycleModels;
	}

	/** Setter for standardProcessLifeCycleModels. */
	public void setStandardProcessLifeCycleModels(Set<StandardProcessLifeCycleModel> standardProcessLifeCycleModels) {
		this.standardProcessLifeCycleModels = standardProcessLifeCycleModels;
	}

	/** Getter for activityStandardProcesses. */
	public List<ActivityStandardProcess> getActivityStandardProcesses() {
		return activitiesStandardProcess;
	}

	/** Setter for activityStandardProcesses. */
	public void setActivityStandardProcesses(List<ActivityStandardProcess> activityStandardProcesses) {
		this.activitiesStandardProcess = activityStandardProcesses;
	}

}
