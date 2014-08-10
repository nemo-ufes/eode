package br.ufes.inf.nemo.eode.rcpapp.userControl.tml;

import br.ufes.inf.nemo.eode.rcpapp.userControl.pdl.User;

/*import java.rmi.RemoteException;
 import org.eclipse.jface.dialogs.MessageDialog;
 import ode.controleUsuario.srv.NucleoRegraNegocioExcecao;
 import ode.controleUsuario.srv.SrvAplAutenticarUsuario;
 import ode.controleUsuario.srv.SrvAplAutenticarUsuarioProxy;
 */
public class ApplAuthenticUser {

	protected static User correntUser;

	public static User getCorrentUser() {
		return correntUser;
	}

	public static void setCorrentUser(User correntUser) {
		ApplAuthenticUser.correntUser = correntUser;
	}

	public static boolean verification1(String login, String password,
			boolean stayconnected) {
		boolean userODE = false;
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		/*
		 * try { SrvAplAutenticarUsuario srv = new
		 * SrvAplAutenticarUsuarioProxy(); java.lang.Long l =
		 * srv.efetuarLogin(login, password, stayconnected);
		 * MessageDialog.openConfirm(null, "f", l.toString()); } catch
		 * (NucleoRegraNegocioExcecao e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (RemoteException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		return userODE;
	}

	public static boolean makeLogin(String login, String password,
			boolean stayconnected) {
		boolean userODE = false;
		User user = ApplCRUDUser.hashUsers.get(login);
		if (user != null && user.getPassword().equals(password)) {
			ApplAuthenticUser.correntUser = user;
			userODE = true;
		}

		return userODE;
	}

	public static boolean makeLogout() {
		correntUser = null;
		return true;
	}

}
