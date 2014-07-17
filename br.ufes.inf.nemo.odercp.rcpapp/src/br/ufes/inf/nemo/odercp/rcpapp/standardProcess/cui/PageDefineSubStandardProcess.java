package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui;

import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKProcess;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.SpecificStandardProcess;

public class PageDefineSubStandardProcess extends WizardPage {

	Shell shell;
	Tree tree;
	TreeItem root;
	SpecificStandardProcess specificStandardProcess;
	Combo combo;
	LinkedList<KProcess> subkprocesses;
	HashMap<String, KProcess> hashKprocess;
	List listavaliables;
	List listselections;
	PageDefineMacroActivityStandardProcess pageDefineMacroActivityStandardProcess;

	/**
	 * Create the wizard.
	 */
	public PageDefineSubStandardProcess() {
		super("wizardPage");
		setTitle("Page Define subProcess");
		subkprocesses = new LinkedList<KProcess>();
		hashKprocess = new HashMap<String, KProcess>();
		for (int i = 0; i < ApplCRUDKProcess.getever().length; i++) {
			subkprocesses.add(ApplCRUDKProcess.getever()[i]);
			hashKprocess.put(ApplCRUDKProcess.getever()[i].getName(), ApplCRUDKProcess.getever()[i]);
		}
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 * @param shell
	 */
	public void createControl(final Composite parent) {

		if (getNextPage() instanceof PageDefineMacroActivityStandardProcess) {
			pageDefineMacroActivityStandardProcess = (PageDefineMacroActivityStandardProcess) getNextPage();
		}
		
		pageDefineMacroActivityStandardProcess.setSpecificStandardProcess(specificStandardProcess);

		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(5, false));

		tree = new Tree(container, SWT.BORDER);
		GridData gd_tree = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 9);
		gd_tree.widthHint = 297;
		tree.setLayoutData(gd_tree);

		root = new TreeItem(tree, SWT.NONE, 0);
		root.setText(specificStandardProcess.getName());
		root.setExpanded(true);

		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblProcessOfEnginnering = new Label(container, SWT.NONE);
		lblProcessOfEnginnering.setText("Process of Enginnering:");

