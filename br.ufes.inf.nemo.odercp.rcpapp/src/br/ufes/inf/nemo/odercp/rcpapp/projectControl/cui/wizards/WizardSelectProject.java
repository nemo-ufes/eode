package br.ufes.inf.nemo.odercp.rcpapp.projectControl.cui.wizards;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.ResourceManager;

import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cui.PageSelectProject;

public class WizardSelectProject extends Wizard {
	protected  PageSelectProject pageselectProject;
	public WizardSelectProject() {
		setWindowTitle("Wizard Select Project");
		pageselectProject = new PageSelectProject();
		
/*		Image img = ResourceManager.getPluginImage(
				"br.ufes.inf.nemo.odercp.rcpapp", "images/editdelete.png");
		ImageDescriptor imagedesc = ImageDescriptor.createFromImage(img);
		super.setDefaultPageImageDescriptor(imagedesc);
*/	}

	@Override
	public void addPages() {
		addPage(pageselectProject);
	}

	@Override
	public boolean performFinish() {
		return false;
	}
}
