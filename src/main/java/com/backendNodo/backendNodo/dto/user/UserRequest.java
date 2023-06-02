package com.backendNodo.backendNodo.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private String password;
}
