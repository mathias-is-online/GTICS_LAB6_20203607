package com.example.lab6_20203607.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "site")
public class Site {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SiteID")
    private Integer SiteID;

    private String SiteName;

    @ManyToOne
    @JoinColumn(name = "LocationID")
    private Location location;

    private Date InstallationDate;

    private String Latitude;
    private String Longitude;


}
