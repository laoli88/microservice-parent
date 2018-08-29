package com.yao.microservicesimpleprovideruser.controller;


import com.google.common.collect.Maps;
import com.yao.microservicesimpleprovideruser.dao.UserRepository;
import com.yao.microservicesimpleprovideruser.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("{id}")
    public User findById(@PathVariable Long id) {
        User user = userRepository.findOne(id);
        user.setPort(port);
        /*if (user != null) {
            throw new RuntimeException("我的异常");
        }*/
        return user;
    }

    @PostMapping("save")
    public String h(@RequestBody User user) {
        userRepository.save(user);
        Maps.newHashMap();
        return "success";
    }
}
