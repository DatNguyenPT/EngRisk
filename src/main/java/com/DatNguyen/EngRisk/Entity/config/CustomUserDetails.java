package com.DatNguyen.EngRisk.Entity.config;

import com.DatNguyen.EngRisk.Entity.DTO.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CustomUserDetails extends User {
    private String email;
    public CustomUserDetails(String email){
        super();
        this.email = email;
    }
}
