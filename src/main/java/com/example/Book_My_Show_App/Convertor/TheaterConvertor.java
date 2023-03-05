package com.example.Book_My_Show_App.Convertor;

import com.example.Book_My_Show_App.DTO.TheaterEntryDTO;
import com.example.Book_My_Show_App.Entities.TheaterEntity;

public class TheaterConvertor {
    public static TheaterEntity convertTheaterDtoToEntity(TheaterEntryDTO theaterEntryDTO){
        TheaterEntity theaterEntity = TheaterEntity.builder().name(theaterEntryDTO.getName())
                .location(theaterEntryDTO.getLocation()).build();
        return theaterEntity;
    }
}
