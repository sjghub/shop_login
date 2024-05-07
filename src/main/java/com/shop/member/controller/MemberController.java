package com.shop.member.controller;

import com.shop.member.dto.MemberDto;
import com.shop.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.shop.member.entity.Member;

@EnableWebSecurity
@ToString
@Slf4j
@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping("/register")
    public String getRegister() {

        return "/register";
    }

    @PostMapping("/member")
    public String postRegister(MemberDto memberDto) {
        // dto -> entity
        Member entity = memberDto.toEntity();
        log.info("entity :" + entity.toString());
        // entity save
        Member save = memberRepository.save(entity);
        // return list
        return "redirect:/list";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/mypage")
    public String mypage(Authentication auth) {
        log.info(auth.toString());
        return "/mypage";
    }
}
