package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class UENService {
    public boolean isUEN(String uenInput) {
        if (uenInput.matches("^\\d{8}[A-Z]$")) {
            return true;
        } else if (uenInput.matches("^(18|19|20)[0-9][0-9]\\d{5}[A-Z]$")) {
            return true;
        } else if (uenInput.matches(
                "^(R|S|T)[0-9][0-9](LP|LL|FC|PF|RF|MQ|MM|NB|CC|CS|MB|FM|GS|DP|CP|NR|CM|CD|MD|HS|VH|CH|MH|CL|XL|CX|RP|TU|TC|FB|FN|PA|PB|SS|MC|SM|GA|GB)\\d{4}[A-Z]$")) {
            return true;
        }
        return false;
    }
}
