package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KHumanResource;

public class ApplCRUDKHumanResource {

	public static KHumanResource[] getever() {
		KHumanResource[] everKHumanResource = new KHumanResource[4];
		KHumanResource aux;
		aux = new KHumanResource();
		aux.setName("Analyst");
		aux.setDescription("Analyst");
		everKHumanResource[0] = aux;

		aux = new KHumanResource();
		aux.setName("Developer");
		aux.setDescription("Developer");
		everKHumanResource[1] = aux;

		aux = new KHumanResource();
		aux.setName("Project Manager");
		aux.setDescription("Project Manager");
		everKHumanResource[2] = aux;

		aux = new KHumanResource();
		aux.setName("Client");
		aux.setDescription("Client");
		everKHumanResource[3] = aux;

		return everKHumanResource;
	}

	public static boolean createKHumanResource(String name, String description) {
		KHumanResource kHumanResource = new KHumanResource();
		kHumanResource.setName(name);
		kHumanResource.setDescription(description);

		return true;
	}

	public static boolean deleteKHumanResource(KHumanResource kHumanResource) {
		return true;
	}

	public static boolean updateKHumanResource(KHumanResource kHumanResource) {
		return true;
	}

}
