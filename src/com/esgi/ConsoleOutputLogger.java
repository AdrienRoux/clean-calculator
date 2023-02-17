package com.esgi;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ConsoleOutputLogger {
    public static boolean IS_LOGGING_ENABLED = false;
    private static final String LOG_PREFIX = "[%s][log] %s";
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HHmmss:SSSSSS");

    public static void logError(String message) {
        System.err.println(message);
    }

    private static void logMessage(String message) {
        if (!IS_LOGGING_ENABLED) return;

        LocalTime now = LocalTime.now();
        String formattedTime = now.format(TIME_FORMATTER);
        System.out.printf((LOG_PREFIX) + "%n", formattedTime, message);
    }

    public static void logStart(String operation) {
        logMessage("started");
        logMessage("applying operation " + getOperationName(operation));
    }

    private static String getOperationName(String operation) {
        return switch (operation) {
            case "+" -> "addition";
            case "-" -> "subtraction";
            case "*" -> "multiplication";
            default -> "unknown operation";
        };
    }

    public static void logEnd(int result) {
        System.out.println("--------------");
        System.out.println("Total = " + result);
        logMessage("end of program");
    }

    private static void logParsedValue(int value) {
        logMessage("parsed value = " + value);
    }

    private static void logAccumulation(int newAcc, int line) {
        logMessage("accumulation: " + newAcc + " on line " + line);
    }

    private static void logOperation(boolean isInitialValue, int value, String operatorSymbol, int newAcc) {
        if (isInitialValue) {
            System.out.println(value);
            return;
        }

        String intermediaryResultString = getIntermediaryResultString(operatorSymbol, newAcc);
        System.out.println(operatorSymbol + value + " (" + intermediaryResultString + ")");
    }

    private static String getIntermediaryResultString(String operation, int result) {
        return switch (operation) {
            case "+", "-", "*" -> "= " + (result);
            default -> "";
        };
    }

    public static void logIteration(int newValue,
                                    boolean isInitialValue,
                                    String operatorSymbol,
                                    int newAcc,
                                    int accumulation) {
        ConsoleOutputLogger.logParsedValue(newValue);
        ConsoleOutputLogger.logOperation(isInitialValue, newValue, operatorSymbol, newAcc);
        ConsoleOutputLogger.logAccumulation(newAcc, accumulation);
    }
}
