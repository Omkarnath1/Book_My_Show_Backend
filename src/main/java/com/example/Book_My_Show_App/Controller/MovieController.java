package com.example.Book_My_Show_App.Controller;

import com.example.Book_My_Show_App.DTO.MovieDTO;
import com.example.Book_My_Show_App.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;
    @PostMapping("/addmovie")
    public String addMovie(@RequestBody MovieDTO movieDTO){
        return movieService.addTheater(movieDTO);
    }
}
