package com.ll.basic1.boundedContext.member.service;

import com.ll.basic1.boundedContext.member.entity.Member;
import com.ll.basic1.base.rsData.RsData;
import com.ll.basic1.boundedContext.member.repository.MemberRepository;



public class MemberService {

    private MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }

    public RsData tryLogin(String username, String password){
        
        Member member = memberRepository.findByUsername(username);

        if (member == null) {
            return RsData.of("F-2", "%s(은)는 존재 하지 않는 회원입니다.".formatted(username));
        }

        if (!member.getPassword().equals(password)){
            return RsData.of("F-1", "비밀번호가 일치하지 않습니다.");
        }

        return RsData.of("S-1", "%s 님 환영합니다".formatted(username));
    } 
}
