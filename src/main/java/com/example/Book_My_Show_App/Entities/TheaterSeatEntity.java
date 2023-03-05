package com.example.Book_My_Show_App.Entities;


import com.example.Book_My_Show_App.Enum.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TheaterSeat")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TheaterSeatEntity {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   private SeatType seatType;

   private int seatNo;

   @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;




}
