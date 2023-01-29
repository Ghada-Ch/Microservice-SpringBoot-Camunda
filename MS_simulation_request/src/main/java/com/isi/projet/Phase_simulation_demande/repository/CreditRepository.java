package com.isi.projet.Phase_simulation_demande.repository;

import com.isi.projet.Phase_simulation_demande.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
    @Query("SELECT u FROM Credit u WHERE u.id = ?1 ")
    Credit getCredit(Long id);
}
