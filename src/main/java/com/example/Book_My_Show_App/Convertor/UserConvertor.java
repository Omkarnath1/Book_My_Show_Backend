package com.example.Book_My_Show_App.Convertor;

import com.example.Book_My_Show_App.DTO.UserEntryDTO;
import com.example.Book_My_Show_App.Entities.UserEntity;

public class UserConvertor {
    public static UserEntity convertDTOtoEntity(UserEntryDTO userEntryDTO){
        UserEntity userEntity = UserEntity.builder().age(userEntryDTO.getAge()).name(userEntryDTO.getName()).email(userEntryDTO.getEmail()).address(userEntryDTO.getAddress()).mobile_no(userEntryDTO.getMobile_no()).build();
        return userEntity;
    }
}
