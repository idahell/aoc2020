package aoc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Utils {
    public static List<Integer> formatInputToIntList(String input) {
        return Utils.formatInput(input).stream()
                .map(Integer::valueOf)
                .collect(toList());
    }

    public static List<String> formatInput(String input) {
        return Arrays.stream(input.split("\n")).collect(Collectors.toList());
    }

    public static List<Long> formatInputToLongList(String input) {
        return Utils.formatInput(input).stream()
                .map(Long::parseLong)
                .collect(toList());
    }
}
