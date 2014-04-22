package br.ufes.inf.nemo.odercp.rcpapp.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import br.ufes.inf.nemo.odercp.rcpapp.usercontrol.cui.WizardNewPassword;


public class NewPasswordHandler {
	@Execute
	public void execute(IWorkbench workbench, Shell shell) {
		WizardNewPassword wizardNewPassword = new WizardNewPassword();
		WizardDialog wizardDialog = new WizardDialog(shell, wizardNewPassword);
		wizardDialog.open();
	}
}
