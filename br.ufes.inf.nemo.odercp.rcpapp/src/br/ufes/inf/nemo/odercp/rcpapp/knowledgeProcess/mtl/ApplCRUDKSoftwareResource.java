package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.mtl;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KSoftwareResource;

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

	public static boolean createKSoftwareResource(String name, String description) {
		KSoftwareResource kSoftwareResource = new KSoftwareResource();
		kSoftwareResource.setName(name);
		kSoftwareResource.setDescription(description);
		return true;
	}

	public static boolean deleteKSoftwareResource(KSoftwareResource kSoftwareResource) {
		return true;
	}

	public static boolean updateKSoftwareResource(KSoftwareResource kSoftwareResource) {
		return true;
	}

}
