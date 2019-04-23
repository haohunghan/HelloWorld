/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author STUDENT TDTU
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NaiveBayesClassifier {
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        
        Scanner sc = new Scanner(new File("data/tennis.txt"));
        String[] type = new String[5]; 
        String strTemp;
        int count = 0;
        ArrayList<String> dataArrL = new ArrayList<>();
        
        while (sc.hasNextLine()){
            
            if (count == 0){
                strTemp = sc.nextLine();
                String[] tmp = strTemp.split(",");
                
                for (int i=0; i< tmp.length; i++){
                    type[i] = tmp[i]; 
                }
            }
            else {
                dataArrL.add(sc.nextLine());
            }
            
            count++;
           // strTemp = sc.nextLine();
           // String[] tmp = strTemp.split(",");
        }
        
        ArrayList<String> keys = new ArrayList<>();
        for (int i=0; i< dataArrL.size(); i++){
            
            String[] tmp = dataArrL.get(i).split(",");
            for (int j=0; j < tmp.length; i++){
                keys.add(tmp[j]);
            }
        }
        System.out.println(keys);
             
    }
    
}
