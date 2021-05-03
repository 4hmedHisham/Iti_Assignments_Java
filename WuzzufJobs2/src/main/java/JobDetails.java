import java.util.ArrayList;

public class JobDetails {
    static ArrayList<String> headers;
    ArrayList<String>details;
    static void SetHeader(ArrayList<String> fromoutside){
        headers=fromoutside;
    }
    static int returnCriteriaColumn(String Criteria){
        for(int i=0;i<headers.size();i++){
            if(headers.get(i).equals(Criteria)){
                return i;
            }
        }
        return -1;
    }
    JobDetails(ArrayList<String> outsidedetails){
        details=outsidedetails;
    }

}