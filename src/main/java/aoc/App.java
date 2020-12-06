package aoc;

import aoc.Day05.Day05;
import aoc.day01.Day01;
import aoc.day02.Day02;
import aoc.day03.Day03;
import aoc.day04.Day04;
import aoc.day06.Day06;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class App {

    private static final Map<Integer, Day> DAYS;

    public static void main(String[] args) {
        int day = 6;
        if (args.length != 0) {
            day = Integer.parseInt(args[0]);
        }

        int part = 2;
        if (args.length > 1) {
            part = Integer.parseInt(args[1]);
        }

        String input = loadInput(day);

        String result;
        if (part == 1) {
            result = DAYS.get(day).part1(input);
        } else {
            result = DAYS.get(day).part2(input);
        }

        System.out.println(result);
    }

    private static String loadInput(int day) {
        String paddedDay = String.valueOf(day);
        if (day < 10) {
            paddedDay = "0" + day;
        }
        String fileName = "day" + paddedDay + ".txt";

        String relativeFilePath = "src/main/resources/";

        String data;

        try {
            data = new String(Files.readAllBytes(Paths.get(relativeFilePath + fileName)));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return data;
    }

    static {
        DAYS = new HashMap<>();
        DAYS.put(1, new Day01());
        DAYS.put(2, new Day02());
        DAYS.put(3, new Day03());
        DAYS.put(4, new Day04());
        DAYS.put(5, new Day05());
        DAYS.put(6, new Day06());
    }
}