package main;

import java.io.*;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputReader {

    public static List<String> getInput() {
        List<String> repArr = new ArrayList<>();
        Scanner myReader = new Scanner(System.in);
        myReader.forEachRemaining(repArr::add);
        return repArr;
    }

    public static List<String> getFileInput(String path) throws FileNotFoundException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        Integer counter = 0;
        List<String> ausgabe = new ArrayList<>();
        try {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("\n")) {
                    counter++;
                } else {//if (ausgabe.size() < counter + 1) {
                    ausgabe.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return ausgabe;
        }


    }
}
