
import java.io.*;  
import java.util.Scanner;  
public class Charrr{
    public static void main(String [] args){
        char c1=args[0].charAt(0);
        int counter=0;
        try{
            File file =new File("sample.txt");
            FileInputStream fls = new FileInputStream(file);
            int r=0;  
            while((r=fls.read())!=-1)  
            {  
                if(((char)r)==c1){
                    counter ++;
                }
            } 
        }
        catch(Exception e)  {  
            e.printStackTrace();  
        }
        System.out.print("Number of reptition is : ");
        System.out.print(counter);

    }    

}