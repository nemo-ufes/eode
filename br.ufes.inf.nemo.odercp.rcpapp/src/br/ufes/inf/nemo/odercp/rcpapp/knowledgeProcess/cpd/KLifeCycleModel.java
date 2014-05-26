package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd;

import java.util.HashSet;
import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeMain.cpd.Knowledge;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
public class KLifeCycleModel extends Knowledge {

	private Set<ConbinationLCM> combinations;

	public KLifeCycleModel() {
		setCombinations(new HashSet<ConbinationLCM>());
	}

	public Set<ConbinationLCM> getCombinations() {
		return combinations;
	}

	public void setCombinations(Set<ConbinationLCM> combinations) {
		this.combinations = combinations;
	}

}
