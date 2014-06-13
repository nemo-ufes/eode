package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KSoftwareResource;

public class ApplCRUDKSoftwareResource {

	public static KSoftwareResource[] getever() {
		KSoftwareResource[] everKSoftwareResource = new KSoftwareResource[1];
		KSoftwareResource aux;
		aux = new KSoftwareResource();
		aux.setName("kSoftware1");
		aux.setDescription("kSoftware1");
		everKSoftwareResource[0] = aux;

		return everKSoftwareResource;
	}
}
