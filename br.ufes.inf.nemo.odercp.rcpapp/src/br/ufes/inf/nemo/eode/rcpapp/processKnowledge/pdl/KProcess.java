package br.ufes.inf.nemo.eode.rcpapp.processKnowledge.pdl;

import br.ufes.inf.nemo.eode.rcpapp.knowledgeMain.pdl.Knowledge;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */

public class KProcess extends Knowledge {

	private boolean isEngineering;

	public KProcess() {}

	public boolean isEngineering() {
		return isEngineering;
	}

	public void setEngineering(boolean isEngineering) {
		this.isEngineering = isEngineering;
	}

}
