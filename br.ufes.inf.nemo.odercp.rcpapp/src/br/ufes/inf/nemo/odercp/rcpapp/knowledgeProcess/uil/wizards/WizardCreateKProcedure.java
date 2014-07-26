package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.mtl.ApplCRUDKProcedure;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.PageCreateKnowledge;

public class WizardCreateKProcedure extends Wizard {
	private PageCreateKnowledge pageCreateKnowledge;

	public WizardCreateKProcedure() {
		setWindowTitle("Wizard Create KProcess");
		pageCreateKnowledge = new PageCreateKnowledge();
	}

	@Override
	public void addPages() {
		addPage(pageCreateKnowledge);
	}

	@Override
	public boolean performFinish() {

		return ApplCRUDKProcedure.createKProcedure(pageCreateKnowledge.getName(),
				pageCreateKnowledge.getDescription());
	}

}
