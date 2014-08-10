package br.ufes.inf.nemo.eode.rcpapp.Handlers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;

import br.ufes.inf.nemo.eode.rcpapp.editors.EditorODE;
import br.ufes.inf.nemo.eode.rcpapp.views.ViewDataODE;

public class CallEditorODE extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// get the view
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage page = window.getActivePage();
		ViewDataODE view = (ViewDataODE) page.findView(ViewDataODE.ID);
		// get the selection
		ISelection selection = view.getSite().getSelectionProvider().getSelection();
		if (selection != null && selection instanceof IStructuredSelection) {
			IFile file = null;
			try {
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IWorkspaceRoot root = workspace.getRoot();
				IPath path = root.getLocation();
				path = path.append(".DatasODE");
				file = root.getFile(path);

				// at this point, no resources have been created

				if (!file.exists()) {
					byte[] bytes = "DatasODE".getBytes();
					InputStream source = new ByteArrayInputStream(bytes);
					try {

						file.create(source, IResource.NONE, null);

					}
					catch (CoreException e) {
					}
				}

				FileEditorInput f = new FileEditorInput(file);

				page.openEditor(f, EditorODE.ID);

			}
			catch (PartInitException e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}
}
