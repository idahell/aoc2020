package aoc.day09;

import aoc.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static aoc.Utils.formatInputToLongList;

public class Day09 implements Day {
    @Override
    public String part1(String input) {
        List<Long> formattedInput = formatInputToLongList(input);
        int preamble = 25;
        Long firstInvalid = 0L;
        for (int i = preamble; i < formattedInput.size() - 1; i++) {
            if (!isValid(formattedInput.get(i), formattedInput.subList(i - preamble, i))) {
                System.out.println(formattedInput.get(i));
                firstInvalid = formattedInput.get(i);
            }
        }

        return String.valueOf(firstInvalid);
    }

    private boolean isValid(Long number, List<Long> formattedInput) {
        boolean isValid = false;
        for (Long value : formattedInput) {
            Long find = number - value;
            if (formattedInput.stream().anyMatch(in -> in.equals(find) && !find.equals(value))) {
                isValid = true;
            }
        }
        return isValid;
    }

    @Override
    public String part2(String input) {
        // number from part 1: 507622668
        long firstInvalid = 507622668L;
        //long firstInvalid = 127L;
        List<Long> formattedInput = formatInputToLongList(input);
        List<Long> range = new ArrayList<>();
        int i = 0;

        while (i < formattedInput.size() - 1) {
            Long sum = range.stream().reduce(0L, (acc, value) -> acc + value);
            if (sum == firstInvalid) {
                break;
            } else if (sum > firstInvalid) {
                range.remove(0);
            } else {
                range.add(formattedInput.get(i));
                i++;
            }
        }

        List<Long> sorted = range.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted.get(0) + sorted.get(sorted.size() - 1));
        return String.valueOf(sorted.get(0) + sorted.get(sorted.size() - 1));
    }
}
