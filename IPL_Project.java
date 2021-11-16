import com.opencsv.CSVReader;

import java.io.FileReader;

public class IPL_Project {

    public static void main(String args[]){
        try {
            FileReader filereader = new FileReader("C:/Users/pkesharwani/Desktop/IPL_Project/matches.csv");
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
