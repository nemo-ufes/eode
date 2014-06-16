package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd;

import java.util.HashSet;
import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeMain.cpd.Knowledge;

/**
 * Class that represents Knowledge Life-Cycle Model
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class KLifeCycleModel extends Knowledge {

	private Set<CombinationLCM> combinations;

	public KLifeCycleModel() {
		setCombinations(new HashSet<CombinationLCM>());
	}

	/** Getter for combinations. */
	public Set<CombinationLCM> getCombinations() {
		return combinations;
	}

	/** Setter for combinations. */
	public void setCombinations(Set<CombinationLCM> combinations) {
		this.combinations = combinations;
	}

	
}
