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

public class SendMailDynamically
{

		public static void main(String[] args) throws MessagingException {
			
			Scanner sc=new Scanner(System.in);
			
			String from="kajalgondgepatil123@gmail.com";
			
			System.out.println("Enter the email of the Receiver");
			String to=sc.next();
			
			
			System.out.println("Enter the no. of mails to sent");
			int count=sc.nextInt();
			
		
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
				
				System.out.println("Enter the Subject");
				String sub=sc.nextLine();
				sub=sc.nextLine();
				message.setSubject(sub);
				
				// actual content of the email
				
				System.out.println("Enter the Text");
				String text=sc.nextLine();
				
				message.setText(text);
				
				// to send message/mail From address To adress
				Transport.send(message);
			
		}
}
