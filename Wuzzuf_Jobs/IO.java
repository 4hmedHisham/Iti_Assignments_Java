
package Wuzzuf_Jobs;
import java.io.*;  
import java.util.Iterator;
import java.util.*;
import java.util.Scanner;

package com.mkyong.io.csv.opencsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class IO {
    int x="Wuzzuf_Jobs.csv";
    public static void main(String [] args){
        List<JobDetails> ReadCSVFile(String FileName){
       
        try (CSVReader reader = new CSVReader(new FileReader("file.csv"))) {
            List<String[]> r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
        }  
            reutrn 
        }
    }
}
