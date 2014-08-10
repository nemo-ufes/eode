package br.ufes.inf.nemo.eode.rcpapp.standardProcess.tml;

import java.util.LinkedList;
import java.util.List;

import br.ufes.inf.nemo.eode.rcpapp.standardProcess.pdl.ActivityStandardProcess;

public class ApplCRUDActivityStandardProcess {

	private static List<ActivityStandardProcess> listActivityStandardProcesses;

	public static boolean CreateActivityStandardProcess(ActivityStandardProcess activityStandardProcess) {
		if (listActivityStandardProcesses == null) listActivityStandardProcesses = new LinkedList<ActivityStandardProcess>();

		listActivityStandardProcesses.add(activityStandardProcess);

		return true;
	}

	public static ActivityStandardProcess[] getever() {
		ActivityStandardProcess[] activityStandardProcesses;
		activityStandardProcesses = listActivityStandardProcesses.toArray(new ActivityStandardProcess[listActivityStandardProcesses.size()]);
		return activityStandardProcesses;
	}

}
