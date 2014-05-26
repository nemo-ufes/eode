package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd;

import java.util.HashSet;
import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeMain.cpd.Knowledge;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */

public class KActivity extends Knowledge {

	private boolean mandatory = false;

	private Set<KProcedure> kProcedures;

	private Set<KResource> kResources;

	private Set<KArtefact> inputs;

	private Set<KArtefact> products;

	private Set<KActivity> preKActivities;

	private Set<KActivity> subKActivities = new HashSet<KActivity>();

	private KProcess kProcess;

	private Set<KHumanResource> humanResources;

	public Set<KHumanResource> getHumanResources() {
		return humanResources;
	}

	public void setHumanResources(Set<KHumanResource> humanResources) {
		this.humanResources = humanResources;
	}

	public KActivity() {}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public Set<KProcedure> getkProcedures() {
		return kProcedures;
	}

	public void setkProcedures(Set<KProcedure> kProcedures) {
		this.kProcedures = kProcedures;
	}

	public Set<KResource> getkResources() {
		return kResources;
	}

	public void setkResources(Set<KResource> kResources) {
		this.kResources = kResources;
	}

	public Set<KArtefact> getInputs() {
		return inputs;
	}

	public void setInputs(Set<KArtefact> inputs) {
		this.inputs = inputs;
	}

	public Set<KArtefact> getProducts() {
		return products;
	}

	public void setProducts(Set<KArtefact> products) {
		this.products = products;
	}

	public Set<KActivity> getPreKActivities() {
		return preKActivities;
	}

	public void setPreKActivities(Set<KActivity> preKActivities) {
		this.preKActivities = preKActivities;
	}

	public Set<KActivity> getSubKActivities() {
		return subKActivities;
	}

	public void setSubKActivities(Set<KActivity> subKActivities) {
		this.subKActivities = subKActivities;
	}

	public KProcess getkProcess() {
		return kProcess;
	}

	public void setkProcess(KProcess kProcess) {
		this.kProcess = kProcess;
	}

}
