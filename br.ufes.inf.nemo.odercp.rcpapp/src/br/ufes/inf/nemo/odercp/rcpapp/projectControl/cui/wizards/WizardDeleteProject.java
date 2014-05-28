package br.ufes.inf.nemo.odercp.rcpapp.projectControl.cui.wizards;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.ResourceManager;

import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cmt.ApplCRUDProject;
import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cui.PageDeleteProject;

public class WizardDeleteProject extends Wizard {
	protected PageDeleteProject pagedeleteProject;

	public WizardDeleteProject() {
		setWindowTitle("Wizard Delete Project");
		pagedeleteProject = new PageDeleteProject();

		Image img = ResourceManager.getPluginImage(
				"br.ufes.inf.nemo.odercp.rcpapp", "images/editdelete.png");
		ImageDescriptor imagedesc = ImageDescriptor.createFromImage(img);
		super.setDefaultPageImageDescriptor(imagedesc);
	}

	@Override
	public void addPages() {
		addPage(pagedeleteProject);
	}

	@Override
	public boolean performFinish() {
		return ApplCRUDProject.deleteProject(pagedeleteProject
				.getChosenProject());
	}

}
