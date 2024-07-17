package com.example.cogosharing.service.userdetail;

import com.example.cogosharing.entity.User;
import com.example.cogosharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null) { //optional 자료형 사용하지 않기 위해 이렇게 처리(이렇게 하면 orElseThrow 이용 못함)
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        return UserPrincipal.create(user);
    }
}