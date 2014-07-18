package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cmt.ApplCRUDActivityStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cmt.ApplCRUDSpecificStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.ActivityStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.SpecificStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.StandardProcess;

public class PageDefineMacroActivityStandardProcess extends WizardPage {

	Shell shell;
	Tree tree;
	TreeItem root;
	SpecificStandardProcess specificStandardProcess;
	SpecificStandardProcess specificStandardProcessSelected;
	LinkedList<KProcess> subkprocessesSelections;
	LinkedList<ActivityStandardProcess> macroActivitiesStandardProcess;
	KProcess processEnginnering;
	ActivityStandardProcess activitiesStandardProcess[];
	List list_avaliables;
	List list_selected;
	HashMap<TreeItem, SpecificStandardProcess> hashStandardProcesses;
	HashMap<String, ActivityStandardProcess> hashActivies;

	/**
	 * Create the wizard.
	 */
	public PageDefineMacroActivityStandardProcess() {
		super("wizardPage");
		setTitle("Page Define Macro-Activity in Process");
		subkprocessesSelections = new LinkedList<KProcess>();
		macroActivitiesStandardProcess = new LinkedList<ActivityStandardProcess>();
		activitiesStandardProcess = ApplCRUDActivityStandardProcess.getever();
		hashStandardProcesses = new HashMap<TreeItem, SpecificStandardProcess>();
		hashActivies = new HashMap<String, ActivityStandardProcess>();
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

		root = new TreeItem(tree, SWT.NONE, 0);
		root.setText(specificStandardProcess.getName());
		root.setExpanded(true);

		TreeItem item;
		Iterator<StandardProcess> it = specificStandardProcess.getSpecialization().iterator();
		SpecificStandardProcess specificStandardProcess;
		specificStandardProcess = (SpecificStandardProcess) it.next();
		item = new TreeItem(root, SWT.NONE, 0);
		item.setText(specificStandardProcess.getName());
		tree.select(item);
		hashStandardProcesses.put(item, specificStandardProcess);

		while (it.hasNext()) {
			specificStandardProcess = (SpecificStandardProcess) it.next();
			item = new TreeItem(root, SWT.NONE, 0);
			item.setText(specificStandardProcess.getName());
			hashStandardProcesses.put(item, specificStandardProcess);

		}

		tree.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TreeItem ti = (TreeItem) e.item;
				if (!ti.equals(root)) {
					specificStandardProcessSelected = hashStandardProcesses.get(ti);
					populateMacro(hashStandardProcesses.get(ti));
				}
			}

