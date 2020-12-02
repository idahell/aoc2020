package main.java.aoc;

import main.java.aoc.day01.Day01;
import main.java.aoc.day02.Day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class App {

    private static final Map<Integer, Day> DAYS;

    public static void main(String[] args) {
        int day = 1;
        if (args.length != 0) {
            day = Integer.parseInt(args[0]);
        }

        int part = 2;
        if (args.length > 1) {
            part = Integer.parseInt(args[1]);
        }

        List<String> input = loadInput(day);

        String result;
        if (part == 1) {
            result = DAYS.get(day).part1(input);
        } else {
            result = DAYS.get(day).part2(input);
        }

        System.out.println(result);
    }

    private static List<String> loadInput(int day) {
        String paddedDay = String.valueOf(day);
        if (day < 10) {
            paddedDay = "0" + day;
        }
        String fileName = "day" + paddedDay + ".txt";

        String relativeFilePath = "main/resources/";

        try (BufferedReader r = new BufferedReader(new InputStreamReader(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream(relativeFilePath + fileName))))) {
            return r.lines().collect(toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    static {
        DAYS = new HashMap<>();
        DAYS.put(1, new Day01());
        DAYS.put(2, new Day02());
    }
}