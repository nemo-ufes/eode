package br.ufes.inf.nemo.odercp.rcpapp.projectControl.cui.wizards;

import java.util.HashMap;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Button;

import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cmt.ApplCRUDProject;
import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cmt.ApplSelectProject;
import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cpd.Project;
import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cui.PageSelectProject;

public class WizardSelectProject extends Wizard {
	protected PageSelectProject pageselectProject;

	public WizardSelectProject() {
		setWindowTitle("Wizard Select Project");
		pageselectProject = new PageSelectProject();

		/*
		 * Image img = ResourceManager.getPluginImage( "br.ufes.inf.nemo.odercp.rcpapp", "images/editdelete.png");
		 * ImageDescriptor imagedesc = ImageDescriptor.createFromImage(img); super.setDefaultPageImageDescriptor(imagedesc);
		 */}

	@Override
	public void addPages() {
		addPage(pageselectProject);
	}

	@Override
	public boolean performFinish() {
		Button[] radios = pageselectProject.getRadios();
		if (radios.length > 0) {
			HashMap<String, Project> hashProjects = ApplCRUDProject.geteverProjectsWorkspace();
			int i = 0;
			while (!radios[i].getSelection()) {
				i++;
			}
			ApplSelectProject.setSelected(hashProjects.get(radios[i].getText()));
			return true;
		}
		return false;
	}
}
