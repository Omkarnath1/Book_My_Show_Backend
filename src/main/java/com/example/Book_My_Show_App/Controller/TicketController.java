package com.example.Book_My_Show_App.Controller;


import com.example.Book_My_Show_App.DTO.TicketEntryDTO;
import com.example.Book_My_Show_App.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public String bookTicket(@RequestBody TicketEntryDTO ticketEntryDTO){


        try{
            String result = ticketService.addTicket(ticketEntryDTO);
            return result;

        }catch (Exception e){

            return "";
        }


    }
}
