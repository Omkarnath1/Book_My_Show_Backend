package com.example.Book_My_Show_App.Controller;

import com.example.Book_My_Show_App.DTO.ShowEntryDTO;
import com.example.Book_My_Show_App.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDTO showEntryDto){

        return new ResponseEntity<>(showService.addShow(showEntryDto), HttpStatus.CREATED);

    }
    @GetMapping("/maxShows")
    public ResponseEntity<String> getMovieWithMaxShows(){
        return new ResponseEntity<>(showService.getMovieWithMaxShows(), HttpStatus.OK);
    }

    @GetMapping("/getShowTime")
    public ResponseEntity<List<LocalTime>> getShowTiming(){
        return new ResponseEntity<>(showService.getShowTiming(), HttpStatus.OK);
    }


}