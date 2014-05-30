package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;

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
		aux.setName("Designer");
		aux.setDescription("Designer");
		everKHumanResource[2] = aux;

		aux = new KHumanResource();
		aux.setName("Project Manager");
		aux.setDescription("Project Manager");
		everKHumanResource[3] = aux;
		
		return everKHumanResource;
	}
}
