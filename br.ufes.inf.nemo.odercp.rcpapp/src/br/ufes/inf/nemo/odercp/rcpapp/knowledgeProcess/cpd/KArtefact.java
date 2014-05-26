package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd;

import java.util.Set;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeMain.cpd.Knowledge;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
public class KArtefact extends Knowledge {

	private Set<KArtefact> subArtefacts;
	private Set<KArtefact> dependes;

	public KArtefact() {}

	public Set<KArtefact> getSubArtefacts() {
		return subArtefacts;
	}

	public void setSubArtefacts(Set<KArtefact> subArtefacts) {
		this.subArtefacts = subArtefacts;
	}

	public Set<KArtefact> getDependes() {
		return dependes;
	}

	public void setDependes(Set<KArtefact> dependes) {
		this.dependes = dependes;
	}

}
