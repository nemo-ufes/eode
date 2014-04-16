/**
 * 
 */
package br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cmt;

import java.rmi.RemoteException;

import ode._controleRecursoHumano.srv.Projeto;
import ode.controleProjeto.srv.SrvAplCadastrarProjeto;
import ode.controleProjeto.srv.SrvAplCadastrarProjetoProxy;

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
public class AplNewProject {

	/**
	 * 
	 */
	public static void CreateNewProject(String namenewproject) {
		// TODO Auto-generated constructor stub
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(namenewproject);
		SrvAplCadastrarProjeto srv = new SrvAplCadastrarProjetoProxy();
		ode.controleProjeto.srv.Projeto projeto = new ode.controleProjeto.srv.Projeto("uuid", 1144168960171946495L,1144168960171946495L,namenewproject,"desc");
		try {
			int save = srv.salvar(projeto);
			System.out.println(srv.recuperarQuantidadeTotal());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			project.create(null);
			project.open(null);

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
