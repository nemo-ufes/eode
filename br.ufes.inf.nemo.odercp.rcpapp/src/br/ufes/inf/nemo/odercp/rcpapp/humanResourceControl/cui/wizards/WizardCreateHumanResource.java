package br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cui.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cmt.ApplCRUDHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cui.PageNewHumanResource;

public class WizardCreateHumanResource extends Wizard {
	PageNewHumanResource pageNewHumanResource = new PageNewHumanResource();

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
