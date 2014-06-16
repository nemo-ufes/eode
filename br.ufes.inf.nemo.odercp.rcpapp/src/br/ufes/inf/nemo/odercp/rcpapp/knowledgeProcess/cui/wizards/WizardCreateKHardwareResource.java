package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKHardwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.PageCreateKnowledge;

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
