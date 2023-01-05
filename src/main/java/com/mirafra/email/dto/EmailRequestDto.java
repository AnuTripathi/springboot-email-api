package com.mirafra.email.dto;

import lombok.Data;

import java.util.List;

@Data
public class EmailRequestDto {
    private String from;
    private List<String> toMailId;
   // private String toMailId;
    private List<String> bccMailId;
    private List<String> ccMailId;
    private String message;
    private String subject;
}
