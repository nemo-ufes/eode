/**
 * 
 */
package br.ufes.inf.nemo.odercp.rcpapp.usercontrol.cui;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cmt.ApplRegisterProject;

public class WizardRegisterProject extends Wizard {

	protected PageNewPassword pagenewpassword;

	public WizardRegisterProject() {
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		pagenewpassword = new PageNewPassword();
		addPage(pagenewpassword);
	}

	@Override
	public boolean performFinish() {
		// Print the result to the console
		return true;
	}
	
}
