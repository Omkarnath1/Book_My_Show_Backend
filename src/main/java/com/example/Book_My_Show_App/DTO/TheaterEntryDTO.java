package com.example.Book_My_Show_App.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class TheaterEntryDTO {

    private String name;

    private String location;

    private int classicSeatsCount;
    private int premiumSeatsCount;
}
