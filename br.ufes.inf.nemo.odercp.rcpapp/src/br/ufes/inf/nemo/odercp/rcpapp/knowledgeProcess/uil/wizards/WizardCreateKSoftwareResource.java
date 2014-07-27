package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml.ApplCRUDKSoftwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.PageCreateKnowledge;

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
