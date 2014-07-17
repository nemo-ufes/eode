package br.ufes.inf.nemo.odercp.rcpapp.views;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.ViewPart;

public class ViewDataODE extends ViewPart {

	public static final String ID = "br.ufes.inf.nemo.odercp.rcpapp.views.ViewDataODE"; //$NON-NLS-1$
	
	private TreeViewer treeViewer;

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

		container.setLayout(new GridLayout(1, false));
		{
			treeViewer = new TreeViewer(container, SWT.BORDER);
			Tree tree = treeViewer.getTree();
			tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			TreeItem root = new TreeItem(tree, SWT.NONE, 0);
			root.setText("Datas ODE");
			root.setExpanded(true);

		}
    getSite().setSelectionProvider(treeViewer);

		hookDoubleClickCommand();
		getViewSite();

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
		treeViewer.getControl().setFocus();
	}

	private void hookDoubleClickCommand() {
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
      public void doubleClick(DoubleClickEvent event) {
        IHandlerService handlerService = (IHandlerService) getSite()
            .getService(IHandlerService.class);
        try {
          handlerService.executeCommand("br.ufes.inf.nemo.odercp.rcpapp.command.ViewDataODE", null);
        } catch (Exception ex) {
          throw new RuntimeException("Command not found.");
        }
      }
    });
	}
	
	

}
