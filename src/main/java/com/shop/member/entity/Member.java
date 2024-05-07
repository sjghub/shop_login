package com.shop.member.entity;


import com.shop.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;


@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column
    private String password;
    @Column
    private String displayName;

    public Member(String username, String password, List<GrantedAuthority> authorities) {
    }

    public MemberDto createDto(Member user){
        return new MemberDto(user.getId(),user.getUsername(),user.getPassword(),user.getDisplayName());
    }

}
