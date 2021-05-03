
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IO {
//    public static void main(String [] args){
//        String x= "Wuzzuf_Jobs.csv";
//        List<JobDetails> alljobs=readFromCsvFile(x);
//        JobsDataService newjob= new JobsDataService();
//        newjob.FilterJobsBy("Title",alljobs);
//
//
//    }
    public static List<JobDetails>  readFromCsvFile(String thefilename)
    {
        try (CSVReader reader = new CSVReader(new FileReader(thefilename))) {
            List<String[]> r = reader.readAll();
            List<ArrayList<String>> listOfListsFromStringArr = new ArrayList<ArrayList<String>>();
            for(String[]row:r)
            {
                listOfListsFromStringArr.add(new ArrayList( Arrays.asList( row ) ));
            }
            //new ArrayList( Arrays.asList( new String[]{"abc", "def"} ) );

            List<JobDetails> alljobs = new ArrayList<JobDetails>();
            boolean firstime=true;

            for(ArrayList<String> details:listOfListsFromStringArr){
                if(firstime){
                    JobDetails.SetHeader(details);
                    firstime=false;
                }
                else{
                    alljobs.add(new JobDetails(details));
                }
            }
//            for(JobDetails job : alljobs){
//                System.out.println(job.details.get(0));
//            }
            return alljobs;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }
        return null;
    }

}
