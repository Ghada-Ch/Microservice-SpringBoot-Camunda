package com.isi.projet.Phase_simulation_demande.model;

import com.isi.projet.Phase_simulation_demande.enums.TypeContrat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;
    @Column(unique=true)
    private String cin;

    private float salaire_mensuel;
    @Enumerated(EnumType.STRING)
    private TypeContrat type_contrat;

    private String date_naissance;


}
