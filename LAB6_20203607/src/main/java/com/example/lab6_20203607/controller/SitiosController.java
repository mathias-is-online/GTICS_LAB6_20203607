package com.example.lab6_20203607.controller;


import com.example.lab6_20203607.entity.Site;
import com.example.lab6_20203607.repository.LocationRepository;
import com.example.lab6_20203607.repository.SiteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sitios")
public class SitiosController {

    final SiteRepository siteRepository;
    final LocationRepository locationRepository;


    public SitiosController(SiteRepository siteRepository,
                            LocationRepository locationRepository){
        this.siteRepository = siteRepository;
        this.locationRepository = locationRepository;
    }




    @GetMapping(value = {"", "/list","/"})
    public String listaSitios(Model model) {

        List<Site> listasitios = siteRepository.findAll();

        model.addAttribute("listasitios", listasitios);
        return "site/lista";
    }


    @GetMapping(value = {"/new"})
    public String nuevositio(Model model) {
        //COMPLETAR
        model.addAttribute("listapaisciudad",locationRepository.findAll());

        return "site/newFrm";

    }



    @PostMapping("/save")
    public String guardarSitio(Site site, RedirectAttributes attr) {
        //COMPLETAR
        siteRepository.save(site);
        attr.addFlashAttribute("msg", "Sitio  " + site.getSiteName() + " creado exitosamente");
        return "redirect:/sitios";

    }



    @GetMapping("/delete")
    public String borrarsitio(Model model,
                                 @RequestParam("id") int id,
                                 RedirectAttributes attr) {

        Optional<Site> optionalSite = siteRepository.findById(id);

        if (optionalSite.isPresent()) {
            Site site = optionalSite.get();
            siteRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Sitio "+site.getSiteName()+" borrado exitosamente.");
        }
        return "redirect:/sitios";

    }



}
