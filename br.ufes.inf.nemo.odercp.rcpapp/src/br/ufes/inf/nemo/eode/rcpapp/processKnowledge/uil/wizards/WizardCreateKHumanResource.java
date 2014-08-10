package br.ufes.inf.nemo.eode.rcpapp.processKnowledge.uil.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.tml.ApplCRUDKHumanResource;
import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.uil.PageCreateKnowledge;

public class WizardCreateKHumanResource extends Wizard {
	private PageCreateKnowledge pageCreateKnowledge;

	public WizardCreateKHumanResource() {
		setWindowTitle("Wizard Create KHuman Resource");
		pageCreateKnowledge = new PageCreateKnowledge();
	}

	@Override
	public void addPages() {
		addPage(pageCreateKnowledge);
	}

	@Override
	public boolean performFinish() {

		return ApplCRUDKHumanResource.createKHumanResource(pageCreateKnowledge.getName(), 
				pageCreateKnowledge.getDescription());
	}

}
