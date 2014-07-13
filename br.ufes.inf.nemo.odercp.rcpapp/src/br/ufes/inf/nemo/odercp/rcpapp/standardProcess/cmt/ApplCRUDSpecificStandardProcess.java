package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cmt;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.SpecificStandardProcess;

public class ApplCRUDSpecificStandardProcess {
	static Set<SpecificStandardProcess> specificStandardProcesses;
	static SpecificStandardProcess vectorsProcess[];

	public static SpecificStandardProcess[] getever() {

		if (specificStandardProcesses == null) specificStandardProcesses = new HashSet<SpecificStandardProcess>();
		if (!specificStandardProcesses.isEmpty()) {
			vectorsProcess = new SpecificStandardProcess[specificStandardProcesses.size()];
			Iterator<SpecificStandardProcess> it = specificStandardProcesses.iterator();
			int i = 0;
			while (it.hasNext()) {
				vectorsProcess[i] = it.next();
				i++;
			}
			return vectorsProcess;
		}
		return null;

	}

	public static boolean create(SpecificStandardProcess standardProcess) {
		if (specificStandardProcesses == null) specificStandardProcesses = new HashSet<SpecificStandardProcess>();
		specificStandardProcesses.add(standardProcess);
		return true;
	}

}
