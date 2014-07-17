package br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;

public class HRDemand {

	private DefinitionActivity definitionActivities;
	private KHumanResource kHumanResource;

	public DefinitionActivity getDefinitionActivities() {
		return definitionActivities;
	}
	public void setDefinitionActivities(DefinitionActivity definitionActivities) {
		this.definitionActivities = definitionActivities;
	}
	public KHumanResource getkHumanResource() {
		return kHumanResource;
	}
	public void setkHumanResource(KHumanResource kHumanResource) {
		this.kHumanResource = kHumanResource;
	}

}
