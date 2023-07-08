package com.techsiast.blog.blog_server.services;

import com.techsiast.blog.blog_server.models.User;
import com.techsiast.blog.blog_server.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user,Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);
}
