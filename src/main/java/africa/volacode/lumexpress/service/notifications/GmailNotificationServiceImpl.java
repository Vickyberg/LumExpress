package africa.volacode.lumexpress.service.notifications;

import africa.volacode.lumexpress.data.dtos.request.EmailNotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class GmailNotificationServiceImpl implements EmailNotificationService {

    private final JavaMailSender javaMailSender;
    @Override
    public String sendHtmlMail(EmailNotificationRequest emailNotificationRequest) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(mimeMessage);

        try {
            mimeMessageHelper.setFrom("no-reply@email.lumExpress.com.ng");
            mimeMessageHelper.setTo(emailNotificationRequest.getUserEmail());
            mimeMessageHelper.setText(emailNotificationRequest.getMailContent(), true);
            javaMailSender.send(mimeMessage);
            return String.format("email sent to %s successfully", emailNotificationRequest.getUserEmail());
        }catch (MessagingException e){
            e.printStackTrace();
        }
        return  String.format("email not sent to %s", emailNotificationRequest.getUserEmail());
    }
}
