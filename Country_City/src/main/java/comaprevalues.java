import java.util.Comparator;

class comaprevalues implements Comparator<String[]> {
    public int compare(String[] citywithvalue,String[] citywithvalue2)
    {
        int integer1=Integer.parseInt(citywithvalue[1].trim());
        int integer2=Integer.parseInt(citywithvalue2[1].trim());
//                System.out.print("VALUE IS : ");
//                System.out.println(integer1);
//                System.out.print("VALUE2 IS : ");
//                System.out.println(integer2);
        return integer1-integer2;

    }
}