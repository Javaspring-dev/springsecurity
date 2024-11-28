package com.example.springsecurity.controller;

import com.example.springsecurity.dto.UserDTO;
import com.example.springsecurity.service.UserService;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/users")
    public class UserController {

        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        @PostMapping
        public String addUser(@RequestBody UserDTO userDTO) {
            return userService.add(userDTO);
        }

        @GetMapping("/admin")
        public String adminEndpoint() {
            return "Welcome Admin!";
        }

        @GetMapping("/user")
        public String userEndpoint() {
            return "Welcome User!";
        }
    }

