package br.ufes.inf.nemo.odercp.rcpapp.knowledgeMain.cpd;

/**
 * Class father to ever Knowledge
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public abstract class Knowledge {

	private String name;
	private String description;
	
	/** Constructor. */
	public Knowledge() {
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

	

}
