/**
 * 
 */
package br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cmt;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
public class NewProject {

	/**
	 * 
	 */
	public static void CreateNewProject(String namenewproject) {
		// TODO Auto-generated constructor stub
		// create a project with name "TESTJDT"
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(namenewproject);
		try {
			project.create(null);
			project.open(null);

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
