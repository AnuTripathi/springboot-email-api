package com.mirafra.email.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mirafra.email.dto.EmailRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailCommonUtil {



    @Autowired
    private ObjectMapper objectMapper;


    public EmailRequestDto convert(String request) throws JsonProcessingException {
        return objectMapper.readValue(request, EmailRequestDto.class);
    }
}
