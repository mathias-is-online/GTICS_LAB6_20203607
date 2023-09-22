package com.example.lab6_20203607.repository;

import com.example.lab6_20203607.dto.SitioMayorTicket;
import com.example.lab6_20203607.dto.SitioMenorTIcket;
import com.example.lab6_20203607.dto.TicketxSitio;
import com.example.lab6_20203607.entity.Site;
import com.example.lab6_20203607.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query(value = "select s.SiteName as NombreSitio, count(*) as Cantidad\n" +
            "from ticket t\n" +
            "inner join site s on (t.SiteID = s.SiteID)\n" +
            "group by SiteName\n" +
            "order by count(*) DESC", nativeQuery = true)
    List<TicketxSitio> ticketxsitio();


    @Query(value = "select s.SiteName as NombreSitio, count(*) as Cantidad\n" +
            "from ticket t\n" +
            "inner join site s on (t.SiteID = s.SiteID)\n" +
            "group by SiteName\n" +
            "order by count(*) DESC\n" +
            "LIMIT 1", nativeQuery = true)
    List<SitioMayorTicket> sitiomayorsitio();



    @Query(value = "select s.SiteName as NombreSitio, count(*) as Cantidad\n" +
            "from ticket t\n" +
            "inner join site s on (t.SiteID = s.SiteID)\n" +
            "group by SiteName\n" +
            "order by count(*) ASC\n" +
            "LIMIT 1",nativeQuery = true)
    List<SitioMenorTIcket> sitiomenorsitio();

}
