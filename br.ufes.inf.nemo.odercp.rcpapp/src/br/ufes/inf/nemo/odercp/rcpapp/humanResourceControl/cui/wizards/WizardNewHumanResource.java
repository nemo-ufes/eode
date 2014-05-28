package br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cui.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cui.PageNewHumanResource;

public class WizardNewHumanResource extends Wizard {
	PageNewHumanResource pageNewHumanResource = new PageNewHumanResource();

	public WizardNewHumanResource() {
		setWindowTitle("Wizard New Human Resource");
	}

	@Override
	public void addPages() {
		addPage(pageNewHumanResource);
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