			private void populateMacro(SpecificStandardProcess specificStandardProcess) {
				list_avaliables.removeAll();
				list_selected.removeAll();
				for (int i = 0; i < activitiesStandardProcess.length; i++) {
					if (specificStandardProcess.getActivityStandardProcesses().contains(activitiesStandardProcess[i])) {
						list_selected.add(activitiesStandardProcess[i].getName());
					}
					else {
						list_avaliables.add(activitiesStandardProcess[i].getName());
					}

				}
			}

		});

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

		list_avaliables = new List(container, SWT.BORDER);
		GridData gd_list = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 7);
		list_avaliables.setLayoutData(gd_list);
		gd_list.widthHint = 300;
		for (int i = 0; i < activitiesStandardProcess.length; i++) {
			list_avaliables.add(activitiesStandardProcess[i].getName());
			hashActivies.put(activitiesStandardProcess[i].getName(), activitiesStandardProcess[i]);
		}

		Button select_one = new Button(container, SWT.NONE);
		GridData gd_button = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_button.widthHint = 25;
		select_one.setLayoutData(gd_button);
		select_one.setText(">");
		select_one.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = list_avaliables.getSelection();

				for (int i = 0; i < selections.length; i++) {
					list_selected.add(selections[i]);
					specificStandardProcessSelected.getActivityStandardProcesses().add(hashActivies.get(selections[i]));
					list_avaliables.remove(selections[i]);
				}
				// pageDefineMacroActivityStandardProcess.createControl(parent);
				// pageDefineMacroActivityStandardProcess.getControl().pack();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selections = list_avaliables.getSelection();

				for (int i = 0; i < selections.length; i++) {
					list_selected.add(selections[i]);
					specificStandardProcessSelected.getActivityStandardProcesses().add(hashActivies.get(selections[i]));
					list_avaliables.remove(selections[i]);
				}
				// pageDefineMacroActivityStandardProcess.createControl(parent);
				// pageDefineMacroActivityStandardProcess.getControl().pack();
			}

		});

		list_selected = new List(container, SWT.BORDER);
		GridData gd_list_1 = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 7);
		list_selected.setLayoutData(gd_list_1);
		gd_list_1.widthHint = 300;
		new Label(container, SWT.NONE);

		Button selected_ever = new Button(container, SWT.NONE);
		selected_ever.setText(">>");
		selected_ever.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = list_avaliables.getItems();

				for (int i = 0; i < selections.length; i++) {
					list_selected.add(selections[i]);
					specificStandardProcessSelected.getActivityStandardProcesses().add(hashActivies.get(selections[i]));
					list_avaliables.remove(selections[i]);
				}
				// pageDefineMacroActivityStandardProcess.createControl(parent);
				// pageDefineMacroActivityStandardProcess.getControl().pack();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selections = list_avaliables.getItems();

				for (int i = 0; i < selections.length; i++) {
					list_selected.add(selections[i]);
					specificStandardProcessSelected.getActivityStandardProcesses().add(hashActivies.get(selections[i]));
					list_avaliables.remove(selections[i]);
				}
				// pageDefineMacroActivityStandardProcess.createControl(parent);
				// pageDefineMacroActivityStandardProcess.getControl().pack();
			}

		});

		new Label(container, SWT.NONE);

		Button deselect_one = new Button(container, SWT.NONE);
		deselect_one.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		deselect_one.setText("<");
		deselect_one.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = list_selected.getSelection();

				for (int i = 0; i < selections.length; i++) {
					list_avaliables.add(selections[i]);
					specificStandardProcessSelected.getActivityStandardProcesses().remove(hashActivies.get(selections[i]));
					list_selected.remove(selections[i]);
				}
				// pageDefineMacroActivityStandardProcess.createControl(parent);
				// pageDefineMacroActivityStandardProcess.getControl().pack();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selections = list_selected.getSelection();

				for (int i = 0; i < selections.length; i++) {
					list_avaliables.add(selections[i]);
					specificStandardProcessSelected.getActivityStandardProcesses().remove(hashActivies.get(selections[i]));
					list_selected.remove(selections[i]);
				}
				// pageDefineMacroActivityStandardProcess.createControl(parent);
				// pageDefineMacroActivityStandardProcess.getControl().pack();
			}

		});

		new Label(container, SWT.NONE);

		Button deselect_ever = new Button(container, SWT.NONE);
		deselect_ever.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		deselect_ever.setText("<<");
		deselect_ever.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = list_selected.getItems();;

				for (int i = 0; i < selections.length; i++) {
					list_avaliables.add(selections[i]);
					specificStandardProcessSelected.getActivityStandardProcesses().remove(hashActivies.get(selections[i]));
					list_selected.remove(selections[i]);
				}
				// pageDefineMacroActivityStandardProcess.createControl(parent);
				// pageDefineMacroActivityStandardProcess.getControl().pack();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selections = list_selected.getItems();

				for (int i = 0; i < selections.length; i++) {
					list_avaliables.add(selections[i]);
					specificStandardProcessSelected.getActivityStandardProcesses().remove(hashActivies.get(selections[i]));
					list_selected.remove(selections[i]);
				}
				// pageDefineMacroActivityStandardProcess.createControl(parent);
				// pageDefineMacroActivityStandardProcess.getControl().pack();
			}

		});

		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

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
