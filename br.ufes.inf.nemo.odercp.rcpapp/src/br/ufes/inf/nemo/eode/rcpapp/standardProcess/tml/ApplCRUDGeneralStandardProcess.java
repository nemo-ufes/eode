package br.ufes.inf.nemo.eode.rcpapp.standardProcess.tml;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import br.ufes.inf.nemo.eode.rcpapp.standardProcess.pdl.GeneralStandardProcess;

public class ApplCRUDGeneralStandardProcess {

	static Set<GeneralStandardProcess> generalStandardProcesses;

	static GeneralStandardProcess vectorsProcess[];

	public static GeneralStandardProcess[] getever() {

		if (generalStandardProcesses == null)
			generalStandardProcesses = new HashSet<GeneralStandardProcess>();
		if (!generalStandardProcesses.isEmpty()) {
			vectorsProcess = new GeneralStandardProcess[generalStandardProcesses
					.size()];
			Iterator<GeneralStandardProcess> it = generalStandardProcesses
					.iterator();
			int i = 0;
			while (it.hasNext()) {
				vectorsProcess[i] = it.next();
				i++;
			}
			return vectorsProcess;
		}
		return null;
	}

	public static boolean create(GeneralStandardProcess standardProcess) {
		if (generalStandardProcesses == null)
			generalStandardProcesses = new HashSet<GeneralStandardProcess>();
		generalStandardProcesses.add(standardProcess);
		return true;
	}

}
