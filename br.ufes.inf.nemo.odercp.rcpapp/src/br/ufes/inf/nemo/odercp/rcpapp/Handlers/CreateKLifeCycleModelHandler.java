package br.ufes.inf.nemo.odercp.rcpapp.Handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.wizards.WizardCreateKLifeCycleModel;
/**
 * Handler to create Knowlodge Life-Cycle Model.
 *
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class CreateKLifeCycleModelHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		WizardCreateKLifeCycleModel wizardCreateKLifeCycleModel = new WizardCreateKLifeCycleModel();
		WizardDialog wizardDialog = new WizardDialog(HandlerUtil
				.getActiveWorkbenchWindow(event).getShell(),
				wizardCreateKLifeCycleModel);
		wizardDialog.open();
		return null;

	}
}
