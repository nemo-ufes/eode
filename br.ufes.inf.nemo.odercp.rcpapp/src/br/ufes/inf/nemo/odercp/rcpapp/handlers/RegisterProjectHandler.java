package br.ufes.inf.nemo.odercp.rcpapp.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import br.ufes.inf.nemo.odercp.rcpapp.usercontrol.cui.WizardRegisterProject;

public class RegisterProjectHandler {
	@Execute
	public void execute(IWorkbench workbench, Shell shell) {
		WizardRegisterProject wizardNewProject = new WizardRegisterProject();
		WizardDialog wizardDialog = new WizardDialog(shell, wizardNewProject);
		wizardDialog.open();
	}
}
