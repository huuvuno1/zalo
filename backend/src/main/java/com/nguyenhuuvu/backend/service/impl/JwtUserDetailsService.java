package com.nguyenhuuvu.backend.service.impl;

import com.nguyenhuuvu.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        var user = userRepository.findUserByEmail(s);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        var granted = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
        return new User(user.getEmail(), user.getPassword(), user.isEnable(), true, true, true, granted);
    }
}
