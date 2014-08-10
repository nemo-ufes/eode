package br.ufes.inf.nemo.eode.rcpapp.standardProcess.uil.wizards;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Button;

import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.pdl.KActivity;
import br.ufes.inf.nemo.eode.rcpapp.standardProcess.pdl.ActivityStandardProcess;
import br.ufes.inf.nemo.eode.rcpapp.standardProcess.tml.ApplCRUDActivityStandardProcess;
import br.ufes.inf.nemo.eode.rcpapp.standardProcess.uil.PageCreateStandardActivity;
import br.ufes.inf.nemo.eode.rcpapp.standardProcess.uil.PageCreateStandardActivityChoiceKActivity;
import br.ufes.inf.nemo.eode.rcpapp.standardProcess.uil.PageCreateStandardActivityChoicepreActivity;
import br.ufes.inf.nemo.eode.rcpapp.standardProcess.uil.PageCreateStandardActivityChoicesubActivity;

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
