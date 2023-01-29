package com.isi.projet.Phase_simulation_demande.services;

import com.isi.projet.Phase_simulation_demande.model.Bareme;
import com.isi.projet.Phase_simulation_demande.model.DemandeCredit;
import com.isi.projet.Phase_simulation_demande.repository.BaremeRepository;
import com.isi.projet.Phase_simulation_demande.repository.DemandeCreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BaremeService {
    @Autowired
    public BaremeRepository baremeRepository;

    @Autowired
    public DemandeCreditRepository demandeCreditRepository;

    public Bareme createBareme (Bareme bareme) {
        return baremeRepository.save(bareme);
    }

    //READ
    public List<Bareme> getBareme() {
        return baremeRepository.findAll();
    }

    //DELETE
    public void deleteBareme(Long baremeId) {
        baremeRepository.deleteById(baremeId);
    }

    // UPDATE

    public Bareme updateBareme(Long baremeId, Bareme bareme) {
        Bareme b = baremeRepository.findById(baremeId).get();
        b.setDuree_maximal(bareme.getDuree_maximal());
        b.setDuree_minimal(bareme.getDuree_minimal());
        b.setTaux_nominal(bareme.getTaux_nominal());
        b.setMontant_minimal(bareme.getMontant_minimal());
        b.setMontant_maximal(bareme.getMontant_maximal());
        return baremeRepository.save(b);
    }
    public Bareme lookForBareme(Long iddemande){
        List<Bareme> bareme  = baremeRepository.findAll();
        DemandeCredit dm =  demandeCreditRepository.findById(iddemande).get();
        ArrayList<Bareme> preselect = new ArrayList<Bareme>();
        bareme.forEach((br) -> {
            if(br.getDuree_minimal() <= dm.getDuree_demande() && br.getDuree_maximal() >= dm.getDuree_demande()){
                //System.out.println("vrai duree");
                if(br.getMontant_minimal() <= dm.getMontant_demande() && br.getMontant_maximal() >= dm.getMontant_demande()){
                    // System.out.println("vrai montant");
                    //System.out.println("Bareme :"+br);
                    preselect.add(preselect.size(),br);
                }
            }

        });
        System.out.println("preselect : "+preselect);
        Bareme min = new Bareme();
        if(preselect.size()!=0){
            min= preselect.get(0);
            for(Bareme br : preselect){
                if(br.getTaux_nominal() <= min.getTaux_nominal()){
                    min = br;
                }
            }
        }

        System.out.println("Bareme selectionné : "+min);
        return min;
    }

}
