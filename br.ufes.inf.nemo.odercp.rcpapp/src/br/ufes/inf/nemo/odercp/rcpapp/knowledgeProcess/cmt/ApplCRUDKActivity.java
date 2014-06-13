package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KActivity;

public class ApplCRUDKActivity {

	public static KActivity[] getever() {
		KActivity[] everKActivity = new KActivity[1];
		KActivity aux;
		aux = new KActivity();
		aux.setName("kActivity1");
		aux.setDescription("kActivity1");
		everKActivity[0] = aux;

		return everKActivity;
	}
}
