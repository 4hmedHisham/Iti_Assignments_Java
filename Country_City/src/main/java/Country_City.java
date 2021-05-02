import java.text.CollationElementIterator;
import java.util.*;
import java.io.*;
import java.lang.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class Country_City {
    public static void main(String [] args) {
        List<String[]> Countries = new ArrayList<String[]>();
        List<String[]> Cities = new ArrayList<String[]>();

        Countries=ReadFromHere("Countries.txt");
        Cities=ReadFromHere("Cities.txt");

        //--------------------------------
        Map<String, ArrayList<String[]>> cities_as_values_by_country_Code_Key = new HashMap<String, ArrayList<String[]>>();
        List<String> CountryCodes= new ArrayList<String>();
        //got_coutries , didnt do anything with em
        for(String [] Counrty : Countries){
            CountryCodes.add(Counrty[0]);
        }
        for (String [] row : Cities){
             row[3] = row[3].replaceAll("\\s+","");
        }


        //got cities and added country code as key and cities as value
        for(String [] city: Cities){
            if(cities_as_values_by_country_Code_Key.get(city[3])!=null){
                cities_as_values_by_country_Code_Key.get(city[3]).add(new String[] {city[1], city[2]});;
            }
            else{
                cities_as_values_by_country_Code_Key.put(city[3],new ArrayList<String[]>());
                cities_as_values_by_country_Code_Key.get(city[3]).add(new String[] {city[1], city[2]});//new ArrayList<String>(Arrays.asList(city[1]))
            }

        }

        for (Map.Entry<String,ArrayList<String[]>> cities_by_country_code : cities_as_values_by_country_Code_Key.entrySet()){

            ArrayList<String[]> cities_with_population= new ArrayList<String[]>();
            cities_with_population=cities_by_country_code.getValue();
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
            System.out.print("Hightest City with population in this country is : ");
            System.out.println(getMostPopBasedOn(cities_with_population));
            System.out.println("----------------------------------------------------------------------------------");



        }

        List<String[]> Continent = new ArrayList<String[]>();

        try (CSVReader reader = new CSVReaderBuilder(new FileReader("countryContinent.csv")).withSkipLines(1).build())//
        {
            Continent = reader.readAll();


        }
        catch (Exception e)
        {

            System.out.println(e);
        }

        System.out.println(Continent.size());
        Continent.removeIf(row -> row[2].isEmpty() || row[5].isEmpty());
        System.out.println(Continent.size());
        List<String[]> CountryCode_Continent = new ArrayList<String[]>();
        Map<String, ArrayList<String>> country_Codes_by_continent = new HashMap<String, ArrayList<String>>();
        //Collecting all country codes by continent
        for(String [] country_code_continent: Continent)
        {
//            System.out.println("Actual Continent is ");
//            System.out.println(country_code_continent[5]);

            if(country_Codes_by_continent.get(country_code_continent[5])!=null){
                country_Codes_by_continent.get(country_code_continent[5]).add(country_code_continent[2]);
            }
            else{
                country_Codes_by_continent.put(country_code_continent[5],new ArrayList<String>(Arrays.asList(country_code_continent[2])));
            }

        }
        for (Map.Entry<String,ArrayList<String>> continent_with_coutnry_codes :country_Codes_by_continent.entrySet())
        {
            ArrayList<String[]> all_continent_cities_in_each_country= new ArrayList<String[]>();
//            System.out.println("Key is ");
            String keyyy=continent_with_coutnry_codes.getKey();
//            System.out.println(continent_with_coutnry_codes.getKey());
//            System.out.println(continent_with_coutnry_codes.getValue());
            ArrayList<String> listofcountries=continent_with_coutnry_codes.getValue();
            ArrayList<String> allKeysInFirstMap=new ArrayList<String>();
            cities_as_values_by_country_Code_Key.forEach((k,v) -> {
                allKeysInFirstMap.add(k);
//                System.out.println(k);
//                System.out.println(cities_as_values_by_country_Code_Key.get(k));
            });
//            ArrayList<String[]> justonevalue=cities_as_values_by_country_Code_Key.get("TWN");
//            boolean see =cities_as_values_by_country_Code_Key.containsKey("TWN");
            for(String country_code : continent_with_coutnry_codes.getValue())
            {
//                System.out.println(cities_as_values_by_country_Code_Key.get("POL"));
                if(cities_as_values_by_country_Code_Key.get(country_code)!=null){
                    all_continent_cities_in_each_country.addAll(cities_as_values_by_country_Code_Key.get(country_code));
                }

                //all_continent_cities_in_each_country.addAll(cities_as_values_by_country_Code_Key.get(country_code))
            }
            Collections.sort(all_continent_cities_in_each_country,new comaprevalues());
//            System.out.print("----------------------------------------------------------------------------------");
//            System.out.print("Continent : ");
//            System.out.print(continent_with_coutnry_codes.getKey());
//            System.out.println("----------------------------------------------------------------------------------");
//            for(String [] cityInfo : all_continent_cities_in_each_country){
//                System.out.print("City is : ");
//                System.out.print(cityInfo[0]);
//                System.out.print("            Population is : ");
//                System.out.println(cityInfo[1]);
//            }
            System.out.println("----------------------------------------------------------------------------------");
            System.out.print("CONTINENT IS : ");
            System.out.print(continent_with_coutnry_codes.getKey());
            System.out.print("     and Hightest City with population in this Continent  is : ");
            System.out.println(getMostPopBasedOn(all_continent_cities_in_each_country));

            System.out.println("----------------------------------------------------------------------------------");
            List<String[]> Captial_city_file = new ArrayList<String[]>();


            try (CSVReader reader = new CSVReaderBuilder(new FileReader("CapitalCountryContinent.csv")).withSkipLines(1).build())//
            {
                Captial_city_file = reader.readAll();


            }
            catch (Exception e)
            {

                System.out.println(e);
            }



//            Captial_city_file=ReadFromHere("CapitalCountryContinent.csv");

            ArrayList<String> CityCapitals = new ArrayList<String>();
            for(String [] row : Captial_city_file)
            {
                CityCapitals.add(row[1]);
            }
            ArrayList<String[]> all_citesWithPopulation=new ArrayList<String[]>();
            ArrayList<String[]> capital_cityWithPopulation=new ArrayList<String[]>();
//            for (String [] row : Cities){
//                row[3] = row[3].replaceAll("\\s+","");
//            }
            for(String[] row : Cities){
                row[1] = row[1].replaceAll("\\s+","");
                all_citesWithPopulation.add(new String [] {row[1],row[2]});
            }
            for (String singlecity:CityCapitals){
                for(String [] each_row : all_citesWithPopulation){
                    String []debugger=each_row;
                    if(singlecity=="Ottawa"){
                        boolean here2=true;
                    }
                    if(each_row[0]=="Ottawa"){
                        boolean here=true;
                    }
                    if(each_row[0].equals(singlecity)){

                        capital_cityWithPopulation.add(each_row);
                        break;
                    }
                }
            }
            Collections.sort(capital_cityWithPopulation,new comaprevalues());
            for(String[]captial : capital_cityWithPopulation){
                System.out.println("CAPITAL IS : "+captial[0]+" and population is : "+captial[1]);
            }
            System.out.print("HIGESHT POPULATION COUNTRY IS : ");

            System.out.println( getMostPopBasedOn(capital_cityWithPopulation));




        }

    }
        //for (Map.Entry<String,ArrayList<String>> countries_in_one_continent :countries_by_continent.entrySet()){

//        Set<String> uniqueCodes = new HashSet<String>(CountryCodes);
//        System.out.println(CountryCodes);
//        System.out.println(uniqueCodes);
//        System.out.println(CountryCodes.size());
//        System.out.println(uniqueCodes.size());

    private static String getMostPopBasedOn(ArrayList<String[]> cities_with_population){
        Collections.sort(cities_with_population,new comaprevalues());
       if(cities_with_population!=null){
           String [] Single_city_with_population =cities_with_population.get(cities_with_population.size()-1);
           return  Single_city_with_population[0];
       }
       return "No Countries within this Continent";
    }
    private static List<String[]> ReadFromHere (String filename){
        List<String[]> Generic = new ArrayList<String[]>();

        try (CSVReader reader = new CSVReader(new FileReader(filename)))
        {
            Generic = reader.readAll();
            for(String [] row:Generic){
                for(String value : row){
                    value.replace(" ","");
                }
            }

        }
        catch (Exception e)
        {

            System.out.println(e);
        }
        return  Generic;
    }

}
