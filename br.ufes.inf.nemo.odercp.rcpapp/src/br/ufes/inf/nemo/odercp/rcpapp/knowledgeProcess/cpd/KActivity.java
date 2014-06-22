package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd;

import java.util.HashSet;
import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeMain.cpd.Knowledge;

/**
 * Class that represents knowledge activity
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
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

	private Set<KHumanResource> khumanResources;

	/** Constructor. */
	public KActivity() {
		super();
	}

	/** Getter for mandatory. */
	public boolean isMandatory() {
		return mandatory;
	}

	/** Setter for mandatory. */
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	/** Getter for kProcedures. */
	public Set<KProcedure> getkProcedures() {
		return kProcedures;
	}

	/** Setter for kProcedures. */
	public void setkProcedures(Set<KProcedure> kProcedures) {
		this.kProcedures = kProcedures;
	}

	/** Getter for kResources. */
	public Set<KResource> getkResources() {
		return kResources;
	}

	/** Setter for kResources. */
	public void setkResources(Set<KResource> kResources) {
		this.kResources = kResources;
	}

	/** Getter for inputs. */
	public Set<KArtefact> getInputs() {
		return inputs;
	}

	/** Setter for inputs. */
	public void setInputs(Set<KArtefact> inputs) {
		this.inputs = inputs;
	}

	/** Getter for products. */
	public Set<KArtefact> getProducts() {
		return products;
	}

	/** Setter for products. */
	public void setProducts(Set<KArtefact> products) {
		this.products = products;
	}

	/** Getter for preKActivities. */
	public Set<KActivity> getPreKActivities() {
		return preKActivities;
	}

	/** Setter for preKActivities. */
	public void setPreKActivities(Set<KActivity> preKActivities) {
		this.preKActivities = preKActivities;
	}

	/** Getter for subKActivities. */
	public Set<KActivity> getSubKActivities() {
		return subKActivities;
	}

	/** Setter for subKActivities. */
	public void setSubKActivities(Set<KActivity> subKActivities) {
		this.subKActivities = subKActivities;
	}

	/** Getter for kProcess. */
	public KProcess getkProcess() {
		return kProcess;
	}

	/** Setter for kProcess. */
	public void setkProcess(KProcess kProcess) {
		this.kProcess = kProcess;
	}

	/** Getter for khumanResources. */
	public Set<KHumanResource> getKHumanResources() {
		return khumanResources;
	}

	/** Setter for khumanResources. */
	public void setKHumanResources(Set<KHumanResource> humanResources) {
		this.khumanResources = humanResources;
	}

}
