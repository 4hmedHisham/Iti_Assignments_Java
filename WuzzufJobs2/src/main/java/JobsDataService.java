import java.util.*;

public class JobsDataService {
    void FilterJobsBy(String Criteria, List<JobDetails> jobs){
        int Criteria_column = JobDetails.returnCriteriaColumn(Criteria);

        Map<String, ArrayList<JobDetails>> Key_Criteria_Pair_JobDetail = new HashMap<String, ArrayList<JobDetails>>();
        for(JobDetails job : jobs){
            if(Key_Criteria_Pair_JobDetail.get(job.details.get(Criteria_column))!=null){
                Key_Criteria_Pair_JobDetail.get(job.details.get(Criteria_column)).add(job);
            }
            else{
                Key_Criteria_Pair_JobDetail.put(job.details.get(Criteria_column),new ArrayList<JobDetails>(Arrays.asList(job)));
            }
        }
        for (Map.Entry<String,ArrayList<JobDetails>> Single_Key_value_pair :Key_Criteria_Pair_JobDetail.entrySet()){
            System.out.println(Criteria+" IS : "+Single_Key_value_pair.getKey()+" AND FREQUENCY IS : " +Single_Key_value_pair.getValue().size());
        }



    }
}
