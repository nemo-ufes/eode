package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml.ApplCRUDKHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.PageCreateKnowledge;

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
