package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

public class PageDefineSubStandardProcess extends WizardPage {

	Shell shell;

	/**
	 * Create the wizard.
	 */
	public PageDefineSubStandardProcess() {
		super("wizardPage");
		setTitle("Page Define subProcess");
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 * @param shell
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		//	parent.getShell().setSize(800, 600);

		setControl(container);
		container.setLayout(new GridLayout(5, false));

		Tree tree = new Tree(container, SWT.BORDER);
		GridData gd_tree = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 9);
		gd_tree.widthHint = 297;
		tree.setLayoutData(gd_tree);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblProcessOfEnginnering = new Label(container, SWT.NONE);
		lblProcessOfEnginnering.setText("Process of Enginnering:");

		Combo combo = new Combo(container, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblOthersProcess = new Label(container, SWT.NONE);
		lblOthersProcess.setText("Others Process:");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblAvaliable = new Label(container, SWT.NONE);
		lblAvaliable.setText("Avaliable:");
		new Label(container, SWT.NONE);

		Label lblSelections = new Label(container, SWT.NONE);
		lblSelections.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblSelections.setText("Selected:");
		new Label(container, SWT.NONE);

		List list = new List(container, SWT.BORDER);
		GridData gd_list = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 4);
		list.setLayoutData(gd_list);
		gd_list.widthHint = 300;

		Button button = new Button(container, SWT.NONE);
		GridData gd_button = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_button.widthHint = 25;
		button.setLayoutData(gd_button);
		button.setText(">");

		List list_1 = new List(container, SWT.BORDER);
		GridData gd_list_1 = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 4);
		list_1.setLayoutData(gd_list_1);
		gd_list_1.widthHint = 300;
		new Label(container, SWT.NONE);

		Button button_1 = new Button(container, SWT.NONE);
		button_1.setText(">>");
		new Label(container, SWT.NONE);

		Button button_2 = new Button(container, SWT.NONE);
		button_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button_2.setText("<");
		new Label(container, SWT.NONE);

		Button button_3 = new Button(container, SWT.NONE);
		button_3.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		button_3.setText("<<");

	}
}
