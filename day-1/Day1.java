import java.io.File; 
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day1 {
    public static void main(String[] args) {
        List<String> repArr=new ArrayList<>();
        Scanner myReader=new Scanner(System.in);
        myReader.forEachRemaining(repArr::add);
        
        List <Integer> arr=repArr.stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        arr.forEach(x-> arr.forEach(y->{
                    if((x+y)==(2020)){
                        System.out.println("Dieses x: "+x+" und dieses y: " +y+" ergeben addiert "+(x+y)+" und multipliziert: "+x*y);
                    }
                })
            );
    }
}
