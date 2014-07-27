package br.ufes.inf.nemo.odercp.rcpapp.processControl.tml;

import java.util.LinkedList;
import java.util.List;

import br.ufes.inf.nemo.odercp.rcpapp.processControl.pdl.SpecificProjectProcess;

public class ApplCRUDSpecificProjectProcess {
	static List<SpecificProjectProcess> specificProjectProcesses;

	static SpecificProjectProcess vectorsoftspecificProjectProcesses[];

	public static SpecificProjectProcess[] getever() {
		if (specificProjectProcesses == null)
			specificProjectProcesses = new LinkedList<SpecificProjectProcess>();
		if (!specificProjectProcesses.isEmpty()) {
			vectorsoftspecificProjectProcesses = specificProjectProcesses
					.toArray(new SpecificProjectProcess[specificProjectProcesses.size()]);
			return vectorsoftspecificProjectProcesses;
		}
		return null;
	}

	public boolean Create(SpecificProjectProcess soft) {
		if (specificProjectProcesses == null)
			specificProjectProcesses = new LinkedList<SpecificProjectProcess>();
		specificProjectProcesses.add(soft);
		return true;
	}
}
