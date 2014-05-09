package br.ufes.inf.nemo.odercp.rcpapp.Handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;

import br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cui.PageRegisterProject;


public class RegisterProjectHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		PageRegisterProject page = new PageRegisterProject();
		page.open(HandlerUtil.getActiveWorkbenchWindow(event).getShell());
		return null;
		
	}
}
