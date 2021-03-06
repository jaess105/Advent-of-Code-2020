import java.io.File; 
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day1Part2 {
    public static void main(String[] args) {
        List<String> repArr=new ArrayList<>();
        Scanner myReader=new Scanner(System.in);
        myReader.forEachRemaining(repArr::add);
        
        List <Integer> arr=repArr.stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        arr.forEach(x-> 
            arr.forEach(y->
                arr.forEach(z->{
                                if((x+y+z)==(2020)){
                                    System.out.println("x: "+x+", y: " +y+", z: "+z+" ergeben addiert "+(x+y+z)+" und multipliziert: "+(x*y*z));
                                }
                            })
                )
            );
    }
}
