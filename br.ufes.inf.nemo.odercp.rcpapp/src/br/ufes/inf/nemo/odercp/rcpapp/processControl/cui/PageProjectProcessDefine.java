package br.ufes.inf.nemo.odercp.rcpapp.processControl.cui;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cmt.ApplCRUDHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cpd.HumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KProcedure;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KResource;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cmt.ApplCRUDArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cmt.ApplCRUDGeneralProjectProcess;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cmt.ApplCRUDHardwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cmt.ApplCRUDSoftwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.Activity;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.Artefact;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.GeneralProjectProcess;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.HardwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.Resource;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.SoftwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.SpecificProjectProcess;
import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cmt.ApplSelectProject;
import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cpd.Project;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.ActivityStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.GeneralStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.SpecificStandardProcess;

import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.wb.swt.SWTResourceManager;

public class PageProjectProcessDefine {
	Shell shell;
	GeneralStandardProcess generalStandardProcess;
	GeneralProjectProcess generalProjectProcess;
	PageProjectProcessDefine pageProcessDefine;
	Project project;
	boolean firsttime;
	CTabFolder tabFolder;

	HashMap<String, Activity> hashActivities;
	HashMap<String, Artefact> hashArtefacts;
	HashMap<String, Resource> hashResources;
	HashMap<String, HumanResource> hashHResources;

	HashMap<TreeItem, Activity> hashitemActivities;
	HashMap<TreeItem, KArtefact> hashitemKArtefacts;
	private HashMap<TreeItem, KResource> hashitemKResources;
	private HashMap<TreeItem, KHumanResource> hashitemKHumanResources;

	KArtefact kArtefactselected;
	KResource kResourceselected;
	KHumanResource kHumanResourceselected;

	Tree tree;
	TreeItem root;
	private Composite composite;
	private HashMap<TreeItem, SpecificProjectProcess> hashProjectProcesses;
	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	private List listAvaliablesArtefacts;
	private List listSelectionsArtefacts;
	List listAvaliablesResources;
	List listSelectionsResources;
	List listAvaliablesHResources;
	List listSelectionsHResources;
	private Activity activitySelected;

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
		hashActivities = new HashMap<String, Activity>();
		hashitemActivities = new HashMap<TreeItem, Activity>();
		hashitemKArtefacts = new HashMap<TreeItem, KArtefact>();
		hashitemKResources = new HashMap<TreeItem, KResource>();
		hashitemKHumanResources = new HashMap<TreeItem, KHumanResource>();

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

		MenuItem choiceDefinedItem = new MenuItem(standardMenu, SWT.PUSH);
		choiceDefinedItem.setText("&Choice Project Process Already Defined");
		choiceDefinedItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO

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
		// populate
		tree.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// Artefacts
				listAvaliablesArtefacts.removeAll();
				Artefact[] artefacts = ApplCRUDArtefact.getever();
				for (int i = 0; i < artefacts.length; i++) {
					listAvaliablesArtefacts.add(artefacts[i].getName());
				}
				listSelectionsArtefacts.removeAll();
				// Resources
				listAvaliablesResources.removeAll();
				int j;
				HardwareResource[] hresources = ApplCRUDHardwareResource
						.getever();
				for (j = 0; j < hresources.length; j++) {
					listAvaliablesResources.add(hresources[j].getName());

				}
				SoftwareResource[] sResources = ApplCRUDSoftwareResource
						.getever();
				for (; j < hresources.length + sResources.length; j++) {
					listAvaliablesResources.add(sResources[j
							- hresources.length].getName());

				}
				listSelectionsResources.removeAll();
				// Human Resources
				listAvaliablesHResources.removeAll();
				HumanResource[] humanResources = ApplCRUDHumanResource
						.getever();

				for (int i = 0; i < humanResources.length; i++) {
					listAvaliablesHResources.add(humanResources[i].getName());

				}
				listSelectionsHResources.removeAll();
				// begin
				TreeItem ti = (TreeItem) e.item;
				TreeItem parentartefact = null;
				TreeItem parentResource = null;

