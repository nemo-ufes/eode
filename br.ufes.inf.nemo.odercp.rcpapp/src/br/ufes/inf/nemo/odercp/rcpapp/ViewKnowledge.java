package br.ufes.inf.nemo.odercp.rcpapp;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ViewKnowledge extends ViewPart {

	public static final String ID = "br.ufes.inf.nemo.odercp.rcpapp.ViewKnowledge"; //$NON-NLS-1$
	private Text name;
	private Text description;

	public ViewKnowledge() {}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		ScrolledComposite sc = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);

		Composite container = new Composite(sc, SWT.BORDER);

		container.setLayout(new GridLayout(6, false));

		// TreeViewer treeViewer = new TreeViewer(container, SWT.BORDER);
		Tree tree = new Tree(container, SWT.BORDER);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		GridData gd_tree = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 8);
		gd_tree.widthHint = 248;
		tree.setLayoutData(gd_tree);

		TreeItem root = new TreeItem(tree, SWT.NONE, 0);
		root.setText("Knowledge");
		root.setExpanded(true);

		TreeItem rootProcess = new TreeItem(root, SWT.NONE, 0);
		rootProcess.setText("Process");
		rootProcess.setExpanded(true);
		{

			TreeItem rootPProcess = new TreeItem(rootProcess, SWT.NONE, 0);
			rootPProcess.setText("Process");
			rootPProcess.setExpanded(true);

			TreeItem rootProcedure = new TreeItem(rootProcess, SWT.NONE, 0);
			rootProcedure.setText("Procedure");
			rootProcedure.setExpanded(true);

			TreeItem rootLifeCycleModel = new TreeItem(rootProcess, SWT.NONE, 0);
			rootLifeCycleModel.setText("Life-Cycle Model");
			rootLifeCycleModel.setExpanded(true);

			TreeItem rootArtefact = new TreeItem(rootProcess, SWT.NONE, 0);
			rootArtefact.setText("Artefact");
			rootArtefact.setExpanded(true);

			TreeItem rootActivity = new TreeItem(rootProcess, SWT.NONE, 0);
			rootActivity.setText("Activity");
			rootActivity.setExpanded(true);

		}

		TreeItem rootResource = new TreeItem(root, SWT.NONE, 0);
		rootResource.setText("Resource");
		rootResource.setExpanded(true);
		{
			TreeItem rootHaResource = new TreeItem(rootResource, SWT.NONE, 0);
			rootHaResource.setText("Hardware Resource");
			rootHaResource.setExpanded(true);

			TreeItem rootSResource = new TreeItem(rootResource, SWT.NONE, 0);
			rootSResource.setText("Software Resource");
			rootSResource.setExpanded(true);

			TreeItem rootHResource = new TreeItem(rootResource, SWT.NONE, 0);
			rootHResource.setText("Human Resource");
			rootHResource.setExpanded(true);


		}

		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblName = new Label(container, SWT.NONE);
		lblName.setText("Name:");

		name = new Text(container, SWT.BORDER);
		name.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		description = new Text(container, SWT.BORDER);
		description.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 3));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblDescription = new Label(container, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDescription.setText("Description:");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
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
