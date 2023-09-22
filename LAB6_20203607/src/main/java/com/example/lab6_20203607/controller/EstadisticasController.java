package com.example.lab6_20203607.controller;


import com.example.lab6_20203607.dto.SitioMayorTicket;
import com.example.lab6_20203607.dto.SitioMenorTIcket;
import com.example.lab6_20203607.dto.TicketxSitio;
import com.example.lab6_20203607.repository.LocationRepository;
import com.example.lab6_20203607.repository.SiteRepository;
import com.example.lab6_20203607.repository.TicketRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/estadisticas")
public class EstadisticasController {


    final TicketRepository ticketRepository;
    final SiteRepository siteRepository;
    final LocationRepository locationRepository;


    public EstadisticasController(SiteRepository siteRepository,
                                    LocationRepository locationRepository,
                                    TicketRepository ticketRepository){
        this.siteRepository = siteRepository;
        this.locationRepository = locationRepository;
        this.ticketRepository = ticketRepository;
    }



    @GetMapping(value = {"","/"})
    public String indice(){
        return "stats/indice";
    }


    @GetMapping(value = {"/intervenciones"})
    public String intervenciones(Model model){


        List<TicketxSitio> listasitios = ticketRepository.ticketxsitio();

        model.addAttribute("listasitios", listasitios);
        return "stats/ticketxsitio";
    }


    @GetMapping(value = {"/mayorintervencion"})
    public String mayorintervencion(Model model){


        List<SitioMayorTicket> listasitios = ticketRepository.sitiomayorsitio();

        model.addAttribute("listasitios", listasitios);
        return "stats/mayorintervencion";
    }


    @GetMapping(value = {"/menorintervencion"})
    public String menorintervencion(Model model){


        List<SitioMenorTIcket> listasitios = ticketRepository.sitiomenorsitio();

        model.addAttribute("listasitios", listasitios);
        return "stats/menorintervencion";
    }

}
