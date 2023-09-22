package com.example.lab6_20203607.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TicketID")
    private Integer TicketID;

    @ManyToOne
    @JoinColumn(name = "SiteID")
    private Site site;

    private Integer TechnicianID;

    private String Status;

    private Date OpenedDate;

    private Date ClosedDate;

}
