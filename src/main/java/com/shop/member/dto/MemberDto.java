package com.shop.member.dto;


import lombok.*;
import com.shop.member.entity.Member;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@AllArgsConstructor
@Getter
@ToString
public class MemberDto {

    private Long id;
    private String username;
    private String password;
    private String displayName;



    public Member toEntity(){
        String encode = new BCryptPasswordEncoder().encode(password);
        return new Member(id, username, encode, displayName);
    }
}
