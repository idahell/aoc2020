package aoc.Day05;

import aoc.Day;

import java.util.List;
import java.util.stream.Collectors;

import static aoc.Utils.formatInput;

public class Day05 implements Day {
    @Override
    public String part1(String input) {
        List<String> formattedInput = formatInput(input);

        return formattedInput.stream()
                .reduce("0", (acc, value) -> {
                    Integer seatId = getSeatId(value);
                    return seatId > Integer.valueOf(acc) ? String.valueOf(seatId) : acc;
                });
    }

    @Override
    public String part2(String input) {
        List<String> formattedInput = formatInput(input);
        List<Integer> boardingPasses = formattedInput.stream()
                .map(this::getSeatId)
                .sorted()
                .collect(Collectors.toList());

        return String.valueOf(boardingPasses.stream().reduce(boardingPasses.get(0), (acc, value) -> acc + 1 == value ? value : acc) + 1);
    }

    private Integer getSeatId(String value) {
        return getRow(value) * 8 + getColumn(value);
    }

    private Integer getRow(String value) {
        char[] rowIndexes = value.substring(0, 7).toCharArray();

        int rowMin = 0;
        int rowMax = 127;

        for (char s : rowIndexes) {
            if (String.valueOf(s).equals("F")) {
                rowMax = (rowMax + rowMin - 1) / 2;
            } else {// == B
                rowMin = (rowMax + rowMin + 1) / 2;
            }
        }

        return (String.valueOf(rowIndexes[6]).equals("F") ? rowMin : rowMax);
    }

    private Integer getColumn(String value) {
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

        return (String.valueOf(columnIndexes[2]).equals("L") ? columnMin : columnMax);
    }
}
