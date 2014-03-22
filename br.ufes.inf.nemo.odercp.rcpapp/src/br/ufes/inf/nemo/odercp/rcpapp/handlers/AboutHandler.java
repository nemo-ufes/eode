package br.ufes.inf.nemo.odercp.rcpapp.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
/**
 * About project ODE-RCP
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class AboutHandler {
	@Execute
	public void execute(Shell shell) {
		MessageDialog.openInformation(shell, "About", "ODE(Ontology-based software Development Environment) in RCP(Rich Client Plataform) more information acess nemo.inf.ufes.br/ODE.");
	}
}
