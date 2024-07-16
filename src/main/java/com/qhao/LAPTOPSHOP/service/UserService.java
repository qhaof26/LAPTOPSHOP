package com.qhao.LAPTOPSHOP.service;

import java.io.File;
import java.util.List;

import jakarta.servlet.ServletContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.qhao.LAPTOPSHOP.domain.User;
import com.qhao.LAPTOPSHOP.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ServletContext servletContext;
    public UserService(UserRepository userRepository, ServletContext servletContext) {
        this.userRepository = userRepository;
        this.servletContext = servletContext;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Transactional
    public User createUser(User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
    public String getImagePath(User user, String targetFile){
        return "/images/" + targetFile + "/" + user.getAvatar();
    }
}
