package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KActivity;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KProcedure;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KProcess;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KResource;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.ActivityStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.SpecificStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.StandardProcess;

public class PageStandardActivityProcess extends WizardPage {

	private Text textDescription;
	private Text txtName;
	private Button btnCheckButtonmandatory;
	SpecificStandardProcess specificStandardProcess;
	Tree tree;
	TreeItem root;
	KProcess processEnginnering;
	HashMap<TreeItem, SpecificStandardProcess> hashStandardProcesses;

	/**
	 * Create the wizard.
	 */
	public PageStandardActivityProcess() {
		super("wizardPage");
		setTitle("Page Standard Activity Process");
		hashStandardProcesses = new HashMap<TreeItem, SpecificStandardProcess>();
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(3, false));

		tree = new Tree(container, SWT.BORDER);
		GridData gd_tree = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 9);
		gd_tree.widthHint = 297;
		tree.setLayoutData(gd_tree);

		root = new TreeItem(tree, SWT.NONE, 0);
		root.setText(specificStandardProcess.getName());
		root.setExpanded(true);

		TreeItem item;
		Iterator<StandardProcess> it = specificStandardProcess
				.getSpecialization().iterator();
		SpecificStandardProcess auxspecificStandardProcess;
		while (it.hasNext()) {

			auxspecificStandardProcess = (SpecificStandardProcess) it.next();
			if (!auxspecificStandardProcess.getName().equals(
					processEnginnering.getName())) {
				item = new TreeItem(root, SWT.NONE, 0);
				item.setText(auxspecificStandardProcess.getName());
				populateProcess(item, auxspecificStandardProcess);
			}

		}
		it = specificStandardProcess.getSpecialization().iterator();

		while (it.hasNext()) {
			auxspecificStandardProcess = (SpecificStandardProcess) it.next();
			if (auxspecificStandardProcess.getName().equals(
					processEnginnering.getName())) {
				item = new TreeItem(root, SWT.NONE, 0);
				item.setText(auxspecificStandardProcess.getName());
				populateProcess(item, auxspecificStandardProcess);
			}
		}

		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblName = new Label(container, SWT.NONE);
		lblName.setText("Name:");

		txtName = new Text(container, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblDescription = new Label(container, SWT.NONE);
		lblDescription.setText("Description:");

		textDescription = new Text(container, SWT.BORDER | SWT.MULTI);
		GridData gd_textDescription = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1);
		gd_textDescription.heightHint = 104;
		textDescription.setLayoutData(gd_textDescription);

		Label lblMandatory = new Label(container, SWT.NONE);
		lblMandatory.setText("Mandatory:");

		btnCheckButtonmandatory = new Button(container, SWT.CHECK);

		Button btnUpdate = new Button(container, SWT.NONE);
		btnUpdate.setText("Update...");

		Button btnDelete = new Button(container, SWT.NONE);
		btnDelete.setText("Delete...");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		tree.getItems()[0].setExpanded(true);

	}

	private void populateProcess(TreeItem item,
			SpecificStandardProcess auxspecificStandardProcess) {
		if (auxspecificStandardProcess.getActivityStandardProcesses() != null) {
			Iterator<ActivityStandardProcess> itActivities = auxspecificStandardProcess
					.getActivityStandardProcesses().iterator();
			ActivityStandardProcess auxActivityStandardProcess;
			TreeItem auxitem;
			while (itActivities.hasNext()) {
				auxActivityStandardProcess = itActivities.next();

				auxitem = new TreeItem(item, SWT.NONE, 0);
				auxitem.setText(auxActivityStandardProcess.getName());
				populateactivity(auxitem, auxActivityStandardProcess);
				// TODO colocar na hash
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
			ActivityStandardProcess preactivities;
			while (itpreactivities.hasNext()) {
				preactivities = itpreactivities.next();
				auxItem = new TreeItem(itemPreActivies, SWT.NONE, 0);
				auxItem.setText(preactivities.getName());
				populateactivity(auxItem, preactivities);

			}
		}

		// SubActivies
		TreeItem itemSubActivies;
		itemSubActivies = new TreeItem(item, SWT.NONE, 0);
		itemSubActivies.setText("SubActivities");
		if (activityStandardProcess.getSubActivityStandardProcesses() != null) {
			Iterator<ActivityStandardProcess> itSubactivities = activityStandardProcess
					.getSubActivityStandardProcesses().iterator();
			ActivityStandardProcess subactivities;
			while (itSubactivities.hasNext()) {
				subactivities = itSubactivities.next();
				auxItem = new TreeItem(itemSubActivies, SWT.NONE, 0);
				auxItem.setText(subactivities.getName());
				populateactivity(auxItem, subactivities);

			}
		}

	}

	public String getTextDescription() {
		return textDescription.getText();
	}
}
