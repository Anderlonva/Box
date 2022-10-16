package com.usa.service;

import com.usa.model.BoxModel;
import com.usa.model.ClientReport;
import com.usa.model.ReservationModel;
import com.usa.model.ReservationReport;
import com.usa.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        if (reservationModel.getIdReservation() == null){
            return  reservationRepository.saveReservation(reservationModel);
        }else {
            Optional<ReservationModel> optional= reservationRepository.getReservation(reservationModel.getIdReservation());
            if (optional.isEmpty()){
                return reservationRepository.saveReservation(reservationModel);
            }else {
                return reservationModel;
            }
        }
    }

    public boolean deleteReservation(Integer id){
        Boolean aBoolean = getReservation(id).map(b -> {
            reservationRepository.deleteReservation(b.getIdReservation());
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public ReservationModel updateReservation(ReservationModel reservationModel){
        if (reservationModel.getIdReservation() != null) {
            Optional<ReservationModel> optional = reservationRepository.getReservation(reservationModel.getIdReservation());
            if (!optional.isEmpty()){
                if (reservationModel.getStartDate() != null) {
                    optional.get().setStartDate(reservationModel.getStartDate());
                }
                if (reservationModel.getDevolutionDate() != null) {
                    optional.get().setDevolutionDate(reservationModel.getDevolutionDate());
                }
                if (reservationModel.getStatus() != null){
                    optional.get().setStatus(reservationModel.getStatus());
                }
                reservationRepository.saveReservation(optional.get());
                return optional.get();
            }else {
                return reservationModel;
            }
        }else {
            return reservationModel;
        }
    }

    public ReservationReport getReservationStatusReport(){
        List<ReservationModel> completed = reservationRepository.getReservationByStatus("completed");
        List<ReservationModel> canceled = reservationRepository.getReservationByStatus("cancelled");
        return new ReservationReport(completed.size(), canceled.size());
    }

    public List<ReservationModel> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date aDate= new Date();
        Date bDate= new Date();

        try {
            aDate = parser.parse(dateA);
            bDate = parser.parse(dateB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }
        if(aDate.before(bDate)){
            return reservationRepository.getReservationPeriod(aDate, bDate);
        }else{
            return new ArrayList<>();
        }
    }
    public List<ClientReport> getTopClients(){
        return reservationRepository.getTopClients();
    }
}
