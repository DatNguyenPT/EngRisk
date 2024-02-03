package com.DatNguyen.EngRisk.Entity.DTO;

import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RegisterForm {
    private String userName;
    private String email;
    private String password;
    private String retypePassword;
}
