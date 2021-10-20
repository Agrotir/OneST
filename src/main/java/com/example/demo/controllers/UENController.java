package com.example.demo.controllers;

import com.example.demo.services.UENService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UENController {

    UENService uenService;

    public UENController(UENService uenService) {
        this.uenService = uenService;
    }

    @GetMapping(value = { "/", "/uen" })
    public String getUEN(Model model) {
        model.addAttribute("uenInput", "");
        return "uen";
    }

    @PostMapping("/uen")
    public String postUEN(Model model, @RequestParam String uenInput) {
        boolean result = uenService.isUEN(uenInput);
        model.addAttribute("uenInput", uenInput);
        model.addAttribute("result", result);
        return "uen";
    }
}
