package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl;
/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */

public class CombinationLCM {

	private TypeCombination typeCombination;

	private KLifeCycleModel kLifeCycleModel;

	public CombinationLCM() {}

	public TypeCombination getTypeCombination() {
		return typeCombination;
	}

	public void setTypeCombination(TypeCombination typeCombination) {
		this.typeCombination = typeCombination;
	}

	public KLifeCycleModel getkLifeCycleModel() {
		return kLifeCycleModel;
	}

	public void setkLifeCycleModel(KLifeCycleModel kLifeCycleModel) {
		this.kLifeCycleModel = kLifeCycleModel;
	}

}
