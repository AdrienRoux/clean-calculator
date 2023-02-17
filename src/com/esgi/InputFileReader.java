package com.esgi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFileReader {
    public static List<Integer> readNumbersFromFile(String fileName) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line.trim());
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    ConsoleOutputLogger.logError("Ignoring non-numeric line: " + line);
                }
            }
        } catch (IOException e) {
            ConsoleOutputLogger.logError("Error reading file: " + e.getMessage());
        }
        return numbers;
    }
}
