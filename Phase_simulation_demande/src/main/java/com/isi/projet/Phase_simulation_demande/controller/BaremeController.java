package com.isi.projet.Phase_simulation_demande.controller;


import com.isi.projet.Phase_simulation_demande.model.Bareme;
import com.isi.projet.Phase_simulation_demande.services.BaremeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BaremeController {
    @Autowired
    BaremeService baremeService;

    @RequestMapping(value="/baremes", method = RequestMethod.POST)
    public Bareme createBareme (@RequestBody Bareme c) {
        return baremeService.createBareme(c);
    }

    @RequestMapping(value="/lookforbaremes/{iddemande}", method=RequestMethod.GET)
    public Bareme lookforbareme (@PathVariable(value = "iddemande") Long id) {

        return baremeService.lookForBareme(id);
    }
    @RequestMapping(value="/baremes", method=RequestMethod.GET)
    public List<Bareme> readBareme() {
        return baremeService.getBareme();
    }


    @RequestMapping(value ="/baremes/{id}", method=RequestMethod.PUT)
    public Bareme updateBareme (@PathVariable(value = "id") Long id, @RequestBody Bareme baremeDetails)
    {
        return baremeService.updateBareme(id, baremeDetails);
    }

    @RequestMapping(value="/baremes/{id}", method=RequestMethod.DELETE)
    public void deleteBareme (@PathVariable(value = "id") Long id) {
        baremeService.deleteBareme(id);
    }




}
