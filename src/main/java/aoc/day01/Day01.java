package aoc.day01;

import aoc.Day;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Day01 implements Day {
    public static void main(String[] args) {
    }

    @Override
    public String part1(String input) {
        /*List<Integer> numbers = formatInput(input);

        return numbers.stream()
                .reduce(1, (acc, value) -> {
                    int diff = 2020 - value;
                    if (numbers.contains(diff)) {
                        return diff * value;
                    } else {
                        return acc;
                    }
                }).toString();*/
        return "";
    }

    @Override
    public String part2(String input) {
        /*List<Integer> numbers = formatInput(input);

        int product = 0;

        for (Integer i : numbers) {
            for (Integer j : numbers) {
                int l = 2020 - i - j;
                if (numbers.contains(l)) {
                    product = i * j * l;
                }
            }
        }

        return String.valueOf(product);*/
        return "";
    }

    private List<Integer> formatInput(List<String> input) {
        return input.stream()
                .map(Integer::valueOf)
                .collect(toList());
    }
}
