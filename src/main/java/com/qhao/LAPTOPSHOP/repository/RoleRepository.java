package com.qhao.LAPTOPSHOP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qhao.LAPTOPSHOP.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role getRoleByName(String name);
}
