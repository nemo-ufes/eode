package br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import br.ufes.inf.nemo.odercp.rcpapp.util.SwtUtil;

public class PageOpenProject {

	protected Shell shlOpenProject;
	private Text txtNameproject;

	public void setTxtNameproject(String Nameproject) {
		this.txtNameproject.setText(Nameproject);
	}

	private Text txtDescription;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	

	/**
	 * Open the window.
	 */
	
	public void open(String nameProject,Shell parent) {
		Display display = Display.getDefault();
		createContents(nameProject);
		SwtUtil.centralizeparent(shlOpenProject, parent);
		shlOpenProject.open();
		shlOpenProject.layout();
		while (!shlOpenProject.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(String nameProject) {
		shlOpenProject = new Shell();
		shlOpenProject.setSize(442, 310);
		shlOpenProject.setText("Open Project");

		Label lblName = new Label(shlOpenProject, SWT.NONE);
		lblName.setBounds(10, 29, 70, 17);
		lblName.setText("Name:");

		txtNameproject = new Text(shlOpenProject, SWT.BORDER);
		txtNameproject.setBounds(112, 19, 295, 27);
		txtNameproject.setText(nameProject);

		Label lblDescription = new Label(shlOpenProject, SWT.NONE);
		lblDescription.setBounds(10, 140, 89, 17);
		lblDescription.setText("Description:");

		txtDescription = new Text(shlOpenProject, SWT.BORDER | SWT.MULTI);
		txtDescription.setBounds(112, 70, 295, 152);

	}
}
