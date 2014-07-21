package br.ufes.inf.nemo.odercp.rcpapp.processControl.cmt;

import java.util.LinkedList;
import java.util.List;

import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.HardwareResource;

public class ApplCRUDHardwareResource {
	static List<HardwareResource> hardwareResources;

	static HardwareResource vectorhardwareResources[];

	public static HardwareResource[] getever() {
		if (hardwareResources == null)
			hardwareResources = new LinkedList<HardwareResource>();
		if (!hardwareResources.isEmpty()) {
			vectorhardwareResources = hardwareResources
					.toArray(new HardwareResource[hardwareResources.size()]);
			return vectorhardwareResources;
		}
		return null;
	}

	public static boolean Create(HardwareResource hardwareResource) {
		if (hardwareResources == null)
			hardwareResources = new LinkedList<HardwareResource>();
		hardwareResources.add(hardwareResource);
		return true;
	}
}
