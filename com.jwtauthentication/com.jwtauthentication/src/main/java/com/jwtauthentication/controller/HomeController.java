package com.jwtauthentication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/welcome")
    public String welcome(){
        String text = "This is private page";
        text
                +=" This is not allowed to authenticated user";
        return text;
    }

}
