package com.shop.user.controller;

import com.shop.user.dto.UserDto;
import com.shop.user.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.shop.user.entity.User;

@ToString
@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/register")
    public String getRegister() {

        return "/register";
    }

    @PostMapping("/member")
    public String postRegister(UserDto userDto) {
        // dto -> entity
        User entity = userDto.toEntity();
        log.info("entity :" + entity.toString());
        // entity save
        User save = userRepository.save(entity);
        // return list
        return "redirect:/list";
    }

    @GetMapping("/login")
    public String login() {
        log.info(userRepository.findByUsername("aa").get().toString());
        return "/login";
    }
}
