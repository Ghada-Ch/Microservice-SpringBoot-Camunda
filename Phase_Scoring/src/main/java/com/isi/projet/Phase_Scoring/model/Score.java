package com.isi.projet.Phase_Scoring.model;

import com.isi.projet.Phase_Scoring.enums.Evaluation;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idscore;

    private String dossier;

    private int calc_score;
    private Evaluation eval_score;
}
