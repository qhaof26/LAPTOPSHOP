package com.qhao.LAPTOPSHOP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qhao.LAPTOPSHOP.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
