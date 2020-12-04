package main.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import main.InputReader;

public class Day4Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        System.setOut(new PrintStream(new File("tasks/de/main/day4/output.txt")));

        String examplePpsP1="tasks/de/main/day4/stdPassPorts.txt";
        String pathInvPpsP2="tasks/de/main/day4/part2InvalidPasswords.txt";
        String pathValPpsP2="tasks/de/main/day4/part2ValidPasswords.txt";
        String pathMyInput="tasks/de/main/day4/passports.txt";
        String pathKrasieInput="tasks/de/main/day4/4.txt";

        List<String > input =new ArrayList<>();
        try {
            input=InputReader.getFileInput(pathMyInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String inputBlock="";
        List<Passport> passports=new ArrayList<>();
        for(String string:input){
            if (string.equals("")){
                passports.add(new Passport(inputBlock));
                inputBlock="";
            } else {
                inputBlock=inputBlock.concat(" "+string);
            }
        }
        if(inputBlock!=""){
            passports.add(new Passport(inputBlock));
        }
        Integer validityCounter=0;
        for(Passport passport:passports){
            if(passport.isValid()){
                validityCounter++;
                System.out.println(passport.toString());
            }

        }
        System.out.println(validityCounter);
    }
}
