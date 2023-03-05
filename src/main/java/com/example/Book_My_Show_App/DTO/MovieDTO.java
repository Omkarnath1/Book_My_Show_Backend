package com.example.Book_My_Show_App.DTO;

import com.example.Book_My_Show_App.Enum.Genre;
import com.example.Book_My_Show_App.Enum.Language;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class MovieDTO {




    private String movie_name;

    private double rating;

    private int duration;


    private Genre genre;


    private Language language;
}
