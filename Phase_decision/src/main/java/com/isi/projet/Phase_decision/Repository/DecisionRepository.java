package com.isi.projet.Phase_decision.Repository;

import com.isi.projet.Phase_decision.model.Decision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecisionRepository extends JpaRepository<Decision, Long> {
}
