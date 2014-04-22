/**
 * 
 */
package br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

import br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cmt.ApplSelectProject;
import br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cmt.ApplShowProjects;
import br.ufes.inf.nemo.odercp.rcpapp.util.SwtUtil;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
public class PageSelectProject {

	protected Shell shlSelectProject;
	private String chosenProject;
	String[] projects = ApplShowProjects.showProjects();
	Button[] radios = new Button[projects.length];
	int i;

	/**
	 * Open the window.
	 */
	public void open(Shell parent) {
		Display display = Display.getDefault();
		createContents();
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
	protected void createContents() {
		shlSelectProject = new Shell();
		shlSelectProject.setSize(515, 365);
		shlSelectProject.setText("SelectProject");

		Button btnSelect = new Button(shlSelectProject, SWT.NONE);
		btnSelect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ApplSelectProject ap = new ApplSelectProject();
				//ap.run();
			}
		});
		btnSelect.setBounds(218, 298, 91, 29);
		btnSelect.setText("Select");

		for (i = 0; i < projects.length; i++) {
			radios[i] = new Button(shlSelectProject, SWT.RADIO);
			radios[i].setText(projects[i]);
			radios[i].setBounds(10, 45 + (30 * i), 750, 30);
		}
		radios[0].setSelection(true);
		chosenProject = radios[0].getText();

	}
}
