package br.ufes.inf.nemo.odercp.rcpapp.editors;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeMain.pdl.Knowledge;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KActivity;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KHardwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KLifeCycleModel;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KProcedure;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KProcess;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KSoftwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml.ApplCRUDKActivity;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml.ApplCRUDKArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml.ApplCRUDKHardwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml.ApplCRUDKHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml.ApplCRUDKLifeCycleModel;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml.ApplCRUDKProcedure;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml.ApplCRUDKProcess;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml.ApplCRUDKSoftwareResource;

public class FormEditorKnowledge extends FormPage {

	private ScrolledForm form;
	private FormToolkit toolkit;
	private Text name;
	private Text description;
	private Button btnMandatory;
	private Button btnIsengineering;
	private Map<TreeItem, Knowledge> hashKnowledge;
	private TabFolder tabFolderKActivity;
	private TabFolder tabFolderKArtefact;
	private TabItem subKactivites;
	private TabItem kHumanResources;
	private TabItem preKactivites;
	private TabItem inputs;
	private TabItem products;
	private TabItem kProcedures;
	private TabItem kProcess;
	private TabItem kResources;
	private TabItem subkArtefacts;
	private TabItem depends;
	private Button checksubKactivies[];
	private Button checkHumanResources[];
	private Button checkprekActivities[];
	private Button checkinputs[];
	private Button checkproducts[];
	private Button checkkprocedures[];
	private Button radioskprocesses[];
	private Button checkResources[];
	private Button checksubartefacts[];
	private Button checkdepends[];
	private Button btnUpdate;
	private Tree tree;
	private TreeItem root;
	private Button btnDelete;
	private Knowledge chosenKnowledge;

	/** Hashs */
	Map<String, Integer> hashKActivity;
	Map<String, Integer> hashKArtefact;
	Map<String, Integer> hashKProcess;
	Map<String, Integer> hashKProcedure;
	Map<String, Integer> hashKLifeCycleModel;
	Map<String, Integer> hashKResource;
	Map<String, Integer> hashKHumanResources;

	/**
	 * Create the form page.
	 * 
	 * @param id
	 * @param title
	 */
	public FormEditorKnowledge(String id, String title) {
		super(id, title);
	}

	/**
	 * Create the form page.
	 * 
	 * @param editor
	 * @param id
	 * @param title
	 * @wbp.parser.constructor
	 * @wbp.eval.method.parameter id "Some id"
	 * @wbp.eval.method.parameter title "Some title"
	 */
	public FormEditorKnowledge(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}