				if (ti.getParentItem() != null
						&& ti.getParentItem().getParentItem() != null
						&& ti.getParentItem().getParentItem().getParentItem() != null) {
					parentartefact = ti.getParentItem().getParentItem()
							.getParentItem();
				}

				if (ti.getParentItem() != null
						&& ti.getParentItem().getParentItem() != null) {
					parentResource = ti.getParentItem().getParentItem();
				}

				if (hashitemActivities.get(parentartefact) != null) {
					activitySelected = hashitemActivities.get(parentartefact);
					kArtefactselected = hashitemKArtefacts.get(ti);
					if (kArtefactselected != null) {
						listAvaliablesArtefacts.removeAll();
						for (int i = 0; i < artefacts.length; i++) {
							if (kArtefactselected.getName().equals(
									artefacts[i].getkArtefact().getName())) {

								listAvaliablesArtefacts.add(artefacts[i]
										.getName());
								if ((activitySelected.getInputs() != null && activitySelected
										.getInputs().contains(artefacts[i]))
										|| (activitySelected.getProducts() != null && activitySelected
												.getProducts().contains(
														artefacts[i]))) {

									listSelectionsArtefacts.add(artefacts[i]
											.getName());

									listAvaliablesArtefacts.remove(artefacts[i]
											.getName());
								}
							}
						}

					}
				}// end Artefacts

				if (hashitemActivities.get(parentResource) != null) {
					activitySelected = hashitemActivities.get(parentResource);
					kResourceselected = hashitemKResources.get(ti);
					if (kResourceselected != null) {
						listAvaliablesResources.removeAll();
						for (int i = 0; i < hresources.length; i++) {
							if (kResourceselected.getName().equals(
									hresources[i].getkResource().getName())) {

								listAvaliablesResources.add(hresources[i]
										.getName());
								if ((activitySelected.getResources() != null && activitySelected
										.getResources().contains(hresources[i]))) {

									listSelectionsResources.add(hresources[i]
											.getName());

									listAvaliablesResources
											.remove(hresources[i].getName());
								}
							}
						}// end hard Resources

						for (int i = 0; i < sResources.length; i++) {
							if (kResourceselected.getName().equals(
									sResources[i].getkResource().getName())) {

								listAvaliablesResources.add(sResources[i]
										.getName());
								if ((activitySelected.getResources() != null && activitySelected
										.getResources().contains(sResources[i]))) {

									listSelectionsResources.add(sResources[i]
											.getName());

									listAvaliablesResources
											.remove(sResources[i].getName());
								}
							}
						}// End Soft Resources

					}
				}// End Resources

				if (hashitemActivities.get(parentResource) != null) {
					activitySelected = hashitemActivities.get(parentResource);
					kHumanResourceselected = hashitemKHumanResources.get(ti);
					if (kHumanResourceselected != null) {
						listAvaliablesHResources.removeAll();
						for (int i = 0; i < humanResources.length; i++) {
							if (kHumanResourceselected.getName().equals(
									humanResources[i].getRole().getName())) {

								listAvaliablesHResources.add(humanResources[i]
										.getName());
								if ((activitySelected.getHumanResources() != null && activitySelected
										.getHumanResources().contains(
												humanResources[i]))) {

									listSelectionsHResources
											.add(humanResources[i].getName());

									listAvaliablesHResources
											.remove(humanResources[i].getName());
								}
							}
						}

					}
				}// End Human Resources
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		tabFolder = new CTabFolder(composite, SWT.BORDER);
		GridData gd_tabFolder = new GridData(SWT.LEFT, SWT.FILL, false, true,
				2, 1);
		gd_tabFolder.widthHint = 523;
		tabFolder.setLayoutData(gd_tabFolder);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

		CTabItem tbtmArtefacts = new CTabItem(tabFolder, SWT.NONE);
		tbtmArtefacts.setText("Artefacts");

