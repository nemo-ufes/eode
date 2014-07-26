package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.mtl.ApplCRUDKLifeCycleModel;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.PageCreateKnowledge;

public class WizardCreateKLifeCycleModel extends Wizard {
	private PageCreateKnowledge pageCreateKnowledge;

	public WizardCreateKLifeCycleModel() {
		setWindowTitle("Wizard Create KLife-Cycle Model");
		pageCreateKnowledge = new PageCreateKnowledge();
	}

	@Override
	public void addPages() {
		addPage(pageCreateKnowledge);
	}

	@Override
	public boolean performFinish() {

		return ApplCRUDKLifeCycleModel.createKLifeCycleModel(pageCreateKnowledge.getName(), pageCreateKnowledge.getDescription());
	}

}
