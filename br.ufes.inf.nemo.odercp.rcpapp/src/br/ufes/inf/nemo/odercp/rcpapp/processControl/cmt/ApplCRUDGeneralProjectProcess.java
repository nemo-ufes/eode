package br.ufes.inf.nemo.odercp.rcpapp.processControl.cmt;

import java.util.LinkedList;
import java.util.List;

import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.GeneralProjectProcess;

public class ApplCRUDGeneralProjectProcess {
	static List<GeneralProjectProcess> generalProjectProcesses;

	static GeneralProjectProcess vectorgeneralProjectProcesses[];

	public static GeneralProjectProcess[] getever() {
		if (generalProjectProcesses == null)
			generalProjectProcesses = new LinkedList<GeneralProjectProcess>();
		if (!generalProjectProcesses.isEmpty()) {
			vectorgeneralProjectProcesses = generalProjectProcesses
					.toArray(new GeneralProjectProcess[generalProjectProcesses.size()]);
			return vectorgeneralProjectProcesses;
		}
		return null;
	}

	public boolean Create(GeneralProjectProcess generalProjectProcess) {
		if (generalProjectProcesses == null)
			generalProjectProcesses = new LinkedList<GeneralProjectProcess>();
		generalProjectProcesses.add(generalProjectProcess);
		return true;
	}
}
