package br.ufes.inf.nemo.odercp.rcpapp.Handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;

import br.ufes.inf.nemo.odercp.rcpapp.editors.EditorODE;
import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cmt.ApplSelectProject;
import br.ufes.inf.nemo.odercp.rcpapp.views.ViewDataODE;

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
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot root = workspace.getRoot();
			IProject[] projects = root.getProjects();
			// Loop over all projects
			IFile file = null;
			for (int i = 0; i < projects.length; i++) {
				if (projects[i].getName().equals(ApplSelectProject.getSelected().getName())) {
					file = projects[i].getFolder(".DatasODE").getFile("DatasODE");
				}
			}
			FileEditorInput f = new FileEditorInput(file);

			try {

				page.openEditor(f, EditorODE.ID);

			}
			catch (PartInitException e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}

}
