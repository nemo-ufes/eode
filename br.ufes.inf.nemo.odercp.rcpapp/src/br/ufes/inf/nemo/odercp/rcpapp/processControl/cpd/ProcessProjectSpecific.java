package br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */

public class ProcessProjectSpecific {

	private String name;

	private ProcessProjectGeneral processProjectGeneral;

	public ProcessProjectGeneral getProcessProjectGeneral() {
		return processProjectGeneral;
	}

	public void setProcessProjectGeneral(ProcessProjectGeneral processProjectGeneral) {
		this.processProjectGeneral = processProjectGeneral;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
