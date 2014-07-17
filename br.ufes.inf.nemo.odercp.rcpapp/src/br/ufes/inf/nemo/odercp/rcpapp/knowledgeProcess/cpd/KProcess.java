package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeMain.cpd.Knowledge;

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
