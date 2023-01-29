package com.isi.projet.Phase_simulation_demande.controller;


import com.isi.projet.Phase_simulation_demande.model.Client;
import com.isi.projet.Phase_simulation_demande.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {
    @Autowired
    public ClientService clientService;

    @RequestMapping(value="/clients/newclient", method = RequestMethod.POST)
    public Long createClient (@RequestBody Client c) {
        return clientService.createClient(c).getId();
    }


    @RequestMapping(value ="/getclientcin/{cin}", method=RequestMethod.GET)
    public Client findClient (@PathVariable(value = "cin") String cin)
    {
        System.out.println("client : "+clientService.getclientbyCIN(cin));
        System.out.println("client cin : "+cin);
        return clientService.getclientbyCIN(cin);

    }

    @RequestMapping(value ="/verifClient/{cin}", method=RequestMethod.GET)
    public boolean verifClient (@PathVariable(value = "id") String cin)
    {
        System.out.println("client : "+clientService.getclientbyCIN(cin));
        System.out.println("client cin : "+cin);
        return clientService.getclientbyCIN(cin) != null;

    }

    @RequestMapping(value="/clients", method=RequestMethod.GET)
    public List<Client> readClient() {
        return clientService.getClient();
    }

    @RequestMapping(value ="/clients/{id}", method=RequestMethod.PUT)
    public Client updateClient (@PathVariable(value = "id") Long id, @RequestBody Client clientDetails)
    {
        return clientService.updateClient(id, clientDetails);
    }

    @RequestMapping(value ="/clients/{cin}", method=RequestMethod.GET)
    public boolean GetById (@PathVariable(value = "cin") String cin)
    {
        System.out.println("client : "+clientService.getclientbyCIN(cin));
        System.out.println("client cin : "+cin);
        return clientService.getclientbyCIN(cin) != null;
    }



    @RequestMapping(value="/clients/{id}", method=RequestMethod.DELETE)
    public void deleteClient (@PathVariable(value = "id") Long id) {
        clientService.deleteClient(id);
    }


}
