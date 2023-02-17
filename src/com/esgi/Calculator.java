package com.esgi;

import java.util.List;
import java.util.function.BiFunction;

public class Calculator {
    String operation;
    List<Integer> numbers;

    public Calculator(List<Integer> numbers, String operation) {
        this.operation = operation;
        this.numbers = numbers;
    }

    public void start() {
        ConsoleOutputLogger.logStart(operation);

        int result = applyOperation();

        ConsoleOutputLogger.logEnd(result);
    }

    private int applyOperation() {
        int initialValue;
        BiFunction<Integer, Integer, Integer> accumulator;

        switch (operation) {
            case "+" -> {
                initialValue = 0;
                accumulator = Integer::sum;
            }
            case "-" -> {
                initialValue = 0;
                accumulator = (acc, x) -> acc - x;
            }
            case "*" -> {
                initialValue = 1;
                accumulator = (acc, x) -> acc * x;
            }
            default -> {
                ConsoleOutputLogger.logError("Invalid operation: " + operation);
                return 0;
            }
        }

        return numbers.stream().reduce(initialValue, (acc, x) -> {
            int newAcc = accumulator.apply(acc, x);
            ConsoleOutputLogger.logIteration(
                    x,
                    acc == initialValue,
                    operation,
                    newAcc,
                    numbers.indexOf(x) + 1
            );
            return newAcc;
        });
    }
}
