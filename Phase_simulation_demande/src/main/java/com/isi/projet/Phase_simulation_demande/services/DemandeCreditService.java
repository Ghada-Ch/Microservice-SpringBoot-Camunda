package com.isi.projet.Phase_simulation_demande.services;

import com.isi.projet.Phase_simulation_demande.model.DemandeCredit;
import com.isi.projet.Phase_simulation_demande.repository.BaremeRepository;
import com.isi.projet.Phase_simulation_demande.repository.DemandeCreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemandeCreditService {

    @Autowired
    public DemandeCreditRepository demandeCreditRepository;
    @Autowired
    public BaremeRepository baremeRepository;


    public DemandeCredit createDemandeCredit (DemandeCredit dcredit) {

        return demandeCreditRepository.save(dcredit);
    }


    public DemandeCredit getDemandeCredit(Long id) {

        DemandeCredit cnv =demandeCreditRepository.findById(id).get();
        return cnv;
    }


}
