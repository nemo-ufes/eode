package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.mtl;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KProcess;

public class ApplCRUDKProcess {

	public static KProcess[] getever() {
		KProcess[] everKProcess = new KProcess[6];
		KProcess aux;
		aux = new KProcess();
		aux.setName("Software Development");
		aux.setDescription("Software Development");
		aux.setEngineering(true);
		everKProcess[0] = aux;

		aux = new KProcess();
		aux.setName("Software Maintenance");
		aux.setDescription("Software Maintenance");
		aux.setEngineering(true);
		everKProcess[1] = aux;

		aux = new KProcess();
		aux.setName("Operation");
		aux.setDescription("Operation");
		aux.setEngineering(false);
		everKProcess[2] = aux;

		aux = new KProcess();
		aux.setName("Training");
		aux.setDescription("Training");
		aux.setEngineering(false);
		everKProcess[3] = aux;

		aux = new KProcess();
		aux.setName("Project Manage");
		aux.setDescription("Project Manage");
		aux.setEngineering(false);
		everKProcess[4] = aux;

		aux = new KProcess();
		aux.setName("Quality Assurance");
		aux.setDescription("Quality Assurance");
		aux.setEngineering(false);
		everKProcess[5] = aux;

		return everKProcess;
	}

	public static boolean createKProcess(String name, String description, boolean isEngineering) {
		KProcess kProcess = new KProcess();
		kProcess.setName(name);
		kProcess.setDescription(description);
		kProcess.setEngineering(isEngineering);
		return true;
	}

	public static boolean deleteKProcess(KProcess kProcess) {
		return true;
	}

	public static boolean updateKProcess(KProcess kProcess) {
		return true;
	}

}
