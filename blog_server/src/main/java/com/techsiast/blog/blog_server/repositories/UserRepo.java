package com.techsiast.blog.blog_server.repositories;

import com.techsiast.blog.blog_server.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
