package com.example.songr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class HelloController {
    @GetMapping("/")
    //@ResponseBody
    public String getHello(){
        return "Hello world";
    }
}
