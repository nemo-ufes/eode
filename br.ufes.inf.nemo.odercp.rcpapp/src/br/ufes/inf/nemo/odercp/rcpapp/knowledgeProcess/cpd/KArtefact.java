package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd;

import java.util.Set;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeMain.cpd.Knowledge;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
public class KArtefact extends Knowledge {

	private Set<KArtefact> subArtefacts;
	private Set<KArtefact> depends;

	/** Constructor. */
	public KArtefact() {
		super();
	}

	/** Getter for subArtefacts. */
	public Set<KArtefact> getSubArtefacts() {
		return subArtefacts;
	}

	/** Setter for subArtefacts. */
	public void setSubArtefacts(Set<KArtefact> subArtefacts) {
		this.subArtefacts = subArtefacts;
	}

	/** Getter for depends. */
	public Set<KArtefact> getDepends() {
		return depends;
	}

	/** Setter for depends. */
	public void setDepends(Set<KArtefact> depends) {
		this.depends = depends;
	}

}
