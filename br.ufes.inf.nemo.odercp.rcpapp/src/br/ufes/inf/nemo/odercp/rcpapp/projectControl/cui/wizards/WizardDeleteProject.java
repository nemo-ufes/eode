package br.ufes.inf.nemo.odercp.rcpapp.projectControl.cui.wizards;

import java.util.HashMap;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.ResourceManager;

import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cmt.ApplCRUDProject;
import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cpd.Project;
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
		Button[] radios = pagedeleteProject.getRadios();
		if (radios.length > 0) {
			HashMap<String, Project> hashProjects = ApplCRUDProject.geteverProjectsWorkspace();
			int i = 0;
			while (!radios[i].getSelection()) {
				i++;
			}
			ApplCRUDProject.deleteProject(hashProjects.get(radios[i].getText()));
			return true;
		}
		return false;
	}

}
