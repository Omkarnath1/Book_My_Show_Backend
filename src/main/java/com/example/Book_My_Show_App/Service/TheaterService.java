package com.example.Book_My_Show_App.Service;


import com.example.Book_My_Show_App.Convertor.TheaterConvertor;
import com.example.Book_My_Show_App.DTO.TheaterEntryDTO;
import com.example.Book_My_Show_App.Entities.TheaterEntity;
import com.example.Book_My_Show_App.Entities.TheaterSeatEntity;
import com.example.Book_My_Show_App.Enum.SeatType;
import com.example.Book_My_Show_App.Repository.TheaterRepository;
import com.example.Book_My_Show_App.Repository.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterSeatRepository theaterSeatRepository;


    @Autowired
    TheaterRepository theaterRepository;

    public String addTheater(TheaterEntryDTO theaterEntryDto)throws Exception{


        //Do some validations :
        if(theaterEntryDto.getName()==null||theaterEntryDto.getLocation()==null){
            throw new Exception("Name and location should valid");
        }

        TheaterEntity theaterEntity = TheaterConvertor.convertTheaterDtoToEntity(theaterEntryDto);
        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeats(theaterEntryDto,theaterEntity);

        theaterEntity.setTheaterSeatEntityList(theaterSeatEntityList);
        theaterRepository.save(theaterEntity);

        return "Theater Added successfully";
    }

    private List<TheaterSeatEntity> createTheaterSeats(TheaterEntryDTO theaterEntryDto,TheaterEntity theaterEntity){

        int noClassicSeats = theaterEntryDto.getClassicSeatsCount();
        int noPremiumSeats = theaterEntryDto.getPremiumSeatsCount();

        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

        //Created the classic Seats
        for(int count = 1;count<=noClassicSeats;count++){

            //We need to make a new TheaterSeatEntity
            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder()
                    .seatType(SeatType.Classic).seatNo(count+"C")
                    .theaterEntity(theaterEntity).build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }


        //Create the premium Seats
        for(int count=1;count<=noPremiumSeats;count++){

            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder().
                    seatType(SeatType.PREMIUM).seatNo(count+"P").theaterEntity(theaterEntity).build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        //Not saving the child here
        return theaterSeatEntityList;

    }

    private List<TheaterEntity> findMyMovieByName(String name){
         List<TheaterEntity> theaterEntityList = theaterRepository.findAll();
         List<TheaterEntity> myMovies = new ArrayList<>();
         for(TheaterEntity theaterEntity : theaterEntityList){
             if(theaterEntity.getShowEntityList().contains(name)){
                 myMovies.add(theaterEntity);
             }
         }
         return myMovies;
    }

    private List<String> getUniqueLocations(){
        List<String> uniqueLocations = new ArrayList<>();
        List<TheaterEntity> theaterEntityList = theaterRepository.findAll();
        for(TheaterEntity theaterEntity : theaterEntityList ){
            if(uniqueLocations.contains(theaterEntity.getLocation())){
                continue;
            }
            else {
                uniqueLocations.add(theaterEntity.getLocation());
            }
        }
        return uniqueLocations;
    }
}
