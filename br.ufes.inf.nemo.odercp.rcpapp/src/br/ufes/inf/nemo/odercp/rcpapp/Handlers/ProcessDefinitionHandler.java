package br.ufes.inf.nemo.odercp.rcpapp.Handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.wizards.WizardDefineStandardProcess;

/**
 * 
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class ProcessDefinitionHandler extends AbstractHandler {

	/** @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent) */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
	//	try {
			WizardDefineStandardProcess wizardDefineStandardProcess = new WizardDefineStandardProcess();
			WizardDialog wizardDialog = new WizardDialog(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), wizardDefineStandardProcess);
			wizardDialog.open();
			
		//}
		//catch (Exception e) {
	//		e.printStackTrace();
		//}
		return null;
	}

}
