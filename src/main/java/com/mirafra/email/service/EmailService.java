package com.mirafra.email.service;

import com.mirafra.email.dto.EmailRequestDto;
import org.springframework.web.multipart.MultipartFile;

public interface EmailService {

    public String sendEmailWithAttachment(EmailRequestDto emailDto, MultipartFile multipartFile)throws Exception;
    public String sendSimpleMail(EmailRequestDto details);
}
