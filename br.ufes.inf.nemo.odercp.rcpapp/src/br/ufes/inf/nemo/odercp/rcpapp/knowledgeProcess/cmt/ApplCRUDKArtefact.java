package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt;

import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KArtefact;

public class ApplCRUDKArtefact {

	public static KArtefact[] getever() {
		KArtefact[] everKArtefact = new KArtefact[1];
		KArtefact aux;
		aux = new KArtefact();
		aux.setName("kArtefact1");
		aux.setDescription("kArtefact1");
		aux.setDepends(null);
		aux.setSubArtefacts(null);
		everKArtefact[0] = aux;

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
