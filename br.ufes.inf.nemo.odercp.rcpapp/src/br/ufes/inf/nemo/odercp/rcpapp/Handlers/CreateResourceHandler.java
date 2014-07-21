package br.ufes.inf.nemo.odercp.rcpapp.Handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import br.ufes.inf.nemo.odercp.rcpapp.processControl.cui.wizard.WizardCreateResource;
/**
 * Handlers
 *
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class CreateResourceHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		WizardCreateResource wizardCreateResource = new WizardCreateResource();
		WizardDialog wizardDialog = new WizardDialog(HandlerUtil
				.getActiveWorkbenchWindow(event).getShell(),
				wizardCreateResource);
		wizardDialog.open();
		return null;

	}
}
