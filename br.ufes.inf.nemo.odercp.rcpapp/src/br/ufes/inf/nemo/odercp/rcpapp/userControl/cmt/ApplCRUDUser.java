package br.ufes.inf.nemo.odercp.rcpapp.userControl.cmt;

import javax.swing.JOptionPane;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cpd.HumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.userControl.cpd.AcessProfile;
import br.ufes.inf.nemo.odercp.rcpapp.userControl.cpd.User;

public class ApplCRUDUser {
	public static boolean CreateNewPassword(String oldpassword, String newpassword, String rnewpassword) {
		// TODO Auto-generated constructor stub
		User user = new User();
		user.setPassword(oldpassword);
		if ((user.getPassword().equals("") || newpassword.equals("") || rnewpassword.equals(""))) {
			JOptionPane.showMessageDialog(null, " Old Password or new Password or repeat new Password\n void!");
			return false;

		}
		else if (!user.getPassword().equals("admin")) {

			JOptionPane.showMessageDialog(null, "Wrong old password!");
			return false;
		}
		else if (!newpassword.equals(rnewpassword)) {
			JOptionPane.showMessageDialog(null, "New password different!");
			return false;

		}
		user.setPassword(newpassword);
		return true;
	}

	public static boolean CreateUser(String login, String password, HumanResource humanResource, AcessProfile acessProfile) {
		User user = new User();
		user.setAcessProfile(acessProfile);
		user.setHumanResource(humanResource);
		user.setLogin(login);
		user.setPassword(password);
		System.out.println(user.getHumanResource().getEmail());
		return true;

	}

}
