package aoc.Day05;

import aoc.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day05 implements Day {
    @Override
    public String part1(String input) {
        List<String> formattedInput = Arrays.stream(input.split("\n")).collect(Collectors.toList());
        String highestSeatId = formattedInput.stream()
                .reduce("0", (acc, value) -> {
                    //.map(value -> {
                    int rowMin = 0;
                    int rowMax = 127;

                    char[] rowIndexes = value.substring(0, 7).toCharArray();

                    for (char s : rowIndexes) {
                        if (String.valueOf(s).equals("F")) {
                            rowMax = (rowMax + rowMin - 1) / 2;
                        } else {// == B
                            rowMin = (rowMax + rowMin + 1) / 2;
                        }
                        //System.out.println(s + "::: min: " + rowMin + " max: " + rowMax);
                    }

                    //System.out.println(rowIndexes);
                    long row = String.valueOf(rowIndexes[6]).equals("F") ? rowMin : rowMax;

                    char[] columnIndexes = value.substring(7, 10).toCharArray();

                    int columnMin = 0;
                    int columnMax = 7;

                    for (char s : columnIndexes) {
                        if (String.valueOf(s).equals("L")) {
                            columnMax = (columnMax + columnMin - 1) / 2;
                        } else {// == R
                            columnMin = (columnMax + columnMin + 1) / 2;
                        }
                    }

                    //System.out.println(columnIndexes);
                    long column = String.valueOf(columnIndexes[2]).equals("L") ? columnMin : columnMax;

                    long seatId = row * 8 + column;
                    //System.out.println(seatId);

                    return seatId > Integer.valueOf(acc) ? String.valueOf(seatId) : acc;

                });
        //.count();
        return highestSeatId;

    }

    @Override
    public String part2(String input) {
        List<String> formattedInput = Arrays.stream(input.split("\n")).collect(Collectors.toList());
        List<Integer> boardingPasses = formattedInput.stream()
                //.reduce("0", (acc, value) -> {
                .map(value -> {
                    int rowMin = 0;
                    int rowMax = 127;

                    char[] rowIndexes = value.substring(0, 7).toCharArray();

                    for (char s : rowIndexes) {
                        if (String.valueOf(s).equals("F")) {
                            rowMax = (rowMax + rowMin - 1) / 2;
                        } else {// == B
                            rowMin = (rowMax + rowMin + 1) / 2;
                        }
                        //System.out.println(s + "::: min: " + rowMin + " max: " + rowMax);
                    }

                    //System.out.println(rowIndexes);
                    Integer row = String.valueOf(rowIndexes[6]).equals("F") ? rowMin : rowMax;

                    char[] columnIndexes = value.substring(7, 10).toCharArray();

                    int columnMin = 0;
                    int columnMax = 7;

                    for (char s : columnIndexes) {
                        if (String.valueOf(s).equals("L")) {
                            columnMax = (columnMax + columnMin - 1) / 2;
                        } else {// == R
                            columnMin = (columnMax + columnMin + 1) / 2;
                        }
                    }

                    //System.out.println(columnIndexes);
                    Integer column = String.valueOf(columnIndexes[2]).equals("L") ? columnMin : columnMax;

                    Integer seatId = row * 8 + column;
                    //System.out.println(seatId);

                    return seatId;
                    //return String.valueOf(Integer.valueOf(acc) + seatId);
                }).sorted().collect(Collectors.toList());
        //.count();*/

        System.out.println(boardingPasses);
        //Integer sum = boardingPasses.stream().reduce(0, (acc, value) -> acc + value);
        /*int expectedSum = IntStream.rangeClosed(8, 1015).sum();

        System.out.println(expectedSum + " - " + actualSum + " = " + (expectedSum - Integer.valueOf(actualSum)));

        return String.valueOf(expectedSum - Integer.valueOf(actualSum));*/

        List<Integer> emptySeats = new ArrayList<>();

        for (int i = 1; i < boardingPasses.size() - 1; i++) {
            Integer thisSeat = boardingPasses.get(i);
            if (thisSeat - boardingPasses.get(i - 1) > 1 || boardingPasses.get(i + 1) - thisSeat > 1) {
                emptySeats.add(thisSeat);
            }
        }

        System.out.println(emptySeats);
        return String.valueOf(emptySeats.get(0) + 1);

    }
}
