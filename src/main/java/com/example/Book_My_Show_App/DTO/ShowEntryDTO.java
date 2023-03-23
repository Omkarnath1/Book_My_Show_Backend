package com.example.Book_My_Show_App.DTO;

import com.example.Book_My_Show_App.Enum.ShowType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntryDTO {

    private LocalDate showDate;
    private LocalTime showTime;
    private ShowType showType;
    private int movieId;
    private int theaterId;
    private int classicSeatPrice;
    private int premiumSeatPrice;
}