		combo = new Combo(container, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		for (int i = 0; i < subkprocesses.size(); i++) {
			if (subkprocesses.get(i).isEngineering()) {
				combo.add(subkprocesses.get(i).getName());
				combo.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						pageDefineMacroActivityStandardProcess.processEnginnering = hashKprocess.get(combo.getItem(combo.getSelectionIndex()));
					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						// TODO Auto-generated method stub

					}
				});
			}
		}

		if (subkprocesses.size() > 0) {
			combo.select(0);
			pageDefineMacroActivityStandardProcess.processEnginnering = hashKprocess.get(combo.getItem(0));
		}

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

		listavaliables = new List(container, SWT.BORDER);
		GridData gd_list = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 4);
		listavaliables.setLayoutData(gd_list);
		gd_list.widthHint = 300;
		for (int i = 0; i < subkprocesses.size(); i++) {
			if (!subkprocesses.get(i).isEngineering()) listavaliables.add(subkprocesses.get(i).getName());
		}

		Button select_one = new Button(container, SWT.NONE);
		GridData gd_button = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_button.widthHint = 25;
		select_one.setLayoutData(gd_button);
		select_one.setText(">");
		select_one.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listavaliables.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listselections.add(selections[i]);
					pageDefineMacroActivityStandardProcess.subkprocessesSelections.add(hashKprocess.get(selections[i]));
					listavaliables.remove(selections[i]);
				}
				pageDefineMacroActivityStandardProcess.createControl(parent);
				pageDefineMacroActivityStandardProcess.getControl().pack();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selections = listavaliables.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listselections.add(selections[i]);
					pageDefineMacroActivityStandardProcess.subkprocessesSelections.add(hashKprocess.get(selections[i]));
					listavaliables.remove(selections[i]);

				}
				pageDefineMacroActivityStandardProcess.createControl(parent);
				pageDefineMacroActivityStandardProcess.getControl().pack();

			}

		});

		listselections = new List(container, SWT.BORDER);
		GridData gd_list_1 = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 4);
		listselections.setLayoutData(gd_list_1);
		gd_list_1.widthHint = 300;
		new Label(container, SWT.NONE);

		Button select_all = new Button(container, SWT.NONE);
		select_all.setText(">>");
		select_all.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listavaliables.getItems();

				for (int i = 0; i < selections.length; i++) {
					listselections.add(selections[i]);
					pageDefineMacroActivityStandardProcess.subkprocessesSelections.add(hashKprocess.get(selections[i]));

				}
				listavaliables.removeAll();
				pageDefineMacroActivityStandardProcess.createControl(parent);
				pageDefineMacroActivityStandardProcess.getControl().pack();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selections = listavaliables.getItems();

				for (int i = 0; i < selections.length; i++) {
					listselections.add(selections[i]);
					pageDefineMacroActivityStandardProcess.subkprocessesSelections.add(hashKprocess.get(selections[i]));

				}
				listavaliables.removeAll();
				pageDefineMacroActivityStandardProcess.createControl(parent);
				pageDefineMacroActivityStandardProcess.getControl().pack();

			}

		});

		new Label(container, SWT.NONE);

		Button deselect_one = new Button(container, SWT.NONE);
		deselect_one.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		deselect_one.setText("<");
		deselect_one.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listselections.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listavaliables.add(selections[i]);
					pageDefineMacroActivityStandardProcess.subkprocessesSelections.remove(hashKprocess.get(selections[i]));
					listselections.remove(selections[i]);

				}
				pageDefineMacroActivityStandardProcess.createControl(parent);
				pageDefineMacroActivityStandardProcess.getControl().pack();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selections = listselections.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listavaliables.add(selections[i]);
					pageDefineMacroActivityStandardProcess.subkprocessesSelections.remove(hashKprocess.get(selections[i]));
					listselections.remove(selections[i]);

				}
				pageDefineMacroActivityStandardProcess.createControl(parent);
				pageDefineMacroActivityStandardProcess.getControl().pack();

			}

		});

		new Label(container, SWT.NONE);

		Button deselect_all = new Button(container, SWT.NONE);
		deselect_all.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		deselect_all.setText("<<");
		deselect_all.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listselections.getItems();

				for (int i = 0; i < selections.length; i++) {
					listavaliables.add(selections[i]);
					pageDefineMacroActivityStandardProcess.subkprocessesSelections.remove(hashKprocess.get(selections[i]));

				}
				listselections.removeAll();
				pageDefineMacroActivityStandardProcess.createControl(parent);
				pageDefineMacroActivityStandardProcess.getControl().pack();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selections = listselections.getItems();

				for (int i = 0; i < selections.length; i++) {
					listavaliables.add(selections[i]);
					pageDefineMacroActivityStandardProcess.subkprocessesSelections.remove(hashKprocess.get(selections[i]));

				}
				listselections.removeAll();
				pageDefineMacroActivityStandardProcess.createControl(parent);
				pageDefineMacroActivityStandardProcess.getControl().pack();

			}

		});
		// }
		// catch (Exception e) {

		// }
	}

	/** Getter for shell. */
	public Shell getShell() {
		return shell;
	}

	/** Setter for shell. */
	public void setShell(Shell shell) {
		this.shell = shell;
	}

	/** Getter for tree. */
	public Tree getTree() {
		return tree;
	}

	/** Setter for tree. */
	public void setTree(Tree tree) {
		this.tree = tree;
	}

	/** Getter for root. */
	public TreeItem getRoot() {
		return root;
	}

	/** Setter for root. */
	public void setRoot(TreeItem root) {
		this.root = root;
	}

	/** Getter for specificStandardProcess. */
	public SpecificStandardProcess getSpecificStandardProcess() {
		return specificStandardProcess;
	}

	/** Setter for specificStandardProcess. */
	public void setSpecificStandardProcess(SpecificStandardProcess specificStandardProcess) {
		this.specificStandardProcess = specificStandardProcess;
	}
}
