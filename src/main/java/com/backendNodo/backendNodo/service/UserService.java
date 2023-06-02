package com.backendNodo.backendNodo.service;

import com.backendNodo.backendNodo.dto.user.UserDTO;
import com.backendNodo.backendNodo.dto.user.UserRequest;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDTO> findAllUsers();
    UserDTO createUser(UserRequest userRequest);
    UserDTO findUserById(UUID uuid);
    UserDTO updateUser(UserRequest userRequest);
    void deleteUserById(UUID uuid);

}
