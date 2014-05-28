/**
 * 
 */
package br.ufes.inf.nemo.odercp.rcpapp.projectControl.cmt;

/*import java.rmi.RemoteException;
 import ode.controleProjeto.srv.SrvAplCadastrarProjeto;
 import ode.controleProjeto.srv.SrvAplCadastrarProjetoProxy;
 */
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cpd.Project;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
public class ApplCreateProject {

	/**
	 * 
	 */
	public static boolean CreateNewProject(String namenewproject, String descriptionproject) {
		// TODO Auto-generated constructor stub
		if (!namenewproject.equals("")) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			Project project = new Project();
			project.setName(namenewproject);
			project.setDescription(descriptionproject);
			IProject iProject = root.getProject(project.getName());
			/*
			 * SrvAplCadastrarProjeto srv = new SrvAplCadastrarProjetoProxy(); ode.controleProjeto.srv.Projeto projeto = new
			 * ode.controleProjeto.srv.Projeto("uuid", 1144168960171946495L, 1144168960171946495L, namenewproject,
			 * descriptionproject); try { // int save = srv.salvar(projeto);
			 * System.out.println(srv.recuperarQuantidadeTotal()); } catch (RemoteException e1) { // TODO Auto-generated catch
			 * block e1.printStackTrace(); }
			 */
			try {
				iProject.create(null);
				iProject.open(null);

			}
			catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;

			}
			return true;

		}
		return false;
	}

}
