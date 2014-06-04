package br.ufes.inf.nemo.odercp.rcpapp.userControl.cui.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.userControl.cui.PageCreateUser;

public class WizardCreateUser extends Wizard {
	PageCreateUser pageCreateUser;

	public WizardCreateUser() {
		setWindowTitle("Wizard Create User");
		pageCreateUser = new PageCreateUser();
	}

	@Override
	public void addPages() {
		addPage(pageCreateUser);
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
