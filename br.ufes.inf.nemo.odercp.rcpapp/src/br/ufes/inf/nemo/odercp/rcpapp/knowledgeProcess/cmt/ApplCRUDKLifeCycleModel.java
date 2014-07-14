package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt;

import java.util.HashSet;
import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.CombinationLCM;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KLifeCycleModel;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.TypeCombination;

public class ApplCRUDKLifeCycleModel {

	public static KLifeCycleModel[] getever() {
		KLifeCycleModel[] everKLifeCycleModel = new KLifeCycleModel[1];
		KLifeCycleModel aux;
		aux = new KLifeCycleModel();
		aux.setName("Model in V");
		aux.setDescription("Model in V");
		CombinationLCM combinationLCM = new CombinationLCM();
		combinationLCM.setkLifeCycleModel(aux);
		combinationLCM.setTypeCombination(TypeCombination.Sequential);
		Set<CombinationLCM> combs = new HashSet<CombinationLCM>();
		combs.add(combinationLCM);
		aux.setCombinations(combs);
		everKLifeCycleModel[0] = aux;

		return everKLifeCycleModel;
	}

	public static boolean createKLifeCycleModel(String name, String description) {
		KLifeCycleModel kLifeCycleModel = new KLifeCycleModel();
		kLifeCycleModel.setName(name);
		kLifeCycleModel.setDescription(description);

		return true;
	}

	public static boolean deleteKLifeCycleModel(KLifeCycleModel kLifeCycleModel) {
		return true;
	}

	public static boolean updateKLifeCycleModel(KLifeCycleModel kLifeCycleModel) {
		return true;
	}

}
