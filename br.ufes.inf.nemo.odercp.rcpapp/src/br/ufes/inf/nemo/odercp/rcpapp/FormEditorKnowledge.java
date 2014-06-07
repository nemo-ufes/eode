package br.ufes.inf.nemo.odercp.rcpapp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class FormEditorKnowledge extends FormPage {

	
	private Text name;
	private Text description;
	
	/**
	 * Create the form page.
	 * @param id
	 * @param title
	 */
	public FormEditorKnowledge(String id, String title) {
		super(id, title);
	}

	/**
	 * Create the form page.
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
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("FormPage Knowledge");
		Composite container = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(container);
		
	
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
		
		
		}
}
