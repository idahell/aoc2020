package aoc.day06;

import aoc.Day;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Day06 implements Day {
    @Override
    public String part1(String input) {
        Integer sum = formatInputPart1(input).stream()
                .map(this::countDistinct)
                .reduce(0, (acc, value) -> acc + value);
        System.out.println(sum);
        return String.valueOf(sum);
    }

    @Override
    public String part2(String input) {
        Integer sum = formatInputPart2(input).stream()
                .map(this::countPart2)
                .reduce(0, (acc, value) -> acc + value);
        System.out.println(sum);
        return String.valueOf(sum);
    }

    private List<String> formatInputPart2(String input) {
        return Arrays.stream(input.split("\n\n"))
                .collect(Collectors.toList());
    }

    private Integer countPart2(String s) {
        long rows = Arrays.stream(s.split("\n")).count();

        List<Character> allAnswers = s.replaceAll("\n", "")
                .chars()
                .mapToObj(i -> (char) i)
                .collect(toList());

        return Math.toIntExact(s.replaceAll("\n", "")
                .chars()
                .mapToObj(i -> (char) i)
                .distinct()
                .filter(da -> allAnswers.stream()
                        .filter(aa -> aa.equals(da))
                        .count() == rows)
                .count());
    }

    private List<String> formatInputPart1(String input) {
        return Arrays.stream(input.split("\n\n"))
                .map(s -> s.replaceAll("\n", ""))
                .collect(Collectors.toList());
    }

    private Integer countDistinct(String s) {
        return Math.toIntExact(s
                .chars()
                .distinct()
                .count());
    }
}
