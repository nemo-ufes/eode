package br.ufes.inf.nemo.eode.rcpapp.processControl.tml;

import java.util.LinkedList;
import java.util.List;

import br.ufes.inf.nemo.eode.rcpapp.processControl.pdl.SoftwareResource;
import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.tml.ApplCRUDKSoftwareResource;

public class ApplCRUDSoftwareResource {
	static List<SoftwareResource> softwareResources;

	static SoftwareResource vectorsoftResources[];

	public static SoftwareResource[] getever() {
		if (softwareResources == null) {
			softwareResources = new LinkedList<SoftwareResource>();
			SoftwareResource softwareResource = new SoftwareResource();
			softwareResource.setName("so1");
			softwareResource
					.setkResource(ApplCRUDKSoftwareResource.getever()[0]);
			softwareResources.add(softwareResource);
		}
		if (!softwareResources.isEmpty()) {
			vectorsoftResources = softwareResources
					.toArray(new SoftwareResource[softwareResources.size()]);
			return vectorsoftResources;
		}
		return null;
	}

	public static boolean Create(SoftwareResource soft) {
		if (softwareResources == null) {
			softwareResources = new LinkedList<SoftwareResource>();
			SoftwareResource softwareResource = new SoftwareResource();
			softwareResource.setName("so1");
			softwareResource
					.setkResource(ApplCRUDKSoftwareResource.getever()[0]);
			softwareResources.add(softwareResource);

		}
		softwareResources.add(soft);
		return true;
	}
}
