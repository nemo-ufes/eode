package br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */

public class Activity {

	private String name;

	private ProcessProjectSpecific processProjectSpecific;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProcessProjectSpecific getProcessProjectSpecific() {
		return processProjectSpecific;
	}

	public void setProcessProjectSpecific(ProcessProjectSpecific processProjectSpecific) {
		this.processProjectSpecific = processProjectSpecific;
	}

}
