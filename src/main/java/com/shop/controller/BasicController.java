package com.shop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class BasicController {

    @GetMapping("/date")
    @ResponseBody
    public String date() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate now = LocalDate.now();
        String format = now.format(formatter);
        System.out.println(format);
        return "format";
    }

}
