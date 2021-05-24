package com.example.demo.Webscrapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Passing{
    private String name;
    private String passYds;
    private String YdsAtt;
    private String Att;

    public Passing(String name, String passYds, String ydsAtt, String att) {
        this.name = name;
        this.passYds = passYds;
        YdsAtt = ydsAtt;
        Att = att;
    }

    public Passing() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassYds() {
        return passYds;
    }

    public void setPassYds(String passYds) {
        this.passYds = passYds;
    }

    public String getYdsAtt() {
        return YdsAtt;
    }

    public void setYdsAtt(String ydsAtt) {
        YdsAtt = ydsAtt;
    }

    public String getAtt() {
        return Att;
    }

    public void setAtt(String att) {
        Att = att;
    }

}


public class DemoWebScrapping {

    public static void main(String[] args) throws IOException {

        
        String url = "https://www.nfl.com/stats/player-stats/";
       
        Document doc = Jsoup.connect(url).get();
       
        Element table = doc.getElementsByClass("d3-o-table d3-o-table--detailed d3-o-player-stats--detailed d3-o-table--sortable").first();
       
        Element tbody = table.getElementsByTag("tbody").first();
       
        List<Element> players = tbody.getElementsByTag("tr");
        
        List<Passing> playersObjects = new ArrayList<>();
        
        for (Element player: players) {
          
            List<Element> attributes = player.getElementsByTag("td");
            
            Passing passing = new Passing(
                    attributes.get(0).text(),
                    attributes.get(1).text(),
                    attributes.get(2).text(),
                    attributes.get(3).text()
            );
            
            playersObjects.add(passing);
        }
        
        for (Passing passing: playersObjects) {
            converterToJson(passing);
        }
    }

    
    private static void converterToJson(Passing passing){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(passing);
            System.out.println("Objeto em JSON: " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
