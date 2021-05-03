import java.util.ArrayList;
import java.util.*;
public class TestWuzzufJobs {
    public static void main(String[] args){
        List<JobDetails> all_jobs=IO.readFromCsvFile("Wuzzuf_Jobs.csv");

        JobsDataService newjob= new JobsDataService();
        newjob.FilterJobsBy("Title",all_jobs);
        System.out.println("--------------------------------------------------------------------------------------");
        newjob.FilterJobsBy("Country",all_jobs);
        System.out.println("--------------------------------------------------------------------------------------");
        newjob.FilterJobsBy("Level",all_jobs);
        System.out.println("--------------------------------------------------------------------------------------");
        newjob.FilterJobsBy("YearsExp",all_jobs);
        System.out.println("--------------------------------------------------------------------------------------");



    }
}
