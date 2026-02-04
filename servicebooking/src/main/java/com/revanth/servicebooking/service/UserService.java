package com.revanth.servicebooking.service;



import com.revanth.servicebooking.entity.Role;
import com.revanth.servicebooking.entity.User;
import com.revanth.servicebooking.repository.RoleRepository;
import com.revanth.servicebooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {

        // 🔐 HASH password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // assign USER role
        Role roleUser = roleRepository.findByName("ROLE_USER");
        user.getRoles().add(roleUser);

        return userRepository.save(user);
    }
}

