package br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cui.wizards;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.wb.swt.ResourceManager;

import br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cmt.ApplCreateProject;
import br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cui.PageCreateProject;

public class WizardCreateProject extends Wizard {
	protected WizardNewProjectCreationPage createProjectPage;
	protected PageCreateProject pagedescription;

	public WizardCreateProject() {
		setWindowTitle("Wizard Create Project");

		createProjectPage = new WizardNewProjectCreationPage("NewProjectPage");
		pagedescription = new PageCreateProject();

		Image img = ResourceManager.getPluginImage(
				"br.ufes.inf.nemo.odercp.rcpapp", "images/filenew.png");
		ImageDescriptor imagedesc = ImageDescriptor.createFromImage(img);
		super.setDefaultPageImageDescriptor(imagedesc);
	}

	@Override
	public void addPages() {
		createProjectPage.setTitle("Project");
		createProjectPage.setDescription("Create a new project resource.");
		addPage(createProjectPage);
		addPage(pagedescription);

	}

	@Override
	public boolean performFinish() {

		return ApplCreateProject.CreateNewProject(
				createProjectPage.getProjectName(),
				pagedescription.getDescription());
	}

}
