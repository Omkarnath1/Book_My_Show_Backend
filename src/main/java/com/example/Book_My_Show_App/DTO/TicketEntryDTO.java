package com.example.Book_My_Show_App.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketEntryDTO {

    private int showId;

    private int userId;

    private List<String> requestedSeats = new ArrayList<>();
}
