import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.HashMap;

public class IPL_Project {

    public static void main(String args[]){
        HashMap<String,Integer>numberof_match=new HashMap<>();
        try {
            FileReader filereader = new FileReader("C:/Users/pkesharwani/Desktop/IPL_Project/matches.csv");
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            csvReader.readNext();
            while ((nextRecord = csvReader.readNext()) != null) {
                   //System.out.println(nextRecord[1]);
                if(numberof_match.containsKey(nextRecord[1])){
                    System.out.println("yes"+numberof_match.get(nextRecord[1]));
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
}
