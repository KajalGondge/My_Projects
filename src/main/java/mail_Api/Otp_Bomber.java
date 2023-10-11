package mail_Api;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class Otp_Bomber 
{

		public static void main(String[] args) throws MessagingException {
			
			Scanner sc=new Scanner(System.in);
			
			String from="kajalgondgepatil123@gmail.com";
			
			String to="prpekam@gmail.com";
			
			
			System.out.println("Enter the no. of mails to sent");
			int count=sc.nextInt();
			
			
			for(int i=0; i<count; i++)
			{
				Random random=new Random();
				int otp=random.nextInt(1000);
				
				Properties properties =System.getProperties();
				
				properties.put("mail.smtp.host", "smtp.gmail.com"); // setting the properties of smtp
				properties.put("mail.smtp.port", "465"); 
				properties.put("mail.smtp.ssl.enable", "true");
				properties.put("mail.smtp.auth", "true");  // setting properties of smtp to send mails
				
				
				
				Session session=Session.getInstance(properties, new AuthenticatorDriver());
				
				session.setDebug(true);
				
				
				
				InternetAddress ia1=new InternetAddress(from);
				InternetAddress ia2=new InternetAddress(to);
				
				// this class used to compose the mail
				MimeMessage message = new MimeMessage(session);

				message.setFrom(ia1);
				
				message.addRecipient(RecipientType.TO, ia2);
				
				message.setSubject("Hello");
				
				// actual content of the email
			
				message.setText("" + String.valueOf(otp));
				
				// to send message/mail From address To adress
				Transport.send(message);
			}
		
		}
}
