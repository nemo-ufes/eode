package br.ufes.inf.nemo.odercp.rcpapp.Handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.core.commands.AbstractHandler;
import br.ufes.inf.nemo.odercp.rcpapp.usercontrol.cui.WizardNewPassword;

/**
* Change password of User corrent in ODE-RCP
* 
* @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
* @version 1.0
*/

public class ChangePasswordHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		WizardNewPassword wizardNewPassword = new WizardNewPassword();
		WizardDialog wizardDialog = new WizardDialog(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), wizardNewPassword);
		wizardDialog.open();
		return null;
	}
}
