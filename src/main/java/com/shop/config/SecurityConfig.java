package com.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable());  //이거 안써있으면 csrf방지 기능 켜있는거
        http.authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/**").permitAll()   // 특정사이트를 검사할지말지 .permitAll()은 항상 허용
        );
        return http.build();
    }

}
