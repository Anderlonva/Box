package com.usa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reservations")
@NoArgsConstructor
@Getter
@Setter
public class ReservationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer idReservation;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Column(name = "start_date")
    private String starDate;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Column(name = "devolution_date")
    private String devolutionDate;

    @OneToOne
    private ClientModel client;

    @OneToMany
    private List<BoxModel> box;
}
