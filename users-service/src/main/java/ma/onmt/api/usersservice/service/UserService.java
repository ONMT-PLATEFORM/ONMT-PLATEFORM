package ma.onmt.api.usersservice.service;


import ma.onmt.api.usersservice.dto.BearerToken;
import ma.onmt.api.usersservice.dto.LoginDto;
import ma.onmt.api.usersservice.dto.RegisterDto;
import ma.onmt.api.usersservice.dto.UserResponse;
import ma.onmt.api.usersservice.entity.Role;
import ma.onmt.api.usersservice.entity.User;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface UserService {


    BearerToken authenticate(LoginDto loginDto);


    BearerToken register(RegisterDto registerDto);




    Role saveRole(Role role);


    User saverUser(User user);

    Page<UserResponse> getAllUsers(Map<String, String> queryParams);
}