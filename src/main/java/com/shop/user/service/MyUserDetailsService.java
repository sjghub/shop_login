//package com.shop.user.service;
//
//import com.shop.user.entity.User;
//import com.shop.user.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        DB에서 username을 가진 유저를 찾아와서
////        return new User(유저아이디, 비번, 권한) 해주세요
//        Optional<User> byUsername = userRepository.findByUsername(username);
//    }
//
//}