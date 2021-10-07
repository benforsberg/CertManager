package com.benforsberg.certmanager.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFirstName(String firstName);

    List<User> findByid(Long id);

    List<User> findByLastName(String lastName);

    List<User> findByEmail(String email);

}
