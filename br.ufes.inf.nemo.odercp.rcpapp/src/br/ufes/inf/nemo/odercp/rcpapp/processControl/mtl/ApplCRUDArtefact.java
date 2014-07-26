package br.ufes.inf.nemo.odercp.rcpapp.processControl.mtl;

import java.util.LinkedList;
import java.util.List;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.mtl.ApplCRUDKArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.pdl.Artefact;

public class ApplCRUDArtefact {
	static List<Artefact> artefacts;

	static Artefact vectorsArtefacts[];

	public static Artefact[] getever() {
		if (artefacts == null){
			artefacts = new LinkedList<Artefact>();
			
			Artefact artefact = new Artefact();
			artefact.setName("Requirement Document v.01");
			artefact.setkArtefact(ApplCRUDKArtefact.getever()[0]);	
			artefacts.add(artefact);
			
			artefact = new Artefact();
			artefact.setName("Specification Document v.01");
			artefact.setkArtefact(ApplCRUDKArtefact.getever()[1]);
			artefacts.add(artefact);

		}
		if (!artefacts.isEmpty()) {
			vectorsArtefacts = artefacts
					.toArray(new Artefact[artefacts.size()]);
			return vectorsArtefacts;
		}
		return null;
	}

	public static boolean Create(Artefact artefact) {
		if (artefacts == null){
			artefacts = new LinkedList<Artefact>();

			Artefact artefact1 = new Artefact();
			artefact1.setName("Requirement Document v.01");
			artefact1.setkArtefact(ApplCRUDKArtefact.getever()[0]);	
			artefacts.add(artefact1);
			
			artefact1 = new Artefact();
			artefact1.setName("Specification Document v.01");
			artefact1.setkArtefact(ApplCRUDKArtefact.getever()[1]);
			artefacts.add(artefact1);
		}
		artefacts.add(artefact);
		return true;
	}

}
