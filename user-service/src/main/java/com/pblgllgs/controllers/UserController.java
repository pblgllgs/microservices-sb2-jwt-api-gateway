package com.pblgllgs.controllers;

import com.pblgllgs.entities.UserVO;
import com.pblgllgs.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserVO> save(@RequestBody UserVO userVO){
        return new ResponseEntity<>(userService.save(userVO), HttpStatus.OK);
    }

    @GetMapping("/secured")
    public ResponseEntity<String> securedEndpoint() {
        return ResponseEntity.ok("Hello, from secured endpoint!");
    }

}
