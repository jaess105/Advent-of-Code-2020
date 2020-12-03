import java.util.List;

import java.io.File; 
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class InputReader {
    public static List<String> getInput(){
        List<String> repArr=new ArrayList<>();
        Scanner myReader=new Scanner(System.in);
        myReader.forEachRemaining(repArr::add);
        return repArr;
    }
}
