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

public class ViewDataODE extends ViewPart {

	public static final String ID = "br.ufes.inf.nemo.odercp.rcpapp.ViewDataODE"; //$NON-NLS-1$
	private Text name;
	private Text description;

	public ViewDataODE() {}

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
		root.setText("ODE");
		root.setExpanded(true);

		
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
