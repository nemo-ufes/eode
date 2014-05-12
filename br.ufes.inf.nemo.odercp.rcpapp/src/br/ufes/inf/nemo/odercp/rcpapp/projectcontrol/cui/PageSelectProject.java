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
import org.eclipse.swt.widgets.Group;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
public class PageSelectProject {

	protected Shell shlSelectProject;
	private String chosenProject;
	String[] projects = ApplShowProjects.showProjects();
	Button[] radios;
	int i;// iterator to buttons actions.
	Shell shlparentSelectProject;

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
		SwtUtil.centralizeparent(shlSelectProject, parent);

		shlSelectProject.open();
		shlSelectProject.layout();
		while (!shlSelectProject.isDisposed()) {
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
		shlparentSelectProject = parent;
		shlSelectProject = new Shell();
		shlSelectProject.setSize(515, 365);
		shlSelectProject.setText("Select Project");

				
		Button btnSelect = new Button(shlSelectProject, SWT.NONE);
		btnSelect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnSelect.setBounds(209, 288, 91, 29);
		btnSelect.setText("Select");
		
		if (projects.length > 0) radios = new Button[projects.length];
		for (i = 0; i < projects.length; i++) {
			radios[i] = new Button(shlSelectProject, SWT.RADIO);
			radios[i].setText(projects[i]);
			radios[i].setBounds(10, 45 + (30 * i), 750, 30);
		}
		if (projects.length > 0) {
			radios[0].setSelection(true);
			chosenProject = radios[0].getText();
		}

	}
}
