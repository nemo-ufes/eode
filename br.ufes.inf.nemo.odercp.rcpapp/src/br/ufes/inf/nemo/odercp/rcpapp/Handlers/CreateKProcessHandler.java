package br.ufes.inf.nemo.odercp.rcpapp.Handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.wizards.WizardCreateKProcess;
/**
 * TODO: Handler to create Knowlodge Process.
 *
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class CreateKProcessHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		WizardCreateKProcess wizardCreateKProcess = new WizardCreateKProcess();
		WizardDialog wizardDialog = new WizardDialog(HandlerUtil
				.getActiveWorkbenchWindow(event).getShell(),
				wizardCreateKProcess);
		wizardDialog.open();
		return null;

	}
}
