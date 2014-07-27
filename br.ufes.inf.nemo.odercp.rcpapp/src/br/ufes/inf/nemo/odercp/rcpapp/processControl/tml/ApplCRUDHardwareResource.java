package br.ufes.inf.nemo.odercp.rcpapp.processControl.tml;

import java.util.LinkedList;
import java.util.List;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml.ApplCRUDKHardwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.pdl.HardwareResource;

public class ApplCRUDHardwareResource {
	static List<HardwareResource> hardwareResources;

	static HardwareResource vectorhardwareResources[];

	public static HardwareResource[] getever() {
		if (hardwareResources == null) {
			hardwareResources = new LinkedList<HardwareResource>();
			HardwareResource hardwareResource = new HardwareResource();
			hardwareResource.setName("PC1");
			hardwareResource
					.setkResource(ApplCRUDKHardwareResource.getever()[0]);
			hardwareResources.add(hardwareResource);
		}
		if (!hardwareResources.isEmpty()) {
			vectorhardwareResources = hardwareResources
					.toArray(new HardwareResource[hardwareResources.size()]);
			return vectorhardwareResources;
		}
		return null;
	}

	public static boolean Create(HardwareResource hardwareResource) {
		if (hardwareResources == null) {
			hardwareResources = new LinkedList<HardwareResource>();
			HardwareResource hardwareResource1 = new HardwareResource();
			hardwareResource1.setName("PC1");
			hardwareResource1
					.setkResource(ApplCRUDKHardwareResource.getever()[0]);
			hardwareResources.add(hardwareResource1);
		}
		hardwareResources.add(hardwareResource);
		return true;
	}
}
