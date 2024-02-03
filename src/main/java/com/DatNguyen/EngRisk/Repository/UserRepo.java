package com.DatNguyen.EngRisk.Repository;

import com.DatNguyen.EngRisk.Entity.DTO.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUserName(String userName);
}
