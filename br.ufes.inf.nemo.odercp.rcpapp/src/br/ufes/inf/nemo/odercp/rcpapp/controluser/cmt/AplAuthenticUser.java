package br.ufes.inf.nemo.odercp.rcpapp.controluser.cmt;

public class AplAuthenticUser {
	
	public static boolean verification(String User,String password){
		boolean userODE=false;
		if(User.equals("admin") && password.equals("admin")){
			userODE=true;
		}
		return userODE;
	}

}
