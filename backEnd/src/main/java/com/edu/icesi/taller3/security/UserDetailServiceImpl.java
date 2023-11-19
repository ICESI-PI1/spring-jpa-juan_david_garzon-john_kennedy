package com.edu.icesi.taller3.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edu.icesi.taller3.persistence.models.Usuario;
import com.edu.icesi.taller3.persistence.repositories.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        System.out
                .println("UserDetailServiceImpl.loadUserByUsername() - username: " + user.getUsername() + " password: "
                        + user.getPassword());
        System.out.println("UserDetailServiceImpl.loadUserByUsername() - user: " + user.getUsername());
        System.out.println("UserDetailServiceImpl.loadUserByUsername() - password: " + user.getPassword());
        return new UserDetailsImpl(user);
    }

}
