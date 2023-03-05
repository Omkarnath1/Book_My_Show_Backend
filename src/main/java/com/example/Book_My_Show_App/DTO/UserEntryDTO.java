package com.example.Book_My_Show_App.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;
@Data
public class UserEntryDTO {

    private int id;

    private String name;

    private int age;

    private String email;

    private String mobile_no;

    private String address;
}
