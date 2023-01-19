package com.isi.projet.Phase_simulation_demande.model;import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bareme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refBareme")
    private Long id;
    private float taux_nominal;

    private int duree_minimal;
    private int duree_maximal;
    private float montant_minimal;
    private float montant_maximal;

}
