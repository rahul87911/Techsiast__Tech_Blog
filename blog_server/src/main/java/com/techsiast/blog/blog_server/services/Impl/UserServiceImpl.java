package com.techsiast.blog.blog_server.services.Impl;

import com.techsiast.blog.blog_server.exceptions.ResourceNotFoundException;
import com.techsiast.blog.blog_server.models.User;
import com.techsiast.blog.blog_server.payloads.UserDto;
import com.techsiast.blog.blog_server.repositories.UserRepo;
import com.techsiast.blog.blog_server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

    User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));

    user.setFirstname(userDto.getFirstname());
    user.setLastname(user.getLastname());
    user.setPhone(userDto.getPhone());
    user.setEmail(userDto.getEmail());
    user.setAbout(userDto.getAbout());

    User updatedUser = this.userRepo.save(user);
    UserDto userDto1 = this.userToDto(updatedUser);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {

        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id", userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();

        List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {

       User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id", userId));
        this.userRepo.delete(user);
    }

    public User dtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        user.setAbout(userDto.getAbout());

        return user;
    }

    public UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());
        userDto.setEmail(user.getEmail());
        userDto.setAbout(user.getAbout());

        return  userDto;
    }
}
