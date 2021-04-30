import java.util.*;
import java.io.*;
import java.lang.*;

import com.opencsv.CSVReader;

public class Country_City {
    public static void main(String [] args) {
        List<String[]> Countries = new ArrayList<String[]>();
        List<String[]> Cities = new ArrayList<String[]>();

        Countries=ReadFromHere("Countries.txt");
        Cities=ReadFromHere("Cities.txt");

        //--------------------------------
        Map<String, ArrayList<String>> firstmap = new HashMap<String, ArrayList<String>>();
//        firstmap.put("SUP", new ArrayList<String>(
//                Arrays.asList("Geeks",
//                        "for",
//                        "Geeks")));
//        System.out.println(firstmap.get("SUP"));
//        System.out.println(firstmap.get("asd"));
//        firstmap.get("SUP").add("GEEK KMAN HENA");
//        System.out.println(firstmap.get("SUP"));
        List<String> CountryCodes= new ArrayList<String>();
        for(String [] Counrty : Countries){
            CountryCodes.add(Counrty[0]);
        }
        for(String [] city: Cities){
            if(firstmap.get(city[3])!=null){
                firstmap.get(city[3]).add(city[1]);
            }
            else{
                firstmap.put(city[3],new ArrayList<String>(Arrays.asList(city[1])));
            }

        }
        class comaprevalues implements Comparator<String[]>{
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
        for (Map.Entry<String,ArrayList<String>> cities_by_country_code :firstmap.entrySet()){

//            System.out.print("Key is: "+ cities_by_country_code.getKey() + " & Value is: ");
//
//            System.out.println(cities_by_country_code.getValue());

//            for(String cities :){
//                for(String city : cities){
//
//                }
//            }
            ArrayList<String[]> cities_with_population= new ArrayList<String[]>();
            for(String cityName : cities_by_country_code.getValue()){
                //Map<String, Integer> cities_inThisCode = new HashMap<String,Integer>();

//
                for(String[]  cityInfoFromCsv : Cities) {
                    if (cityName.equals(cityInfoFromCsv[1])) {
//                        System.out.print("FOUND COUNTRY WITH POPULATION : ");
//                        System.out.println(cityInfoFromCsv[2]);
                        cities_with_population.add(new String[]{cityInfoFromCsv[1], cityInfoFromCsv[2]});

                    }
                }
            }
            Collections.sort(cities_with_population,new comaprevalues());
            System.out.print("------------------------------------------------");
            System.out.print(cities_by_country_code.getKey());
            System.out.println("------------------------------------------------");
            for(String [] cityInfo : cities_with_population){
                System.out.print("City is : ");
                System.out.print(cityInfo[0]);
                System.out.print("            Population is : ");
                System.out.println(cityInfo[1]);
            }
            System.out.println("----------------------------------------------------------------------------------");

        }
//        Set<String> uniqueCodes = new HashSet<String>(CountryCodes);
//        System.out.println(CountryCodes);
//        System.out.println(uniqueCodes);
//        System.out.println(CountryCodes.size());
//        System.out.println(uniqueCodes.size());


    }

    private static List<String[]> ReadFromHere (String filename){
        List<String[]> Generic = new ArrayList<String[]>();

        try (CSVReader reader = new CSVReader(new FileReader(filename)))
        {
            Generic = reader.readAll();


        }
        catch (Exception e)
        {

            System.out.println(e);
        }
        return  Generic;
    }

}
