package com.example.Book_My_Show_App.Repository;

import com.example.Book_My_Show_App.Entities.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
}
