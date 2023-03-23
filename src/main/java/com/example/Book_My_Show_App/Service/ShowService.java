package com.example.Book_My_Show_App.Service;

import com.example.Book_My_Show_App.Convertor.ShowConvertors;
import com.example.Book_My_Show_App.DTO.ShowEntryDTO;
import com.example.Book_My_Show_App.Entities.*;
import com.example.Book_My_Show_App.Enum.SeatType;
import com.example.Book_My_Show_App.Repository.MovieRepository;
import com.example.Book_My_Show_App.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;


    public String addShow(ShowEntryDTO showEntryDTO){
        //1. to create a entity;
        ShowEntity showEntity = ShowConvertors.convertDtoToEntity(showEntryDTO);

        int movieId = showEntryDTO.getMovieId();
        int theaterId = showEntryDTO.getTheaterId();

        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        TheaterEntity theaterEntity = theaterRepository.findById(theaterId).get();

        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);

        List<ShowSeatEntity> showSeatEntityList = createShowSeatEntity(showEntryDTO ,showEntity);
        //Setting the attribute of foreign key

        showEntity.setListOfShowsSeats(showSeatEntityList);

        List<ShowEntity> showEntityList = movieEntity.getShowEntityList();
        showEntityList.add(showEntity);
        movieEntity.setShowEntityList(showEntityList);
        movieRepository.save(movieEntity);

        List<ShowEntity> showEntityList1 = theaterEntity.getShowEntityList();
        showEntityList1.add(showEntity);
        theaterEntity.setShowEntityList(showEntityList1);
        theaterRepository.save(theaterEntity);
        return "Show added successfully";
    }

    public List<ShowSeatEntity> createShowSeatEntity(ShowEntryDTO showEntryDTO , ShowEntity showEntity){
        TheaterEntity theaterEntity = showEntity.getTheaterEntity();
       List<TheaterSeatEntity> theaterSeatEntityList = theaterEntity.getTheaterSeatEntityList();

       List<ShowSeatEntity> showSeatEntityList = new ArrayList<>();
       for(TheaterSeatEntity theaterSeatEntity : theaterSeatEntityList){
           ShowSeatEntity showSeatEntity = new ShowSeatEntity();
           showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNo());
           showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());
           if(theaterSeatEntity.getSeatType().equals(SeatType.Classic))
               showSeatEntity.setPrice(showEntryDTO.getClassicSeatPrice());
           else
               showSeatEntity.setPrice(showEntryDTO.getPremiumSeatPrice());

           showSeatEntity.setBooked(false);
           showSeatEntity.setShowEntity(showEntity); // parent : forign key for the showSeat entity

           showSeatEntityList.add(showSeatEntity);
       }

   return showSeatEntityList;

    }

    public List<LocalTime> getShowTiming(int theaterId , int movieId){
        TheaterEntity theaterEntity = theaterRepository.findById(theaterId).get();
        List<LocalTime> showTimingList = new ArrayList<>();
        List<ShowEntity> showEntityList = theaterEntity.getShowEntityList();
        for(ShowEntity showEntity : showEntityList){
            if(showEntity.getMovieEntity().getId() == movieId){
                showTimingList.add(showEntity.getShowTime());
            }
        }
        return showTimingList;

    }

    public String getMovieWithMaxShows(){
      List<MovieEntity> movieEntityList = movieRepository.findAll();
      int max = 0;
      String movie = "";
      for(MovieEntity movieEntity : movieEntityList){
          if(movieEntity.getShowEntityList().size()>max){
             max = movieEntity.getShowEntityList().size();
             movie = movieEntity.getMovie_name();
          }
      }

      return movie;
    }

}
