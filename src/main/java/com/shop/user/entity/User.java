package com.shop.user.entity;


import com.shop.user.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Member")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column
    private String password;
    @Column
    private String displayName;

    public UserDto createDto(User user){
        return new UserDto(user.getId(),user.getUsername(),user.getPassword(),user.getDisplayName());
    }

}
