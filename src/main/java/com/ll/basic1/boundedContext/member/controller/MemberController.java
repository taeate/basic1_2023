package com.ll.basic1.boundedContext.member.controller;

import com.ll.basic1.base.rsData.RsData;
import com.ll.basic1.boundedContext.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
public class MemberController {
    //  V1//http://localhost:8080/member/login?username=user1&password=1234
//    @GetMapping("/member/login")
//    @ResponseBody
//    public Map<String, Object> Login(@RequestParam String username, @RequestParam String password) {
//
//        Map<String, Object> result = new HashMap<>();
//
//        if("user1".equals(username) && "1234".equals(password)){
//            result.put("resultCode", "S-1");
//            result.put("msg", username + "님 환영합니다");
//        } else {
//            result.put("resultCode", "F-1");
//            result.put("msg", "비밀번호가 일치하지않습니다");
//        }
//        return result;
//    }
    private final MemberService memberService;

    public MemberController(){
        memberService = new MemberService();
    }
    @GetMapping("/member/login")
    @ResponseBody
    public RsData login(String username, String password){
        return memberService.tryLogin(username, password);
    }
}
