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
        Map<String, ArrayList<String>> cities_as_values_by_country_Code_Key = new HashMap<String, ArrayList<String>>();
        List<String> CountryCodes= new ArrayList<String>();
        //got_coutries , didnt do anything with em
        for(String [] Counrty : Countries){
            CountryCodes.add(Counrty[0]);
        }

        //got cities and added country code as key and cities as value
        for(String [] city: Cities){
            if(cities_as_values_by_country_Code_Key.get(city[3])!=null){
                cities_as_values_by_country_Code_Key.get(city[3]).add(city[1]);
            }
            else{
                cities_as_values_by_country_Code_Key.put(city[3],new ArrayList<String>(Arrays.asList(city[1])));
            }

        }

        for (Map.Entry<String,ArrayList<String>> cities_by_country_code : cities_as_values_by_country_Code_Key.entrySet()){

            ArrayList<String[]> cities_with_population= new ArrayList<String[]>();
            for(String cityName : cities_by_country_code.getValue()){


//
                for(String[]  cityInfoFromCsv : Cities) {
                    if (cityName.equals(cityInfoFromCsv[1])) {
                        //[1]City , [2]Population
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
            System.out.print("Hightest City with population in this country is : ");
            System.out.println(getMostPopBasedOnCountry(cities_with_population));

            System.out.println("----------------------------------------------------------------------------------");

            System.out.println("----------------------------------------------------------------------------------");

        }

        List<String[]> Continent = new ArrayList<String[]>();
        Continent=ReadFromHere("countryContinent.csv");

        List<String[]> CountryCode_Continent = new ArrayList<String[]>();
        Map<String, ArrayList<String>> country_Codes_by_continent = new HashMap<String, ArrayList<String>>();
        //Collecting all country codes by continent
        for(String [] country_code_continent: Continent)
        {
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
            for(String country_code : continent_with_coutnry_codes.getValue())
            {
                //all_continent_cities_in_each_country.addAll(cities_as_values_by_country_Code_Key.get(country_code))
            }
        }

    }
        //for (Map.Entry<String,ArrayList<String>> countries_in_one_continent :countries_by_continent.entrySet()){

//        Set<String> uniqueCodes = new HashSet<String>(CountryCodes);
//        System.out.println(CountryCodes);
//        System.out.println(uniqueCodes);
//        System.out.println(CountryCodes.size());
//        System.out.println(uniqueCodes.size());

    private static String getMostPopBasedOnCountry ( ArrayList<String[]> cities_with_population){
        Collections.sort(cities_with_population,new comaprevalues());
        String [] Single_city_with_population =cities_with_population.get(cities_with_population.size()-1);
        return  Single_city_with_population[0];
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
