package br.ufes.inf.nemo.odercp.rcpapp.processControl.cmt;

import java.util.LinkedList;
import java.util.List;

import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.Artefact;

public class ApplCRUDArtefact {
	static List<Artefact> artefacts;

	static Artefact vectorsArtefacts[];

	public static Artefact[] getever() {
		if (artefacts == null)
			artefacts = new LinkedList<Artefact>();
		if (!artefacts.isEmpty()) {
			vectorsArtefacts = artefacts
					.toArray(new Artefact[artefacts.size()]);
			return vectorsArtefacts;
		}
		return null;
	}

	public static boolean Create(Artefact artefact) {
		if (artefacts == null)
			artefacts = new LinkedList<Artefact>();
		artefacts.add(artefact);
		return true;
	}

}
