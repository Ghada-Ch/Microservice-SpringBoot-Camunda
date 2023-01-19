package com.isi.projet.Phase_Scoring.controller;

import com.isi.projet.Phase_Scoring.model.BlacklisteBCT;
import com.isi.projet.Phase_Scoring.model.Score;
import com.isi.projet.Phase_Scoring.services.BlacklisteBCTService;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BlacklisteBCTController {
    @Autowired
    public BlacklisteBCTService blacklisteBCTService;

    @RequestMapping(value="/blacklistes", method = RequestMethod.POST)
    public BlacklisteBCT createBlacklisteBCT(@RequestBody BlacklisteBCT c) {
        return blacklisteBCTService.createBlacklisteBCT(c);
    }

    @RequestMapping(value="/blacklistes", method=RequestMethod.GET)
    public List<BlacklisteBCT> readBlacklisteBCT() {
        return blacklisteBCTService.getBlacklisteBCT();
    }

    @RequestMapping(value ="/blacklistes/{id}", method=RequestMethod.PUT)
    public BlacklisteBCT updateClient (@PathVariable(value = "id") Long id, @RequestBody BlacklisteBCT bcDetails)
    {
        return blacklisteBCTService.updateBlacklisteBCT(id, bcDetails);
    }

    @RequestMapping(value="/blacklistes/{id}", method=RequestMethod.DELETE)
    public void deleteBlacklisteBCT(@PathVariable(value = "id") Long id) {
        blacklisteBCTService.deleteBlacklisteBCT(id);
    }

    @RequestMapping(value = "/blackliste/checkclient/{cin}", method = RequestMethod.GET)
    public  boolean ExistanceClient(@PathVariable(value = "cin") String cin )  {

        return blacklisteBCTService.existanceClient(cin) ;

    }
}
