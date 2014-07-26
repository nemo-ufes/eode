package br.ufes.inf.nemo.odercp.rcpapp.editors;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.wb.swt.SWTResourceManager;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.mtl.ApplCRUDHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.pdl.HumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.mtl.ApplCRUDKHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KHumanResource;

public class FormEditorHumanResource extends FormPage {

	public HumanResource[] HRs;
	private Text name;
	private Text workload;
	private Text email;
	private Text phone;
	private Button active;
	Map<TreeItem, HumanResource> hashHR = new HashMap<TreeItem, HumanResource>();
	Map<String, Integer> hashindex;
	private HumanResource chosenHR;
	private Combo role;
	private Tree tree;
	private Menu menu;
	TreeItem root;
	private Button btnUpdate;
	private Button btnDelete;

	/**
	 * Create the form page.
	 * 
	 * @param id
	 * @param title
	 */
	public FormEditorHumanResource(String id, String title) {
		super(id, title);
		hashindex = new HashMap<String, Integer>();

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
	public FormEditorHumanResource(FormEditor editor, String id, String title) {
		super(editor, id, title);
		hashindex = new HashMap<String, Integer>();

	}

	/**
	 * Create contents of the form.
	 * 
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Page Human Resource");
		Composite container = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(container);

		HRs = ApplCRUDHumanResource.getever();
		container.setLayout(new GridLayout(3, false));

		tree = new Tree(container, SWT.BORDER);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 8));

		root = new TreeItem(tree, SWT.NONE, 0);
		root.setText("Human Resource");
		root.setExpanded(true);

		for (int i = 0; i < HRs.length; i++) {
			TreeItem no = new TreeItem(root, SWT.NONE, i);
			no.setText(HRs[i].getName());
			hashHR.put(no, HRs[i]);

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
				//System.out.println(hashindex.get(hr.getRole()).intValue());
				role.select(hashindex.get(hr.getRole().getName()).intValue());
				chosenHR = hr;
			}

		});

		menu = new Menu(tree);
		tree.setMenu(menu);

		menu.addMenuListener(new MenuAdapter() {
			public void menuShown(MenuEvent e) {
				MenuItem[] items = menu.getItems();
				for (int i = 0; i < items.length; i++) {
					items[i].dispose();
				}
				MenuItem itemDelete = new MenuItem(menu, SWT.NONE);
				itemDelete.setText("Delete...");
				itemDelete.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						if (tree.getSelection()[0] != root) ApplCRUDHumanResource.delete(chosenHR);
					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						// TODO Auto-generated method stub

					}

				});

				MenuItem itemUpdate = new MenuItem(menu, SWT.NONE);
				itemUpdate.setText("Update...");
				itemUpdate.addSelectionListener(new SelectionListener() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						if (tree.getSelection()[0] != root) ApplCRUDHumanResource.update(chosenHR);
					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						// TODO Auto-generated method stub

					}
				});

			}
		});

		{
			Label lblName = new Label(container, SWT.NONE);
			lblName.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
			lblName.setAlignment(SWT.CENTER);
			lblName.setText("Name:");
			managedForm.getToolkit().adapt(lblName, true, true);

		}

		{
			name = new Text(container, SWT.BORDER);
			name.setBackground(SWTResourceManager.getColor(255, 255, 255));
			name.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		}
		{
			Label lblActive = new Label(container, SWT.NONE);
			lblActive.setText("Active:");
			lblActive.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
			lblActive.setAlignment(SWT.CENTER);
			managedForm.getToolkit().adapt(lblActive, true, true);

		}

		active = new Button(container, SWT.CHECK);
		managedForm.getToolkit().adapt(active, true, true);

		{
			Label lblWorkload = new Label(container, SWT.NONE);
			lblWorkload.setText("Workload:");
			lblWorkload.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
			lblWorkload.setAlignment(SWT.CENTER);
			managedForm.getToolkit().adapt(lblWorkload, true, true);

		}
		{
			workload = new Text(container, SWT.BORDER);
			workload.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		}
		{
			Label lblEmail = new Label(container, SWT.NONE);
			lblEmail.setText("Email:");
			lblEmail.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
			lblEmail.setAlignment(SWT.CENTER);
			managedForm.getToolkit().adapt(lblEmail, true, true);

		}
		{
			email = new Text(container, SWT.BORDER);
			email.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		}
		{
			Label lblPhone = new Label(container, SWT.NONE);
			lblPhone.setText("Phone:");
			lblPhone.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
			lblPhone.setAlignment(SWT.CENTER);
			managedForm.getToolkit().adapt(lblPhone, true, true);

		}
		{
			phone = new Text(container, SWT.BORDER);
			phone.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		}
		{
			Label lblRole = new Label(container, SWT.NONE);
			lblRole.setText("Role:");
			lblRole.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
			lblRole.setAlignment(SWT.CENTER);
			managedForm.getToolkit().adapt(lblRole, true, true);

		}

		role = new Combo(container, SWT.READ_ONLY);
		role.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

		KHumanResource[] everKHR = ApplCRUDKHumanResource.getever();
		// Populate Combo of Roles
		for (int i = 0; i < everKHR.length; i++) {
			
			role.add(everKHR[i].getName());
			hashindex.put(everKHR[i].getName(), new Integer(i));
			
		}
		
		
		{
			btnUpdate = new Button(managedForm.getForm().getBody(), SWT.NONE);
			managedForm.getToolkit().adapt(btnUpdate, true, true);
			btnUpdate.setText("update...");
			btnUpdate.addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					if (tree.getSelection()[0] != root) ApplCRUDHumanResource.update(chosenHR);
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
					if (tree.getSelection()[0] != root) ApplCRUDHumanResource.delete(chosenHR);
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub

				}

			});

		}
		new Label(managedForm.getForm().getBody(), SWT.NONE);
		new Label(managedForm.getForm().getBody(), SWT.NONE);

	}
}
