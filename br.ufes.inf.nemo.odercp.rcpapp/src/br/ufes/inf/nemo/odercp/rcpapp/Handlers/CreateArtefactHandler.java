package br.ufes.inf.nemo.odercp.rcpapp.Handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import br.ufes.inf.nemo.odercp.rcpapp.processControl.uil.wizard.WizardCreateArtefact;
/**
 * Handler .
 *
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class CreateArtefactHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		WizardCreateArtefact wizardCreateArtefact = new WizardCreateArtefact();
		WizardDialog wizardDialog = new WizardDialog(HandlerUtil
				.getActiveWorkbenchWindow(event).getShell(),
				wizardCreateArtefact);
		wizardDialog.open();
		return null;

	}
}
