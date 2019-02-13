package com.example.demo1.service;

import com.example.demo1.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> getUser(String id);

}
