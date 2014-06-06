package br.ufes.inf.nemo.odercp.rcpapp.Handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import br.ufes.inf.nemo.odercp.rcpapp.userControl.cui.wizards.WizardCreateUser;

/**
 * TODO: document this type.
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class CreateUserHandler extends AbstractHandler {

	/** @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent) */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		WizardCreateUser wizardCreateUser = new WizardCreateUser();
		WizardDialog wizardDialog = new WizardDialog(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), wizardCreateUser);
		wizardDialog.open();
		return null;
	}

}
