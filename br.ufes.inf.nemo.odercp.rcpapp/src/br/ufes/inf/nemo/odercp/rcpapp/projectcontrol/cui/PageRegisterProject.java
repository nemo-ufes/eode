/**
 * 
 */
package br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.CoolBar;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
public class PageRegisterProject {

	protected Shell shlRegisterProject;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PageRegisterProject window = new PageRegisterProject();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
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
	 */
	protected void createContents() {
		shlRegisterProject = new Shell();
		shlRegisterProject.setSize(485, 322);
		shlRegisterProject.setText("Register Project");
		
		Button btnNewProject = new Button(shlRegisterProject, SWT.NONE);
		btnNewProject.setImage(ResourceManager.getPluginImage("br.ufes.inf.nemo.odercp.rcpapp", "images/filenew.png"));
		btnNewProject.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewProject.setBounds(10, 10, 28, 29);
		
		Button btnOpenProject = new Button(shlRegisterProject, SWT.NONE);
		btnOpenProject.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnOpenProject.setImage(ResourceManager.getPluginImage("br.ufes.inf.nemo.odercp.rcpapp", "images/fileopen.png"));
		btnOpenProject.setBounds(44, 10, 28, 29);
		
		Button button_1 = new Button(shlRegisterProject, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_1.setImage(ResourceManager.getPluginImage("br.ufes.inf.nemo.odercp.rcpapp", "images/editdelete.png"));
		button_1.setBounds(78, 10, 28, 29);

	}
}
