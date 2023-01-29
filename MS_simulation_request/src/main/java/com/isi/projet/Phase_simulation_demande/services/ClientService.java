package com.isi.projet.Phase_simulation_demande.services;


import com.isi.projet.Phase_simulation_demande.model.Client;
import com.isi.projet.Phase_simulation_demande.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    //@Autowired pour instancier un objet de classe.
    @Autowired
    public ClientRepository clientRepository;

    public Client createClient (Client client) {


        return clientRepository.save(client);
    }
    //READ
    public List<Client> getClient() {
        return clientRepository.findAll();
    }

    //DELETE
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    // UPDATE

    public Client updateClient(Long clientId, Client client) {
        Client c = clientRepository.findById(clientId).get();
        c.setNom(client.getNom());
        c.setPrenom(client.getPrenom());
        c.setCin(client.getCin());
        c.setSalaire_mensuel(client.getSalaire_mensuel());
        c.setType_contrat(client.getType_contrat());
        c.setDate_naissance(client.getDate_naissance());
        return clientRepository.save(c);
    }

    public Client getclientbyCIN(String cin) {
        return clientRepository.findByCin(cin) ;
    }


}
