package com.isi.projet.Phase_Scoring.Repository;

import com.isi.projet.Phase_Scoring.model.BlacklisteBCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlacklisteBCTRepository  extends JpaRepository<BlacklisteBCT, Long> {
}
