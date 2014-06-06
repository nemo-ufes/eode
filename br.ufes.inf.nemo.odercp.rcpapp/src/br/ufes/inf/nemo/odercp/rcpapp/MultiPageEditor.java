package br.ufes.inf.nemo.odercp.rcpapp;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.MultiPageEditorPart;

public class MultiPageEditor extends MultiPageEditorPart {

	public static final String ID = "br.ufes.inf.nemo.odercp.rcpapp.MultiPageEditor"; //$NON-NLS-1$

	public MultiPageEditor() {}

	@Override
	protected void createPages() {
		try {
			addPage(new EditorHumanResource(), (org.eclipse.ui.IEditorInput) null);
			addPage(new EditorKnowledge(), (org.eclipse.ui.IEditorInput) null);
		}
		catch (PartInitException e) {}
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
	}

}
