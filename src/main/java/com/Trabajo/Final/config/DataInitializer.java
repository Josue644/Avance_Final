package com.Trabajo.Final.config;

import com.Trabajo.Final.model.User;
import com.Trabajo.Final.model.Role;
import com.Trabajo.Final.repository.UserRepository;
import com.Trabajo.Final.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Verifica si ya existe un usuario admin
        if (userRepository.count() == 0) {
            // Crear el rol de admin si no existe
            Role adminRole = new Role("ADMIN"); 
            roleRepository.save(adminRole);

            // Crear el usuario admin
            User admin = new User();
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("1234")); // Encriptando la contraseña
            admin.getRoles().add(adminRole); // Asociar el rol al usuario

            userRepository.save(admin); // Guardar el usuario en la base de datos

            System.out.println("Usuario ADMIN creado exitosamente.");
        }
    }
}


