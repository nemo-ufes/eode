package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
public enum TypeCombination {

	Sequential("Sequential"), Interactive("Interactive");

	private String type;

	private TypeCombination(String type) {
		this.type = type;

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
