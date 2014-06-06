package br.ufes.inf.nemo.odercp.rcpapp.Handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.wizards.WizardCreateKHardwareResource;
/**
 * TODO: Handler to create Knowlodge Hardware Resource.
 *
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class CreateKHardwareResourceHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		WizardCreateKHardwareResource wizardCreateKHardwareResource = new WizardCreateKHardwareResource();
		WizardDialog wizardDialog = new WizardDialog(HandlerUtil
				.getActiveWorkbenchWindow(event).getShell(),
				wizardCreateKHardwareResource);
		wizardDialog.open();
		return null;

	}
}
