package com.esgi;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        if (args.length < 2 || args.length > 3) {
            ConsoleOutputLogger.logError("Usage: java com.esgi.Calculator <filename> <+/-/*> [-log]");
            return;
        }

        List<Integer> numbers = InputFileReader.readNumbersFromFile(args[0]);
        String operation = args[1];

        ConsoleOutputLogger.IS_LOGGING_ENABLED = args.length == 3 && "-log".equals(args[2]);

        Calculator calculator = new Calculator(numbers, operation);
        calculator.start();
    }
}