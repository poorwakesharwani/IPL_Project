import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.HashMap;

public class IPL_Project {
    void question1(){
        HashMap<String,Integer>numberof_match=new HashMap<>();
        try {
            FileReader filereader = new FileReader("C:/Users/pkesharwani/Desktop/IPL_Project/matches.csv");
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            csvReader.readNext();
            while ((nextRecord = csvReader.readNext()) != null) {
                //System.out.println(nextRecord[1]);
                if(numberof_match.containsKey(nextRecord[1])){
                  //  System.out.println("yes"+numberof_match.get(nextRecord[1]));
                    numberof_match.put(nextRecord[1],numberof_match.get(nextRecord[1])+1);
                }else {
                    numberof_match.put(nextRecord[1], 1);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(numberof_match);
    }
    void question2(){
        int totalnormalmatch=0;
        try {
            FileReader filereader = new FileReader("C:/Users/pkesharwani/Desktop/IPL_Project/matches.csv");
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            csvReader.readNext();
            while ((nextRecord = csvReader.readNext()) != null) {
                //System.out.println(nextRecord[8]);
                if(nextRecord[8].equals("normal")){
                    totalnormalmatch++;
                }

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(totalnormalmatch);
    }
    void question3(){
        HashMap<String,Integer>getExtranunbyTeam_2016=new HashMap<>();
        try {
            FileReader filereader = new FileReader("C:/Users/pkesharwani/Desktop/IPL_Project/matches.csv");
            CSVReader csvReader_matches = new CSVReader(filereader);
            FileReader file = new FileReader("C:/Users/pkesharwani/Desktop/IPL_Project/deliveries.csv");
            CSVReader csvReader_deliveries = new CSVReader(file);
            String[] nextRecord;
            csvReader_matches.readNext();
            csvReader_deliveries.readNext();
            while ((nextRecord = csvReader_deliveries.readNext()) != null) {
                if(Integer.parseInt(nextRecord[0])-577>=0  ) {
                    break;
                }
                csvReader_deliveries.readNext();
            }
            while ((nextRecord = csvReader_deliveries.readNext()) != null) {
                //System.out.println(Integer.valueOf(nextRecord[16])+nextRecord[2]);
                // break;
                if(Integer.parseInt(nextRecord[0])-577>=0  ) {
                    if (getExtranunbyTeam_2016.containsKey(nextRecord[2])) {
                        getExtranunbyTeam_2016.put(nextRecord[2], getExtranunbyTeam_2016.get(nextRecord[2]) + Integer.valueOf(nextRecord[16]));
                    } else {
                        getExtranunbyTeam_2016.put(nextRecord[2], 0);
                    }
                    //break;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getExtranunbyTeam_2016);
    }
    public static void main(String args[]) {
        
    }
}

