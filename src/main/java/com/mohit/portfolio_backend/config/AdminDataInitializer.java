package com.mohit.portfolio_backend.config;

import com.mohit.portfolio_backend.entity.User;
import com.mohit.portfolio_backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminDataInitializer {

    @Bean
    CommandLineRunner initializeAdmin(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            if (userRepository.findByUsername("mohit").isEmpty()) {

                User admin = new User();
                admin.setUsername("mohit");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole("ADMIN");

                userRepository.save(admin);

                System.out.println("=================================");
                System.out.println("ADMIN USER CREATED");
                System.out.println("Username: mohit");
                System.out.println("Password: admin123");
                System.out.println("Role: ADMIN");
                System.out.println("=================================");

            } else {
                System.out.println("Admin user already exists.");
            }
        };
    }
}