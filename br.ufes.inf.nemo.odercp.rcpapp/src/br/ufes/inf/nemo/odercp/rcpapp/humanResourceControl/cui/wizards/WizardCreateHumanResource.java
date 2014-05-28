package br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cui.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cui.PageCreateHumanResource;

public class WizardCreateHumanResource extends Wizard {

	public WizardCreateHumanResource() {
		setWindowTitle("New Wizard");
	}

	@Override
	public void addPages() {
		addPage(new PageCreateHumanResource());
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
