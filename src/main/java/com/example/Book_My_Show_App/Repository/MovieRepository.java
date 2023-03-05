package com.example.Book_My_Show_App.Repository;

import com.example.Book_My_Show_App.Entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
}
