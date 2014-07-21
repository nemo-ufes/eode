package br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd;

import java.util.LinkedHashSet;
import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.StandardProcessLifeCycleModel;

public class SpecificProjectProcess extends ProjectProcess {

	private StandardProcessLifeCycleModel standardProcessLifeCycleModel;
	private Set<Activity> activities;

	SpecificProjectProcess() {
		super();
		activities = new LinkedHashSet<Activity>();
	}

	/**
	 * @return the standardProcessLifeCycleModel
	 */
	public StandardProcessLifeCycleModel getStandardProcessLifeCycleModel() {
		return standardProcessLifeCycleModel;
	}

	/**
	 * @param standardProcessLifeCycleModel
	 *            the standardProcessLifeCycleModel to set
	 */
	public void setStandardProcessLifeCycleModel(
			StandardProcessLifeCycleModel standardProcessLifeCycleModel) {
		this.standardProcessLifeCycleModel = standardProcessLifeCycleModel;
	}

	/**
	 * @return the activities
	 */
	public Set<Activity> getActivities() {
		return activities;
	}

	/**
	 * @param activities
	 *            the activities to set
	 */
	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

}