package br.ufes.inf.nemo.eode.rcpapp.processKnowledge.uil.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.tml.ApplCRUDKSoftwareResource;
import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.uil.PageCreateKnowledge;

public class WizardCreateKSoftwareResource extends Wizard {
	private PageCreateKnowledge pageCreateKnowledge;

	public WizardCreateKSoftwareResource() {
		setWindowTitle("Wizard Create KSoftware Resource");
		pageCreateKnowledge = new PageCreateKnowledge();
	}

	@Override
	public void addPages() {
		addPage(pageCreateKnowledge);
	}

	@Override
	public boolean performFinish() {

		return ApplCRUDKSoftwareResource.createKSoftwareResource(pageCreateKnowledge.getName(), pageCreateKnowledge.getDescription());
	}

}
