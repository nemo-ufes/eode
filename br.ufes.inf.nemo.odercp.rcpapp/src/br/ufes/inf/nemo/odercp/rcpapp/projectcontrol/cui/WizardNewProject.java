/**
 * 
 */
package br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cui;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cmt.NewProject;

public class WizardNewProject extends Wizard {

	protected PageNewProject pagenewproject;

	public WizardNewProject() {
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		pagenewproject = new PageNewProject();
		addPage(pagenewproject);
	}

	@Override
	public boolean performFinish() {
		// Print the result to the console
		NewProject.CreateNewProject(pagenewproject.getNamenewproject().getText());

		System.out.println(pagenewproject.getNamenewproject());
		return true;
	}
	
	public String getNewnameproject() {
	return pagenewproject.getNamenewproject().getText();
	}
}
