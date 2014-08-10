package br.ufes.inf.nemo.eode.rcpapp.processControl.pdl;

import java.util.LinkedHashSet;
import java.util.Set;

import br.ufes.inf.nemo.eode.rcpapp.standardProcess.pdl.StandardProcessLifeCycleModel;

public class SpecificProjectProcess extends ProjectProcess {

	private StandardProcessLifeCycleModel standardProcessLifeCycleModel;
	private Set<Activity> activities;

	public SpecificProjectProcess() {
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