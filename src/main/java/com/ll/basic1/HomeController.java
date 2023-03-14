package com.ll.basic1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    private int count = -1;

    @GetMapping("/home/main")
    @ResponseBody
    public String showMain(){
        return "안녕하세요";
    }
    @GetMapping("/home/increase")
    @ResponseBody
    public int showIncrease(){
        count++;
        return count;
    }
}
