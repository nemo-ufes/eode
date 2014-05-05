package br.ufes.inf.nemo.odercp.rcpapp.usercontrol.cmt;

import java.rmi.RemoteException;

import org.eclipse.jface.dialogs.MessageDialog;
//
//import ode.controleUsuario.srv.NucleoRegraNegocioExcecao;
//import ode.controleUsuario.srv.SrvAplAutenticarUsuario;
//import ode.controleUsuario.srv.SrvAplAutenticarUsuarioProxy;

public class ApplAuthenticUser {
	public static boolean verification1(String User, String password, boolean stayconnected) {
		boolean userODE = false;

//		try {
//			SrvAplAutenticarUsuario srv = new SrvAplAutenticarUsuarioProxy();
//			java.lang.Long l = srv.efetuarLogin(User, password, stayconnected);
//			MessageDialog.openConfirm(null, "f", l.toString());
//
//		} catch (NucleoRegraNegocioExcecao e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// System.exit(0);

		return userODE;
	}

	public static boolean verification(String User, String password, boolean stayconnected) {
		boolean userODE = false;
		if (User.equals("admin") && password.equals("admin")) {
			userODE = true;
		}
		return userODE;
	}

}
