package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.wizards;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KActivity;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KProcedure;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KProcess;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml.ApplCRUDKActivity;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.PageCreateKActivityChoiceKArtefactinputs;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.PageCreateKActivityChoiceKArtefactproducts;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.PageCreateKActivityChoiceKHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.PageCreateKActivityChoiceKProcedures;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.PageCreateKActivityChoiceKProcess;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.PageCreateKActivityChoiceKResources;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.PageCreateKActivityChoicepreKActivity;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.PageCreateKActivityChoicesubKActivity;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.PageCreateKnowledge;

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
		Set<KProcedure> kprocedures = new HashSet<KProcedure>();
		Set<KResource> kresources = new HashSet<KResource>();
		Set<KArtefact> inputs = new HashSet<KArtefact>();
		Set<KArtefact> products = new HashSet<KArtefact>();
		Set<KActivity> preKActivities = new HashSet<KActivity>();
		Set<KActivity> subKActivities = new HashSet<KActivity>();
		KProcess kProcess = new KProcess();
		Set<KHumanResource> kHumanResources = new HashSet<KHumanResource>();

		/** to kProcedures */
		for (int i = 0; i < pageCreateKActivityChoiceKProcedures.getChecks().length; i++) {
			if (pageCreateKActivityChoiceKProcedures.getChecks()[i].getSelection() == true) {
				kprocedures.add(pageCreateKActivityChoiceKProcedures.getHashkProcedures().get(pageCreateKActivityChoiceKProcedures.getChecks()[i].getText()));
			}
		}

		/** to kResources */
		for (int i = 0; i < pageCreateKActivityChoiceKResources.getChecks().length; i++) {
			if (pageCreateKActivityChoiceKResources.getChecks()[i].getSelection() == true) {
				kresources.add(pageCreateKActivityChoiceKResources.getHashkResources().get(pageCreateKActivityChoiceKResources.getChecks()[i].getText()));
			}
		}

		/** to kArtefacts inputs */
		for (int i = 0; i < pageCreateKActivityChoiceKArtefactinputs.getChecks().length; i++) {
			if (pageCreateKActivityChoiceKArtefactinputs.getChecks()[i].getSelection() == true) {
				inputs.add(pageCreateKActivityChoiceKArtefactinputs.getHashinputs().get(pageCreateKActivityChoiceKArtefactinputs.getChecks()[i].getText()));
			}
		}

		/** to kArtefacts products */
		for (int i = 0; i < pageCreateKActivityChoiceKArtefactproducts.getChecks().length; i++) {
			if (pageCreateKActivityChoiceKArtefactproducts.getChecks()[i].getSelection() == true) {
				products.add(pageCreateKActivityChoiceKArtefactproducts.getHashproducts().get(pageCreateKActivityChoiceKArtefactproducts.getChecks()[i].getText()));
			}
		}

		/** to preKActivities */
		for (int i = 0; i < pageCreateKActivityChoicepreKActivity.getChecks().length; i++) {
			if (pageCreateKActivityChoicepreKActivity.getChecks()[i].getSelection() == true) {
				preKActivities.add(pageCreateKActivityChoicepreKActivity.getHashpreKactivities().get(pageCreateKActivityChoicepreKActivity.getChecks()[i].getText()));
			}
		}

		/** to subKActivities */
		for (int i = 0; i < pageCreateKActivityChoicesubKActivity.getChecks().length; i++) {
			if (pageCreateKActivityChoicesubKActivity.getChecks()[i].getSelection() == true) {
				subKActivities.add(pageCreateKActivityChoicesubKActivity.getHashsubActivities().get(pageCreateKActivityChoicesubKActivity.getChecks()[i].getText()));
			}
		}

		/** to KHumanResources */
		for (int i = 0; i < pageCreateKActivityChoiceKHumanResource.getChecks().length; i++) {
			if (pageCreateKActivityChoiceKHumanResource.getChecks()[i].getSelection() == true) {
				kHumanResources.add(pageCreateKActivityChoiceKHumanResource.getHashKhumanResources().get(pageCreateKActivityChoiceKHumanResource.getChecks()[i].getText()));
			}
		}

		/** to KProcess */
		boolean found = false;
		for (int i = 0; i < pageCreateKActivityChoiceKProcess.getRadios().length && found == false; i++) {
			if (pageCreateKActivityChoiceKProcess.getRadios()[i].getSelection() == true) {
				kProcess = pageCreateKActivityChoiceKProcess.getHashKprocesses().get(pageCreateKActivityChoiceKProcess.getRadios()[i].getText());
				found = true;
			}
		}

		return ApplCRUDKActivity.createKActivity(pageCreateKnowledge.getName(), pageCreateKnowledge.getDescription(), kHumanResources, inputs, kprocedures, kProcess, kresources, preKActivities, subKActivities, pageCreateKnowledge.getBtnMandatory().getSelection(), products);

	}
}
