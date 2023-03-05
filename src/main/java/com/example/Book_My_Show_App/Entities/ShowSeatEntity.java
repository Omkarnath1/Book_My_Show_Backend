package com.example.Book_My_Show_App.Entities;


import com.example.Book_My_Show_App.Enum.SeatType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@Table(name = "ShowSeatTable")
@NoArgsConstructor
public class ShowSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

    private boolean isBooked;

    private int price;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Date bookedAt;

    @JoinColumn
    @ManyToOne
    private ShowEntity showEntity;


}
