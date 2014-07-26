package br.ufes.inf.nemo.odercp.rcpapp.userControl.uil.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.userControl.mtl.ApplCRUDUser;
import br.ufes.inf.nemo.odercp.rcpapp.userControl.uil.PageCreateUser;

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
		return ApplCRUDUser.CreateUser(pageCreateUser.getLogin(),
				pageCreateUser.getPassword(), pageCreateUser.getHumanResource(),
				pageCreateUser.getAcessProfile());
	}

}
