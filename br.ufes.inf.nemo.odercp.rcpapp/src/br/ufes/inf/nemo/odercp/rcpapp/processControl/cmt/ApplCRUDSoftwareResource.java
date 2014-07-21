package br.ufes.inf.nemo.odercp.rcpapp.processControl.cmt;

import java.util.LinkedList;
import java.util.List;

import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.SoftwareResource;

public class ApplCRUDSoftwareResource {
	static List<SoftwareResource> softwareResources;

	static SoftwareResource vectorsoftResources[];

	public static SoftwareResource[] getever() {
		if (softwareResources == null)
			softwareResources = new LinkedList<SoftwareResource>();
		if (!softwareResources.isEmpty()) {
			vectorsoftResources = softwareResources
					.toArray(new SoftwareResource[softwareResources.size()]);
			return vectorsoftResources;
		}
		return null;
	}

	public static boolean Create(SoftwareResource soft) {
		if (softwareResources == null)
			softwareResources = new LinkedList<SoftwareResource>();
		softwareResources.add(soft);
		return true;
	}
}
