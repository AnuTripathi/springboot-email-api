package com.mirafra.email.controller;

import com.mirafra.email.dto.EmailRequestDto;
import com.mirafra.email.service.EmailService;
import com.mirafra.email.util.EmailCommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailCommonUtil commonUtil;
    @PostMapping("/sendmail")
    public ResponseEntity<String>sendEmail(@RequestParam("multipartFile") MultipartFile multipartFile, @RequestParam("data") String request)throws Exception{
        EmailRequestDto requestDto = commonUtil.convert(request);
        System.out.println("file name *****  "+multipartFile.getName()+"   file size ******** "+multipartFile.getSize()+"  email *** "+requestDto.getSubject());
        String data = emailService.sendEmailWithAttachment(requestDto,multipartFile);

       // String data =   emailService.sendSimpleMail(requestDto);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
}
