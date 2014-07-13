package br.ufes.inf.nemo.odercp.rcpapp.Handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.core.commands.AbstractHandler;

import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.wizards.WizardCreateStandardProcess;

/**
* Create Standard Process
* 
* @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
* @version 1.0
*/

public class CreateStandardProcessHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		WizardCreateStandardProcess wizardCreateStandardProcess = new WizardCreateStandardProcess();
		WizardDialog wizardDialog = new WizardDialog(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), wizardCreateStandardProcess);
		wizardDialog.open();
		return null;
	}
}
