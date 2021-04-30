
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IO {
    String x= "Wuzzuf_Jobs.csv";
    public static void main(String [] args){

        List<JobDetails> readFromCsvFile(String name)
        {
            try (CSVReader reader = new CSVReader(new FileReader(name))) {
                List<String[]> r = reader.readAll();
                List<JobDetails> alljobs = new ArrayList<JobDetails>();
                boolean firstime=true;
                for(String [] details:r){
                    if(firstime){
                        JobDetails.SetHeader(details);
                        firstime=false;
                    }
                    else{
                        alljobs.add(new JobDetails(details));
                    }
                }
                for(JobDetails job : alljobs){
                    System.out.println(job.details[0]);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (CsvException e) {
                e.printStackTrace();
            }
        }


    }
}
