package com.usa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@Getter
@Setter
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer idClient;

    private  String email;
    private  String password;
    private String name;
    private  Integer age;

    @OneToMany
    private List<MessageModel> messages;

    @OneToMany
    private List<ReservationModel> reservations;


}
