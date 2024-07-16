package com.qhao.LAPTOPSHOP.service;

import org.springframework.stereotype.Service;

import com.qhao.LAPTOPSHOP.domain.Role;
import com.qhao.LAPTOPSHOP.repository.RoleRepository;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRoleByName(String name) {
        return this.roleRepository.getRoleByName(name);
    }
}
