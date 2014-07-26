package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.mtl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.mtl.ApplCRUDKLifeCycleModel;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.pdl.ActivityStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.pdl.Combination;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.pdl.StandardProcessLifeCycleModel;

public class ApplCRUDStandardProcessLifeCycleModel {
	public static Set<StandardProcessLifeCycleModel> standardProcessLifeCycleModels;

	public static StandardProcessLifeCycleModel[] getever() {
		StandardProcessLifeCycleModel[] vector = new StandardProcessLifeCycleModel[1];
		if (standardProcessLifeCycleModels == null) {
			standardProcessLifeCycleModels = new HashSet<StandardProcessLifeCycleModel>();
			StandardProcessLifeCycleModel object = new StandardProcessLifeCycleModel();
			object.setkLifeCycleModel(ApplCRUDKLifeCycleModel.getever()[0]);

			HashSet<ActivityStandardProcess> orders = new LinkedHashSet<ActivityStandardProcess>();
			// Order
			ActivityStandardProcess[] activitiesStandardProcess = ApplCRUDActivityStandardProcess
					.getever();
			String[] strings = { "Requirements Elicitation", "Analysis",
					"Design", "Implementation", "Test" };
			for (int i = strings.length - 1; i > 0; i--) {
				for (int j = 0; j < activitiesStandardProcess.length; j++) {
					if (activitiesStandardProcess[j].getName().equals(
							strings[i])) {
						orders.add(activitiesStandardProcess[j]);
					}
				}
			}
			Combination combination = new Combination();
			combination.setOrdersActivities(orders);
			combination.setLifeCycleModel(object);
			HashSet<Combination> combinations = new HashSet<Combination>();
			combinations.add(combination);
			object.setCombinations(combinations);
			standardProcessLifeCycleModels.add(object);
		}
		int i = 0;
		Iterator<StandardProcessLifeCycleModel> it = standardProcessLifeCycleModels
				.iterator();
		while (it.hasNext()) {
			vector[i] = it.next();
			i++;
		}
		return vector;

	}
}
