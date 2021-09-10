package com.neki.api.security;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neki.api.entity.UserEntity;
import com.neki.api.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity usuario = getUser(() -> userRepository.findByLogin(username));
        return usuario;
    }

    public UserDetails pegarUsuarioPorId(Integer id) {
    	UserEntity usuario = getUser(() -> userRepository.findById(id));
        return usuario;
    }


    private UserEntity getUser(Supplier<Optional<UserEntity>> supplier) {
        return supplier.get().orElseThrow(() -> 
                new UsernameNotFoundException("Usuário não encontrado"));
    }

}
