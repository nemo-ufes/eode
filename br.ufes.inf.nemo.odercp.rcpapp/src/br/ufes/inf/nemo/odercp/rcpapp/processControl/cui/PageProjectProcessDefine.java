package br.ufes.inf.nemo.odercp.rcpapp.processControl.cui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KProcedure;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KResource;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cmt.ApplCRUDActivityStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cmt.ApplCRUDSpecificStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.ActivityStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.GeneralStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.SpecificStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.StandardProcess;

public class PageProjectProcessDefine {
	Shell shell;
	GeneralStandardProcess generalStandardProcess;
	PageProjectProcessDefine pageProcessDefine;
	
	Tree tree;
	TreeItem root;
	private Composite composite;
	

	/**
	 * Launch the application.
	 * 
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public void main() {
		pageProcessDefine = this;
		Display display = Display.getDefault();
		shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN);
		shell.setSize(800, 680);
		shell.setText(" Project Process Define");

		Menu menuBar = new Menu(shell, SWT.BAR);

		MenuItem cascadeStandardMenu = new MenuItem(menuBar, SWT.CASCADE);
		cascadeStandardMenu.setText("&Project Process");

		Menu standardMenu = new Menu(shell, SWT.DROP_DOWN);
		cascadeStandardMenu.setMenu(standardMenu);


		MenuItem choiceItem = new MenuItem(standardMenu, SWT.PUSH);
		choiceItem.setText("&Choice Standard Process");
		choiceItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				PageChoiceStandardProcess pageChoiceStandardProcess = new PageChoiceStandardProcess();
				pageChoiceStandardProcess.main(pageProcessDefine);

			}
		});

		MenuItem defineItem = new MenuItem(standardMenu, SWT.PUSH);
		defineItem.setText("&Define Project Process");
		defineItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tree.removeAll();
				tree.setVisible(false);
				createtree();

			}
		});
		

		shell.setMenuBar(menuBar);

		ScrolledComposite scrolledComposite = new ScrolledComposite(shell,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);

		scrolledComposite.setBounds(0, 0, 794, 591);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setBounds(0, 0, 794, 591);
		composite.setLayout(new GridLayout(4, false));
		scrolledComposite.setContent(composite);

		tree = new Tree(composite, SWT.BORDER);
		GridData gd_tree = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
		gd_tree.widthHint = 219;
		tree.setLayoutData(gd_tree);
	
		//tree.setVisible(false);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createtree() {
		if (generalStandardProcess != null) {
			tree.removeAll();

			tree.setVisible(true);
			root = new TreeItem(tree, SWT.NONE);
			root.setText(generalStandardProcess.getName());
/**
			tabFolder.setVisible(true);
			tabFolder.setSelection(0);

			TreeItem item;
			// specificStandardProcess.getSpecialization().add(processEngineering);

			if (!generalStandardProcess.getSpecialization().isEmpty()) {

				hashStandardProcesses = new HashMap<TreeItem, SpecificStandardProcess>();

				item = new TreeItem(root, SWT.NONE);
				item.setText(processEngineering.getName());
				hashStandardProcesses.put(item, processEngineering);
				populateProcess(item, processEngineering);

				Iterator<StandardProcess> itsubprocesses = generalStandardProcess
						.getSpecialization().iterator();
				SpecificStandardProcess auxspecificStandardProcess;
				while (itsubprocesses.hasNext()) {

					auxspecificStandardProcess = (SpecificStandardProcess) itsubprocesses
							.next();
					if (!auxspecificStandardProcess.equals(processEngineering)) {
						item = new TreeItem(root, SWT.NONE);
						item.setText(auxspecificStandardProcess.getName());
						hashStandardProcesses.put(item,
								auxspecificStandardProcess);
						populateProcess(item, auxspecificStandardProcess);
					}
				}
			}
*/
		} else {
			MessageDialog.openConfirm(null, "Confirmation",
					"Choice Standard Process to define.");
		}
	}

	private void populateProcess(TreeItem item,
			SpecificStandardProcess auxspecificStandardProcess) {

		if (auxspecificStandardProcess.getActivityStandardProcesses() != null
				&& !auxspecificStandardProcess.getActivityStandardProcesses()
						.isEmpty()) {

			TreeItem auxitem;
			int size = auxspecificStandardProcess
					.getActivityStandardProcesses().size();

			ActivityStandardProcess[] activitiesStandardProcess = auxspecificStandardProcess
					.getActivityStandardProcesses().toArray(
							new ActivityStandardProcess[size]);
			int j = size - 1;
			for (int i = j; i >= 0; i--) {

				auxitem = new TreeItem(item, SWT.NONE, 0);
				auxitem.setText(activitiesStandardProcess[i].getName());

				populateactivity(auxitem, activitiesStandardProcess[i]);
			}

		}

	}

	private void populateactivity(TreeItem item,
			ActivityStandardProcess activityStandardProcess) {

		TreeItem auxItem;
		// kProcedures
		TreeItem itemKprocedure;
		itemKprocedure = new TreeItem(item, SWT.NONE, 0);
		itemKprocedure.setText("Procedures");
		if (activityStandardProcess.getkProcedures() != null) {
			Iterator<KProcedure> itKProcedures = activityStandardProcess
					.getkProcedures().iterator();
			KProcedure kProcedure;
			while (itKProcedures.hasNext()) {
				kProcedure = itKProcedures.next();
				auxItem = new TreeItem(itemKprocedure, SWT.NONE, 0);
				auxItem.setText(kProcedure.getName());

			}
		}
		// kHumanResource
		TreeItem itemKHumanResource;
		itemKHumanResource = new TreeItem(item, SWT.NONE, 0);
		itemKHumanResource.setText("Human Resources");
		if (activityStandardProcess.getkHumanResources() != null) {
			Iterator<KHumanResource> itKHumanResources = activityStandardProcess
					.getkHumanResources().iterator();
			KHumanResource kHumanResource;
			while (itKHumanResources.hasNext()) {
				kHumanResource = itKHumanResources.next();
				auxItem = new TreeItem(itemKHumanResource, SWT.NONE, 0);
				auxItem.setText(kHumanResource.getName());
			}
		}
		// KResources
		TreeItem itemKResource;
		itemKResource = new TreeItem(item, SWT.NONE, 0);
		itemKResource.setText("Resources");
		if (activityStandardProcess.getkResources() != null) {
			Iterator<KResource> itKResources = activityStandardProcess
					.getkResources().iterator();
			KResource kResource;
			while (itKResources.hasNext()) {
				kResource = itKResources.next();
				auxItem = new TreeItem(itemKResource, SWT.NONE, 0);
				auxItem.setText(kResource.getName());
			}
		}
		// KArtefacts
		TreeItem itemKArtefacts;
		itemKArtefacts = new TreeItem(item, SWT.NONE, 0);
		itemKArtefacts.setText("Artefacts");

		TreeItem iteminputs;
		iteminputs = new TreeItem(itemKArtefacts, SWT.NONE, 0);
		iteminputs.setText("Inputs");
		if (activityStandardProcess.getInputs() != null) {
			Iterator<KArtefact> itInputs = activityStandardProcess.getInputs()
					.iterator();
			KArtefact input;
			while (itInputs.hasNext()) {
				input = itInputs.next();
				auxItem = new TreeItem(iteminputs, SWT.NONE, 0);
				auxItem.setText(input.getName());
			}
		}

		TreeItem itemproducts;
		itemproducts = new TreeItem(itemKArtefacts, SWT.NONE, 0);
		itemproducts.setText("Products");
		if (activityStandardProcess.getProducts() != null) {
			Iterator<KArtefact> itproducts = activityStandardProcess
					.getProducts().iterator();
			KArtefact product;
			while (itproducts.hasNext()) {
				product = itproducts.next();
				auxItem = new TreeItem(itemproducts, SWT.NONE, 0);
				auxItem.setText(product.getName());
			}
		}
		// PreActivies
		TreeItem itemPreActivies;
		itemPreActivies = new TreeItem(item, SWT.NONE, 0);
		itemPreActivies.setText("PreActivities");
		if (activityStandardProcess.getPreActivityStandardProcesses() != null) {
			Iterator<ActivityStandardProcess> itpreactivities = activityStandardProcess
					.getPreActivityStandardProcesses().iterator();
			ActivityStandardProcess preactivity;

			while (itpreactivities.hasNext()) {
				preactivity = itpreactivities.next();
				auxItem = new TreeItem(itemPreActivies, SWT.NONE, 0);
				auxItem.setText(preactivity.getName());

				populateactivity(auxItem, preactivity);

			}
		}

		// SubActivies
		TreeItem itemSubActivies;
		itemSubActivies = new TreeItem(item, SWT.NONE, 0);
		itemSubActivies.setText("SubActivities");
		if (activityStandardProcess.getSubActivityStandardProcesses() != null) {
			Iterator<ActivityStandardProcess> itSubactivities = activityStandardProcess
					.getSubActivityStandardProcesses().iterator();
			ActivityStandardProcess subactivity;
			while (itSubactivities.hasNext()) {
				subactivity = itSubactivities.next();
				auxItem = new TreeItem(itemSubActivies, SWT.NONE, 0);
				auxItem.setText(subactivity.getName());
				populateactivity(auxItem, subactivity);

			}
		}

	}
}
