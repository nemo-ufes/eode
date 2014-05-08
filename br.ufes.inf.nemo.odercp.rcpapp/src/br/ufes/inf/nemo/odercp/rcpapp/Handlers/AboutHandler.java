package br.ufes.inf.nemo.odercp.rcpapp.Handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * About project ODE-RCP
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class AboutHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		MessageDialog
				.openInformation(
						HandlerUtil.getActiveWorkbenchWindow(event).getShell(),
						"About",
						"ODE(Ontology-based software Development Environment) in RCP(Rich Client Plataform) more information acess nemo.inf.ufes.br/ODE.");
		return null;

	}
}
