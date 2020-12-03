import java.util.*;
import java.util.stream.IntStream;


public class Day3PartOne {
    
    public static void main(String[] args) {
        List<String> input = InputReader.getInput();
        List<Integer> treeCounter=new ArrayList<>();
        List<DownAndRight> parameters=new ArrayList();

        parameters.add(new DownAndRight(1, 1));
        parameters.add(new DownAndRight(1, 3));
        parameters.add(new DownAndRight(1, 5));
        parameters.add(new DownAndRight(1, 7));
        parameters.add(new DownAndRight(2, 1));
        
        treeCounter.add(executeRunDown(input,parameters.get(0).getDown(),parameters.get(0).getRight()));
        treeCounter.add(executeRunDown(input,parameters.get(1).getDown(),parameters.get(1).getRight()));
        treeCounter.add(executeRunDown(input,parameters.get(2).getDown(),parameters.get(2).getRight()));
        treeCounter.add(executeRunDown(input,parameters.get(3).getDown(),parameters.get(3).getRight()));
        treeCounter.add(executeRunDown(input,parameters.get(4).getDown(),parameters.get(4).getRight()));

        input.stream().forEach(System.out::println); 
        IntStream.range(0, parameters.size()).forEach(x->System.out.println("Für "+parameters.get(x).getDown()+" runter und "+parameters.get(x).getRight()+" nach rechts, trifft man "+treeCounter.get(x)+" Bäume"));
        treeCounter.stream().reduce((x,y)->x*y).ifPresent(x->System.out.println("Die Multiplikation dieser Werte ist: "+x));
    }

    private static Integer executeRunDown(List<String> input,int down, int right ){
        while (mapIsNotLongEnough(input,down,right)) {
            IntStream.range(0, input.size()).forEach(i -> input.set(i,input.get(i).concat(input.get(i))));
        }
        int treeCounter = 0;
        treeCounter = runDown(down,right,input, treeCounter);
        input.stream().forEach(System.out::println);
        System.out.println("Für "+down+" runter und "+right+" nach rechts, trifft man "+treeCounter+" Bäume");
        return treeCounter;
    }

    private static int runDown(int down, int right, List<String> input, int treeCounter) {
        for (int i = 0; i*down < input.size(); i++) {
            if (input.get(i*down).charAt(i * right) == '#') {
                // StringBuilder stringBuilder=new StringBuilder(input.get(i*down));
                // stringBuilder.setCharAt(i*right, 'X');
                input.set(i, input.get(i*down)); //input.set(i, input.get(stringBuilder.toString()));
                treeCounter = treeCounter + 1;
            } else if(input.get(i*down).charAt(i * right) == 'X'){
                treeCounter = treeCounter + 1;
            } else {
                StringBuilder stringBuilder=new StringBuilder(input.get(i*down));
                stringBuilder.setCharAt(i*right, '0');
                input.set(i, stringBuilder.toString());
            }
        }
        return treeCounter;
    }

    private static boolean mapIsNotLongEnough(List<String> input, int down, int right) {
        if (input.get(0).length() < input.size() * right) {
            return true;
        }
        return false;
    }
}
