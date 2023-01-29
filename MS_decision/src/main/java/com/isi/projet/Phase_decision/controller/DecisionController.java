package com.isi.projet.Phase_decision.controller;

import com.isi.projet.Phase_decision.model.Decision;
import com.isi.projet.Phase_decision.services.DecisionService;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import net.minidev.json.parser.JSONParser;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DecisionController {
    @Autowired
    public DecisionService decisionService;

    @RequestMapping(value="/decisions", method = RequestMethod.POST)
    public Decision createDecision (@RequestBody Decision c) {
        return decisionService.createDecision(c);
    }

    @RequestMapping(value="/decisions", method=RequestMethod.GET)
    public List<Decision> readDecision() {
        return decisionService.getDecision();
    }

    @RequestMapping(value ="/decisions/{id}", method=RequestMethod.PUT)
    public Decision updateDecision (@PathVariable(value = "id") Long id, @RequestBody Decision decision)
    {
        return decisionService.updateDecision(id, decision);
    }

    @RequestMapping(value="/decisions/{id}", method=RequestMethod.DELETE)
    public void deleteDecision (@PathVariable(value = "id") Long id) {
        decisionService.deleteDecision(id);
    }


    @RequestMapping(value = "/decisions/getScore/{idscore}/{iddossier}", method = RequestMethod.GET)
    public Decision getDecisionChanged(@PathVariable(value = "idscore") Long idscore,@PathVariable(value = "iddossier") Long iddossier ) throws IOException, ParseException, ParseException {
        URL url = new URL("http://localhost:8081/api/getScore/"+idscore);
        URL urldemandedossier = new URL("http://localhost:8083/api/getCredit/"+iddossier);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        HttpURLConnection con1 = (HttpURLConnection) urldemandedossier.openConnection();

        con.setRequestMethod("GET");
        con1.setRequestMethod("GET");

        int status = con.getResponseCode();
        int status1 = con1.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        BufferedReader in1 = new BufferedReader(new InputStreamReader(con1.getInputStream()));

        String inputLine;
        String demandecredit;

        StringBuffer content = new StringBuffer();
        StringBuffer content1 = new StringBuffer();

        inputLine = in.readLine();
        demandecredit = in1.readLine();

        JSONParser parser = new JSONParser();
        JSONObject score = (JSONObject) parser.parse(inputLine);
        JSONObject demande = (JSONObject) parser.parse(demandecredit);

        return decisionService.addDecision(score,demande);

    }


}
