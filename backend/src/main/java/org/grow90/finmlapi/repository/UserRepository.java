package org.grow90.finmlapi.repository;

import org.grow90.finmlapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,  Integer> {
    User findByUserName(String userName);
}
