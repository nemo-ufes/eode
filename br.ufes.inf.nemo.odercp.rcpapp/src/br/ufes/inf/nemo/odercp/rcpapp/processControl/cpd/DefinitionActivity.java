package br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd;

import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KResource;

public class DefinitionActivity {

	private Activity activity;
	private Set<KResource> kResources;
	private Set<Activity> subActivities;
	
	
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public Set<KResource> getkResources() {
		return kResources;
	}
	public void setkResources(Set<KResource> kResources) {
		this.kResources = kResources;
	}
	public Set<Activity> getSubActivities() {
		return subActivities;
	}
	public void setSubActivities(Set<Activity> subActivities) {
		this.subActivities = subActivities;
	}
	
}
