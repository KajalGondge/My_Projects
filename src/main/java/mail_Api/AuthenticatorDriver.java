package mail_Api;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class AuthenticatorDriver extends Authenticator
{
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		
		return new PasswordAuthentication("kajalgondgepatil123@gmail.com","tjjnncsnccbnnqch");
		
	}

}
