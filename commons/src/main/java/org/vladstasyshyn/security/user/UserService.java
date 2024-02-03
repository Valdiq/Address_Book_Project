package org.vladstasyshyn.security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(repository.findByUsername(username))
                .get()
                .orElseThrow(() -> new UsernameNotFoundException("User with name: " + username + " NOT found"));
    }
}
