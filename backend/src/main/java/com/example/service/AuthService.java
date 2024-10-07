package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Créer un nouvel utilisateur
    public User registerUser(String firstname, String lastname, String email, String password) {
        User user = new User();
        user.SetFirstName(firstname);
        user.SetLastName(lastname);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setRole("USER");
        return userRepository.save(user);
    }

    // Lire tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Lire un utilisateur par ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Mettre à jour un utilisateur
    public User updateUser(Long id, String email, String role) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: User not found."));
        
        user.setEmail(email);
        user.setRole(role);
        return userRepository.save(user);
    }

    // Supprimer un utilisateur par ID
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: User not found."));
        userRepository.delete(user);
    }
}
