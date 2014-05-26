package br.ufes.inf.nemo.odercp.rcpapp.userControl.cui.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.userControl.cmt.ApplNewPassword;
import br.ufes.inf.nemo.odercp.rcpapp.userControl.cui.PageNewPassword;

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
		return ApplNewPassword.CreateNewPassword(pagenewpassword
				.getTxtoldPassword().getText(), pagenewpassword
				.getTxtnewPassword().getText(), pagenewpassword
				.getTxtrepeatNewPassword().getText());
	}

}
