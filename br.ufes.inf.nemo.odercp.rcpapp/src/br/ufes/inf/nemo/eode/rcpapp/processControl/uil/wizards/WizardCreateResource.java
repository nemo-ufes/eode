package br.ufes.inf.nemo.eode.rcpapp.processControl.uil.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.eode.rcpapp.processControl.pdl.HardwareResource;
import br.ufes.inf.nemo.eode.rcpapp.processControl.pdl.Resource;
import br.ufes.inf.nemo.eode.rcpapp.processControl.pdl.SoftwareResource;
import br.ufes.inf.nemo.eode.rcpapp.processControl.tml.ApplCRUDHardwareResource;
import br.ufes.inf.nemo.eode.rcpapp.processControl.tml.ApplCRUDSoftwareResource;
import br.ufes.inf.nemo.eode.rcpapp.processControl.uil.PageCreateResource;
import br.ufes.inf.nemo.eode.rcpapp.processControl.uil.PageCreateResourceChoiceKResources;
import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.pdl.KHardwareResource;
import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.pdl.KSoftwareResource;

public class WizardCreateResource extends Wizard {

	PageCreateResource pageCreateResource;
	PageCreateResourceChoiceKResources pageCreateResourceChoiceKResources;

	public WizardCreateResource() {
		setWindowTitle(" Wizard Create Resource");
		pageCreateResource = new PageCreateResource();
		pageCreateResourceChoiceKResources = new PageCreateResourceChoiceKResources();
	}

	@Override
	public void addPages() {
		addPage(pageCreateResource);
		addPage(pageCreateResourceChoiceKResources);
	}

	@Override
	public boolean performFinish() {
		Resource resource = new Resource();

		for (int i = 0; i < pageCreateResourceChoiceKResources.getRadios().length; i++) {
			if (pageCreateResourceChoiceKResources.getRadios()[i]
					.getSelection()) {

				resource.setkResource(pageCreateResourceChoiceKResources
						.getHashkResources()
						.get(pageCreateResourceChoiceKResources.getRadios()[i]
								.getText()));

			}
		}

		if (resource.getkResource() instanceof KHardwareResource) {
			HardwareResource hardwareResource = new HardwareResource();
			hardwareResource.setName(pageCreateResource.getTxtname().getText());
			hardwareResource.setkResource(resource.getkResource());
			return ApplCRUDHardwareResource.Create(hardwareResource);
		} else if (resource.getkResource() instanceof KSoftwareResource) {
			SoftwareResource softwareResource = new SoftwareResource();
			softwareResource.setName(pageCreateResource.getTxtname().getText());
			softwareResource.setkResource(resource.getkResource());
			return ApplCRUDSoftwareResource.Create(softwareResource);

		}
		return false;
	}
}
