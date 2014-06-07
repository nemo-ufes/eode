package br.ufes.inf.nemo.odercp.rcpapp;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.wst.sse.ui.StructuredTextEditor;

public class EditorODE extends FormEditor {

	public static final String ID = "br.ufes.inf.nemo.odercp.rcpapp.editor.ODE";
	private StructuredTextEditor mSourceEditor;
	private int mSourceEditorIndex;

	/** Keeps track of dirty code from source editor. */
	private boolean mSourceDirty = false;

	@Override
	public void init(final IEditorSite site, final IEditorInput input)
			throws PartInitException {
		super.init(site, input);

		// TODO: load your model here
	}

	@Override
	protected void addPages() {
		mSourceEditor = new StructuredTextEditor();
		mSourceEditor.setEditorPart(this);

		try {
			// add form pages
			addPage(new FormEditorHumanResource(this, "firstID", "Human Resource"));
			addPage(new FormEditorKnowledge(this, "firstIDQ", "Knowledge"));
			// add source page
			mSourceEditorIndex = addPage(mSourceEditor, getEditorInput());
			setPageText(mSourceEditorIndex, "Source");
		} catch (final PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// add listener for changes of the document source
		getDocument().addDocumentListener(new IDocumentListener() {

			@Override
			public void documentAboutToBeChanged(final DocumentEvent event) {
				// nothing to do
			}

			@Override
			public void documentChanged(final DocumentEvent event) {
				mSourceDirty = true;
			}
		});
	}

	@Override
	public void doSaveAs() {
		// not allowed
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
		if (getActivePage() != mSourceEditorIndex)
			updateSourceFromModel();

		mSourceEditor.doSave(monitor);
	}

	@Override
	protected void pageChange(final int newPageIndex) {
		// check for update from the source code
		if ((getActivePage() == mSourceEditorIndex) && (mSourceDirty))
			updateModelFromSource();

		// check for updates to be propagated to the source code
		if (newPageIndex == mSourceEditorIndex)
			updateSourceFromModel();

		// switch page
		super.pageChange(newPageIndex);

		// update page if needed
		final IFormPage page = getActivePageInstance();
		if (page != null) {
			// TODO update form page with new model data
			page.setFocus();
		}
	}

	private void updateModelFromSource() {
		// TODO update source code for source viewer using new model data
		mSourceDirty = false;
	}

	private void updateSourceFromModel() {
		// TODO update source page from model
		// getDocument().set("new source code");
		mSourceDirty = false;
	}

	private IDocument getDocument() {
		final IDocumentProvider provider = mSourceEditor.getDocumentProvider();
		return provider.getDocument(getEditorInput());
	}

	private IFile getFile() {
		final IEditorInput input = getEditorInput();
		if (input instanceof FileEditorInput)
			return ((FileEditorInput) input).getFile();

		return null;
	}

	private String getContent() {
		return getDocument().get();
	}
}