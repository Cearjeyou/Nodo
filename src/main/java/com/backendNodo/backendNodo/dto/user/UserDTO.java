package com.backendNodo.backendNodo.dto.user;

import com.backendNodo.backendNodo.model.enums.RolUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private RolUser rolUser;
}
