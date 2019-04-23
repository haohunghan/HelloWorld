//Idea: https://machinelearningcoban.com/2017/08/08/nbc/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NaiveBayesClassifier {
    
    final static int alpha = 1 ;
    
    public static void main(String[] args) throws FileNotFoundException{
        
        String test  = "sunny,hot,high,true";
        System.out.println(NaiveBayesCalculation(test));
    }
    
    static boolean NaiveBayesCalculation(String inputString) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("data/tennis.txt"));
        String[] type = new String[5]; 
        String strTemp;
        ArrayList<String> dataArrL = new ArrayList<>();
        
        while (sc.hasNextLine()){
            dataArrL.add(sc.nextLine());
        }
        
        int numberOfYes = 0, numberOfNo = 0;
        
        ArrayList<String> keysYes = new ArrayList<>();     //Tong tat ca cac thuoc tinh yes
        ArrayList<String> keysNo = new ArrayList<>();       // tong tat ca thuoc tinh false
        ArrayList<String> element = new ArrayList<>();   //Tong tat ca cac thuoc tinh(khong trung)
        for (int i=0; i< dataArrL.size(); i++){ 
            
            //Them tat ca cac kieu du lieu vao keys
            String[] tmp = dataArrL.get(i).split(",");
            
            //Lay so lan xuat hien play = yes va play = no ( de tinh xac suat P(yes), P{no)
            if ("yes".equals(tmp[4]))
                numberOfYes++;
            else numberOfNo++;
            
            for (int j=0; j < tmp.length; j++){
                
                if ("yes".equals(tmp[tmp.length-1]) ){
                    if (!"yes".equals(tmp[j]))
                        keysYes.add(tmp[j]);     
                }
                else {
                    if (!"no".equals(tmp[j]))
                        keysNo.add(tmp[j]);  
                    
                }
                
                //Them cac gia tri data(khong trung) vao element
                if (!element.contains(tmp[j])) {
                    //loai bo yes no cua class play
                    if (tmp[j].equals("yes") || tmp[j].equals("no") ){
                        
                    }
                    else {
                        element.add(tmp[j]);
                    }
                }
            }
               
        }
        
        
        //Tong so luong cac phan tu ben trong data(loai bo di phan tu trung) va yes no cua play
        int V = element.size();
        float rateYes = (float) numberOfYes/dataArrL.size();       //dataArrL.size = numberOfYes + numberOfNo
        float rateNo = (float) numberOfNo/dataArrL.size();
        float resultPlay, resultNoPlay, n1, n2, n3, n4;
        
        //tinh toan so luong phan tu trung
        int inputOutlook, inputTemp, inputHumidty, inputWindy;

        //Tinh toan he so play = yes
        String[] tempString = inputString.split(",");
        inputOutlook = getNumberDuplicate(tempString[0], keysYes);
        inputTemp = getNumberDuplicate(tempString[1], keysYes);
        inputHumidty = getNumberDuplicate(tempString[2], keysYes);
        inputWindy = getNumberDuplicate(tempString[3], keysYes);
        
        
        //Rate/5 because each time add 5 value 
        int xxx = keysYes.size() + V;
        n1 = (float)  (inputOutlook +alpha)/xxx;
        n2 =(float)  (inputTemp + alpha)/xxx;
        n3 = (float) (inputHumidty+alpha)/xxx;
        n4 = (float) (inputWindy+alpha)/xxx;
        resultPlay =(rateYes)*n1*n2*n3*n4;
        
        //Tinh toan he so play = no
        inputOutlook = getNumberDuplicate(tempString[0], keysNo);
        inputTemp = getNumberDuplicate(tempString[1], keysNo);
        inputHumidty = getNumberDuplicate(tempString[2], keysNo);
        inputWindy = getNumberDuplicate(tempString[3], keysNo);
                
        int xx = keysNo.size() + V;
        n1 = (float)  (inputOutlook +alpha)/xx;
        n2 =(float)  (inputTemp + alpha)/xx;
        n3 = (float) (inputHumidty+alpha)/xx;
        n4 = (float) (inputWindy+alpha)/xx;
        resultNoPlay =(rateNo)*n1*n2*n3*n4;
        
        if (resultPlay > resultNoPlay)
            return true;
        else return false;
    }
    
    static int getNumberDuplicate(String str, ArrayList<String> arrL){
        
        int count=0;
        for (int i=0; i < arrL.size(); i++){
            if (str.equals(arrL.get(i)) )
                count++;    
        }
        return count;
    }

}
