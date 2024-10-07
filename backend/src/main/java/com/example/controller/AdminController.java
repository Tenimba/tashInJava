package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateRole")
    public ResponseEntity<?> updateUserRole(@RequestParam String email, @RequestParam String role) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Error: User not found."));
        user.setRole(role);
        userRepository.save(user);
        return ResponseEntity.ok("User role updated successfully!");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Error: User not found."));
        userRepository.delete(user);
        return ResponseEntity.ok("User deleted successfully!");
    }
}
