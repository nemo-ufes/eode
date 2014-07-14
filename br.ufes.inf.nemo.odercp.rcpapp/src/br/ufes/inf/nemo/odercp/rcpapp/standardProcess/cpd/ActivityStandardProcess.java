package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd;

import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KActivity;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KProcedure;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KResource;

public class ActivityStandardProcess {

	private String name;
	private String description;
	private boolean mandatory;
	private Set<KHumanResource> kHumanResources;
	private Set<KResource> kResources;
	private Set<ActivityStandardProcess> preActivityStandardProcesses;
	private Set<ActivityStandardProcess> subActivityStandardProcesses;
	private Set<KProcedure> kProcedures;
	private ActivityStandardProcess specification;
	private KActivity kActivity;
	private Set<KArtefact> products;
	private Set<KArtefact> inputs;
	private SpecificStandardProcess standardProcess;
	private Set<Combination> combination;

	/** Constructor. */
	public ActivityStandardProcess() {
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

	/** Getter for description. */
	public String getDescription() {
		return description;
	}

	/** Setter for description. */
	public void setDescription(String description) {
		this.description = description;
	}

	/** Getter for mandatory. */
	public boolean isMandatory() {
		return mandatory;
	}

	/** Setter for mandatory. */
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	/** Getter for kHumanResources. */
	public Set<KHumanResource> getkHumanResources() {
		return kHumanResources;
	}

	/** Setter for kHumanResources. */
	public void setkHumanResources(Set<KHumanResource> kHumanResources) {
		this.kHumanResources = kHumanResources;
	}

	/** Getter for kResources. */
	public Set<KResource> getkResources() {
		return kResources;
	}

	/** Setter for kResources. */
	public void setkResources(Set<KResource> kResources) {
		this.kResources = kResources;
	}

	/** Getter for preActivityStandardProcesses. */
	public Set<ActivityStandardProcess> getPreActivityStandardProcesses() {
		return preActivityStandardProcesses;
	}

	/** Setter for preActivityStandardProcesses. */
	public void setPreActivityStandardProcesses(Set<ActivityStandardProcess> preActivityStandardProcesses) {
		this.preActivityStandardProcesses = preActivityStandardProcesses;
	}

	/** Getter for subActivityStandardProcesses. */
	public Set<ActivityStandardProcess> getSubActivityStandardProcesses() {
		return subActivityStandardProcesses;
	}

	/** Setter for subActivityStandardProcesses. */
	public void setSubActivityStandardProcesses(Set<ActivityStandardProcess> subActivityStandardProcesses) {
		this.subActivityStandardProcesses = subActivityStandardProcesses;
	}

	/** Getter for kProcedures. */
	public Set<KProcedure> getkProcedures() {
		return kProcedures;
	}

	/** Setter for kProcedures. */
	public void setkProcedures(Set<KProcedure> kProcedures) {
		this.kProcedures = kProcedures;
	}

	/** Getter for specification. */
	public ActivityStandardProcess getSpecification() {
		return specification;
	}

	/** Setter for specification. */
	public void setSpecification(ActivityStandardProcess specification) {
		this.specification = specification;
	}

	/** Getter for kActivity. */
	public KActivity getkActivity() {
		return kActivity;
	}

	/** Setter for kActivity. */
	public void setkActivity(KActivity kActivity) {
		this.kActivity = kActivity;
	}

	/** Getter for products. */
	public Set<KArtefact> getProducts() {
		return products;
	}

	/** Setter for products. */
	public void setProducts(Set<KArtefact> products) {
		this.products = products;
	}

	/** Getter for inputs. */
	public Set<KArtefact> getInputs() {
		return inputs;
	}

	/** Setter for inputs. */
	public void setInputs(Set<KArtefact> inputs) {
		this.inputs = inputs;
	}

	/** Getter for standardProcess. */
	public SpecificStandardProcess getStandardProcess() {
		return standardProcess;
	}

	/** Setter for standardProcess. */
	public void setStandardProcess(SpecificStandardProcess standardProcess) {
		this.standardProcess = standardProcess;
	}

	/** Getter for combination. */
	public Set<Combination> getCombination() {
		return combination;
	}

	/** Setter for combination. */
	public void setCombination(Set<Combination> combination) {
		this.combination = combination;
	}

}
