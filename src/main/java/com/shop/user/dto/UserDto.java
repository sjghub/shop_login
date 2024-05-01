package com.shop.user.dto;


import lombok.*;
import com.shop.user.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Getter
@ToString
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String displayName;



    public User toEntity(){
        String encode = new BCryptPasswordEncoder().encode(password);
        return new User(id, username, encode, displayName);
    }
}
