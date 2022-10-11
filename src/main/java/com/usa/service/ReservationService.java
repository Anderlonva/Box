package com.usa.service;

import com.usa.model.ReservationModel;
import com.usa.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAllReservations(){
        return (List<ReservationModel>) reservationRepository.getAllReservations();
    }

    public Optional<ReservationModel> getReservation(Integer id){
        return reservationRepository.getReservation(id);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel){
        return reservationRepository.saveReservation(reservationModel);
    }

    public boolean deleteReservation(Integer id){
        reservationRepository.deleteReservation(id);
        return true;
    }

    public ReservationModel updateReservation(ReservationModel reservationModel){
        return reservationRepository.updateReservation(reservationModel);
    }
}
