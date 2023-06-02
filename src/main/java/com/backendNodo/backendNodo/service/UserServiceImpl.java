package com.backendNodo.backendNodo.service;

import com.backendNodo.backendNodo.dto.user.UserMapper;
import com.backendNodo.backendNodo.dto.user.UserRequest;
import com.backendNodo.backendNodo.dto.user.UserDTO;
import com.backendNodo.backendNodo.model.User;
import com.backendNodo.backendNodo.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    @Override
    public UserDTO createUser(UserRequest userRequest) {
        User user = userRepository.save(userMapper.toModel(userRequest));
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserDTO findUserById(UUID uuid) {
        Optional<User> user = userRepository.findById(uuid);
        if (user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return userMapper.toUserResponse(user.get());
    }

    @Override
    public UserDTO updateUser(UserRequest userRequest) {
        Optional<User> user = userRepository.findById(userRequest.getId());
        if (user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        User usuario = userMapper.toModel(userRequest);
        return userMapper.toUserResponse(userRepository.save(usuario));
    }

    @Override
    public void deleteUserById(UUID uuid) {
        Optional<User> user = userRepository.findById(uuid);
        if (user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(uuid);
    }
}
