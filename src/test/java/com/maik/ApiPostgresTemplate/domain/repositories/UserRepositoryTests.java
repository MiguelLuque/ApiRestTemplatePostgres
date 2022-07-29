package com.maik.ApiPostgresTemplate.domain.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.maik.ApiPostgresTemplate.domain.entities.Role;
import com.maik.ApiPostgresTemplate.domain.entities.User;
import lombok.Builder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired private UserRepository repo;

    @Test
    public void testCreateAdmin() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("admin");

        User newUser = User
                .builder()
                .email("admin@gmail.com")
                .password(password)
                .build();
        User savedUser = repo.save(newUser);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testAssignRoleToAdmin() {
        Long userId = 1L;
        Long roleId = 1L;
        User user = repo.findById(userId).get();
        user.addRole(new Role(roleId));

        User updatedUser = repo.save(user);
        assertThat(updatedUser.getRoles()).hasSize(1);

    }
    @Test
    public void testCreateEditor() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("editor");

        User newUser = User
                .builder()
                .email("editor@gmail.com")
                .password(password)
                .build();
        User savedUser = repo.save(newUser);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testAssignRoleToEditor() {
        Long userId = 2L;
        Long roleId = 2L;
        User user = repo.findById(userId).get();
        user.addRole(new Role(roleId));

        User updatedUser = repo.save(user);
        assertThat(updatedUser.getRoles()).hasSize(1);

    }

    @Test
    public void testCreateCustomer() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("customer");

        User newUser = User
                .builder()
                .email("customer@gmail.com")
                .password(password)
                .build();
        User savedUser = repo.save(newUser);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }



    @Test
    public void testAssignRoleToCustomer() {
        Long userId = 3L;
        Long roleId = 3L;
        User user = repo.findById(userId).get();
        user.addRole(new Role(roleId));

        User updatedUser = repo.save(user);
        assertThat(updatedUser.getRoles()).hasSize(1);

    }
}