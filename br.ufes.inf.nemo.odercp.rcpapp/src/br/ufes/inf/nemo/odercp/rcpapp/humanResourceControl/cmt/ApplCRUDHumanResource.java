package br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cmt;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cpd.HumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;

/**
 * Applications Create,Read,Update and Delete of Human Resource in database ODE.
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class ApplCRUDHumanResource {

	/**
	 * Create a HR(Human Resource) in Database ODE.
	 * 
	 * @param name
	 *            Name of people that will be HR.
	 * @param active
	 *            boolean if HR is active or not.
	 * @param phone
	 *            phone of HR.
	 * @param workLoad
	 *            workLoad of HR.
	 * @param email
	 *            email of HR.
	 * @param kHumanResource
	 *            role that is KHumanResource registered in database ODE.
	 * @return True if Create human Resource is OK else false.
	 */

	public static boolean CreateHumanResource(String name, boolean active,
			String phone, Integer workLoad, String email,
			KHumanResource kHumanResource) {
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
		HumanResource[] h = new HumanResource[3];
		KHumanResource[] k = new KHumanResource[4];
		k = ApplCRUDKHumanResource.getever();
		HumanResource humanResource = new HumanResource();
		humanResource.setActive(true);
		humanResource.setEmail("danillo@ode.com");
		humanResource.setName("Danillo Ricardo Celino");
		humanResource.setPhone("33332222");
		humanResource.setRole(k[0]);
		humanResource.setWorkLoad(40);
		h[0] = humanResource;

		humanResource = new HumanResource();
		humanResource.setActive(true);
		humanResource.setEmail("joao@ode.com");
		humanResource.setName("Joao Ribeiro");
		humanResource.setPhone("11112222");
		humanResource.setRole(k[1]);
		humanResource.setWorkLoad(40);
		h[1] = humanResource;

		humanResource = new HumanResource();
		humanResource.setActive(true);
		humanResource.setEmail("ricardo@ode.com");
		humanResource.setName("Ricardo de Almeida Falbo ");
		humanResource.setPhone("44445555");
		humanResource.setRole(k[2]);
		humanResource.setWorkLoad(40);
		h[2] = humanResource;

		return h;

	}

	public static void delete(HumanResource chosenHR) {
		System.out.println(chosenHR.getName());
	}

	public static void update(HumanResource chosenHR) {
		System.out.println(chosenHR.getName());

	}

}
