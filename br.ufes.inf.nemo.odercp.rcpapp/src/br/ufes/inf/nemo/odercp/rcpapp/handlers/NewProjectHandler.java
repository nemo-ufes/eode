package br.ufes.inf.nemo.odercp.rcpapp.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cmt.NewProject;
import br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cui.WizardNewProject;

public class NewProjectHandler {
	@Execute
	public void execute(IWorkbench workbench, Shell shell) {
		WizardNewProject wizardNewProject = new WizardNewProject();
		WizardDialog wizardDialog = new WizardDialog(shell, wizardNewProject);
		wizardDialog.open();
	}
}
