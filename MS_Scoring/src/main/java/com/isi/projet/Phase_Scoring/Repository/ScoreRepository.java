package com.isi.projet.Phase_Scoring.Repository;

import com.isi.projet.Phase_Scoring.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository  extends JpaRepository<Score, Long> {
    @Query("SELECT u FROM Score u WHERE u.id = ?1 ")
    Score getScore(Long id);
}
