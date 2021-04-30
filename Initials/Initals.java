import java.util.Iterator;
import java.util.Vector;

public class Initals{
    public static void main (String [] args)
    {
        String fullName;
        fullName = args[0];
        if(fullName.length()==0){
            System.out.print("");
            return;

        }
        else{
            System.out.print(fullName.charAt(0));
            System.out.print(" ");
        }
        for(int i=0;i<fullName.length()-1;i++){
            if(fullName.charAt(i)==' '){
                System.out.println(fullName.charAt(i+1));
                return;
            }
        }        
    }


}