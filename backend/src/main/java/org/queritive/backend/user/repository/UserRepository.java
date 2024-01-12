package org.queritive.backend.user.repository;

import org.queritive.backend.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
