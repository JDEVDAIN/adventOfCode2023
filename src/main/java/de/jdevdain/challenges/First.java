package de.jdevdain.challenges;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class First {
    private static int sumOfcalibrationTwoDigitValues_Part1(List<String> calibrationValues) {
        int sum = 0;
        for (String calibrationValue : calibrationValues) {
            List<Character> charList = calibrationValue.chars()
                    .mapToObj(value -> (char) value)
                    .filter(Character::isDigit)
                    .toList();
            if (charList.isEmpty()) {
                continue;
            }
            if (charList.size() == 1) { //alsp can us *10
                String s = "" + charList.getFirst() + charList.getFirst();

                sum += Integer.parseInt(s);
            } else {
                String s = "" + charList.getFirst() + charList.getFirst();

                sum += Integer.parseInt("" + charList.getFirst() + charList.getLast());
            }

        }
        return sum;
    }


    private static int sumOfcalibrationTwoDigitValues_Part2(List<String> calibrationValues) {
        Map<String, Integer> numberMap = new HashMap<>();
        numberMap.put("zero", 0);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);

        int sum = 0;
        for (String calibrationValue : calibrationValues) {

            List<Integer> charList = new ArrayList<>();
            for (int i = 0; i < calibrationValue.length(); i++) {
                if (Character.isDigit(calibrationValue.charAt(i))) {
                    charList.add(Integer.parseInt(""+ calibrationValue.charAt(i)));
                }
                for (int j = i; j <= calibrationValue.length(); j++) {

                    Integer valueAsInt = numberMap.getOrDefault(calibrationValue.substring(i, j), 0);
                    if (valueAsInt > 0) {
                        charList.add(valueAsInt);
                    }
                }
            }

            if (charList.isEmpty()) {
                continue;
            }
            if (charList.size() == 1) { //alsp can us *10
                String s = "" + charList.getFirst() + charList.getFirst();

                sum += Integer.parseInt(s);
            } else {
                String s = "" + charList.getFirst() + charList.getFirst();

                sum += Integer.parseInt("" + charList.getFirst() + charList.getLast());
            }
        }
        return sum;
    }


    public static void main(String[] args) throws IOException, URISyntaxException {

        Path path = Paths.get(First.class.getClassLoader().getResource("first.txt").toURI());
        List<String> allLines = Files.readAllLines(path);
        System.out.println(sumOfcalibrationTwoDigitValues_Part1(allLines));
        System.out.println(sumOfcalibrationTwoDigitValues_Part2(allLines));
    }
}