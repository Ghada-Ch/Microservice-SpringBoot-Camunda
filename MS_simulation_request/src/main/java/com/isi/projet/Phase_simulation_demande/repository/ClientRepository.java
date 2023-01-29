package com.isi.projet.Phase_simulation_demande.repository;

import com.isi.projet.Phase_simulation_demande.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository  extends JpaRepository<Client, Long> {
    public Client findByCin(String cin);
}
