package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KProcedure;

public class ApplCRUDKProcedure {

	public static KProcedure[] getever() {
		KProcedure[] everKProcedure = new KProcedure[5];
		KProcedure aux;
		aux = new KProcedure();
		aux.setName("Use Case Modeling");
		aux.setDescription("Use Case Modeling");
		everKProcedure[0] = aux;

		aux = new KProcedure();
		aux.setName("Class Modeling");
		aux.setDescription("Class Modeling");
		everKProcedure[1] = aux;

		aux = new KProcedure();
		aux.setName("Designing Software");
		aux.setDescription("Designing Software");
		everKProcedure[2] = aux;

		aux = new KProcedure();
		aux.setName("Coding Software");
		aux.setDescription("Coding Software");
		everKProcedure[3] = aux;

		aux = new KProcedure();
		aux.setName("Testing Software");
		aux.setDescription("Testing Software");
		everKProcedure[4] = aux;

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
