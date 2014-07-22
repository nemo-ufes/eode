package br.ufes.inf.nemo.odercp.rcpapp.processControl.cui;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KProcedure;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KResource;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.Activity;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.GeneralProjectProcess;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.SpecificProjectProcess;
import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cmt.ApplSelectProject;
import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cpd.Project;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.ActivityStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.GeneralStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.SpecificStandardProcess;

public class PageProjectProcessDefine {
	Shell shell;
	GeneralStandardProcess generalStandardProcess;
	GeneralProjectProcess generalProjectProcess;
	PageProjectProcessDefine pageProcessDefine;
	Project project;
	boolean firsttime;
	CTabFolder tabFolder;

	HashMap<String, Activity> hashActivities;

	Tree tree;
	TreeItem root;
	private Composite composite;
	private HashMap<TreeItem, SpecificProjectProcess> hashProjectProcesses;

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

		project = ApplSelectProject.getSelected();

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

		tabFolder = new CTabFolder(composite, SWT.BORDER);
		GridData gd_tabFolder = new GridData(SWT.LEFT, SWT.FILL, false, true,
				2, 1);
		gd_tabFolder.widthHint = 488;
		tabFolder.setLayoutData(gd_tabFolder);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT,
				SWT.DEFAULT));

		tree.setVisible(false);
		tabFolder.setVisible(false);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void populateactivityStandard(
			ActivityStandardProcess activitystandard, Activity auxactivity) {
		Activity preactivity;
		ActivityStandardProcess[] preactivities;

		int sizepre;
		if (activitystandard.getPreActivityStandardProcesses() != null
				&& activitystandard.getPreActivityStandardProcesses().size() > 0) {
			sizepre = activitystandard.getPreActivityStandardProcesses().size();
			preactivities = activitystandard.getPreActivityStandardProcesses()
					.toArray(new ActivityStandardProcess[sizepre]);
			for (int w = 0; w < sizepre; w++) {
				preactivity = new Activity();
				preactivity.setName(preactivities[w].getName());
				preactivity.setActivityStandardProcess(preactivities[w]);
				preactivity.setkHumanResources(preactivities[w]
						.getkHumanResources());
				preactivity.setkActivity(preactivities[w].getkActivity());
				preactivity.setKinputs(preactivities[w].getInputs());
				preactivity.setkProcedures(preactivities[w].getkProcedures());
				preactivity.setKproducts(preactivities[w].getProducts());
				preactivity.setkResources(preactivities[w].getkResources());
				//populateactivityStandard(preactivities[w], preactivity);
				auxactivity.getPreActivities().add(preactivity);
			}
		}

		int sizesub;
		Activity subactivity;
		ActivityStandardProcess[] subactivities;
		if (activitystandard.getSubActivityStandardProcesses() != null
				&& activitystandard.getSubActivityStandardProcesses().size() > 0) {

			sizesub = activitystandard.getSubActivityStandardProcesses().size();
			subactivities = activitystandard.getSubActivityStandardProcesses()
					.toArray(new ActivityStandardProcess[sizesub]);
			for (int w = 0; w < sizesub; w++) {
				subactivity = new Activity();
				subactivity.setName(subactivities[w].getName());
				subactivity.setActivityStandardProcess(subactivities[w]);
				subactivity.setkHumanResources(subactivities[w]
						.getkHumanResources());
				subactivity.setkActivity(subactivities[w].getkActivity());
				subactivity.setKinputs(subactivities[w].getInputs());
				subactivity.setkProcedures(subactivities[w].getkProcedures());
				subactivity.setKproducts(subactivities[w].getProducts());
				subactivity.setkResources(subactivities[w].getkResources());
				populateactivityStandard(subactivities[w], subactivity);
				auxactivity.getSubActivities().add(subactivity);
			}
		}

	}

	private void createGeneralProcess() {
		generalProjectProcess = new GeneralProjectProcess();
		generalProjectProcess.setName(generalStandardProcess.getName() + "::"
				+ project.getName());
		generalProjectProcess.setProject(project);
		generalProjectProcess.setStandardProcess(generalStandardProcess);

		SpecificStandardProcess[] specificStandardProcesses;
		int sizeact, size = generalStandardProcess
				.getSpecificStandardProcesses().size();
		specificStandardProcesses = generalStandardProcess
				.getSpecificStandardProcesses().toArray(
						new SpecificStandardProcess[size]);

		// put specific process
		SpecificProjectProcess processEng = null;
		SpecificProjectProcess specificProjectProcess;
		Activity activity = null;
		ActivityStandardProcess[] activities;

		for (int i = 0; i < size; i++) {
			if (!specificStandardProcesses[i].getkProcess().isEngineering()) {
				specificProjectProcess = new SpecificProjectProcess();
				specificProjectProcess.setName(specificStandardProcesses[i]
						.getName());

				specificProjectProcess
						.setStandardProcess(specificStandardProcesses[i]);

				sizeact = specificStandardProcesses[i]
						.getActivityStandardProcesses().size();

				activities = specificStandardProcesses[i]
						.getActivityStandardProcesses().toArray(
								new ActivityStandardProcess[sizeact]);

				for (int j = 0; j < sizeact; j++) {
					activity = new Activity();
					activity.setName(activities[j].getName());
					activity.setActivityStandardProcess(activities[j]);
					activity.setkHumanResources(activities[j]
							.getkHumanResources());
					activity.setkActivity(activities[j].getkActivity());
					activity.setKinputs(activities[j].getInputs());
					activity.setkProcedures(activities[j].getkProcedures());
					activity.setKproducts(activities[j].getProducts());
					activity.setkResources(activities[j].getkResources());
					populateactivityStandard(activities[j], activity);
					specificProjectProcess.getActivities().add(activity);

				}

				generalProjectProcess.getSubProcesses().add(
						specificProjectProcess);
			} else {
				specificProjectProcess = new SpecificProjectProcess();
				specificProjectProcess.setName(specificStandardProcesses[i]
						.getName());

				specificProjectProcess
						.setStandardProcess(specificStandardProcesses[i]);

				sizeact = specificStandardProcesses[i]
						.getActivityStandardProcesses().size();

				activities = specificStandardProcesses[i]
						.getActivityStandardProcesses().toArray(
								new ActivityStandardProcess[sizeact]);

				for (int j = 0; j < sizeact; j++) {
					activity = new Activity();
					activity.setName(activities[j].getName());
					activity.setActivityStandardProcess(activities[j]);
					activity.setkHumanResources(activities[j]
							.getkHumanResources());
					activity.setkActivity(activities[j].getkActivity());
					activity.setKinputs(activities[j].getInputs());
					activity.setkProcedures(activities[j].getkProcedures());
					activity.setKproducts(activities[j].getProducts());
					activity.setkResources(activities[j].getkResources());
					populateactivityStandard(activities[j], activity);
					specificProjectProcess.getActivities().add(activity);

				}

				processEng = specificProjectProcess;
			}// end else

		}// end for
		generalProjectProcess.getSubProcesses().add(processEng);

	}

	protected void createtree() {
		if (generalStandardProcess != null) {
			tree.removeAll();

			tree.setVisible(true);
			root = new TreeItem(tree, SWT.NONE);
			root.setText(generalStandardProcess.getName() + "::"
					+ project.getName());
			if (!firsttime) {
				createGeneralProcess();
				firsttime = true;
				tabFolder.setSelection(0);
			}
			tabFolder.setVisible(true);

			TreeItem item;

			hashProjectProcesses = new HashMap<TreeItem, SpecificProjectProcess>();

			SpecificProjectProcess[] itsubprocesses = generalProjectProcess
					.getSubProcesses().toArray(
							new SpecificProjectProcess[generalProjectProcess
									.getSubProcesses().size()]);
			SpecificProjectProcess auxspecificProjectProcess;
			for (int i = itsubprocesses.length - 1; i >= 0; i--) {

				auxspecificProjectProcess = itsubprocesses[i];

				item = new TreeItem(root, SWT.NONE);
				item.setText(auxspecificProjectProcess.getName());
				hashProjectProcesses.put(item, auxspecificProjectProcess);
				populateProcess(item, auxspecificProjectProcess);

			}

		} else {
			MessageDialog.openConfirm(null, "Confirmation",
					"Choice Standard Process to define.");
		}
	}

	private void populateProcess(TreeItem item,
			SpecificProjectProcess auxspecificProjectProcess) {

		if (auxspecificProjectProcess.getActivities() != null
				&& !auxspecificProjectProcess.getActivities().isEmpty()) {

			TreeItem auxitem;
			int size = auxspecificProjectProcess.getActivities().size();

			Activity[] activities = auxspecificProjectProcess.getActivities()
					.toArray(new Activity[size]);
			int j = size - 1;
			for (int i = j; i >= 0; i--) {

				auxitem = new TreeItem(item, SWT.NONE, 0);
				auxitem.setText(activities[i].getName());

				populateactivity(auxitem, activities[i]);
			}

		}

	}

	private void populateactivity(TreeItem item, Activity activity) {

		TreeItem auxItem;
		// kProcedures
		TreeItem itemKprocedure;
		itemKprocedure = new TreeItem(item, SWT.NONE, 0);
		itemKprocedure.setText("Procedures");
		if (activity.getkProcedures() != null
				&& !activity.getkProcedures().isEmpty()) {
			Iterator<KProcedure> itKProcedures = activity.getkProcedures()
					.iterator();
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
		if (activity.getkHumanResources() != null
				&& !activity.getkHumanResources().isEmpty()) {
			Iterator<KHumanResource> itKHumanResources = activity
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
		if (activity.getkResources() != null
				&& !activity.getkResources().isEmpty()) {
			Iterator<KResource> itKResources = activity.getkResources()
					.iterator();
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
		if (activity.getKinputs() != null && !activity.getKinputs().isEmpty()) {
			Iterator<KArtefact> itInputs = activity.getKinputs().iterator();
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
		if (activity.getKproducts() != null
				&& !activity.getKproducts().isEmpty()) {
			Iterator<KArtefact> itproducts = activity.getKproducts().iterator();
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
		if (activity.getPreActivities() != null
				&& !activity.getPreActivities().isEmpty()) {
			Iterator<Activity> itpreactivities = activity.getPreActivities()
					.iterator();
			Activity preactivity;

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
		if (activity.getSubActivities() != null
				&& !activity.getSubActivities().isEmpty()) {
			Iterator<Activity> itSubactivities = activity.getSubActivities()
					.iterator();
			Activity subactivity;
			while (itSubactivities.hasNext()) {
				subactivity = itSubactivities.next();
				auxItem = new TreeItem(itemSubActivies, SWT.NONE, 0);
				auxItem.setText(subactivity.getName());
				populateactivity(auxItem, subactivity);

			}
		}

	}
}