	/**
	 * Create contents of the form.
	 * 
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		toolkit = managedForm.getToolkit();
		form = managedForm.getForm();
		form.setText("Page Knowledge");
		Composite container = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(container);

		container.setLayout(new GridLayout(3, false));

		// TreeViewer treeViewer = new TreeViewer(container, SWT.BORDER);
		tree = new Tree(container, SWT.BORDER);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		GridData gd_tree = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 13);
		gd_tree.widthHint = 248;
		tree.setLayoutData(gd_tree);

		root = new TreeItem(tree, SWT.NONE, 0);
		root.setText("Knowledge");
		root.setExpanded(true);

		// inicialize hashKnowledge
		hashKnowledge = new HashMap<TreeItem, Knowledge>();

		TreeItem rootProcess = new TreeItem(root, SWT.NONE, 0);
		rootProcess.setText("Process");
		rootProcess.setExpanded(true);
		{

			TreeItem rootPProcess = new TreeItem(rootProcess, SWT.NONE, 0);
			rootPProcess.setText("Process");
			rootPProcess.setExpanded(true);

			KProcess[] kProcesses = ApplCRUDKProcess.getever();

			for (int i = 0; i < kProcesses.length; i++) {
				TreeItem no = new TreeItem(rootPProcess, SWT.NONE, i);
				no.setText(kProcesses[i].getName());
				hashKnowledge.put(no, kProcesses[i]);

			}

			TreeItem rootProcedure = new TreeItem(rootProcess, SWT.NONE, 0);
			rootProcedure.setText("Procedure");
			rootProcedure.setExpanded(true);

			KProcedure[] kProcedures = ApplCRUDKProcedure.getever();

			for (int i = 0; i < kProcedures.length; i++) {
				TreeItem no = new TreeItem(rootProcedure, SWT.NONE, i);
				no.setText(kProcedures[i].getName());
				hashKnowledge.put(no, kProcedures[i]);

			}

			TreeItem rootLifeCycleModel = new TreeItem(rootProcess, SWT.NONE, 0);
			rootLifeCycleModel.setText("Life-Cycle Model");
			rootLifeCycleModel.setExpanded(true);

			KLifeCycleModel[] kLifeCycleModels = ApplCRUDKLifeCycleModel.getever();

			for (int i = 0; i < kLifeCycleModels.length; i++) {
				TreeItem no = new TreeItem(rootLifeCycleModel, SWT.NONE, i);
				no.setText(kLifeCycleModels[i].getName());
				hashKnowledge.put(no, kLifeCycleModels[i]);

			}

			TreeItem rootArtefact = new TreeItem(rootProcess, SWT.NONE, 0);
			rootArtefact.setText("Artefact");
			rootArtefact.setExpanded(true);

			KArtefact[] kArtefacts = ApplCRUDKArtefact.getever();
			for (int i = 0; i < kArtefacts.length; i++) {
				TreeItem no = new TreeItem(rootArtefact, SWT.NONE, i);
				no.setText(kArtefacts[i].getName());
				hashKnowledge.put(no, kArtefacts[i]);

			}

			TreeItem rootActivity = new TreeItem(rootProcess, SWT.NONE, 0);
			rootActivity.setText("Activity");
			rootActivity.setExpanded(true);

			KActivity[] kActivities = ApplCRUDKActivity.getever();
			for (int i = 0; i < kActivities.length; i++) {
				TreeItem no = new TreeItem(rootActivity, SWT.NONE, i);
				no.setText(kActivities[i].getName());
				hashKnowledge.put(no, kActivities[i]);

			}

		}

		TreeItem rootResource = new TreeItem(root, SWT.NONE, 0);
		rootResource.setText("Resource");
		rootResource.setExpanded(true);
		{

			TreeItem rootHadwareResource = new TreeItem(rootResource, SWT.NONE, 0);
			rootHadwareResource.setText("Hardware Resource");
			rootHadwareResource.setExpanded(true);

			KHardwareResource[] kHardwareResource = ApplCRUDKHardwareResource.getever();

			for (int i = 0; i < kHardwareResource.length; i++) {
				TreeItem no = new TreeItem(rootHadwareResource, SWT.NONE, i);
				no.setText(kHardwareResource[i].getName());
				hashKnowledge.put(no, kHardwareResource[i]);

			}

			TreeItem rootSoftwareResource = new TreeItem(rootResource, SWT.NONE, 0);
			rootSoftwareResource.setText("Software Resource");
			rootSoftwareResource.setExpanded(true);

			KSoftwareResource[] kSoftwareResource = ApplCRUDKSoftwareResource.getever();
			for (int i = 0; i < kSoftwareResource.length; i++) {
				TreeItem no = new TreeItem(rootSoftwareResource, SWT.NONE, i);
				no.setText(kSoftwareResource[i].getName());
				hashKnowledge.put(no, kSoftwareResource[i]);

			}

			TreeItem rootHumanResource = new TreeItem(rootResource, SWT.NONE, 0);
			rootHumanResource.setText("Human Resource");
			rootHumanResource.setExpanded(true);

			KHumanResource[] kHumanResource = ApplCRUDKHumanResource.getever();
			for (int i = 0; i < kHumanResource.length; i++) {
				TreeItem no = new TreeItem(rootHumanResource, SWT.NONE, i);
				no.setText(kHumanResource[i].getName());
				hashKnowledge.put(no, kHumanResource[i]);

			}

		}

		// selection to Knowledge
		tree.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TreeItem ti = (TreeItem) e.item;
				if (hashKnowledge.get(ti) != null) populateKnowledge(hashKnowledge.get(ti));
			}

			private void populateKnowledge(Knowledge k) {
				chosenKnowledge = k;
				name.setText(k.getName());
				description.setText(k.getDescription());
				if (k instanceof KActivity) {
					hideelements();

					btnMandatory.setVisible(true);
					btnMandatory.setSelection(((KActivity) k).isMandatory());
					tabFolderKActivity.setVisible(true);
					/** complete the tabfolderKActivity */

