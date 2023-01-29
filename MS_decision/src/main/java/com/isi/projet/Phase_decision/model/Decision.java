package com.isi.projet.Phase_decision.model;

import com.isi.projet.Phase_decision.enums.Statut;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Decision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iddec;

    private String ref_demande;

    private Date date_decision;

    private Statut statut;


}
