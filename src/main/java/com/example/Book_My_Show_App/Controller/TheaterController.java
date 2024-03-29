package com.example.Book_My_Show_App.Controller;

import com.example.Book_My_Show_App.DTO.TheaterEntryDTO;
import com.example.Book_My_Show_App.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheaterController {
    @Autowired
    TheaterService theaterService;

    @PostMapping("/addTheatre")
    public ResponseEntity addTheater(@RequestBody TheaterEntryDTO theaterEntryDTO){
        try {
            String result = theaterService.addTheater(theaterEntryDTO);
            return new ResponseEntity(result, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<LocalTime>> getShowTiming(){
        return new ResponseEntity<>(theaterService.getShowTiming(), HttpStatus.OK);
    }
}
