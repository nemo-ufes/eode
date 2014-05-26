package br.ufes.inf.nemo.odercp.rcpapp.projectControl.cmt;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * TODO: document this type.
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class ApplDeleteProject {

	public static boolean deleteProject(String nameProject) {
		int i;
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		// Get all projects in the workspace
		IProject[] projects = root.getProjects();
		// Loop over all projects
		for (i = 0; i < projects.length; i++) {
			if (projects[i].getName().equals(nameProject)) {
				try {
					projects[i].delete(true, null);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
				return true;
			}
		}
		MessageDialog
				.openInformation(
						null,
						"Don't select project",
						"Select a project");

		return false;

	}

}
