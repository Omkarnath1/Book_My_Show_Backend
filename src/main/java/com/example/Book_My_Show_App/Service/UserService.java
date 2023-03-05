package com.example.Book_My_Show_App.Service;

import com.example.Book_My_Show_App.Convertor.UserConvertor;
import com.example.Book_My_Show_App.DTO.UserEntryDTO;
import com.example.Book_My_Show_App.Entities.UserEntity;
import com.example.Book_My_Show_App.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public String addUser(UserEntryDTO userEntryDTO) throws Exception{

       UserEntity userEntity = UserConvertor.convertDTOtoEntity(userEntryDTO);
        userRepository.save(userEntity);
        return "Added Successfully";
    }
}
