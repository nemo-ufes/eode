package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KProcedure;

public class ApplCRUDKProcedure {

	public static KProcedure[] getever() {
		KProcedure[] everKProcedure = new KProcedure[1];
		KProcedure aux;
		aux = new KProcedure();
		aux.setName("kprocedure1");
		aux.setDescription("kprocedure1");
		everKProcedure[0] = aux;

		return everKProcedure;
	}

	public static boolean createKProcedure(String name, String description) {
		KProcedure kProcedure = new KProcedure();
		kProcedure.setName(name);
		kProcedure.setDescription(description);

		return true;
	}

	public static boolean deleteKProcedure(KProcedure kProcedure) {
		return true;
	}

	public static boolean updateKProcedure(KProcedure kProcedure) {
		return true;
	}
}
