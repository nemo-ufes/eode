package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.wizards;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Button;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KActivity;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cmt.ApplCRUDActivityStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.ActivityStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.PageCreateStandardActivity;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.PageCreateStandardActivityChoiceKActivity;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.PageCreateStandardActivityChoicepreActivity;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.PageCreateStandardActivityChoicesubActivity;

public class WizardCreateActivityStandardProcess extends Wizard {

	PageCreateStandardActivity pageCreateStandardActivity;
	PageCreateStandardActivityChoiceKActivity pageCreateStandardActivityChoiceKActivity;
	PageCreateStandardActivityChoicepreActivity pageCreateStandardActivityChoicepreActivity;
	PageCreateStandardActivityChoicesubActivity pageCreateStandardActivityChoicesubActivity;

	public WizardCreateActivityStandardProcess() {
		setWindowTitle(" Wizard Create Activity");
		pageCreateStandardActivity = new PageCreateStandardActivity();
		pageCreateStandardActivityChoiceKActivity = new PageCreateStandardActivityChoiceKActivity();
		pageCreateStandardActivityChoicepreActivity = new PageCreateStandardActivityChoicepreActivity();
		pageCreateStandardActivityChoicesubActivity = new PageCreateStandardActivityChoicesubActivity();
	}

	@Override
	public void addPages() {
		addPage(pageCreateStandardActivity);
		addPage(pageCreateStandardActivityChoiceKActivity);
		addPage(pageCreateStandardActivityChoicepreActivity);
		addPage(pageCreateStandardActivityChoicesubActivity);
	}

	@Override
	public boolean performFinish() {

		ActivityStandardProcess activityStandardProcess = new ActivityStandardProcess();
		activityStandardProcess.setName(pageCreateStandardActivity.getTxtname()
				.getText());
		activityStandardProcess.setDescription(pageCreateStandardActivity
				.getTxtdescription().getText());

		KActivity Kactivity = null;
		Button[] kactivities = pageCreateStandardActivityChoiceKActivity
				.getRadios();
		for (int i = 0; i < kactivities.length; i++) {
			if (kactivities[i].getSelection()) {
				Kactivity = pageCreateStandardActivityChoiceKActivity
						.getHashKActivity().get(kactivities[i].getText());
			}

		}
		activityStandardProcess.setkActivity(Kactivity);

		Button[] bsubactivities = pageCreateStandardActivityChoicesubActivity
				.getChecks();

		for (int i = 0; i < bsubactivities.length; i++) {
			if (bsubactivities[i].getSelection()) {
				activityStandardProcess.getSubActivityStandardProcesses().add(
						pageCreateStandardActivityChoicesubActivity
								.getHashsubactivities().get(
										bsubactivities[i].getText()));
			}
		}

		Button[] bpreactivities = pageCreateStandardActivityChoicepreActivity
				.getChecks();

		for (int i = 0; i < bpreactivities.length; i++) {
			if (bpreactivities[i].getSelection()) {
				activityStandardProcess.getPreActivityStandardProcesses().add(
						pageCreateStandardActivityChoicepreActivity
								.getHashpreactivities().get(
										bpreactivities[i].getText()));
			}
		}

		return ApplCRUDActivityStandardProcess
				.CreateActivityStandardProcess(activityStandardProcess);
	}

}
