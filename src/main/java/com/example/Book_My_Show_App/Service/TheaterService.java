package com.example.Book_My_Show_App.Service;


import com.example.Book_My_Show_App.Convertor.TheaterConvertor;
import com.example.Book_My_Show_App.DTO.TheaterEntryDTO;
import com.example.Book_My_Show_App.Entities.TheaterEntity;
import com.example.Book_My_Show_App.Entities.TheaterSeatEntity;
import com.example.Book_My_Show_App.Enum.SeatType;
import com.example.Book_My_Show_App.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;
    public String addTheater(TheaterEntryDTO theaterEntryDTO) throws Exception{

        TheaterEntity theaterEntity = TheaterConvertor.convertTheaterDtoToEntity(theaterEntryDTO);
        List<TheaterSeatEntity> theaterSeatEntityList = createThreatreSeats(theaterEntryDTO,theaterEntity);
        theaterEntity.setTheaterSeatEntityList(theaterSeatEntityList);
        theaterRepository.save(theaterEntity);
        return "Theater added Sucessfully";
    }

    private List<TheaterSeatEntity> createThreatreSeats(TheaterEntryDTO theaterEntryDTO,TheaterEntity theaterEntity){
        int noClassicSeats = theaterEntryDTO.getClassicSeatsCount();
        int noPremiumSeats = theaterEntryDTO.getPremiumSeatsCount();

        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();


        for(int count=1;count<noClassicSeats;count++){
            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder().seatType(SeatType.Classic).seatNo(Integer.parseInt(count+"C")).theaterEntity(theaterEntity).build();
            theaterSeatEntityList.add(theaterSeatEntity);
        }


        for(int count=1;count<noPremiumSeats;count++){
            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder().seatType(SeatType.Premium).seatNo(Integer.parseInt(count+"P"))
                    .theaterEntity(theaterEntity).build();
            theaterSeatEntityList.add(theaterSeatEntity);
        }
        return theaterSeatEntityList;

    }
}
