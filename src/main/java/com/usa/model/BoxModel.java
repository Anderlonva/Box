package com.usa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "boxes")
@NoArgsConstructor
@Getter
@Setter
public class BoxModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    private String name;
    private String location;
    private Integer capacity;
    private String description;

    @ManyToOne
    private CategoryModel category;

    @ManyToMany
    @JoinColumn(name = "messages_id")
    private List<MessageModel> messages;

    @ManyToMany
    @JoinColumn(name="reservations_id")
    private List<ReservationModel> reservations;

}
