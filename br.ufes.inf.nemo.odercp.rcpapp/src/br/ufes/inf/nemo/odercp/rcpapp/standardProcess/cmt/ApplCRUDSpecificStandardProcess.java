package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cmt;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKActivity;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKHardwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKProcedure;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKProcess;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KProcedure;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KProcess;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KResource;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.ActivityStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.SpecificStandardProcess;

public class ApplCRUDSpecificStandardProcess {
	static Set<SpecificStandardProcess> specificStandardProcesses;
	static SpecificStandardProcess vectorsProcess[];

	public static SpecificStandardProcess[] getever() {

		if (specificStandardProcesses == null) specificStandardProcesses = new HashSet<SpecificStandardProcess>();
		if (!specificStandardProcesses.isEmpty()) {
			vectorsProcess = new SpecificStandardProcess[specificStandardProcesses.size()];
			Iterator<SpecificStandardProcess> it = specificStandardProcesses.iterator();
			int i = 0;
			while (it.hasNext()) {
				vectorsProcess[i] = it.next();
				i++;
			}
			return vectorsProcess;
		}
		return null;

	}

	public static boolean create(SpecificStandardProcess standardProcess) {
		if (specificStandardProcesses == null) specificStandardProcesses = new HashSet<SpecificStandardProcess>();
		specificStandardProcesses.add(standardProcess);
		return true;
	}

