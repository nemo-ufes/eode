package br.ufes.inf.nemo.eode.rcpapp.humanResourceControl.uil.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.eode.rcpapp.humanResourceControl.tml.ApplCRUDHumanResource;
import br.ufes.inf.nemo.eode.rcpapp.humanResourceControl.uil.PageCreateHumanResource;

public class WizardCreateHumanResource extends Wizard {
	PageCreateHumanResource pageNewHumanResource = new PageCreateHumanResource();

	public WizardCreateHumanResource() {
		setWindowTitle("Wizard New Human Resource");
	}

	@Override
	public void addPages() {
		addPage(pageNewHumanResource);
	}

	@Override
	public boolean performFinish() {
		System.out.println(pageNewHumanResource.getKHR().getName());
		return ApplCRUDHumanResource.CreateHumanResource(pageNewHumanResource.getName(),
				pageNewHumanResource.getCheckActive().getSelection(), pageNewHumanResource.getPhone(),
				pageNewHumanResource.getWorkLoad(), pageNewHumanResource.getEmail(), pageNewHumanResource.getKHR());
	}

}