		Form frmArtefacts = formToolkit.createForm(tabFolder);
		tbtmArtefacts.setControl(frmArtefacts);
		formToolkit.paintBordersFor(frmArtefacts);
		frmArtefacts.setText("Artefacts");

		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT,
				SWT.DEFAULT));

		Composite compositeArtefacts = frmArtefacts.getBody();
		frmArtefacts.getBody().setLayout(new GridLayout(3, false));

		Label label = new Label(frmArtefacts.getBody(), SWT.NONE);
		formToolkit.adapt(label, true, true);
		new Label(frmArtefacts.getBody(), SWT.NONE);
		new Label(frmArtefacts.getBody(), SWT.NONE);

		Label lblAvaliableArtefacts = new Label(compositeArtefacts, SWT.NONE);
		lblAvaliableArtefacts.setFont(SWTResourceManager.getFont("Segoe UI",
				12, SWT.NORMAL));
		lblAvaliableArtefacts.setText("Avaliable:");
		formToolkit.adapt(lblAvaliableArtefacts, true, true);
		new Label(frmArtefacts.getBody(), SWT.NONE);

		Label lblSelectionsArtefacts = new Label(compositeArtefacts, SWT.NONE);
		lblSelectionsArtefacts.setFont(SWTResourceManager.getFont("Segoe UI",
				12, SWT.NORMAL));
		lblSelectionsArtefacts.setLayoutData(new GridData(SWT.LEFT, SWT.TOP,
				false, false, 1, 1));
		lblSelectionsArtefacts.setText("Selected:");
		formToolkit.adapt(lblSelectionsArtefacts, true, true);

		listAvaliablesArtefacts = new List(compositeArtefacts, SWT.BORDER);
		GridData gd_lisMArtefacts = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 15);
		listAvaliablesArtefacts.setLayoutData(gd_lisMArtefacts);
		gd_lisMArtefacts.widthHint = 230;

		Artefact[] artefacts = ApplCRUDArtefact.getever();
		hashArtefacts = new HashMap<String, Artefact>();
		for (int i = 0; i < artefacts.length; i++) {
			listAvaliablesArtefacts.add(artefacts[i].getName());
			hashArtefacts.put(artefacts[i].getName(), artefacts[i]);
		}

		Button select_oneArtefacts = new Button(compositeArtefacts, SWT.NONE);
		GridData gd_buttonArtefacts = new GridData(SWT.FILL, SWT.FILL, false,
				false, 1, 1);
		gd_buttonArtefacts.widthHint = 25;
		select_oneArtefacts.setLayoutData(gd_buttonArtefacts);
		select_oneArtefacts.setText(">");
		select_oneArtefacts.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listAvaliablesArtefacts.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listSelectionsArtefacts.add(selections[i]);
					if (kArtefactselected != null
							&& activitySelected.getKinputs() != null
							&& !activitySelected.getKinputs().isEmpty()
							&& activitySelected.getKinputs().contains(
									kArtefactselected)) {
						activitySelected.getInputs().add(
								hashArtefacts.get(selections[i]));

					} else if (kArtefactselected != null
							&& activitySelected.getKproducts() != null
							&& !activitySelected.getKproducts().isEmpty()
							&& activitySelected.getKproducts().contains(
									kArtefactselected)) {
						activitySelected.getProducts().add(
								hashArtefacts.get(selections[i]));

					}
					listAvaliablesArtefacts.remove(selections[i]);
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}

		});

		listSelectionsArtefacts = new List(compositeArtefacts, SWT.BORDER);
		GridData gd_listselection = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 15);
		listSelectionsArtefacts.setLayoutData(gd_listselection);
		gd_listselection.widthHint = 226;

		Button select_allArtefact = new Button(compositeArtefacts, SWT.NONE);
		select_allArtefact.setText(">>");
		select_allArtefact.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listAvaliablesArtefacts.getItems();

				for (int i = 0; i < selections.length; i++) {
					listSelectionsArtefacts.add(selections[i]);
					if (kArtefactselected != null
							&& activitySelected.getKinputs() != null
							&& !activitySelected.getKinputs().isEmpty()
							&& activitySelected.getKinputs().contains(
									kArtefactselected)) {
						activitySelected.getInputs().add(
								hashArtefacts.get(selections[i]));

					} else if (kArtefactselected != null
							&& activitySelected.getKproducts() != null
							&& !activitySelected.getKproducts().isEmpty()
							&& activitySelected.getKproducts().contains(
									kArtefactselected)) {
						activitySelected.getProducts().add(
								hashArtefacts.get(selections[i]));

					}

				}
				listAvaliablesArtefacts.removeAll();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}

		});

		Button deselect_oneArtefact = new Button(compositeArtefacts, SWT.NONE);
		deselect_oneArtefact.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		deselect_oneArtefact.setText("<");
		deselect_oneArtefact.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listSelectionsArtefacts.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listAvaliablesArtefacts.add(selections[i]);
					if (kArtefactselected != null
							&& activitySelected.getKinputs() != null
							&& !activitySelected.getKinputs().isEmpty()
							&& activitySelected.getKinputs().contains(
									kArtefactselected)) {
						activitySelected.getInputs().remove(
								hashArtefacts.get(selections[i]));

					} else if (kArtefactselected != null
							&& activitySelected.getKproducts() != null
							&& !activitySelected.getKproducts().isEmpty()
							&& activitySelected.getKproducts().contains(
									kArtefactselected)) {
						activitySelected.getProducts().remove(
								hashArtefacts.get(selections[i]));

					}
					listSelectionsArtefacts.remove(selections[i]);

				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}

		});

		Button deselect_allArtefact = new Button(compositeArtefacts, SWT.NONE);
		deselect_allArtefact.setLayoutData(new GridData(SWT.LEFT, SWT.TOP,
				false, false, 1, 1));
		deselect_allArtefact.setText("<<");

		deselect_allArtefact.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listSelectionsArtefacts.getItems();

				for (int i = 0; i < selections.length; i++) {
					listAvaliablesArtefacts.add(selections[i]);
					if (kArtefactselected != null
							&& activitySelected.getKinputs() != null
							&& !activitySelected.getKinputs().isEmpty()
							&& activitySelected.getKinputs().contains(
									kArtefactselected)) {
						activitySelected.getInputs().remove(
								hashArtefacts.get(selections[i]));

					} else if (kArtefactselected != null
							&& activitySelected.getKproducts() != null
							&& !activitySelected.getKproducts().isEmpty()
							&& activitySelected.getKproducts().contains(
									kArtefactselected)) {
						activitySelected.getProducts().remove(
								hashArtefacts.get(selections[i]));

					}
				}
				listSelectionsArtefacts.removeAll();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}

		});
		new Label(frmArtefacts.getBody(), SWT.NONE);
		new Label(frmArtefacts.getBody(), SWT.NONE);
		new Label(frmArtefacts.getBody(), SWT.NONE);
		new Label(frmArtefacts.getBody(), SWT.NONE);
		new Label(frmArtefacts.getBody(), SWT.NONE);
		new Label(frmArtefacts.getBody(), SWT.NONE);
		new Label(frmArtefacts.getBody(), SWT.NONE);
		new Label(frmArtefacts.getBody(), SWT.NONE);
		new Label(frmArtefacts.getBody(), SWT.NONE);
		new Label(frmArtefacts.getBody(), SWT.NONE);
		new Label(frmArtefacts.getBody(), SWT.NONE);
		new Label(frmArtefacts.getBody(), SWT.NONE);
		new Label(frmArtefacts.getBody(), SWT.NONE);

		Button btnDefineArtefact = new Button(compositeArtefacts, SWT.NONE);
		btnDefineArtefact.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		formToolkit.adapt(btnDefineArtefact, true, true);
		btnDefineArtefact.setText("Define");
		btnDefineArtefact.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {

				createtree();
			}

		});

		new Label(composite, SWT.NONE);

		// Resources

		CTabItem tbtmResources = new CTabItem(tabFolder, SWT.NONE);
		tbtmResources.setText("Resources");

		Form frmResources = formToolkit.createForm(tabFolder);
		tbtmResources.setControl(frmResources);
		formToolkit.paintBordersFor(frmResources);
		frmResources.setText("Resources");

		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT,
				SWT.DEFAULT));

		Composite compositeResources = frmResources.getBody();
		frmResources.getBody().setLayout(new GridLayout(3, false));

		new Label(frmResources.getBody(), SWT.NONE);
		formToolkit.adapt(label, true, true);
		new Label(frmResources.getBody(), SWT.NONE);
		new Label(frmResources.getBody(), SWT.NONE);

		Label lblAvaliableResources = new Label(compositeResources, SWT.NONE);
		lblAvaliableResources.setFont(SWTResourceManager.getFont("Segoe UI",
				12, SWT.NORMAL));
		lblAvaliableResources.setText("Avaliable:");
		formToolkit.adapt(lblAvaliableResources, true, true);
		new Label(frmResources.getBody(), SWT.NONE);

		Label lblSelectionsResources = new Label(compositeResources, SWT.NONE);
		lblSelectionsResources.setFont(SWTResourceManager.getFont("Segoe UI",
				12, SWT.NORMAL));
		lblSelectionsResources.setLayoutData(new GridData(SWT.LEFT, SWT.TOP,
				false, false, 1, 1));
		lblSelectionsResources.setText("Selected:");
		formToolkit.adapt(lblSelectionsResources, true, true);

		listAvaliablesResources = new List(compositeResources, SWT.BORDER);
		GridData gd_listResources = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 15);
		listAvaliablesResources.setLayoutData(gd_listResources);
		gd_listResources.widthHint = 230;
		int j;
		HardwareResource[] hresources = ApplCRUDHardwareResource.getever();
		hashResources = new HashMap<String, Resource>();
		for (j = 0; j < hresources.length; j++) {
			listAvaliablesResources.add(hresources[j].getName());
			hashResources.put(hresources[j].getName(), hresources[j]);
		}
		SoftwareResource[] sResources = ApplCRUDSoftwareResource.getever();
		for (; j < hresources.length + sResources.length; j++) {
			listAvaliablesResources.add(sResources[j - hresources.length]
					.getName());
			hashResources.put(sResources[j - hresources.length].getName(),
					sResources[j - hresources.length]);
		}

		Button select_oneResources = new Button(compositeResources, SWT.NONE);
		GridData gd_buttonResources = new GridData(SWT.FILL, SWT.FILL, false,
				false, 1, 1);
		gd_buttonResources.widthHint = 25;
		select_oneResources.setLayoutData(gd_buttonResources);
		select_oneResources.setText(">");
		select_oneResources.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listAvaliablesResources.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listSelectionsResources.add(selections[i]);
					if (kResourceselected != null
							&& activitySelected.getkResources() != null
							&& !activitySelected.getkResources().isEmpty()
							&& activitySelected.getkResources().contains(
									kResourceselected)) {

						activitySelected.getResources().add(
								hashResources.get(selections[i]));

					}
					listAvaliablesResources.remove(selections[i]);
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}

		});

		listSelectionsResources = new List(compositeResources, SWT.BORDER);
		GridData gd_listselectionResources = new GridData(SWT.FILL, SWT.FILL,
				true, true, 1, 15);
		listSelectionsResources.setLayoutData(gd_listselectionResources);
		gd_listselectionResources.widthHint = 226;

		Button select_allResources = new Button(compositeResources, SWT.NONE);
		select_allResources.setText(">>");
		select_allResources.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listAvaliablesResources.getItems();

				for (int i = 0; i < selections.length; i++) {
					listSelectionsResources.add(selections[i]);
					if (kResourceselected != null
							&& activitySelected.getkResources() != null
							&& !activitySelected.getkResources().isEmpty()
							&& activitySelected.getkResources().contains(
									kResourceselected)) {

						activitySelected.getResources().add(
								hashResources.get(selections[i]));

					}

				}
				listAvaliablesResources.removeAll();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}

		});

		Button deselect_oneResources = new Button(compositeResources, SWT.NONE);
		deselect_oneResources.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		deselect_oneResources.setText("<");
		deselect_oneResources.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listSelectionsResources.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listAvaliablesResources.add(selections[i]);
					if (kResourceselected != null
							&& activitySelected.getkResources() != null
							&& !activitySelected.getkResources().isEmpty()
							&& activitySelected.getkResources().contains(
									kResourceselected)) {

						activitySelected.getResources().remove(
								hashResources.get(selections[i]));

					}
					listSelectionsResources.remove(selections[i]);

				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}

		});

		Button deselect_allResources = new Button(compositeResources, SWT.NONE);
		deselect_allResources.setLayoutData(new GridData(SWT.LEFT, SWT.TOP,
				false, false, 1, 1));
		deselect_allResources.setText("<<");

		deselect_allResources.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listSelectionsResources.getItems();

				for (int i = 0; i < selections.length; i++) {
					listAvaliablesResources.add(selections[i]);
					if (kResourceselected != null
							&& activitySelected.getkResources() != null
							&& !activitySelected.getkResources().isEmpty()
							&& activitySelected.getkResources().contains(
									kResourceselected)) {

						activitySelected.getResources().remove(
								hashResources.get(selections[i]));

					}
				}
				listSelectionsResources.removeAll();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}

		});
		new Label(frmResources.getBody(), SWT.NONE);
		new Label(frmResources.getBody(), SWT.NONE);
		new Label(frmResources.getBody(), SWT.NONE);
		new Label(frmResources.getBody(), SWT.NONE);
		new Label(frmResources.getBody(), SWT.NONE);
		new Label(frmResources.getBody(), SWT.NONE);
		new Label(frmResources.getBody(), SWT.NONE);
		new Label(frmResources.getBody(), SWT.NONE);
		new Label(frmResources.getBody(), SWT.NONE);
		new Label(frmResources.getBody(), SWT.NONE);
		new Label(frmResources.getBody(), SWT.NONE);
		new Label(frmResources.getBody(), SWT.NONE);
		new Label(frmResources.getBody(), SWT.NONE);

		Button btnDefineResource = new Button(compositeResources, SWT.NONE);
		btnDefineResource.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		formToolkit.adapt(btnDefineResource, true, true);
		btnDefineResource.setText("Define");
		btnDefineResource.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {

				createtree();
			}

		});

		new Label(composite, SWT.NONE);

		// Human Resources
		CTabItem tbHumanResource = new CTabItem(tabFolder, SWT.NONE);
		tbHumanResource.setText("Humans Resources");

		Form frmHResources = formToolkit.createForm(tabFolder);
		tbHumanResource.setControl(frmHResources);
		formToolkit.paintBordersFor(frmHResources);
		frmHResources.setText("Humans Resources");

		Composite compositeHResources = frmHResources.getBody();
		frmHResources.getBody().setLayout(new GridLayout(3, false));

		new Label(frmHResources.getBody(), SWT.NONE);
		formToolkit.adapt(label, true, true);
		new Label(frmHResources.getBody(), SWT.NONE);
		new Label(frmHResources.getBody(), SWT.NONE);

		Label lblAvaliableHResources = new Label(compositeHResources, SWT.NONE);
		lblAvaliableHResources.setFont(SWTResourceManager.getFont("Segoe UI",
				12, SWT.NORMAL));
		lblAvaliableHResources.setText("Avaliable:");
		formToolkit.adapt(lblAvaliableHResources, true, true);
		new Label(frmHResources.getBody(), SWT.NONE);

		Label lblSelectionsHResources = new Label(compositeHResources, SWT.NONE);
		lblSelectionsHResources.setFont(SWTResourceManager.getFont("Segoe UI",
				12, SWT.NORMAL));
		lblSelectionsHResources.setLayoutData(new GridData(SWT.LEFT, SWT.TOP,
				false, false, 1, 1));
		lblSelectionsHResources.setText("Selected:");
		formToolkit.adapt(lblSelectionsHResources, true, true);

		listAvaliablesHResources = new List(compositeHResources, SWT.BORDER);
		GridData gd_listHResources = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 15);
		listAvaliablesHResources.setLayoutData(gd_listHResources);
		gd_listHResources.widthHint = 230;

		HumanResource[] humanResources = ApplCRUDHumanResource.getever();
		hashHResources = new HashMap<String, HumanResource>();
		for (int i = 0; i < humanResources.length; i++) {
			listAvaliablesHResources.add(humanResources[i].getName());
			hashHResources.put(humanResources[i].getName(), humanResources[i]);
		}

		Button select_oneHResource = new Button(compositeHResources, SWT.NONE);
		GridData gd_buttonHResources = new GridData(SWT.FILL, SWT.FILL, false,
				false, 1, 1);
		gd_buttonHResources.widthHint = 25;
		select_oneHResource.setLayoutData(gd_buttonHResources);
		select_oneHResource.setText(">");
		select_oneHResource.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listAvaliablesHResources.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listSelectionsHResources.add(selections[i]);
					if (kHumanResourceselected != null
							&& activitySelected.getkHumanResources() != null
							&& !activitySelected.getkHumanResources().isEmpty()
							&& activitySelected.getkHumanResources().contains(
									kHumanResourceselected)) {
						activitySelected.getHumanResources().add(
								hashHResources.get(selections[i]));

					}
					listAvaliablesHResources.remove(selections[i]);
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}

		});

		listSelectionsHResources = new List(compositeHResources, SWT.BORDER);
		GridData gd_listselectionHR = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 15);
		listSelectionsHResources.setLayoutData(gd_listselectionHR);
		gd_listselectionHR.widthHint = 226;

		Button select_allHResources = new Button(compositeHResources, SWT.NONE);
		select_allHResources.setText(">>");
		select_allHResources.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listAvaliablesHResources.getItems();

				for (int i = 0; i < selections.length; i++) {
					listSelectionsHResources.add(selections[i]);
					if (kHumanResourceselected != null
							&& activitySelected.getkHumanResources() != null
							&& !activitySelected.getkHumanResources().isEmpty()
							&& activitySelected.getkHumanResources().contains(
									kHumanResourceselected)) {
						activitySelected.getHumanResources().add(
								hashHResources.get(selections[i]));

					}

				}
				listAvaliablesHResources.removeAll();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}

		});

		Button deselect_oneHResource = new Button(compositeHResources, SWT.NONE);
		deselect_oneHResource.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		deselect_oneHResource.setText("<");
		deselect_oneHResource.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listSelectionsHResources.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listAvaliablesHResources.add(selections[i]);
					if (kHumanResourceselected != null
							&& activitySelected.getkHumanResources() != null
							&& !activitySelected.getkHumanResources().isEmpty()
							&& activitySelected.getkHumanResources().contains(
									kHumanResourceselected)) {
						activitySelected.getHumanResources().remove(
								hashHResources.get(selections[i]));

					}
					listSelectionsHResources.remove(selections[i]);

				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}

		});

		Button deselect_allHResources = new Button(compositeHResources,
				SWT.NONE);
		deselect_allHResources.setLayoutData(new GridData(SWT.LEFT, SWT.TOP,
				false, false, 1, 1));
		deselect_allHResources.setText("<<");

		deselect_allHResources.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listSelectionsHResources.getItems();

				for (int i = 0; i < selections.length; i++) {
					listAvaliablesHResources.add(selections[i]);
					if (kHumanResourceselected != null
							&& activitySelected.getkHumanResources() != null
							&& !activitySelected.getkHumanResources().isEmpty()
							&& activitySelected.getkHumanResources().contains(
									kHumanResourceselected)) {
						activitySelected.getHumanResources().remove(
								hashHResources.get(selections[i]));

					}
				}
				listSelectionsHResources.removeAll();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}

		});
		new Label(frmHResources.getBody(), SWT.NONE);
		new Label(frmHResources.getBody(), SWT.NONE);
		new Label(frmHResources.getBody(), SWT.NONE);
		new Label(frmHResources.getBody(), SWT.NONE);
		new Label(frmHResources.getBody(), SWT.NONE);
		new Label(frmHResources.getBody(), SWT.NONE);
		new Label(frmHResources.getBody(), SWT.NONE);
		new Label(frmHResources.getBody(), SWT.NONE);
		new Label(frmHResources.getBody(), SWT.NONE);
		new Label(frmHResources.getBody(), SWT.NONE);
		new Label(frmHResources.getBody(), SWT.NONE);
		new Label(frmHResources.getBody(), SWT.NONE);
		new Label(frmHResources.getBody(), SWT.NONE);

		Button btnDefineHResource = new Button(compositeHResources, SWT.NONE);
		btnDefineHResource.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		formToolkit.adapt(btnDefineHResource, true, true);
		btnDefineHResource.setText("Define");
		btnDefineHResource.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {

				createtree();
			}

		});

		new Label(composite, SWT.NONE);

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
				// populateactivityStandard(preactivities[w], preactivity);
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
		generalProjectProcess.setName(project.getName() + "::"
				+ generalStandardProcess.getName());
		generalProjectProcess.setProject(project);
		generalProjectProcess.setStandardProcess(generalStandardProcess);
		ApplCRUDGeneralProjectProcess.Create(generalProjectProcess);

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
			root.setText(project.getName() + "::"
					+ generalStandardProcess.getName());
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
				hashitemActivities.put(auxitem, activities[i]);
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
				hashitemKHumanResources.put(auxItem, kHumanResource);
				// TODO fazer verificacao dos konw e um remove all na lista de
				// hr
				if (activity.getHumanResources() != null
						&& !activity.getHumanResources().isEmpty()) {
					populateHResources(auxItem, activity, kHumanResource);
				}
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
				hashitemKResources.put(auxItem, kResource);
				if (activity.getResources() != null
						&& !activity.getResources().isEmpty()) {

					populateResources(auxItem, activity, kResource);
				}
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
				hashitemKArtefacts.put(auxItem, input);
				if (activity.getInputs() != null
						&& !activity.getInputs().isEmpty()) {

					populateInputs(auxItem, activity, input);
				}
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
				hashitemKArtefacts.put(auxItem, product);
				if (activity.getProducts() != null
						&& !activity.getProducts().isEmpty()) {

					populateProducts(auxItem, activity, product);
				}

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

				// populateactivity(auxItem, preactivity);

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
				hashitemActivities.put(auxItem, subactivity);
				populateactivity(auxItem, subactivity);

			}
		}

	}

	private void populateHResources(TreeItem auxItem, Activity activity,
			KHumanResource kHumanResource) {
		if (activity != null && activity.getHumanResources() != null
				&& !activity.getHumanResources().isEmpty()) {
			HumanResource[] Hresources = activity.getHumanResources().toArray(
					new HumanResource[activity.getHumanResources().size()]);
			for (int i = 0; i < Hresources.length; i++) {
				if (Hresources[i].getRole().getName()
						.equals(kHumanResource.getName())) {
					TreeItem item;
					item = new TreeItem(auxItem, SWT.NONE, 0);
					item.setText(Hresources[i].getName());
				}
			}
		}
	}

	private void populateResources(TreeItem auxItem, Activity activity,
			KResource kResource) {
		if (activity != null && activity.getResources() != null
				&& !activity.getResources().isEmpty()) {
			Resource[] resources = activity.getResources().toArray(
					new Resource[activity.getResources().size()]);
			for (int i = 0; i < resources.length; i++) {
				if (resources[i].getkResource().getName()
						.equals(kResource.getName())) {
					TreeItem item;
					item = new TreeItem(auxItem, SWT.NONE, 0);
					item.setText(resources[i].getName());
				}
			}
		}
	}

	private void populateProducts(TreeItem auxItem, Activity activity,
			KArtefact kArtefact) {
		if (activity != null && activity.getProducts() != null
				&& !activity.getProducts().isEmpty()) {
			Artefact[] products = activity.getProducts().toArray(
					new Artefact[activity.getProducts().size()]);
			for (int i = 0; i < products.length; i++) {
				if (products[i].getkArtefact().getName()
						.equals(kArtefact.getName())) {
					TreeItem item;
					item = new TreeItem(auxItem, SWT.NONE, 0);
					item.setText(products[i].getName());
				}
			}
		}

	}

	private void populateInputs(TreeItem auxItem, Activity activity,
			KArtefact kArtefact) {
		if (activity != null && activity.getInputs() != null
				&& !activity.getInputs().isEmpty()) {
			Artefact[] inputs = activity.getInputs().toArray(
					new Artefact[activity.getInputs().size()]);
			for (int i = 0; i < inputs.length; i++) {
				if (inputs[i].getkArtefact().getName()
						.equals(kArtefact.getName())) {
					TreeItem item;
					item = new TreeItem(auxItem, SWT.NONE, 0);
					item.setText(inputs[i].getName());
				}
			}
		}

	}
}
