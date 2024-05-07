package com.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable());  //이거 안써있으면 csrf방지 기능 켜있는거
        http.authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/**").permitAll()   // 특정사이트를 검사할지말지 .permitAll()은 항상 허용
        );
        http.formLogin((formLogin) ->
                formLogin.loginPage("/login") // 로그인할 url
                        .defaultSuccessUrl("/") // 로그인 성공시 이동 url
                        // 실패시 기본적으로 /login?error 로 이동
        );
        http.logout(logout -> logout.logoutUrl("/logout")
                .logoutSuccessUrl("/"));
        return http.build();
    }

}