					if (((KActivity) k).getSubKActivities() != null) {
						Iterator<KActivity> itsubkActivities = ((KActivity) k).getSubKActivities().iterator();
						while (itsubkActivities.hasNext()) {

							Integer i = hashKActivity.get(itsubkActivities.next().getName());
							checkprekActivities[i.intValue()].setSelection(true);
						}
					}

					if (((KActivity) k).getPreKActivities() != null) {
						Iterator<KActivity> itprekActivities = ((KActivity) k).getPreKActivities().iterator();
						while (itprekActivities.hasNext()) {

							Integer i = hashKActivity.get(itprekActivities.next().getName());
							checkprekActivities[i.intValue()].setSelection(true);
						}
					}

					if (((KActivity) k).getInputs() != null) {
						Iterator<KArtefact> itinputs = ((KActivity) k).getInputs().iterator();
						while (itinputs.hasNext()) {

							Integer i = hashKArtefact.get(itinputs.next().getName());
							checkinputs[i.intValue()].setSelection(true);
						}
					}

					if (((KActivity) k).getProducts() != null) {
						Iterator<KArtefact> itproducts = ((KActivity) k).getProducts().iterator();
						while (itproducts.hasNext()) {

							Integer i = hashKArtefact.get(itproducts.next().getName());
							checkproducts[i.intValue()].setSelection(true);
						}
					}

					if (((KActivity) k).getkProcedures() != null) {
						Iterator<KProcedure> itprocedures = ((KActivity) k).getkProcedures().iterator();
						while (itprocedures.hasNext()) {

							Integer i = hashKProcedure.get(itprocedures.next().getName());
							checkkprocedures[i.intValue()].setSelection(true);
						}
					}

					if (((KActivity) k).getKHumanResources() != null) {
						Iterator<KHumanResource> itkhumanResources = ((KActivity) k).getKHumanResources().iterator();
						while (itkhumanResources.hasNext()) {

							Integer i = hashKHumanResources.get(itkhumanResources.next().getName());
							checkHumanResources[i.intValue()].setSelection(true);
						}
					}

					if (((KActivity) k).getkResources() != null) {
						Iterator<KResource> itkResources = ((KActivity) k).getkResources().iterator();
						while (itkResources.hasNext()) {

							Integer i = hashKResource.get(itkResources.next().getName());
							checkResources[i.intValue()].setSelection(true);
						}
					}

