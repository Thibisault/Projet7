package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.domain.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    public Optional<User> findById(Integer id);
    public Optional<User> findByUsername(String username);
    public Optional<User> findByUsernameAndUserType(String username, UserType userType);
    public Optional<User> findByPassword(String password);
    public Optional<User> findByFullname(String fullname);
    public Optional<User> findByRole(String role);
}
