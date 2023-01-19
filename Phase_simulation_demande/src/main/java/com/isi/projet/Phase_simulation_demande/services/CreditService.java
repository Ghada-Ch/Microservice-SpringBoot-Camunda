package com.isi.projet.Phase_simulation_demande.services;

import com.isi.projet.Phase_simulation_demande.model.Bareme;
import com.isi.projet.Phase_simulation_demande.model.Credit;
import com.isi.projet.Phase_simulation_demande.model.DemandeCredit;
import com.isi.projet.Phase_simulation_demande.repository.BaremeRepository;
import com.isi.projet.Phase_simulation_demande.repository.CreditRepository;
import com.isi.projet.Phase_simulation_demande.repository.DemandeCreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditService {
    @Autowired
    public CreditRepository creditRepository;

    @Autowired
    public DemandeCreditRepository demandeCreditRepository;

    @Autowired
    public BaremeRepository baremeRepository;



    public Credit createCredit (Long iddemande, Long refbr) {
        Credit c = new Credit();
        //c.setId(null);
        DemandeCredit dm = demandeCreditRepository.findById(iddemande).get();
        Bareme br = baremeRepository.findById(refbr).get();
        c.setDemandeCredit(dm);
        c.setRefclient(dm.getClient().getCin());
        c.setRefbareme(br);
        float interet = c.getDemandeCredit().getMontant_demande() * c.getRefbareme().getTaux_nominal();
        c.setInteret(interet);
        float mensualite = (c.getDemandeCredit().getMontant_demande()+c.getInteret())/c.getDemandeCredit().getDuree_demande();
        c.setMensualite(mensualite);
        return creditRepository.save(c);
    }

    //READ
    public List<Credit> getCredit() {
        return creditRepository.findAll();
    }

    //DELETE
    public void deleteCredit(Long creditId) {
        creditRepository.deleteById(creditId);
    }

    public Credit updateCredit(Long creditId, Credit credit) {
        Credit c = creditRepository.findById(creditId).get();
        c = credit;
        return creditRepository.save(c);
    }

    public Credit sendCredit(Long id) {

        Credit cnv =creditRepository.getCredit(id);
        return cnv;
    }

}
