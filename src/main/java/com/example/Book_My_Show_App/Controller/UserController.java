package com.example.Book_My_Show_App.Controller;

import com.example.Book_My_Show_App.DTO.UserEntryDTO;
import com.example.Book_My_Show_App.Entities.UserEntity;
import com.example.Book_My_Show_App.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDTO userEntryDTO){

       try {
           String response = userService.addUser(userEntryDTO);
           return new ResponseEntity<>(response, HttpStatus.CREATED);

       } catch (Exception e) {
          String result = "User could not be added";
          return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
       }
    }
}
