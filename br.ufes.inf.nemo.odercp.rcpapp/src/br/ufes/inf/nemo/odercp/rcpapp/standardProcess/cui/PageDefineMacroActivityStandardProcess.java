package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cmt.ApplCRUDSpecificStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.SpecificStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.StandardProcess;

public class PageDefineMacroActivityStandardProcess extends WizardPage {

	Shell shell;
	Tree tree;
	SpecificStandardProcess specificStandardProcess;
	LinkedList<KProcess> subkprocessesSelections;
	KProcess processEnginnering;

	/**
	 * Create the wizard.
	 */
	public PageDefineMacroActivityStandardProcess() {
		super("wizardPage");
		setTitle("Page Define Macro-Activity in Process");
		subkprocessesSelections = new LinkedList<KProcess>();
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 * @param shell
	 */
	public void createControl(Composite parent) {
		{// pegando da outra pagina

			HashSet<StandardProcess> subprocess = new HashSet<StandardProcess>();
			SpecificStandardProcess[] specificStandardProcesses = ApplCRUDSpecificStandardProcess.getever();

			int j;
			for (j = 0; j < specificStandardProcesses.length; j++) {
				if (processEnginnering.getName().equals(specificStandardProcesses[j].getName())) {
					subprocess.add(specificStandardProcesses[j]);
				}
				int k = 0;
				while (k < subkprocessesSelections.size()) {
					if (subkprocessesSelections.get(k).getName().equals(specificStandardProcesses[j].getName())) {
						subprocess.add(specificStandardProcesses[j]);
						k = subkprocessesSelections.size();
					}
					k++;
				}
			}
			specificStandardProcess.setSpecialization(subprocess);
		}// fim do pegando
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(5, false));

		tree = new Tree(container, SWT.BORDER);
		GridData gd_tree = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 9);
		gd_tree.widthHint = 297;
		tree.setLayoutData(gd_tree);

		TreeItem root = new TreeItem(tree, SWT.NONE, 0);
		root.setText(specificStandardProcess.getName());
		root.setExpanded(true);

		TreeItem item;
		Iterator<StandardProcess> it = specificStandardProcess.getSpecialization().iterator();
		while (it.hasNext()) {
			item = new TreeItem(root, SWT.NONE, 0);
			item.setText(it.next().getName());
		}

		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblAvaliable = new Label(container, SWT.NONE);
		lblAvaliable.setText("Activity Avaliable:");
		new Label(container, SWT.NONE);

		Label lblSelections = new Label(container, SWT.NONE);
		lblSelections.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblSelections.setText("Activity Selected:");
		new Label(container, SWT.NONE);

		List list = new List(container, SWT.BORDER);
		GridData gd_list = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 7);
		list.setLayoutData(gd_list);
		gd_list.widthHint = 300;

		Button button = new Button(container, SWT.NONE);
		GridData gd_button = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_button.widthHint = 25;
		button.setLayoutData(gd_button);
		button.setText(">");

		List list_1 = new List(container, SWT.BORDER);
		GridData gd_list_1 = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 7);
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
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		setPageComplete(false);

	}

	/** Getter for specificStandardProcess. */
	public SpecificStandardProcess getSpecificStandardProcess() {
		return specificStandardProcess;
	}

	/** Setter for specificStandardProcess. */
	public void setSpecificStandardProcess(SpecificStandardProcess specificStandardProcess) {
		// root.setText(specificStandardProcess.getName());
		this.specificStandardProcess = specificStandardProcess;
	}

}
