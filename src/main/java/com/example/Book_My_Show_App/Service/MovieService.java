package com.example.Book_My_Show_App.Service;


import com.example.Book_My_Show_App.Controller.MovieController;
import com.example.Book_My_Show_App.Convertor.MovieConvertor;
import com.example.Book_My_Show_App.DTO.MovieDTO;
import com.example.Book_My_Show_App.DTO.TheaterEntryDTO;
import com.example.Book_My_Show_App.Entities.MovieEntity;
import com.example.Book_My_Show_App.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addTheater(MovieDTO movieDTO){
        MovieEntity movieEntity = MovieConvertor.convertMovieDTOtoEntity(movieDTO);
        movieRepository.save(movieEntity);
        return "Theater added sucessfully";
    }
}
