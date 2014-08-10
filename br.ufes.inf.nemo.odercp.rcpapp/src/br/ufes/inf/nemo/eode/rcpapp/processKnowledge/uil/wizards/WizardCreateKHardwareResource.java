package br.ufes.inf.nemo.eode.rcpapp.processKnowledge.uil.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.tml.ApplCRUDKHardwareResource;
import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.uil.PageCreateKnowledge;

public class WizardCreateKHardwareResource extends Wizard {
	private PageCreateKnowledge pageCreateKnowledge;

	public WizardCreateKHardwareResource() {
		setWindowTitle("Wizard Create KHardware Resource");
		pageCreateKnowledge = new PageCreateKnowledge();
	}

	@Override
	public void addPages() {
		addPage(pageCreateKnowledge);
	}

	@Override
	public boolean performFinish() {
		return ApplCRUDKHardwareResource.createKHardwareResource(pageCreateKnowledge.getName(),
				pageCreateKnowledge.getDescription());
	}

}
