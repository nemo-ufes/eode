package br.ufes.inf.nemo.odercp.rcpapp.Util;

public class LoginODERCP {
	
	public static boolean verification(String User,String password){
		boolean userODE=false;
		if(User.equals("admin") && password.equals("admin")){
			userODE=true;
		}
		return userODE;
	}

}
