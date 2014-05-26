package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd;
/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */

public class ConbinationLCM {

	private TypeCombination typeCombination;

	private KLifeCycleModel kLifeCycleModel;

	public ConbinationLCM() {}

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
