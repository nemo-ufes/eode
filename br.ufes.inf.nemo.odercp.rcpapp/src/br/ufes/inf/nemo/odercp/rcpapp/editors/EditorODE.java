package br.ufes.inf.nemo.odercp.rcpapp.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;

public class EditorODE extends FormEditor {

	public static final String ID = "br.ufes.inf.nemo.odercp.rcpapp.editors.EditorODE";

	public EditorODE() {}

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		super.init(site, input);

		// TODO: load your model here
	}

	@Override
	protected void addPages() {
	

		try {
			// add form pages
			addPage(new FormEditorHumanResource(this, "1", "Human Resource"));
			addPage(new FormEditorKnowledge(this, "2", "Knowledge"));
		
		}
		catch (final PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public void doSave(IProgressMonitor monitor) {}

	public void doSaveAs() {}

	public boolean isSaveAsAllowed() {
		return false;
	}
}
