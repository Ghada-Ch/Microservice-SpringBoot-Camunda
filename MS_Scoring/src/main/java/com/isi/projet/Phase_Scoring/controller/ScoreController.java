package com.isi.projet.Phase_Scoring.controller;

import com.isi.projet.Phase_Scoring.model.Score;
import com.isi.projet.Phase_Scoring.services.ScoreService;
import lombok.RequiredArgsConstructor;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ScoreController {
    @Autowired
    public ScoreService scoreService;

    @RequestMapping(value="/scores", method = RequestMethod.POST)
    public Score createScore (@RequestBody Score c) {
        return scoreService.createScore(c);
    }

    @RequestMapping(value="/scores", method=RequestMethod.GET)
    public List<Score> readScore() {
        return scoreService.getScore();
    }

    @RequestMapping(value ="/scores/{id}", method=RequestMethod.PUT)
    public Score updateScore (@PathVariable(value = "id") Long id, @RequestBody Score scoreDetails)
    {
        return scoreService.updateScore(id, scoreDetails);
    }

    @RequestMapping(value="/scores/{id}", method=RequestMethod.DELETE)
    public void deleteScore (@PathVariable(value = "id") Long id) {
        scoreService.deleteScore(id);
    }


    @RequestMapping(value = "/scores/calcuScore/{iddossier}", method = RequestMethod.GET)
    public Score getScoreChanged( @PathVariable(value = "iddossier") Long iddossier ) throws IOException, ParseException {
        URL url = new URL("http://localhost:8083/api/getCredit/"+iddossier);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        inputLine = in.readLine();
        System.out.println("input  : "+inputLine);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(inputLine);
        return scoreService.changeScore(json);

    }


    @RequestMapping(value = "/score/scorenull/{iddossier}", method = RequestMethod.GET)
    public Score calculScoreNull( @PathVariable(value = "iddossier") Long iddossier ) throws IOException, ParseException {
        URL url = new URL("http://localhost:8083/api/getCredit/"+iddossier);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        inputLine = in.readLine();
        System.out.println("input  : "+inputLine);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(inputLine);
        return scoreService.scoreNull(json);

    }

    @RequestMapping(value ="/evaluationscore/{idscore}", method=RequestMethod.PUT)
    public Score updateScore (@PathVariable(value = "idscore") Long idscore)
    {
        return scoreService.evaluationScore(idscore);
    }


    @RequestMapping(value="/getScore/{idscore}", method=RequestMethod.GET)
    public Score getScore(@PathVariable(value = "idscore") Long id){
        return scoreService.sendScore(id);
    }

}
