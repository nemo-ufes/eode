package br.ufes.inf.nemo.eode.rcpapp.userControl.tml;

import java.util.HashMap;

import javax.swing.JOptionPane;

import br.ufes.inf.nemo.eode.rcpapp.humanResourceControl.pdl.HumanResource;
import br.ufes.inf.nemo.eode.rcpapp.humanResourceControl.tml.ApplCRUDHumanResource;
import br.ufes.inf.nemo.eode.rcpapp.userControl.pdl.AcessProfile;
import br.ufes.inf.nemo.eode.rcpapp.userControl.pdl.User;

public class ApplCRUDUser {
	protected static User[] users;
	protected static HashMap<String, User> hashUsers;

	public static boolean CreateNewPassword(String oldpassword, String newpassword, String rnewpassword) {
		// TODO Auto-generated constructor stub
		User user = ApplAuthenticUser.correntUser;

		if ((oldpassword.equals("") || newpassword.equals("") || rnewpassword.equals(""))) {
			JOptionPane.showMessageDialog(null, " Old Password or new Password or repeat new Password\n void!");
			return false;

		}
		else if (!user.getPassword().equals(oldpassword)) {

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
		hashUsers.put(user.getLogin(), user);
		return true;

	}

	public static void init() {
		users = new User[5];
		User user = new User();
		hashUsers = new HashMap<String, User>();
		HumanResource[] HRs = ApplCRUDHumanResource.getever();

		user.setLogin("ricardo.falbo");
		user.setPassword("ricardo");
		user.setHumanResource(HRs[2]);
		user.setAcessProfile(AcessProfile.Administrator);
		hashUsers.put(user.getLogin(), user);

		user = new User();
		user.setLogin("danillo.ricardo");
		user.setPassword("danillo");
		user.setHumanResource(HRs[0]);
		user.setAcessProfile(AcessProfile.Developer);
		hashUsers.put(user.getLogin(), user);
	}

	public static User[] getever() {
		return (User[]) hashUsers.values().toArray();
	}
}
