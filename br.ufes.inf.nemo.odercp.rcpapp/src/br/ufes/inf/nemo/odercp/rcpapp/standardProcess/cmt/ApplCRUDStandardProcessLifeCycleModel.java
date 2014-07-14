package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cmt;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKLifeCycleModel;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.Combination;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.StandardProcessLifeCycleModel;

public class ApplCRUDStandardProcessLifeCycleModel {
	public static Set<StandardProcessLifeCycleModel> standardProcessLifeCycleModels;

	public static StandardProcessLifeCycleModel[] getever() {
		StandardProcessLifeCycleModel[] vector = new StandardProcessLifeCycleModel[1];
		if (standardProcessLifeCycleModels == null) {
			standardProcessLifeCycleModels = new HashSet<StandardProcessLifeCycleModel>();
			StandardProcessLifeCycleModel object = new StandardProcessLifeCycleModel();
			object.setkLifeCycleModel(ApplCRUDKLifeCycleModel.getever()[0]);
			Combination combination = new Combination();
			combination.setLifeCycleModel(object);
			HashSet<Combination> combinations = new HashSet<Combination>();
			combinations.add(combination);
			object.setCombinations(combinations);
			standardProcessLifeCycleModels.add(object);
		}
		int i = 0;
		Iterator<StandardProcessLifeCycleModel> it = standardProcessLifeCycleModels.iterator();
		while (it.hasNext()) {
			vector[i] = it.next();
			i++;
		}
		return vector;

	}

}
