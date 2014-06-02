package br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cmt;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cpd.HumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;

public class ApplCRUDHumanResource {

	public static boolean CreateHumanResource(String name, boolean active, String phone, Integer workLoad, String email, KHumanResource kHumanResource) {
		HumanResource humanResource = new HumanResource();
		humanResource.setActive(active);
		humanResource.setEmail(email);
		humanResource.setName(name);
		humanResource.setPhone(phone);
		humanResource.setRole(kHumanResource);
		humanResource.setWorkLoad(workLoad);
		return true;
	}

	public static HumanResource[] getever() {
		HumanResource[] h = new HumanResource[2];
		KHumanResource[] k = new KHumanResource[4];
		k = ApplCRUDKHumanResource.getever();
		HumanResource humanResource = new HumanResource();
		humanResource.setActive(true);
		humanResource.setEmail("dfdfdfd");
		humanResource.setName("Danillo Ric");
		humanResource.setPhone("2431234123");
		humanResource.setRole(k[0]);
		humanResource.setWorkLoad(40);
		h[0] = humanResource;

		humanResource = new HumanResource();
		humanResource.setActive(true);
		humanResource.setEmail("sdfsdf");
		humanResource.setName("Daniel Ric");
		humanResource.setPhone("233334123");
		humanResource.setRole(k[1]);
		humanResource.setWorkLoad(40);
		h[1] = humanResource;
		
		return h;

	}

	public static void delete(HumanResource chosenHR) {
		// TODO Auto-generated method stub
		
	}

	public static void update(HumanResource chosenHR) {
		// TODO Auto-generated method stub
		
	}

}
