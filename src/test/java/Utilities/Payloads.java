package Utilities;

import pojo.credentails;

public class Payloads {

	public credentails LoginPayload(String userEmail, String userPassword) {
		credentails cred = new credentails();
		cred.setUserEmail(userEmail);
		cred.setUserPassword(userPassword);
		return cred;
		
	}
}
