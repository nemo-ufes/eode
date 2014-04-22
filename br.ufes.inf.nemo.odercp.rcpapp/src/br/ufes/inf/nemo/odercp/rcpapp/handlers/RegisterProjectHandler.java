package br.ufes.inf.nemo.odercp.rcpapp.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.swt.widgets.Shell;

import br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cui.PageRegisterProject;


public class RegisterProjectHandler {
	@Execute
	public void execute(IWorkbench workbench, Shell shell) {
		PageRegisterProject page = new PageRegisterProject();
		page.open(shell);
		
	}
}
