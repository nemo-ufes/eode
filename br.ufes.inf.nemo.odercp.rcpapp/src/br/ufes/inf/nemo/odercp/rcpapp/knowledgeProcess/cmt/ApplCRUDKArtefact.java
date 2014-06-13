package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KArtefact;

public class ApplCRUDKArtefact {

	public static KArtefact[] getever() {
		KArtefact[] everKArtefact = new KArtefact[1];
		KArtefact aux;
		aux = new KArtefact();
		aux.setName("kArtefact1");
		aux.setDescription("kArtefact1");
		everKArtefact[0] = aux;

		return everKArtefact;
	}
}
