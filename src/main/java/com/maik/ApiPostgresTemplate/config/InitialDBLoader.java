package com.maik.ApiPostgresTemplate.config;

import com.maik.ApiPostgresTemplate.domain.entities.Role;
import com.maik.ApiPostgresTemplate.domain.entities.User;
import com.maik.ApiPostgresTemplate.domain.repositories.RoleRepository;
import com.maik.ApiPostgresTemplate.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;

@Component
public class InitialDBLoader {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void loadData() {
        createRoles();
        createAdmin();
        createEditor();
        createCustomer();
    }

    private void createRoles() {
        Role admin = new Role("ROLE_ADMIN");
        Role editor = new Role("ROLE_EDITOR");
        Role customer = new Role("ROLE_CUSTOMER");

        //try catch
        try{
            roleRepository.saveAll(List.of(admin, editor, customer));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void createAdmin() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("Administrator1!");
        User admin = User
                .builder()
                .email("admin@gmail.com")
                .password(password)
                .roles(new HashSet<>())
                .build();
        admin.addRole(new Role(1L));
        try{
            userRepository.save(admin);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void createEditor() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("Editor1!");
        User editor = User
                .builder()
                .email("editor@gmail.com")
                .password(password)
                .roles(new HashSet<>())
                .build();
        editor.addRole(new Role(2L));
        try{
            userRepository.save(editor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void createCustomer() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("Customer1!");
        User customer = User
                .builder()
                .email("customer@gmail.com")
                .password(password)
                .roles(new HashSet<>())
                .build();
        customer.addRole(new Role(3L));
        try{
            userRepository.save(customer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
