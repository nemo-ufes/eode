package br.ufes.inf.nemo.eode.rcpapp.userControl.uil.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.eode.rcpapp.userControl.uil.PageNewPassword;
import br.ufes.inf.nemo.eode.rcpapp.userControl.tml.ApplCRUDUser;

public class WizardNewPassword extends Wizard {

	PageNewPassword pagenewpassword = new PageNewPassword();

	public WizardNewPassword() {
		setWindowTitle("Wizard new Password");
	}

	@Override
	public void addPages() {
		addPage(pagenewpassword);

	}

	@Override
	public boolean performFinish() {
		return ApplCRUDUser.CreateNewPassword(pagenewpassword.getTxtoldPassword().getText(), 
				pagenewpassword.getTxtnewPassword().getText(),
				pagenewpassword.getTxtrepeatNewPassword().getText());
	}

}
