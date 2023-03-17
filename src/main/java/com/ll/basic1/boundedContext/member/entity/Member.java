package com.ll.basic1.boundedContext.member.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Member {
    private final long id;
    private static long lastId;
    private final String username;
    private final String password;

    
    static {
        lastId = 0;
    }
    
    public Member(String username, String password){
        this(++lastId, username, password);
    }
}

