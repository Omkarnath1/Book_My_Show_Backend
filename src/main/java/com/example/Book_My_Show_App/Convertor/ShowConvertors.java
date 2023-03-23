package com.example.Book_My_Show_App.Convertor;

import com.example.Book_My_Show_App.DTO.ShowEntryDTO;
import com.example.Book_My_Show_App.Entities.ShowEntity;

public class ShowConvertors {

    public static ShowEntity convertDtoToEntity(ShowEntryDTO showEntryDTO){
        ShowEntity showEntity = ShowEntity.builder().
                showType(showEntryDTO.getShowType())
                .showTime(showEntryDTO.getShowTime()).showDate(showEntryDTO.getShowDate())
                .build();
        return showEntity;
    }
}
