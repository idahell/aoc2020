package aoc.day08;

import aoc.Day;

import java.util.ArrayList;
import java.util.List;

import static aoc.Utils.formatInput;

public class Day08 implements Day {
    @Override
    public String part1(String input) {
        List<String> formattedInput = formatInput(input);

        int i = 0;
        boolean goOn = true;
        List<Integer> visited = new ArrayList<>();
        int sum = 0;

        while (goOn) {
            final Integer index = i;

            if (visited.stream().anyMatch(v -> v.equals(index)) || i > formattedInput.size() - 1) {
                goOn = false;
            } else {
                String command = formattedInput.get(i).split(" ")[0];
                if ("nop".equals(command)) {
                    visited.add(index);
                    i++;
                } else if ("acc".equals(command)) {
                    sum = getSum(formattedInput, i, visited, sum, index);
                    i++;
                } else if ("jmp".equals(command)) {
                    i = getSum(formattedInput, i, visited, i, index);
                }
            }
        }

        System.out.println(sum);
        return String.valueOf(sum);
    }

    private int getSum(List<String> formattedInput, int i, List<Integer> visited, int sum, Integer index) {
        String[] plus = formattedInput.get(i).split("\\+");
        String[] minus = formattedInput.get(i).split("-");
        visited.add(index);
        if (plus.length == 1) {
            sum -= Integer.valueOf(minus[1]);
        } else {
            sum += Integer.valueOf(plus[1]);
        }
        return sum;
    }

    @Override
    public String part2(String input) {
        List<String> formattedInput = formatInput(input);

        int max = formattedInput.size() - 1;

        int finalSum = 0;

        for (int j = 0; j < max; j++) {
            int i = 0;
            boolean goOn = true;
            List<Integer> visited = new ArrayList<>();
            int sum = 0;
            boolean swapped = false;

            while (goOn) {
                final Integer index = i;

                if (i > formattedInput.size() - 1) {
                    finalSum = sum;
                    System.out.println("FINAL " + finalSum);
                    goOn = false;
                } else {
                    String command = formattedInput.get(i).split(" ")[0];
                    if (i == j) {
                        if (swapped) {
                            goOn = false;
                        } else if (!command.equals("acc")) {
                            command = command.equals("nop") ? "jmp" : "nop";
                            swapped = true;
                        }
                    }

                    if (visited.stream().anyMatch(v -> v.equals(index)) || i > formattedInput.size() - 1) {
                        goOn = false;
                    } else {
                        if (command.equals("nop")) {
                            visited.add(index);
                            i++;
                        } else if (command.equals("acc")) {
                            sum = getSum(formattedInput, i, visited, sum, index);
                            i++;
                        } else if (command.equals("jmp")) {
                            i = getSum(formattedInput, i, visited, i, index);
                        }
                    }
                }
            }
        }

        return String.valueOf(finalSum);
    }
}
