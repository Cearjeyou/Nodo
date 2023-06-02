package com.backendNodo.backendNodo.dto.user;

import com.backendNodo.backendNodo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toModel(UserRequest userRequest);
    @Mapping(target = "rolUser", source = "rolUser")
    UserDTO toUserResponse(User user);
}
