package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHardwareResource;

public class ApplCRUDKHardwareResource {

	public static KHardwareResource[] getever() {
		KHardwareResource[] everKHardwareResource = new KHardwareResource[1];
		KHardwareResource aux;
		aux = new KHardwareResource();
		aux.setName("PC");
		aux.setDescription("PC");
		everKHardwareResource[0] = aux;

		return everKHardwareResource;
	}
	public static boolean createKHardwareResource(String name, String description) {
		KHardwareResource kHardwareResource = new KHardwareResource();
		kHardwareResource.setName(name);
		kHardwareResource.setDescription(description);
		return true;
	}

	public static boolean deleteKHardwareResource(KHardwareResource kHardwareResource) {
		return true;
	}

	public static boolean updateKHardwareResource(KHardwareResource kHardwareResource) {
		return true;
	}

}
