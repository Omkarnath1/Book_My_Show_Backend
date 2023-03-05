package com.example.Book_My_Show_App.Convertor;

import com.example.Book_My_Show_App.DTO.MovieDTO;
import com.example.Book_My_Show_App.Entities.MovieEntity;

public class MovieConvertor {
    public static MovieEntity convertMovieDTOtoEntity(MovieDTO movieDTO){
        MovieEntity movieEntity = MovieEntity.builder().movie_name(movieDTO.getMovie_name())
                .genre(movieDTO.getGenre()).rating(movieDTO.getRating()).duration(movieDTO.getDuration())
                .language(movieDTO.getLanguage()).build();
        return movieEntity;
    }
}
