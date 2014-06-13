package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KProcess;

public class ApplCRUDKProcess {

	public static KProcess[] getever() {
		KProcess[] everKProcess = new KProcess[1];
		KProcess aux;
		aux = new KProcess();
		aux.setName("kProcess1");
		aux.setDescription("kProcess1");
		everKProcess[0] = aux;

		
		
		return everKProcess;
	}
}
