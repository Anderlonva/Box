package com.usa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "messages")
@NoArgsConstructor
@Getter
@Setter
public class MessageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id; //idMessage

    private String MessageText;

    @ManyToOne
    @JoinColumn(name= "clients_id")
    private ClientModel client;

    @ManyToOne
    @JoinColumn(name= "boxes_id")
    private BoxModel box;
}
