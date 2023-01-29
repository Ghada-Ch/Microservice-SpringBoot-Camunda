package com.isi.projet.Phase_simulation_demande.repository;

import com.isi.projet.Phase_simulation_demande.model.Bareme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaremeRepository extends JpaRepository<Bareme, Long> {
}
