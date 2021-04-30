public class JobDetails {
    static String [] heades;
    String [] details;
    static void SetHeader(String []fromoutside){
        headers=fromoutside;
    }
    static int returnCriteriaColumn(String Criteria){
        for(int i=0;i<headers.length();i++){
            if(headers[i].equals(Criteria)){
                return i;
            }
        }
        return -1;
    }
    JobDetails(String [] outsidedetails){
        details=outsidedetails;
    }

}