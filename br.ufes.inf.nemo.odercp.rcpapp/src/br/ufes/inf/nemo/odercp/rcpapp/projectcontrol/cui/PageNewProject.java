/**
 * 
 */
package br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cui;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cmt.AplNewProject;

public class PageNewProject extends WizardPage {
	private Text namenewproject;
	/**
	 * @return the namenewproject
	 */
	public Text getNamenewproject() {
		return namenewproject;
	}

	private Composite container;

	public PageNewProject() {
		super("New Project");
		setTitle("New Project");
		//setDescription("New Project");
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		Label label1 = new Label(container, SWT.NONE);
		label1.setText("Name New Project:");

		namenewproject = new Text(container, SWT.BORDER | SWT.SINGLE);
		namenewproject.setText("");
		namenewproject.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (!namenewproject.getText().isEmpty()) {
					setPageComplete(true);

				}
			}

		});
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		namenewproject.setLayoutData(gd);
		// Required to avoid an error in the system
		setControl(container);
		setPageComplete(false);

	}

}