	public static void processos() {
		KProcess kProcesses[] = ApplCRUDKProcess.getever();
		SpecificStandardProcess specificStandardProcess;
		for (int i = 0; i < kProcesses.length; i++) {
			specificStandardProcess = new SpecificStandardProcess();
			specificStandardProcess.setkProcess(kProcesses[i]);
			if (kProcesses[i].getName().equals("Software Development")) {
				specificStandardProcess.setName(kProcesses[i].getName());
				specificStandardProcess.setDescription(kProcesses[i].getDescription());
				specificStandardProcess.setIsDefine(true);
				specificStandardProcess.setStandardProcessLifeCycleModels(ApplCRUDStandardProcessLifeCycleModel.standardProcessLifeCycleModels);
				HashSet<ActivityStandardProcess> macroActivityStandardProcesses = new HashSet<ActivityStandardProcess>();

				ActivityStandardProcess activityStandardProcess;
				HashSet<ActivityStandardProcess> activityStandardProcesses = new HashSet<ActivityStandardProcess>();
				HashSet<ActivityStandardProcess> preactivityStandardProcesses = new HashSet<ActivityStandardProcess>();
				HashSet<KArtefact> kArtefacts;
				HashSet<KResource> kResources;
				HashSet<KProcedure> kProcedures;

				activityStandardProcess = new ActivityStandardProcess();
				activityStandardProcess.setName("capture requirements");
				activityStandardProcess.setDescription("capture requirements");
				activityStandardProcess.setMandatory(true);
				activityStandardProcess.setStandardProcess(specificStandardProcess);
				// tipo de atividade elecitation
				activityStandardProcess.setkActivity(ApplCRUDKActivity.getever()[0]);
				activityStandardProcess.setInputs(null);
				activityStandardProcess.setProducts(null);
				activityStandardProcess.setPreActivityStandardProcesses(null);
				activityStandardProcess.setkResources(null);
				activityStandardProcess.setkProcedures(null);
				HashSet<KHumanResource> kHumanResources = new HashSet<KHumanResource>();
				kHumanResources.add(ApplCRUDKHumanResource.getever()[0]);
				kHumanResources.add(ApplCRUDKHumanResource.getever()[3]);
				activityStandardProcess.setkHumanResources(kHumanResources);
				activityStandardProcesses.add(activityStandardProcess);
				preactivityStandardProcesses = new HashSet<ActivityStandardProcess>();
				preactivityStandardProcesses.add(activityStandardProcess);

				activityStandardProcess = new ActivityStandardProcess();
				activityStandardProcess.setName("requirements modeling");
				activityStandardProcess.setDescription("requirements modeling");
				activityStandardProcess.setMandatory(true);
				activityStandardProcess.setStandardProcess(specificStandardProcess);
				// tipo de atividade elecitation
				activityStandardProcess.setkActivity(ApplCRUDKActivity.getever()[0]);
				activityStandardProcess.setInputs(null);
				activityStandardProcess.setProducts(null);
				activityStandardProcess.setPreActivityStandardProcesses(preactivityStandardProcesses);
				activityStandardProcess.setkResources(null);
				activityStandardProcess.setkProcedures(null);
				kHumanResources = new HashSet<KHumanResource>();
				kHumanResources.add(ApplCRUDKHumanResource.getever()[0]);
				activityStandardProcess.setkHumanResources(kHumanResources);
				activityStandardProcesses.add(activityStandardProcess);
				preactivityStandardProcesses = new HashSet<ActivityStandardProcess>();
				preactivityStandardProcesses.add(activityStandardProcess);

				activityStandardProcess = new ActivityStandardProcess();
				activityStandardProcess.setName("Requirements documentation");
				activityStandardProcess.setDescription("Requirements documentation");
				activityStandardProcess.setMandatory(true);
				activityStandardProcess.setStandardProcess(specificStandardProcess);
				// tipo de atividade elecitation
				activityStandardProcess.setkActivity(ApplCRUDKActivity.getever()[0]);
				activityStandardProcess.setInputs(null);
				kArtefacts = new HashSet<KArtefact>();
				kArtefacts.add(ApplCRUDKArtefact.getever()[0]);
				activityStandardProcess.setProducts(kArtefacts);
				activityStandardProcess.setPreActivityStandardProcesses(preactivityStandardProcesses);
				activityStandardProcess.setkResources(null);
				activityStandardProcess.setkProcedures(null);
				kHumanResources = new HashSet<KHumanResource>();
				kHumanResources.add(ApplCRUDKHumanResource.getever()[0]);
				activityStandardProcess.setkHumanResources(kHumanResources);
				activityStandardProcesses.add(activityStandardProcess);

				activityStandardProcess = new ActivityStandardProcess();
				activityStandardProcess.setName("Requirements Elicitation");
				activityStandardProcess.setDescription("Requirements Elicitation");
				activityStandardProcess.setMandatory(true);
				activityStandardProcess.setStandardProcess(specificStandardProcess);
				// tipo de atividade elecitation
				activityStandardProcess.setkActivity(ApplCRUDKActivity.getever()[0]);
				activityStandardProcess.setInputs(null);
				kArtefacts = new HashSet<KArtefact>();
				kArtefacts.add(ApplCRUDKArtefact.getever()[0]);
				activityStandardProcess.setProducts(kArtefacts);
				activityStandardProcess.setPreActivityStandardProcesses(null);
				kResources = new HashSet<KResource>();
				kResources.add(ApplCRUDKHardwareResource.getever()[0]);
				activityStandardProcess.setkResources(kResources);
				kProcedures = new HashSet<KProcedure>();
				kProcedures.add(ApplCRUDKProcedure.getever()[0]);
				activityStandardProcess.setkProcedures(kProcedures);
				kHumanResources = new HashSet<KHumanResource>();
				kHumanResources.add(ApplCRUDKHumanResource.getever()[0]);
				kHumanResources.add(ApplCRUDKHumanResource.getever()[3]);
				activityStandardProcess.setkHumanResources(kHumanResources);
				activityStandardProcess.setSubActivityStandardProcesses(activityStandardProcesses);
				// activityStandardProcesses.add(activityStandardProcess);
				ActivityStandardProcess preActivityStandardProcess = activityStandardProcess;
				macroActivityStandardProcesses.add(activityStandardProcess);

				// Analysis
				activityStandardProcesses = new HashSet<ActivityStandardProcess>();
				preactivityStandardProcesses = new HashSet<ActivityStandardProcess>();

				activityStandardProcess = new ActivityStandardProcess();
				activityStandardProcess.setName("requirements modeling");
				activityStandardProcess.setDescription("requirements modeling");
				activityStandardProcess.setMandatory(true);
				activityStandardProcess.setStandardProcess(specificStandardProcess);
				// tipo de atividade elecitation
				activityStandardProcess.setkActivity(ApplCRUDKActivity.getever()[1]);
				kArtefacts = new HashSet<KArtefact>();
				kArtefacts.add(ApplCRUDKArtefact.getever()[0]);
				activityStandardProcess.setInputs(kArtefacts);
				activityStandardProcess.setProducts(null);
				activityStandardProcess.setPreActivityStandardProcesses(preactivityStandardProcesses);
				kResources = new HashSet<KResource>();
				kResources.add(ApplCRUDKHardwareResource.getever()[0]);
				activityStandardProcess.setkResources(kResources);
				kProcedures = new HashSet<KProcedure>();
				kProcedures.add(ApplCRUDKProcedure.getever()[1]);
				activityStandardProcess.setkProcedures(kProcedures);
				kHumanResources = new HashSet<KHumanResource>();
				kHumanResources.add(ApplCRUDKHumanResource.getever()[0]);
				activityStandardProcess.setkHumanResources(kHumanResources);
				activityStandardProcesses.add(activityStandardProcess);
				preactivityStandardProcesses = new HashSet<ActivityStandardProcess>();
				preactivityStandardProcesses.add(activityStandardProcess);

				activityStandardProcess = new ActivityStandardProcess();
				activityStandardProcess.setName("modeling documentation");
				activityStandardProcess.setDescription("modeling documentation");
				activityStandardProcess.setMandatory(true);
				activityStandardProcess.setStandardProcess(specificStandardProcess);
				// tipo de atividade elecitation
				activityStandardProcess.setkActivity(ApplCRUDKActivity.getever()[2]);
				kArtefacts = new HashSet<KArtefact>();
				kArtefacts.add(ApplCRUDKArtefact.getever()[0]);
				activityStandardProcess.setInputs(kArtefacts);
				kArtefacts = new HashSet<KArtefact>();
				kArtefacts.add(ApplCRUDKArtefact.getever()[1]);
				activityStandardProcess.setProducts(kArtefacts);
				preactivityStandardProcesses = new HashSet<ActivityStandardProcess>();
				preactivityStandardProcesses.add(preActivityStandardProcess);
				activityStandardProcess.setPreActivityStandardProcesses(preactivityStandardProcesses);
				kResources = new HashSet<KResource>();
				kResources.add(ApplCRUDKHardwareResource.getever()[0]);
				activityStandardProcess.setkResources(kResources);
				kProcedures = new HashSet<KProcedure>();
				kProcedures.add(ApplCRUDKProcedure.getever()[1]);
				activityStandardProcess.setkProcedures(kProcedures);
				kHumanResources = new HashSet<KHumanResource>();
				kHumanResources.add(ApplCRUDKHumanResource.getever()[0]);
				activityStandardProcess.setkHumanResources(kHumanResources);
				activityStandardProcesses.add(activityStandardProcess);
				preactivityStandardProcesses = new HashSet<ActivityStandardProcess>();
				preactivityStandardProcesses.add(activityStandardProcess);

				activityStandardProcess = new ActivityStandardProcess();
				activityStandardProcess.setName("Analysis");
				activityStandardProcess.setDescription("Analysis");
				activityStandardProcess.setMandatory(true);
				activityStandardProcess.setStandardProcess(specificStandardProcess);
				// tipo de atividade elecitation
				activityStandardProcess.setkActivity(ApplCRUDKActivity.getever()[1]);
				kArtefacts = new HashSet<KArtefact>();
				kArtefacts.add(ApplCRUDKArtefact.getever()[0]);
				activityStandardProcess.setInputs(kArtefacts);
				kArtefacts = new HashSet<KArtefact>();
				kArtefacts.add(ApplCRUDKArtefact.getever()[1]);
				kResources = new HashSet<KResource>();
				kResources.add(ApplCRUDKHardwareResource.getever()[0]);
				activityStandardProcess.setkResources(kResources);
				kProcedures = new HashSet<KProcedure>();
				kProcedures.add(ApplCRUDKProcedure.getever()[0]);
				activityStandardProcess.setkProcedures(kProcedures);
				kHumanResources = new HashSet<KHumanResource>();
				kHumanResources.add(ApplCRUDKHumanResource.getever()[0]);
				activityStandardProcess.setkHumanResources(kHumanResources);
				activityStandardProcess.setSubActivityStandardProcesses(activityStandardProcesses);
				preactivityStandardProcesses = new HashSet<ActivityStandardProcess>();
				preactivityStandardProcesses.add(preActivityStandardProcess);
				activityStandardProcess.setPreActivityStandardProcesses(preactivityStandardProcesses);
				// activityStandardProcesses.add(activityStandardProcess);
				preActivityStandardProcess = activityStandardProcess;
				
				//Design
			}

		}
	}
}
