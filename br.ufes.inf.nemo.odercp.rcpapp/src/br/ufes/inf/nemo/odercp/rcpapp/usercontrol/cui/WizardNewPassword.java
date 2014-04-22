/**
 * 
 */
package br.ufes.inf.nemo.odercp.rcpapp.usercontrol.cui;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
import org.eclipse.jface.wizard.Wizard;
import br.ufes.inf.nemo.odercp.rcpapp.usercontrol.cmt.ApplNewPassword;

public class WizardNewPassword extends Wizard {

	protected PageNewPassword pagenewpassword;

	public WizardNewPassword() {
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
		
		return ApplNewPassword.CreateNewPassword(pagenewpassword
				.getTxtoldPassword().getText(), pagenewpassword
				.getTxtnewPassword().getText(), pagenewpassword
				.getTxtrepeatNewPassword().getText());
	}

}
