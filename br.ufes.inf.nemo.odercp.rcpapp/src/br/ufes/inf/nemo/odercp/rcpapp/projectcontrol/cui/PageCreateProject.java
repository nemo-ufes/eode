package br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cmt.ApplCreateProject;
import br.ufes.inf.nemo.odercp.rcpapp.util.SwtUtil;

public class PageCreateProject {

	protected Shell shlCreateProject;
	private Text txtNameproject;
	private Text txtDescription;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void start() {
		try {
			PageCreateProject window = new PageCreateProject();
			//window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open(Shell parent) {
		Display display = Display.getDefault();
		createContents();
		SwtUtil.centralizeparent(shlCreateProject, parent);
		shlCreateProject.open();
		shlCreateProject.layout();
		while (!shlCreateProject.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCreateProject = new Shell();
		shlCreateProject.setSize(442, 310);
		shlCreateProject.setText("Create Project");

		Label lblName = new Label(shlCreateProject, SWT.NONE);
		lblName.setBounds(10, 29, 70, 17);
		lblName.setText("Name:");

		txtNameproject = new Text(shlCreateProject, SWT.BORDER);
		txtNameproject.setBounds(112, 19, 295, 27);
		txtNameproject.setText("");

		Label lblDescription = new Label(shlCreateProject, SWT.NONE);
		lblDescription.setBounds(10, 140, 89, 17);
		lblDescription.setText("Description:");

		txtDescription = new Text(shlCreateProject, SWT.BORDER | SWT.MULTI);
		txtDescription.setBounds(112, 70, 295, 152);

		Button btnCreate = new Button(shlCreateProject, SWT.NONE);
		btnCreate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean ok = ApplCreateProject.CreateNewProject(
						txtNameproject.getText(), txtDescription.getText());
				if (ok)
					shlCreateProject.close();
			}
		});
		btnCreate.setBounds(180, 243, 91, 29);
		btnCreate.setText("Create");

	}
}
