package main.java.aoc.day01;

import main.java.aoc.Day;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Day01 implements Day {
    public static void main(String[] args) {
    }

    @Override
    public String part1(List<String> input) {
        List<Integer> numbers = input.stream()
                .map(Integer::valueOf)
                .collect(toList());

        Integer number1 = 0;
        Integer number2 = 0;

        for (Integer number : numbers) {
            List<Integer> filtered = numbers.stream()
                    .filter(n -> 2020 - number == n)
                    .collect(toList());

            if (!filtered.isEmpty()) {
                number1 = number;
                number2 = filtered.get(0);
                break;
            }
        }

        //System.out.println("number1: " + number1 + " number2: " + number2);
        return String.valueOf(number1 * number2);
    }

    @Override
    public String part2(List<String> input) {
        List<Integer> numbers = input.stream()
                .map(Integer::valueOf)
                .collect(toList());

        Integer number1 = 0;
        Integer number2 = 0;
        Integer number3 = 0;

        for (Integer i : numbers) {
            for (Integer j : numbers) {
                for (Integer k : numbers) {
                    if (i + j + k == 2020) {
                        number1 = i;
                        number2 = j;
                        number3 = k;
                        break;
                    }
                }
            }
        }

        //System.out.println("number1: " + number1 + " number2: " + number2 + " number3: " + number3);
        return String.valueOf(number1 * number2 * number3);
    }
}
