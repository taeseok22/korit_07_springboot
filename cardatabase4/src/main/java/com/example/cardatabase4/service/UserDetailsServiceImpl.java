package com.example.cardatabase4.service;

import com.example.cardatabase4.domain.AppUser;
import com.example.cardatabase4.domain.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.security.core.userdetails.User.withUsername;
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = appUserRepository.findByUsername(username);

        UserBuilder builder = null;
        if (user.isPresent()) {
            AppUser currentUser = user.get();       // user 자체는 Optional 자료형이지 AppUser가 아니다.
            builder = withUsername(username);
            builder.password(currentUser.getPassword()).roles(currentUser.getRole());
        } else {
            throw new UsernameNotFoundException("User Not Found");
        }
        return builder.build();
    }
}
