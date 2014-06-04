package br.ufes.inf.nemo.odercp.rcpapp.userControl.cpd;

/**
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */

public enum AcessProfile {

	Administrator("Administrator"), Developer("Developer");

	private String name;

	private AcessProfile(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
