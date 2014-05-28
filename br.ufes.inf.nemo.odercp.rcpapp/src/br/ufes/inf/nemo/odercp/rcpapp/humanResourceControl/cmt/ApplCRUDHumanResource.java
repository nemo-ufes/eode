package br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cmt;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cpd.HumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;

public class ApplCRUDHumanResource {

	public boolean NewHumanResource(String name, boolean active, String phone, Integer workLoad, String email, KHumanResource kHumanResource) {
		HumanResource humanResource = new HumanResource();
		humanResource.setActive(active);
		humanResource.setEmail(email);
		humanResource.setName(name);
		humanResource.setPhone(phone);
		humanResource.setRole(kHumanResource);
		humanResource.setWorkLoad(workLoad);
		return true;
	}

}
