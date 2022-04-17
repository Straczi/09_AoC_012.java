package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<String> inputList = getInputData("inputData.txt");
        int wantedNumberIndex =0;
        for (int i = 25; i < inputList.size(); i++) {
            boolean isCorrect = false;
            for (int j = i-25; j < i-1 ; j++) {
                for (int k = j+1; k < i ; k++) {
                    if (Integer.parseInt(inputList.get(j)) + Integer.parseInt(inputList.get(k)) == Integer.parseInt(inputList.get(i)) ) {
                        isCorrect = true;
                    }
                }
            }
            if(!isCorrect){
                System.out.println(inputList.get(i));
                wantedNumberIndex =i;
                break;
            }
        }

        //gewollte Nummer gefunden
        int sum =0;
        int lower =wantedNumberIndex-2;
        int upper = wantedNumberIndex-1;
        int wantedNumber =Integer.parseInt(inputList.get(wantedNumberIndex));
        while (sum != wantedNumber) {
            sum =0;
            for (int i = lower; i <= upper; i++) {
                sum+= Integer.parseInt(inputList.get(i));
            }
            if(sum <wantedNumber){
                lower--;
            } else if( sum > wantedNumber){
                upper--;
                if(upper == lower){
                    lower--;
                }
            } else {
                System.out.println("solte Zahl sein:" + sum);
                System.out.println(inputList.get(lower));
                System.out.println( inputList.get(upper));
                System.out.println("LowerIndex: " + lower);
                System.out.println("UpperIndex: " + upper);
                break;
            }
        }

        int minNumber = Integer.parseInt(inputList.get(lower));
        int maxNumber = minNumber;
        for (int i = lower; i <= upper; i++) {
            int temp = Integer.parseInt(inputList.get(i));
            if(temp> maxNumber){
                maxNumber =temp;
            } else if( temp< minNumber){
                minNumber = temp;
            }
        }
        System.out.println("Ergebnis: " + (minNumber+maxNumber)); //Test gibt gewoLlte Zahl aus, aber AoC sagt, ist falsch?
    }

    public static ArrayList<String> getInputData (String filename) throws Exception{
        File inputData = new File(filename);
        Scanner scanner = new Scanner(inputData);
        ArrayList<String> dataList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            dataList.add(scanner.nextLine());
        }
        return dataList;
    }
}
