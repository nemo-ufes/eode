package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.PageCreateKActivityChoiceKArtefactinputs;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.PageCreateKActivityChoiceKArtefactproducts;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.PageCreateKActivityChoiceKHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.PageCreateKActivityChoiceKProcedures;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.PageCreateKActivityChoiceKProcess;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.PageCreateKActivityChoiceKResources;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.PageCreateKActivityChoicepreKActivity;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.PageCreateKActivityChoicesubKActivity;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.PageCreateKnowledge;

public class WizardCreateKActivity extends Wizard {
	private PageCreateKnowledge pageCreateKnowledge;
	private PageCreateKActivityChoiceKArtefactinputs pageCreateKActivityChoiceKArtefactinputs;
	private PageCreateKActivityChoiceKProcedures pageCreateKActivityChoiceKProcedures;
	private PageCreateKActivityChoiceKArtefactproducts pageCreateKActivityChoiceKArtefactproducts;
	private PageCreateKActivityChoicepreKActivity pageCreateKActivityChoicepreKActivity;
	private PageCreateKActivityChoiceKHumanResource pageCreateKActivityChoiceKHumanResource;
	private PageCreateKActivityChoiceKProcess pageCreateKActivityChoiceKProcess;
	private PageCreateKActivityChoiceKResources pageCreateKActivityChoiceKResources;
	private PageCreateKActivityChoicesubKActivity pageCreateKActivityChoicesubKActivity;

	public WizardCreateKActivity() {
		setWindowTitle("Wizard Create KActivity");
		pageCreateKnowledge = new PageCreateKnowledge();
		pageCreateKActivityChoiceKProcedures = new PageCreateKActivityChoiceKProcedures();
		pageCreateKActivityChoiceKResources = new PageCreateKActivityChoiceKResources();
		pageCreateKActivityChoiceKArtefactinputs = new PageCreateKActivityChoiceKArtefactinputs();
		pageCreateKActivityChoiceKArtefactproducts = new PageCreateKActivityChoiceKArtefactproducts();
		pageCreateKActivityChoiceKHumanResource = new PageCreateKActivityChoiceKHumanResource();
		pageCreateKActivityChoiceKProcess = new PageCreateKActivityChoiceKProcess();
		pageCreateKActivityChoicepreKActivity = new PageCreateKActivityChoicepreKActivity();
		pageCreateKActivityChoicesubKActivity = new PageCreateKActivityChoicesubKActivity();

	}

	@Override
	public void addPages() {
		addPage(pageCreateKnowledge);
		addPage(pageCreateKActivityChoiceKProcedures);
		addPage(pageCreateKActivityChoiceKResources);
		addPage(pageCreateKActivityChoiceKArtefactinputs);
		addPage(pageCreateKActivityChoiceKArtefactproducts);
		addPage(pageCreateKActivityChoicepreKActivity);
		addPage(pageCreateKActivityChoicesubKActivity);
		addPage(pageCreateKActivityChoiceKProcess);
		addPage(pageCreateKActivityChoiceKHumanResource);
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
