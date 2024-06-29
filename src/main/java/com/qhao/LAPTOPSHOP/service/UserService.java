package com.qhao.LAPTOPSHOP.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qhao.LAPTOPSHOP.domain.User;
import com.qhao.LAPTOPSHOP.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Transactional
    public User createUser(User user) {
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
}
