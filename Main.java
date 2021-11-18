package com.poorwa.ipl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {

           List<Match> matchData = Main.getDataOfMatch();
           List<Delivery> deliveryData = Main.getDataOfDelivery();

           Main.numberOfMatchesPlayedPerYear(matchData);
           Main.totalMatchesWonByAllTeam(matchData);
           Main.extraRunConcededPerTeam2016(matchData,deliveryData);
           Main.totalMatchesAtGivenVenue(matchData);
           Main.topTenEconomicalBowlers2015(matchData,deliveryData);

    }

    public static void topTenEconomicalBowlers2015(List<Match> matchData, List<Delivery> deliveryData) {
        String topEconomicBowler = "";
        double topEconomicalBowlerRun = Double.MAX_VALUE;
        HashMap<String,Integer> bowlersAndTheirTotalRun = new HashMap<>();
        HashMap<String,Integer> bowlersAndTheirOver = new HashMap<>();

        for(int i=0;i<deliveryData.size();i++){
            if(deliveryData.get(i).getId()>=518 && deliveryData.get(i).getId()<=576){
                if(bowlersAndTheirTotalRun.containsKey(deliveryData.get(i).getBowler())){
                    bowlersAndTheirTotalRun.put(deliveryData.get(i).getBowler(),bowlersAndTheirTotalRun.get(
                            deliveryData.get(i).getBowler())+deliveryData.get(i).getTotalRungGivenByBowler());
                }else {
                    bowlersAndTheirTotalRun.put(deliveryData.get(i).getBowler(),deliveryData.get(i).
                            getTotalRungGivenByBowler());
                }
            }
        }
        for(int i=0;i<deliveryData.size();i++){
            if(deliveryData.get(i).getId()>=518 && deliveryData.get(i).getId()<=576){
                if(!bowlersAndTheirOver.containsKey(deliveryData.get(i).getBowler())) {
                    bowlersAndTheirOver.put(deliveryData.get(i).getBowler(), 0);

                    Set<Integer> calculateOver = new HashSet<>();
                    for (int j = 0; j < deliveryData.size(); j++) {
                        if (deliveryData.get(i).getId() >= 518 && deliveryData.get(i).getId() <= 576) {
                            if (deliveryData.get(i).getBowler().equals(deliveryData.get(j).getBowler())) {
                                calculateOver.add(deliveryData.get(j).getOver());
                            }
                        }
                    }
                    bowlersAndTheirOver.put(deliveryData.get(i).getBowler(),calculateOver.size());
                }
            }
        }
        for (Map.Entry<String,Integer> entry : bowlersAndTheirOver.entrySet()) {
            double meanRun=(double)bowlersAndTheirTotalRun.get(entry.getKey())/(double) entry.getValue();
            if(meanRun<topEconomicalBowlerRun) {
                topEconomicalBowlerRun = meanRun;
                topEconomicBowler = entry.getKey();
            }

        }
        System.out.println(topEconomicBowler);

    }

    public static void totalMatchesAtGivenVenue(List<Match> matchData) {
        int totalMatchesAtGivenVenue=0;
        for (Match matchDatum : matchData) {
            if (matchDatum.getVenue().equals("Rajiv Gandhi International Stadium, Uppal")) {
                totalMatchesAtGivenVenue++;
            }
        }
        System.out.println(totalMatchesAtGivenVenue);
    }

    public static List<Delivery> getDataOfDelivery() {
        List<Delivery>deliveryData = new ArrayList<>();
        try {
            String line;
            FileReader file = new FileReader("C:/Users/pkesharwani/Desktop/IPL_Project/deliveries.csv");
            BufferedReader br = new BufferedReader(file);
            br.readLine();
            while ((line = br.readLine()) != null)
            {
                Delivery d=new Delivery();
                String[] delivery = line.split(",");
                d.setId(Integer.parseInt(delivery[0]));
                d.setBattingTeam(delivery[2]);
                d.setExtraRun(Integer.parseInt(delivery[16]));
                d.setTotalRungGivenByBowler(Integer.parseInt(delivery[17]));
                d.setIsSuperOver(Integer.parseInt(delivery[9]));
                d.setOver(Integer.parseInt(delivery[4]));
                d.setBowler(delivery[8]);
                deliveryData.add(d);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return deliveryData;
    }
    public static List<Match> getDataOfMatch(){
        List<Match>matchData = new ArrayList<>();
        try {
            String line;
            FileReader file = new FileReader("C:/Users/pkesharwani/Desktop/IPL_Project/matches.csv");
            BufferedReader br = new BufferedReader(file);
            br.readLine();
            while ((line = br.readLine()) != null)
            {
                Match m=new Match();
                String[] match = line.split(",");
                m.setId(Integer.parseInt(match[0]));
                m.setSeason(Integer.parseInt(match[1]));
                m.setVenue(match[14]);
                m.setResult(match[8]);
                matchData.add(m);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return matchData;
    }

    public static void extraRunConcededPerTeam2016(List<Match> matchData, List<Delivery> deliveryData) {
        HashMap<String,Integer>extraRunConcededPerTeam2016 = new HashMap<>();
        for (Delivery deliveryDatum : deliveryData) {
            if (deliveryDatum.getId() - 577 >= 0) {
                if (extraRunConcededPerTeam2016.containsKey(deliveryDatum.getBattingTeam())) {
                    extraRunConcededPerTeam2016.put(deliveryDatum.getBattingTeam(), extraRunConcededPerTeam2016.
                            get(deliveryDatum.getBattingTeam()) + deliveryDatum.getExtraRun());
                } else {
                    extraRunConcededPerTeam2016.put(deliveryDatum.getBattingTeam(), deliveryDatum.
                            getExtraRun());
                }
            }
        }
       System.out.println(extraRunConcededPerTeam2016);
    }

    public static void totalMatchesWonByAllTeam(List<Match> matchData) {
        int totalMatchesWonByAllTeam = 0;
        for (Match matchDatum : matchData) {
            if (matchDatum.getResult().equals("normal")) {
                totalMatchesWonByAllTeam++;
            }
        }
            System.out.println(totalMatchesWonByAllTeam);
    }

    public static void numberOfMatchesPlayedPerYear(List<Match> matchData) {
            HashMap<Integer,Integer> numberOfMatchPlayedPerYear=new HashMap<>();
        for (Match matchDatum : matchData) {
            if (numberOfMatchPlayedPerYear.containsKey(matchDatum.getSeason())) {
                numberOfMatchPlayedPerYear.put(matchDatum.getSeason(), numberOfMatchPlayedPerYear.
                        get(matchDatum.getSeason()) + 1);
            } else {
                numberOfMatchPlayedPerYear.put(matchDatum.getSeason(), 1);
            }
        }
            System.out.println(numberOfMatchPlayedPerYear);

    }
}
