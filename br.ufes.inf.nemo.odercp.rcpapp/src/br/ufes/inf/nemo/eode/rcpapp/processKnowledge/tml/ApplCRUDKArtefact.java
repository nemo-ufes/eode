package br.ufes.inf.nemo.eode.rcpapp.processKnowledge.tml;

import java.util.HashSet;
import java.util.Set;

import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.pdl.KArtefact;

public class ApplCRUDKArtefact {

	public static KArtefact[] getever() {
		KArtefact[] everKArtefact = new KArtefact[5];
		Set<KArtefact> kArtefacts;
		KArtefact aux;
		aux = new KArtefact();
		aux.setName("Requirement Document");
		aux.setDescription("Requirement Document");
		aux.setDepends(null);
		aux.setSubArtefacts(null);
		everKArtefact[0] = aux;
		
		aux = new KArtefact();
		aux.setName("Specification Document");
		aux.setDescription("Specification Document");
		kArtefacts = new HashSet<KArtefact>();
		kArtefacts.add(everKArtefact[0]);
		aux.setDepends(kArtefacts);
		aux.setSubArtefacts(null);
		everKArtefact[1] = aux;
		
		aux = new KArtefact();
		aux.setName("Design Document");
		aux.setDescription("Design Document");
		kArtefacts = new HashSet<KArtefact>();
		kArtefacts.add(everKArtefact[1]);
		aux.setDepends(kArtefacts);
		aux.setSubArtefacts(null);
		everKArtefact[2] = aux;

		aux = new KArtefact();
		aux.setName("Source");
		aux.setDescription("Source");
		kArtefacts = new HashSet<KArtefact>();
		kArtefacts.add(everKArtefact[1]);
		kArtefacts.add(everKArtefact[2]);
		aux.setDepends(kArtefacts);
		aux.setSubArtefacts(null);
		everKArtefact[3] = aux;

		aux = new KArtefact();
		aux.setName("Project Document");
		aux.setDescription("Project Document");
		aux.setDepends(null);
		aux.setSubArtefacts(null);
		everKArtefact[4] = aux;

		return everKArtefact;

	}

	public static boolean createKArtefact(String name, String description, Set<KArtefact> depends, Set<KArtefact> subArtefacts) {
		KArtefact kArtefact = new KArtefact();
		kArtefact.setName(name);
		kArtefact.setDescription(description);
		kArtefact.setDepends(depends);
		kArtefact.setSubArtefacts(subArtefacts);

		return true;
	}

	public static boolean deleteKArtefact(KArtefact kArtefact) {
		return true;
	}

	public static boolean updateKArtefact(KArtefact kArtefact) {
		return true;
	}

}
