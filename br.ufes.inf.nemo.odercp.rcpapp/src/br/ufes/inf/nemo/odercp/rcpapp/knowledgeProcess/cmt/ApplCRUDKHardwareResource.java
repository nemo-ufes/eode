package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHardwareResource;

public class ApplCRUDKHardwareResource {

	public static KHardwareResource[] getever() {
		KHardwareResource[] everKHardwareResource = new KHardwareResource[1];
		KHardwareResource aux;
		aux = new KHardwareResource();
		aux.setName("khardware1");
		aux.setDescription("khardware1");
		everKHardwareResource[0] = aux;

		return everKHardwareResource;
	}
}
