package br.ufes.inf.nemo.odercp.rcpapp;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cmt.ApplCRUDHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cpd.HumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;

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
		container.setLayout(new GridLayout(3, false));

		// TreeViewer treeViewer = new TreeViewer(container, SWT.BORDER);
		Tree tree = new Tree(container, SWT.BORDER);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 7));

		TreeItem root = new TreeItem(tree, SWT.NONE, 0);
		root.setText("Human Resource");
		root.setExpanded(true);
		
		Menu menu = new Menu(tree);
		//tree.setMenu(menu);
		
		MenuItem mntmDelete = new MenuItem(menu, SWT.NONE);
		mntmDelete.setText("Delete");
		mntmDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ApplCRUDHumanResource.delete(chosenHR);

			}
		});
		

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
		{
			Label lblName = new Label(container, SWT.SHADOW_IN | SWT.CENTER);
			lblName.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
			lblName.setAlignment(SWT.CENTER);
			lblName.setText("Name:");
		}
		{
			name = new Text(container, SWT.BORDER);
			name.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		}
		{
			Label lblActive = new Label(container, SWT.SHADOW_IN | SWT.CENTER);
			lblActive.setText("Active:");
			lblActive.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
			lblActive.setAlignment(SWT.CENTER);
		}

		active = new Button(container, SWT.CHECK);
		{
			Label lblWorkload = new Label(container, SWT.SHADOW_IN | SWT.CENTER);
			lblWorkload.setText("Workload:");
			lblWorkload.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
			lblWorkload.setAlignment(SWT.CENTER);
		}
		{
			workload = new Text(container, SWT.BORDER);
			workload.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		}
		{
			Label lblEmail = new Label(container, SWT.SHADOW_IN | SWT.CENTER);
			lblEmail.setText("Email:");
			lblEmail.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
			lblEmail.setAlignment(SWT.CENTER);
		}
		{
			email = new Text(container, SWT.BORDER);
			email.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		}
		{
			Label lblPhone = new Label(container, SWT.SHADOW_IN | SWT.CENTER);
			lblPhone.setText("Phone:");
			lblPhone.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
			lblPhone.setAlignment(SWT.CENTER);
		}
		{
			phone = new Text(container, SWT.BORDER);
			phone.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		}
		{
			Label lblRole = new Label(container, SWT.SHADOW_IN | SWT.CENTER);
			lblRole.setText("Role:");
			lblRole.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
			lblRole.setAlignment(SWT.CENTER);
		}

		role = new Combo(container, SWT.READ_ONLY);
		role.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		{
			btnUpdate = new Button(container, SWT.NONE);
			GridData gd_btnUpdate = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
			gd_btnUpdate.widthHint = 70;
			btnUpdate.setLayoutData(gd_btnUpdate);
			btnUpdate.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					ApplCRUDHumanResource.update(chosenHR);
				}
			});
			btnUpdate.setText("Update");
		}
		{
			btnDelete = new Button(container, SWT.NONE);
			GridData gd_btnDelete = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
			gd_btnDelete.widthHint = 62;
			btnDelete.setLayoutData(gd_btnDelete);
			btnDelete.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					ApplCRUDHumanResource.delete(chosenHR);

				}
			});
			btnDelete.setText("Delete");
		}
		KHumanResource[] everKHR = ApplCRUDKHumanResource.getever();
		// Populate Combo of Roles
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
		@SuppressWarnings("unused")
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		@SuppressWarnings("unused")
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
