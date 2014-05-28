package br.ufes.inf.nemo.odercp.rcpapp.userControl.cmt;

import br.ufes.inf.nemo.odercp.rcpapp.userControl.cpd.User;

/*import java.rmi.RemoteException;
 import org.eclipse.jface.dialogs.MessageDialog;
 import ode.controleUsuario.srv.NucleoRegraNegocioExcecao;
 import ode.controleUsuario.srv.SrvAplAutenticarUsuario;
 import ode.controleUsuario.srv.SrvAplAutenticarUsuarioProxy;
 */
public class ApplAuthenticUser {
	public static boolean verification1(String login, String password, boolean stayconnected) {
		boolean userODE = false;
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		/*
		 * try { SrvAplAutenticarUsuario srv = new SrvAplAutenticarUsuarioProxy(); java.lang.Long l =
		 * srv.efetuarLogin(login, password, stayconnected); MessageDialog.openConfirm(null, "f", l.toString()); } catch
		 * (NucleoRegraNegocioExcecao e) { // TODO Auto-generated catch block e.printStackTrace(); } catch (RemoteException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		return userODE;
	}

	public static boolean verification(String login, String password, boolean stayconnected) {
		boolean userODE = false;
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		if (user.getLogin().equals("admin") && user.getPassword().equals("admin")) {
			userODE = true;
		}
		return userODE;
	}

}
