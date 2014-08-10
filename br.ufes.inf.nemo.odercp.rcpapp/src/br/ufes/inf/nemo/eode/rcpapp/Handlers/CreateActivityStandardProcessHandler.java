package br.ufes.inf.nemo.eode.rcpapp.Handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import br.ufes.inf.nemo.eode.rcpapp.standardProcess.uil.wizards.WizardCreateActivityStandardProcess;

/**
 * 
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class CreateActivityStandardProcessHandler extends AbstractHandler {

	/** @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent) */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		WizardCreateActivityStandardProcess wizardCreateActivityStandardProcess = new WizardCreateActivityStandardProcess();
		WizardDialog wizardDialog = new WizardDialog(HandlerUtil
				.getActiveWorkbenchWindow(event).getShell(), wizardCreateActivityStandardProcess);
		wizardDialog.open();
		return null;
	}

}
