package main.day3;

import java.util.List;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class InputReader {
    public static List<String> getInput(){
        List<String> repArr=new ArrayList<>();
        Scanner myReader=new Scanner(System.in);
        myReader.forEachRemaining(repArr::add);
        return repArr;
    }
}
