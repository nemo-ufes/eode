package br.ufes.inf.nemo.odercp.rcpapp;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.layout.GridData;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cmt.ApplCRUDHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cpd.HumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;

import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Combo;

public class ViewHumanResource extends ViewPart {

	public static final String VIEW_ID = "br.ufes.inf.nemo.odercp.rcpapp.ViewHumanResource"; //$NON-NLS-1$

	public HumanResource[] HRs;
	private Text name;
	private Text workload;
	private Text email;
	private Text phone;
	private Button active;
	Map<TreeItem, HumanResource> hashHR = new HashMap<TreeItem, HumanResource>();
	Map<HumanResource, Integer> hashindex;
	private Button btnDelete;
	private Button btnUpdate;
	private HumanResource chosenHR;
	private Combo role;

	public ViewHumanResource() {}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		ScrolledComposite sc = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);

		Composite container = new Composite(sc, SWT.BORDER);

		HRs = ApplCRUDHumanResource.getever();

		// TreeViewer treeViewer = new TreeViewer(container, SWT.BORDER);
		Tree tree = new Tree(container, SWT.BORDER);

		tree.setBounds(10, 10, 192, 440);

		TreeItem root = new TreeItem(tree, SWT.NONE, 0);
		root.setText("Human Resource");
		{
			Label lblName = new Label(container, SWT.BORDER | SWT.SHADOW_IN | SWT.CENTER);
			lblName.setFont(SWTResourceManager.getFont("Ubuntu", 12, SWT.NORMAL));
			lblName.setAlignment(SWT.CENTER);
			lblName.setBounds(221, 10, 86, 27);
			lblName.setText("Name:");
		}
		{
			name = new Text(container, SWT.BORDER);
			name.setBounds(317, 10, 229, 27);
		}
		{
			Label lblActive = new Label(container, SWT.BORDER | SWT.SHADOW_IN | SWT.CENTER);
			lblActive.setText("Active:");
			lblActive.setFont(SWTResourceManager.getFont("Ubuntu", 12, SWT.NORMAL));
			lblActive.setAlignment(SWT.CENTER);
			lblActive.setBounds(221, 63, 86, 27);
		}

		active = new Button(container, SWT.CHECK);
		active.setBounds(317, 63, 115, 24);
		{
			Label lblWorkload = new Label(container, SWT.BORDER | SWT.SHADOW_IN | SWT.CENTER);
			lblWorkload.setText("Workload:");
			lblWorkload.setFont(SWTResourceManager.getFont("Ubuntu", 12, SWT.NORMAL));
			lblWorkload.setAlignment(SWT.CENTER);
			lblWorkload.setBounds(221, 116, 86, 27);
		}
		{
			workload = new Text(container, SWT.BORDER);
			workload.setBounds(317, 116, 75, 27);
		}
		{
			Label lblEmail = new Label(container, SWT.BORDER | SWT.SHADOW_IN | SWT.CENTER);
			lblEmail.setText("Email:");
			lblEmail.setFont(SWTResourceManager.getFont("Ubuntu", 12, SWT.NORMAL));
			lblEmail.setAlignment(SWT.CENTER);
			lblEmail.setBounds(221, 168, 86, 27);
		}
		{
			Label lblPhone = new Label(container, SWT.BORDER | SWT.SHADOW_IN | SWT.CENTER);
			lblPhone.setText("Phone:");
			lblPhone.setFont(SWTResourceManager.getFont("Ubuntu", 12, SWT.NORMAL));
			lblPhone.setAlignment(SWT.CENTER);
			lblPhone.setBounds(221, 218, 86, 27);
		}
		{
			email = new Text(container, SWT.BORDER);
			email.setBounds(317, 168, 229, 27);
		}
		{
			Label lblRole = new Label(container, SWT.BORDER | SWT.SHADOW_IN | SWT.CENTER);
			lblRole.setText("Role:");
			lblRole.setFont(SWTResourceManager.getFont("Ubuntu", 12, SWT.NORMAL));
			lblRole.setAlignment(SWT.CENTER);
			lblRole.setBounds(221, 268, 86, 27);
		}
		{
			phone = new Text(container, SWT.BORDER);
			phone.setBounds(317, 218, 229, 27);
		}
		{
			btnDelete = new Button(container, SWT.NONE);
			btnDelete.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					ApplCRUDHumanResource.delete(chosenHR);

				}
			});
			btnDelete.setBounds(455, 332, 91, 29);
			btnDelete.setText("Delete");
		}
		{
			btnUpdate = new Button(container, SWT.NONE);
			btnUpdate.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					ApplCRUDHumanResource.update(chosenHR);
				}
			});
			btnUpdate.setBounds(317, 332, 91, 29);
			btnUpdate.setText("Update");
		}
		container.setTabList(new Control[] { tree, name, active, workload, email, phone, btnDelete, btnUpdate });

		tree.setLayoutData(new GridData(GridData.FILL_BOTH));

		role = new Combo(container, SWT.READ_ONLY);
		role.setBounds(317, 266, 229, 29);
		KHumanResource[] everKHR = ApplCRUDKHumanResource.getever();
		//Populate Combo of Roles
		for (int i = 0; i < everKHR.length; i++) {
			role.add(everKHR[i].getName());
		}
		
		hashindex = new HashMap<HumanResource, Integer>();
		for (int i = 0; i < HRs.length; i++) {
			TreeItem no = new TreeItem(root, SWT.NONE, i);
			no.setText(HRs[i].getName());
			hashHR.put(no, HRs[i]);
			hashindex.put(HRs[i], new Integer(i));
		}

		tree.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TreeItem ti = (TreeItem) e.item;
				if (!ti.getText().equals("Human Resource")) populateHR(hashHR.get(ti));
			}

			private void populateHR(HumanResource hr) {
				name.setText(hr.getName());
				active.setSelection(hr.isActive());
				workload.setText(hr.getWorkLoad().toString());
				email.setText(hr.getEmail());
				phone.setText(hr.getPhone());
				role.select(hashindex.get(hr));
				chosenHR = hr;
			}

		});

		createActions();
		initializeToolBar();
		initializeMenu();
		sc.setContent(container);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		sc.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
