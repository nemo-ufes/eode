package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKProcess;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.PageCreateKnowledge;

public class WizardCreateKProcess extends Wizard {
	private PageCreateKnowledge pageCreateKnowledge;

	public WizardCreateKProcess() {
		setWindowTitle("Wizard Create KProcedure");
		pageCreateKnowledge = new PageCreateKnowledge();
	}

	@Override
	public void addPages() {
		addPage(pageCreateKnowledge);
	}

	@Override
	public boolean performFinish() {

		return ApplCRUDKProcess.createKProcess(pageCreateKnowledge.getName(), pageCreateKnowledge.getDescription(), pageCreateKnowledge.getBtnIsEng().getSelection());
	}

}
