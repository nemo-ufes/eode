/**
 * 
 */
package br.ufes.inf.nemo.odercp.rcpapp.userControl.cmt;

import javax.swing.JOptionPane;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
public class ApplNewPassword {

	public static boolean CreateNewPassword(String oldpassword,
			String newpassword, String rnewpassword) {
		// TODO Auto-generated constructor stub
		if ((oldpassword.equals("") || newpassword.equals("") || rnewpassword
				.equals(""))) {
			JOptionPane
					.showMessageDialog(null,
							" Old Password or new Password or repeat new Password\n void!");
			return false;

		} else if (!oldpassword.equals("admin")) {

			JOptionPane.showMessageDialog(null, "Wrong old password!");
			return false;
		} else if (!newpassword.equals(rnewpassword)) {
			JOptionPane.showMessageDialog(null, "New password different!");
			return false;

		}

		return true;
	}
}
