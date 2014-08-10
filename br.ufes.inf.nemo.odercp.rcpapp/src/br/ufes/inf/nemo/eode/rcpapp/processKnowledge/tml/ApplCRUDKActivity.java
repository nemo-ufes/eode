package br.ufes.inf.nemo.eode.rcpapp.processKnowledge.tml;

import java.util.HashSet;
import java.util.Set;

import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.pdl.KActivity;
import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.pdl.KArtefact;
import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.pdl.KHumanResource;
import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.pdl.KProcedure;
import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.pdl.KProcess;
import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.pdl.KResource;

public class ApplCRUDKActivity {

	public static KActivity[] getever() {
		KActivity[] everKActivity = new KActivity[5];
		KActivity aux;
		aux = new KActivity();
		aux.setName("Elicitacion");
		aux.setDescription("Elicitacion");
		
		aux.setKHumanResources(new HashSet<KHumanResource>());
		aux.setInputs(null);
		aux.setkProcedures(new HashSet<KProcedure>());
		aux.setkProcess(null);
		aux.setkResources(new HashSet<KResource>());
		aux.setMandatory(true);
		aux.setPreKActivities(null);
		aux.setProducts(new HashSet<KArtefact>());
		aux.setSubKActivities(null);
		everKActivity[0] = aux;

		aux = new KActivity();
		aux.setName("Modeling");
		aux.setDescription("Modeling");
		
		aux.setKHumanResources(new HashSet<KHumanResource>());
		aux.setInputs(null);
		aux.setkProcedures(new HashSet<KProcedure>());
		aux.setkProcess(null);
		aux.setkResources(new HashSet<KResource>());
		aux.setMandatory(true);
		aux.setPreKActivities(null);
		aux.setProducts(new HashSet<KArtefact>());
		aux.setSubKActivities(null);
		everKActivity[1] = aux;

		aux = new KActivity();
		aux.setName("Documetation");
		aux.setDescription("Documetation");
		
		aux.setKHumanResources(new HashSet<KHumanResource>());
		aux.setInputs(null);
		aux.setkProcedures(new HashSet<KProcedure>());
		aux.setkProcess(null);
		aux.setkResources(new HashSet<KResource>());
		aux.setMandatory(true);
		aux.setPreKActivities(null);
		aux.setProducts(new HashSet<KArtefact>());
		aux.setSubKActivities(null);
		everKActivity[2] = aux;

		aux = new KActivity();
		aux.setName("Coding");
		aux.setDescription("Coding");
		
		aux.setKHumanResources(new HashSet<KHumanResource>());
		aux.setInputs(null);
		aux.setkProcedures(new HashSet<KProcedure>());
		aux.setkProcess(null);
		aux.setkResources(new HashSet<KResource>());
		aux.setMandatory(true);
		aux.setPreKActivities(null);
		aux.setProducts(new HashSet<KArtefact>());
		aux.setSubKActivities(null);
		everKActivity[3] = aux;
		
		aux = new KActivity();
		aux.setName("Design");
		aux.setDescription("Design");
		
		aux.setKHumanResources(new HashSet<KHumanResource>());
		aux.setInputs(null);
		aux.setkProcedures(new HashSet<KProcedure>());
		aux.setkProcess(null);
		aux.setkResources(new HashSet<KResource>());
		aux.setMandatory(true);
		aux.setPreKActivities(null);
		aux.setProducts(new HashSet<KArtefact>());
		aux.setSubKActivities(null);
		everKActivity[4] = aux;

		aux = new KActivity();
		aux.setName("Test");
		aux.setDescription("Test");
		
		aux.setKHumanResources(new HashSet<KHumanResource>());
		aux.setInputs(null);
		aux.setkProcedures(new HashSet<KProcedure>());
		aux.setkProcess(null);
		aux.setkResources(new HashSet<KResource>());
		aux.setMandatory(true);
		aux.setPreKActivities(null);
		aux.setProducts(new HashSet<KArtefact>());
		aux.setSubKActivities(null);
		everKActivity[4] = aux;

		return everKActivity;
	}

	public static boolean createKActivity(String name, String description, Set<KHumanResource> humanResources, Set<KArtefact> inputs, Set<KProcedure> procedures, KProcess kProcess, Set<KResource> resources, Set<KActivity> preActivities, Set<KActivity> subActivities, boolean mandatory, Set<KArtefact> products) {
		KActivity activity = new KActivity();
		activity.setDescription(description);
		activity.setKHumanResources(humanResources);
		activity.setInputs(inputs);
		activity.setkProcedures(procedures);
		activity.setkProcess(kProcess);
		activity.setkResources(resources);
		activity.setMandatory(mandatory);
		activity.setName(name);
		activity.setPreKActivities(preActivities);
		activity.setSubKActivities(subActivities);
		return true;
	}
	
	public static boolean deleteKActivity(KActivity kActivity){
		return true;
	}
	
	public static boolean updateKActivity(KActivity kActivity){
		return true;
	}

}
