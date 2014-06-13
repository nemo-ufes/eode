package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KLifeCycleModel;

public class ApplCRUDKLifeCycleModel {

	public static KLifeCycleModel[] getever() {
		KLifeCycleModel[] everKLifeCycleModel = new KLifeCycleModel[4];
		KLifeCycleModel aux;
		aux = new KLifeCycleModel();
		aux.setName("kLifeCycleModel1");
		aux.setDescription("kLifeCycleModel1");
		everKLifeCycleModel[0] = aux;

		return everKLifeCycleModel;
	}
}
