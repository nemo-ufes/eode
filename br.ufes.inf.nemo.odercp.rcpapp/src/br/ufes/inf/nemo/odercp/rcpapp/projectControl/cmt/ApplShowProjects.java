package br.ufes.inf.nemo.odercp.rcpapp.projectControl.cmt;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;

public class ApplShowProjects {

	public static String[] showProjects() {
		String[] nameprojects;
		int i;
		// Get the root of the workspace
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		// Get all projects in the workspace
		IProject[] projects = root.getProjects();
		// Loop over all projects
		nameprojects = new String[projects.length];
		for (i = 0; i < projects.length; i++) {
			nameprojects[i] = projects[i].getName();
		}
		return nameprojects;
	}

}
