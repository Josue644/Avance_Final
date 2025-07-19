package com.Trabajo.Final.security;

import com.Trabajo.Final.model.User;
import com.Trabajo.Final.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Buscar el usuario por correo electrónico
        User user = userRepository.findByEmail(email);
    
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    
        // Asegúrate de que el método getRoles() está devolviendo los roles correctamente
        UserBuilder builder = org.springframework.security.core.userdetails.User
            .withUsername(user.getEmail())
            .password(user.getPassword())
            .roles(user.getRoles().stream()
                    .map(role -> role.getName().replace("ROLE_", ""))  // Eliminar el prefijo 'ROLE_' si está presente
                    .toArray(String[]::new));
    
        return builder.build();
    }

}

