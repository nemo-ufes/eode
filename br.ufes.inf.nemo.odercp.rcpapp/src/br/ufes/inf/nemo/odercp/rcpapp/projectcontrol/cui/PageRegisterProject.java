/**
 * 
 */
package br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.ResourceManager;

import br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cmt.ApplDeleteProject;
import br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cmt.ApplShowProjects;
import br.ufes.inf.nemo.odercp.rcpapp.util.SwtUtil;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
public class PageRegisterProject {

	protected Shell shlRegisterProject;
	private String chosenProject;
	String[] projects = ApplShowProjects.showProjects();
	Button[] radios;
	int i;// iterator to buttons actions.
	Shell shlparentRegisterProject;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */

	/**
	 * Open the window.
	 */
	public void open(Shell parent) {
		Display display = Display.getDefault();
		createContents(parent);
		SwtUtil.centralizeparent(shlRegisterProject, parent);

		shlRegisterProject.open();
		shlRegisterProject.layout();
		while (!shlRegisterProject.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	protected void createContents(Shell parent) {
		shlparentRegisterProject = parent;
		shlRegisterProject = new Shell();
		shlRegisterProject.setSize(515, 365);
		shlRegisterProject.setText("Register Project");

		Button btnNewProject = new Button(shlRegisterProject, SWT.NONE);
		btnNewProject.setImage(ResourceManager.getPluginImage("br.ufes.inf.nemo.odercp.rcpapp", "images/filenew.png"));
		btnNewProject.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PageCreateProject page = new PageCreateProject();
				page.open(shlparentRegisterProject);
			}
		});
		btnNewProject.setBounds(10, 10, 28, 29);

		Button btnOpenProject = new Button(shlRegisterProject, SWT.NONE);
		btnOpenProject.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PageOpenProject page = new PageOpenProject();
				for (i = 0; i < projects.length; i++) {
					if (radios[i].getSelection()) {
						chosenProject = radios[i].getText();
					}
				}
				page.open(chosenProject, shlparentRegisterProject);
			}
		});
		btnOpenProject.setImage(ResourceManager.getPluginImage("br.ufes.inf.nemo.odercp.rcpapp", "images/fileopen.png"));
		btnOpenProject.setBounds(44, 10, 28, 29);

		Button btnDeleteProject = new Button(shlRegisterProject, SWT.NONE);
		btnDeleteProject.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (i = 0; i < projects.length; i++) {
					if (radios[i].getSelection()) {
						chosenProject = radios[i].getText();
					}
				}
				if (MessageDialog.openConfirm(shlRegisterProject, "Confirmation", "Do you want Delete " + chosenProject + " ?")) {
					ApplDeleteProject.deleteProject(chosenProject);
				}
			}
		});
		btnDeleteProject.setImage(ResourceManager.getPluginImage("br.ufes.inf.nemo.odercp.rcpapp", "images/editdelete.png"));
		btnDeleteProject.setBounds(78, 10, 28, 29);
		if (projects.length > 0) radios = new Button[projects.length];
		for (i = 0; i < projects.length; i++) {
			radios[i] = new Button(shlRegisterProject, SWT.RADIO);
			radios[i].setText(projects[i]);
			radios[i].setBounds(10, 45 + (30 * i), 750, 30);
		}
		if (projects.length > 0) {
			radios[0].setSelection(true);
			chosenProject = radios[0].getText();
		}

	}
}
