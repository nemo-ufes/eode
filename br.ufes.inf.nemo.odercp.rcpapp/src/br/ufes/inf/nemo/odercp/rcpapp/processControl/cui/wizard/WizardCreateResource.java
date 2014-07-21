package br.ufes.inf.nemo.odercp.rcpapp.processControl.cui.wizard;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.processControl.cmt.ApplCRUDHardwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cmt.ApplCRUDSoftwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.HardwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.Resource;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.SoftwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cui.PageCreateResource;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cui.PageCreateResourceChoiceKResources;

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
		Resource resource = null;

		for (int i = 0; i < pageCreateResourceChoiceKResources.getRadios().length; i++) {
			if (pageCreateResourceChoiceKResources.getRadios()[i]
					.getSelection()) {

				resource.setkResource(pageCreateResourceChoiceKResources
						.getHashkResources()
						.get(pageCreateResourceChoiceKResources.getRadios()[i]
								.getText()));

				continue;
			}
		}

		if (resource instanceof HardwareResource) {
			HardwareResource hardwareResource = (HardwareResource) resource;
			hardwareResource.setName(pageCreateResource.getTxtname().getText());
			return ApplCRUDHardwareResource.Create(hardwareResource);
		} else if (resource instanceof SoftwareResource) {
			SoftwareResource softwareResource = (SoftwareResource) resource;
			softwareResource.setName(pageCreateResource.getTxtname().getText());
			return ApplCRUDSoftwareResource.Create(softwareResource);

		}
		return false;
	}
}
