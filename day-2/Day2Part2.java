import java.io.File; 
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day2Part2 {
    public static void main(String[] args) {
        List<String> repArr=new ArrayList<>();
        Scanner myReader=new Scanner(System.in);
        Integer validPwCounter=0;
        // myReader.forEachRemaining(System.out::println);
        myReader.forEachRemaining(repArr::add);
        for(int i=0;i<repArr.size();i+=3){
            String [] delimiters = repArr.get(i).split("-");
            String letter = repArr.get(i+1);
            String passwort = repArr.get(i+2);
            Passwort pw = new Passwort(delimiters, letter, passwort);
            if (pw.isValidPart2()){
                validPwCounter++;
            }
        }
        System.out.println(validPwCounter);
    }
}