					if (((KActivity) k).getkProcess() != null) {
						Integer i = hashKProcess.get(((KActivity) k).getkProcess().getName());
						radioskprocesses[i.intValue()].setSelection(true);
					}
				}
				else if (k instanceof KProcess) {
					hideelements();

					btnIsengineering.setVisible(true);
					btnIsengineering.setSelection(((KProcess) k).isEngineering());
				}
				else if (k instanceof KArtefact) {
					hideelements();
					tabFolderKArtefact.setVisible(true);

					// hashs
					if (((KArtefact) k).getDepends() != null) {
						Iterator<KArtefact> itdepends = ((KArtefact) k).getDepends().iterator();
						while (itdepends.hasNext()) {

							Integer i = hashKArtefact.get(itdepends.next().getName());
							checkdepends[i.intValue()].setSelection(true);
						}
					}

					if (((KArtefact) k).getSubArtefacts() != null) {
						Iterator<KArtefact> itsubkArtefacts = ((KArtefact) k).getSubArtefacts().iterator();
						while (itsubkArtefacts.hasNext()) {

							Integer i = hashKArtefact.get(itsubkArtefacts.next().getName());
							checksubartefacts[i.intValue()].setSelection(true);
						}
					}

				}
				else {
					hideelements();
				}

			}

		});

		/** to stay rendering in layout */

		Label lblName = new Label(container, SWT.NONE);
		lblName.setText("Name:");
		managedForm.getToolkit().adapt(lblName, true, true);

		name = new Text(container, SWT.BORDER);
		name.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		new Label(managedForm.getForm().getBody(), SWT.NONE);

		description = new Text(container, SWT.BORDER);
		description.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 3));
		managedForm.getToolkit().adapt(description, true, true);

		Label lblDescription = new Label(container, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		lblDescription.setText("Description:");
		managedForm.getToolkit().adapt(lblDescription, true, true);
		new Label(managedForm.getForm().getBody(), SWT.NONE);

		btnMandatory = new Button(managedForm.getForm().getBody(), SWT.BORDER | SWT.CHECK);
		managedForm.getToolkit().adapt(btnMandatory, true, true);
		btnMandatory.setText("Mandatory");

		btnIsengineering = new Button(managedForm.getForm().getBody(), SWT.BORDER | SWT.CHECK);
		managedForm.getToolkit().adapt(btnIsengineering, true, true);
		btnIsengineering.setText("isEngineering");

		tabFolderKArtefact = new TabFolder(managedForm.getForm().getBody(), SWT.BORDER);
		tabFolderKArtefact.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		managedForm.getToolkit().adapt(tabFolderKArtefact);
		managedForm.getToolkit().paintBordersFor(tabFolderKArtefact);

		tabFolderKActivity = new TabFolder(managedForm.getForm().getBody(), SWT.BORDER);
		tabFolderKActivity.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		managedForm.getToolkit().adapt(tabFolderKActivity);
		managedForm.getToolkit().paintBordersFor(tabFolderKActivity);

		{
			btnUpdate = new Button(managedForm.getForm().getBody(), SWT.NONE);
			managedForm.getToolkit().adapt(btnUpdate, true, true);
			btnUpdate.setText("update...");
			btnUpdate.addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					if (chosenKnowledge != null) {
						if (chosenKnowledge instanceof KActivity) {
							ApplCRUDKActivity.updateKActivity((KActivity) chosenKnowledge);
						}
						else if (chosenKnowledge instanceof KArtefact) {
							ApplCRUDKArtefact.updateKArtefact((KArtefact) chosenKnowledge);

						}
						else if (chosenKnowledge instanceof KHumanResource) {
							ApplCRUDKHumanResource.updateKHumanResource((KHumanResource) chosenKnowledge);

						}
						else if (chosenKnowledge instanceof KHardwareResource) {
							ApplCRUDKHardwareResource.updateKHardwareResource((KHardwareResource) chosenKnowledge);

						}
						else if (chosenKnowledge instanceof KSoftwareResource) {
							ApplCRUDKSoftwareResource.updateKSoftwareResource((KSoftwareResource) chosenKnowledge);

						}
						else if (chosenKnowledge instanceof KProcess) {
							ApplCRUDKProcess.updateKProcess((KProcess) chosenKnowledge);

						}
						else if (chosenKnowledge instanceof KProcedure) {
							ApplCRUDKProcedure.updateKProcedure((KProcedure) chosenKnowledge);

						}
						else if (chosenKnowledge instanceof KLifeCycleModel) {
							ApplCRUDKLifeCycleModel.updateKLifeCycleModel((KLifeCycleModel) chosenKnowledge);

						}

					}// end if
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub

				}

			});

		}
		{
			btnDelete = new Button(managedForm.getForm().getBody(), SWT.NONE);
			managedForm.getToolkit().adapt(btnDelete, true, true);
			btnDelete.setText("delete...");
			btnDelete.addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					if (chosenKnowledge != null) {
						if (chosenKnowledge instanceof KActivity) {
							ApplCRUDKActivity.deleteKActivity((KActivity) chosenKnowledge);
						}
						else if (chosenKnowledge instanceof KArtefact) {
							ApplCRUDKArtefact.deleteKArtefact((KArtefact) chosenKnowledge);

						}
						else if (chosenKnowledge instanceof KHumanResource) {
							ApplCRUDKHumanResource.deleteKHumanResource((KHumanResource) chosenKnowledge);

						}
						else if (chosenKnowledge instanceof KHardwareResource) {
							ApplCRUDKHardwareResource.deleteKHardwareResource((KHardwareResource) chosenKnowledge);

						}
						else if (chosenKnowledge instanceof KSoftwareResource) {
							ApplCRUDKSoftwareResource.deleteKSoftwareResource((KSoftwareResource) chosenKnowledge);

						}
						else if (chosenKnowledge instanceof KProcess) {
							ApplCRUDKProcess.deleteKProcess((KProcess) chosenKnowledge);

						}
						else if (chosenKnowledge instanceof KProcedure) {
							ApplCRUDKProcedure.deleteKProcedure((KProcedure) chosenKnowledge);

						}
						else if (chosenKnowledge instanceof KLifeCycleModel) {
							ApplCRUDKLifeCycleModel.deleteKLifeCycleModel((KLifeCycleModel) chosenKnowledge);

						}

					}// end if
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub

				}

			});

		}
		new Label(managedForm.getForm().getBody(), SWT.NONE);
		new Label(managedForm.getForm().getBody(), SWT.NONE);
		new Label(managedForm.getForm().getBody(), SWT.NONE);
		new Label(managedForm.getForm().getBody(), SWT.NONE);
		new Label(managedForm.getForm().getBody(), SWT.NONE);
		new Label(managedForm.getForm().getBody(), SWT.NONE);
		new Label(managedForm.getForm().getBody(), SWT.NONE);
		new Label(managedForm.getForm().getBody(), SWT.NONE);
		new Label(managedForm.getForm().getBody(), SWT.NONE);
		new Label(managedForm.getForm().getBody(), SWT.NONE);

		folderkActivity();
		folderkArtefact();
		hideelements();
		chosenKnowledge = null;

	}

	protected void hideelements() {

		tabFolderKArtefact.setVisible(false);
		tabFolderKActivity.setVisible(false);
		btnMandatory.setVisible(false);
		btnIsengineering.setVisible(false);

	}

	/** create TabItem to KActivity */
	protected void folderkActivity() {

		subKactivites = new TabItem(tabFolderKActivity, SWT.NONE);
		subKactivites.setText("subKActivities");
		KActivity vsubKActivities[] = ApplCRUDKActivity.getever();
		hashKActivity = new HashMap<String, Integer>();

		ScrolledForm frmsubkActivities = toolkit.createScrolledForm(tabFolderKActivity);
		subKactivites.setControl(frmsubkActivities);
		toolkit.paintBordersFor(frmsubkActivities);
		frmsubkActivities.setText("subKActivities");

		if (vsubKActivities.length > 0) checksubKactivies = new Button[vsubKActivities.length];
		for (int i = 0; i < vsubKActivities.length; i++) {
			checksubKactivies[i] = new Button(frmsubkActivities.getBody(), SWT.CHECK);
			checksubKactivies[i].setBounds(10, 20 + 20 * i, 355, 24);
			toolkit.adapt(checksubKactivies[i], true, true);
			checksubKactivies[i].setText(vsubKActivities[i].getName());
			hashKActivity.put(vsubKActivities[i].getName(), Integer.valueOf(i));
		}

		preKactivites = new TabItem(tabFolderKActivity, SWT.NONE);
		preKactivites.setText("preKActivities");

		ScrolledForm frmprekActivities = toolkit.createScrolledForm(tabFolderKActivity);
		preKactivites.setControl(frmprekActivities);
		toolkit.paintBordersFor(frmprekActivities);
		frmprekActivities.setText("preKActivities");

		KActivity vprekActivities[] = ApplCRUDKActivity.getever();
		if (vprekActivities.length > 0) checkprekActivities = new Button[vprekActivities.length];
		for (int i = 0; i < vprekActivities.length; i++) {
			checkprekActivities[i] = new Button(frmprekActivities.getBody(), SWT.CHECK);
			checkprekActivities[i].setBounds(10, 20 + 20 * i, 355, 24);
			toolkit.adapt(checkprekActivities[i], true, true);
			checkprekActivities[i].setText(vprekActivities[i].getName());
		}

		inputs = new TabItem(tabFolderKActivity, SWT.NONE);
		inputs.setText("Inputs");
		hashKArtefact = new HashMap<String, Integer>();

		ScrolledForm frminputs = toolkit.createScrolledForm(tabFolderKActivity);
		inputs.setControl(frminputs);
		toolkit.paintBordersFor(frminputs);
		frminputs.setText("Inputs");

		KArtefact vinputs[] = ApplCRUDKArtefact.getever();
		if (vinputs.length > 0) checkinputs = new Button[vinputs.length];
		for (int i = 0; i < vinputs.length; i++) {
			checkinputs[i] = new Button(frminputs.getBody(), SWT.CHECK);
			checkinputs[i].setBounds(10, 20 + 20 * i, 355, 24);
			toolkit.adapt(checkinputs[i], true, true);
			checkinputs[i].setText(vinputs[i].getName());
			hashKArtefact.put(vinputs[i].getName(), Integer.valueOf(i));
		}

		products = new TabItem(tabFolderKActivity, SWT.NONE);
		products.setText("products");

		ScrolledForm frmproducts = toolkit.createScrolledForm(tabFolderKActivity);
		products.setControl(frmproducts);
		toolkit.paintBordersFor(frmproducts);
		frmproducts.setText("Products");

		KArtefact vproducts[] = ApplCRUDKArtefact.getever();
		if (vproducts.length > 0) checkproducts = new Button[vproducts.length];
		for (int i = 0; i < vproducts.length; i++) {
			checkproducts[i] = new Button(frmproducts.getBody(), SWT.CHECK);
			checkproducts[i].setBounds(10, 20 + 20 * i, 355, 24);
			toolkit.adapt(checkproducts[i], true, true);
			checkproducts[i].setText(vproducts[i].getName());
		}

		kProcedures = new TabItem(tabFolderKActivity, SWT.NONE);
		kProcedures.setText("kProcedures");
		hashKProcedure = new HashMap<String, Integer>();

		ScrolledForm frmkprocedures = toolkit.createScrolledForm(tabFolderKActivity);
		kProcedures.setControl(frmkprocedures);
		toolkit.paintBordersFor(frmkprocedures);
		frmkprocedures.setText("KProcedures");

		KProcedure vkprocedures[] = ApplCRUDKProcedure.getever();
		if (vkprocedures.length > 0) checkkprocedures = new Button[vkprocedures.length];
		for (int i = 0; i < vkprocedures.length; i++) {
			checkkprocedures[i] = new Button(frmkprocedures.getBody(), SWT.CHECK);
			checkkprocedures[i].setBounds(10, 20 + 20 * i, 355, 24);
			toolkit.adapt(checkkprocedures[i], true, true);
			checkkprocedures[i].setText(vkprocedures[i].getName());
			hashKProcedure.put(vkprocedures[i].getName(), Integer.valueOf(i));
		}

		kProcess = new TabItem(tabFolderKActivity, SWT.NONE);
		kProcess.setText("kProcess");
		hashKProcess = new HashMap<String, Integer>();

		ScrolledForm frmkprocess = toolkit.createScrolledForm(tabFolderKActivity);
		kProcess.setControl(frmkprocess);
		toolkit.paintBordersFor(frmkprocess);
		frmkprocess.setText("KProcess");

		KProcess vkProcess[] = ApplCRUDKProcess.getever();
		if (vkProcess.length > 0) radioskprocesses = new Button[vkProcess.length];
		for (int i = 0; i < vkProcess.length; i++) {
			radioskprocesses[i] = new Button(frmkprocess.getBody(), SWT.RADIO);
			radioskprocesses[i].setBounds(10, 20 + 20 * i, 355, 24);
			toolkit.adapt(radioskprocesses[i], true, true);
			radioskprocesses[i].setText(vkProcess[i].getName());
			hashKProcess.put(vkProcess[i].getName(), Integer.valueOf(i));
		}

		kHumanResources = new TabItem(tabFolderKActivity, SWT.NONE);
		kHumanResources.setText("kHumanResources");
		hashKHumanResources = new HashMap<String, Integer>();

		ScrolledForm frmkHumanResources = toolkit.createScrolledForm(tabFolderKActivity);
		kHumanResources.setControl(frmkHumanResources);
		toolkit.paintBordersFor(frmkHumanResources);
		frmkHumanResources.setText("KHumanResources");

		KHumanResource vkHumanResources[] = ApplCRUDKHumanResource.getever();
		if (vkHumanResources.length > 0) checkHumanResources = new Button[vkHumanResources.length];
		for (int i = 0; i < vkHumanResources.length; i++) {
			checkHumanResources[i] = new Button(frmkHumanResources.getBody(), SWT.CHECK);
			checkHumanResources[i].setBounds(10, 20 + 20 * i, 355, 24);
			toolkit.adapt(checkHumanResources[i], true, true);
			checkHumanResources[i].setText(vkHumanResources[i].getName());
			hashKHumanResources.put(vkHumanResources[i].getName(), Integer.valueOf(i));
		}

		kResources = new TabItem(tabFolderKActivity, SWT.NONE);
		kResources.setText("kResources");
		hashKResource = new HashMap<String, Integer>();

		ScrolledForm frmkResources = toolkit.createScrolledForm(tabFolderKActivity);
		kResources.setControl(frmkResources);
		toolkit.paintBordersFor(frmkResources);
		frmkResources.setText("KResources");

		KHardwareResource vkHardwareResources[] = ApplCRUDKHardwareResource.getever();
		KSoftwareResource vkSoftwareResources[] = ApplCRUDKSoftwareResource.getever();

		int iR;

		if (vkHardwareResources.length > 0 || vkSoftwareResources.length > 0) checkResources = new Button[vkHardwareResources.length + vkSoftwareResources.length];
		for (iR = 0; iR < vkHardwareResources.length; iR++) {
			checkResources[iR] = new Button(frmkResources.getBody(), SWT.CHECK);
			checkResources[iR].setBounds(10, 20 + 20 * iR, 355, 24);
			toolkit.adapt(checkResources[iR], true, true);
			checkResources[iR].setText(vkHardwareResources[iR].getName());
			hashKResource.put(vkHardwareResources[iR].getName(), Integer.valueOf(iR));
		}
		for (; iR < vkHardwareResources.length + vkSoftwareResources.length; iR++) {
			checkResources[iR] = new Button(frmkResources.getBody(), SWT.CHECK);
			checkResources[iR].setBounds(10, 20 + 20 * iR, 355, 24);
			toolkit.adapt(checkResources[iR], true, true);
			checkResources[iR].setText(vkSoftwareResources[iR - vkHardwareResources.length].getName());
			hashKResource.put(vkSoftwareResources[iR - vkHardwareResources.length].getName(), Integer.valueOf(iR));

		}

	}

	/** create TabItem to KArtefact */
	protected void folderkArtefact() {

		subkArtefacts = new TabItem(tabFolderKArtefact, SWT.NONE);
		subkArtefacts.setText("subkArtefacts");

		ScrolledForm frmksubArtefacts = toolkit.createScrolledForm(tabFolderKArtefact);
		subkArtefacts.setControl(frmksubArtefacts);
		toolkit.paintBordersFor(frmksubArtefacts);
		frmksubArtefacts.setText("subkArtefacts");

		KArtefact vsubkArtefacts[] = ApplCRUDKArtefact.getever();
		if (vsubkArtefacts.length > 0) checksubartefacts = new Button[vsubkArtefacts.length];
		for (int i = 0; i < vsubkArtefacts.length; i++) {
			checksubartefacts[i] = new Button(frmksubArtefacts.getBody(), SWT.CHECK);
			checksubartefacts[i].setBounds(10, 20 + 20 * i, 355, 24);
			toolkit.adapt(checksubartefacts[i], true, true);
			checksubartefacts[i].setText(vsubkArtefacts[i].getName());
		}

		depends = new TabItem(tabFolderKArtefact, SWT.NONE);
		depends.setText("depends");

		ScrolledForm frmkdepends = toolkit.createScrolledForm(tabFolderKArtefact);
		depends.setControl(frmkdepends);
		toolkit.paintBordersFor(frmkdepends);
		frmkdepends.setText("depends");

		KArtefact vdepends[] = ApplCRUDKArtefact.getever();
		if (vdepends.length > 0) checkdepends = new Button[vdepends.length];
		for (int i = 0; i < vdepends.length; i++) {
			checkdepends[i] = new Button(frmkdepends.getBody(), SWT.CHECK);
			checkdepends[i].setBounds(10, 20 + 20 * i, 355, 24);
			toolkit.adapt(checkdepends[i], true, true);
			checkdepends[i].setText(vdepends[i].getName());
		}

	}
}
