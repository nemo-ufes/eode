package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KProcess;

public class ApplCRUDKProcess {

	public static KProcess[] getever() {
		KProcess[] everKProcess = new KProcess[1];
		KProcess aux;
		aux = new KProcess();
		aux.setName("kProcess1");
		aux.setDescription("kProcess1");
		aux.setEngineering(true);
		everKProcess[0] = aux;

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
