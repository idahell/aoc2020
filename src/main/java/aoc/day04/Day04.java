package aoc.day04;

import aoc.Day;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day04 implements Day {

    private List<String> VALID_EYE_COLORS = Collections.unmodifiableList(Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth"));

    @Override
    public String part1(String input) {

        long count = formatInput(input).stream()
                .filter(this::isValidPassportPart1)
                .count();

        return String.valueOf(count);
    }

    private List<String> formatInput(String input) {
        return Arrays.stream(input.split("\n\n"))
                .map(s -> s.replaceAll("\n", " "))
                .collect(Collectors.toList());
    }

    private boolean isValidPassportPart1(String s) {
        return s.contains("ecl")
                && s.contains("pid")
                && s.contains("eyr")
                && s.contains("hcl")
                && s.contains("byr")
                && s.contains("iyr")
                && s.contains("hgt");
    }

    @Override
    public String part2(String input) {
        List<String> formattedInput = formatInput(input);

        long count = formattedInput.stream()
                .filter(this::isValidPassportPart2)
                .count();

        return String.valueOf(count);
    }

    private boolean isValidPassportPart2(String string) {

        HashMap<String, String> fields = new HashMap<>();

        String[] split = string.split(" ");

        for (String s : split) {
            if (!s.isEmpty()) {
                String[] strings = s.split(":");
                fields.put(strings[0], strings[1]);
            }
        }

        return byrIsValid(fields.get("byr"))
                && iyrIsValid(fields.get("iyr"))
                && eyrIsValid(fields.get("eyr"))
                && hgtIsValid(fields.get("hgt"))
                && hclIsValid(fields.get("hcl"))
                && eclIsValid(fields.get("ecl"))
                && pidIsValid(fields.get("pid"));
    }

    private boolean byrIsValid(String s) {
        return s != null && !s.isEmpty() && inRange(s, 1920, 2002);
    }

    private boolean iyrIsValid(String s) {
        return s != null && !s.isEmpty() && inRange(s, 2010, 2020);
    }

    private boolean eyrIsValid(String s) {
        return s != null && !s.isEmpty() && inRange(s, 2020, 2030);
    }

    private boolean hgtIsValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        if (s.contains("cm")) {
            return inRange(s.split("cm")[0], 150, 193);
        } else if (s.contains("in")) {
            return inRange(s.split("in")[0], 59, 76);
        } else {
            return false;
        }
    }

    private boolean hclIsValid(String s) {
        return s != null && !s.isEmpty() && Pattern.compile("#[0-9a-f]{6}").matcher(s).matches();
    }

    private boolean eclIsValid(String s) {
        return s != null && !s.isEmpty() && VALID_EYE_COLORS.contains(s);
    }

    private boolean pidIsValid(String s) {
        return s != null && !s.isEmpty() && Pattern.compile("[0-9]{9}").matcher(s).matches();
    }

    private boolean inRange(String number, int min, int max) {
        return Integer.valueOf(number) >= min && Integer.valueOf(number) <= max;
    }
}
