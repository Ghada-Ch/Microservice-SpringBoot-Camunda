package com.isi.projet.Phase_Scoring.services;

import com.isi.projet.Phase_Scoring.Repository.BlacklisteBCTRepository;
import com.isi.projet.Phase_Scoring.model.BlacklisteBCT;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlacklisteBCTService {
    @Autowired
    public BlacklisteBCTRepository blacklisteBCTRepository;

    public BlacklisteBCT createBlacklisteBCT (BlacklisteBCT b) {

        return blacklisteBCTRepository.save(b);
    }
    //READ
    public List<BlacklisteBCT> getBlacklisteBCT() {
        return blacklisteBCTRepository.findAll();
    }

    //DELETE
    public void deleteBlacklisteBCT(Long bcId) {
        blacklisteBCTRepository.deleteById(bcId);
    }

    // UPDATE

    public BlacklisteBCT updateBlacklisteBCT(Long bctId, BlacklisteBCT bct) {
        BlacklisteBCT c = blacklisteBCTRepository.findById(bctId).get();
        c.setNom(bct.getNom());
        c.setPrenom(bct.getPrenom());
        c.setCin(bct.getCin());

        return blacklisteBCTRepository.save(c);
    }

    public boolean existanceClient(String cin)  {
        Boolean trouve = false;
        List<BlacklisteBCT> bct  = blacklisteBCTRepository.findAll();
        for (BlacklisteBCT liste : bct){
            if(liste.getCin().equals(cin)){
                trouve= true;
            }
        }
        return trouve;
    }

}
