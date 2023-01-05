package com.mirafra.email.service;

import com.mirafra.email.dto.EmailRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
@Autowired
private JavaMailSender emailSender;



    public String sendEmailWithAttachment(EmailRequestDto emailDto, MultipartFile multipartFile) throws Exception{

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true,"utf-8");
        helper.setFrom("noreply@mirafra.com");
        //helper.set
        helper.setSubject(emailDto.getSubject());
        helper.setText(emailDto.getMessage(),true);
       if(emailDto.getBccMailId()!=null && !emailDto.getBccMailId().isEmpty()){
            System.out.println("inside  bcc email");
        String[] bccEmail =  emailDto.getBccMailId().toArray(String[]::new);
        helper.setBcc(bccEmail);
        }
        if(emailDto.getCcMailId()!=null && !emailDto.getCcMailId().isEmpty()){
            System.out.println("inside  cc email");
         String[] ccEmail =  emailDto.getCcMailId().toArray(String[]::new);
          helper.setCc(ccEmail);
        }
        if(emailDto.getToMailId()!=null && !emailDto.getToMailId().isEmpty()){
            System.out.println("inside  to email");
            String[] toEmail =  emailDto.getToMailId().toArray(String[]::new);
            helper.setTo(toEmail);
        }
        //helper.ad
        helper.addAttachment(multipartFile.getName(),multipartFile);

      //  helper.setTo(emailDto.getToMailId());
        emailSender.send(message);
        return "Email send successfully";
    }



    // To send a simple email
    public String sendSimpleMail(EmailRequestDto details)
    {


        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom("anooptripathi163@gmail.com");
           // mailMessage.setTo(details.getToMailId());
            mailMessage.setText(details.getMessage());
            mailMessage.setSubject(details.getSubject());

            // Sending the mail
            emailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

}
