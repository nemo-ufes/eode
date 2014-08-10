package br.ufes.inf.nemo.eode.rcpapp.Handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.uil.wizards.WizardCreateKSoftwareResource;
/**
 * Handler to create Knowlodge Software Resource.
 *
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class CreateKSoftwareResourceHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		WizardCreateKSoftwareResource wizardCreateKSoftwareResource = new WizardCreateKSoftwareResource();
		WizardDialog wizardDialog = new WizardDialog(HandlerUtil
				.getActiveWorkbenchWindow(event).getShell(),
				wizardCreateKSoftwareResource);
		wizardDialog.open();
		return null;

	}
}
