package com.backendNodo.backendNodo.controller;

import com.backendNodo.backendNodo.dto.user.UserDTO;
import com.backendNodo.backendNodo.dto.user.UserRequest;
import com.backendNodo.backendNodo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserDTO> findUserByUuid(@RequestParam UUID uuid){
        return ResponseEntity.ok(userService.findUserById(uuid));
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUSer(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.updateUser(userRequest));
    }
}
