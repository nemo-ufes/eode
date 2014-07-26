package br.ufes.inf.nemo.odercp.rcpapp.userControl.uil.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.userControl.mtl.ApplCRUDUser;
import br.ufes.inf.nemo.odercp.rcpapp.userControl.uil.PageNewPassword;

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
