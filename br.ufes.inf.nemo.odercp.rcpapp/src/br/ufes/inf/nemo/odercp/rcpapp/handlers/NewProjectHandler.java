package br.ufes.inf.nemo.odercp.rcpapp.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class NewProjectHandler {
	@Execute
	public void execute(Shell shell) {
		MessageDialog.openInformation(shell, "New", "New Project.");
	}
}
