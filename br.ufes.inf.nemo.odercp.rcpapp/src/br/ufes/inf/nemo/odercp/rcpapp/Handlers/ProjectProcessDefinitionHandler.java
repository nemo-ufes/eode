package br.ufes.inf.nemo.odercp.rcpapp.Handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;

import br.ufes.inf.nemo.odercp.rcpapp.processControl.uil.PageProjectProcessDefine;
import br.ufes.inf.nemo.odercp.rcpapp.projectControl.mtl.ApplSelectProject;

/**
 * 
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class ProjectProcessDefinitionHandler extends AbstractHandler {

	/** @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent) */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (ApplSelectProject.getSelected() != null) {
			PageProjectProcessDefine pageProcessDefine = new PageProjectProcessDefine();
			pageProcessDefine.main();
		} else {
			MessageDialog.openConfirm(null, "Confirmation",
					"Choice a Project in menu Project");
		}
		return null;
	}

}
