package com.DatNguyen.EngRisk.Entity.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LoginForm {
    private String email;
    private String password;
}
