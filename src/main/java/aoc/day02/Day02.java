package main.java.aoc.day02;

import main.java.aoc.Day;
import main.java.aoc.day02.Day02.Part1;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;


public class Day02 implements Day {
    public static void main(String[] args) {
    }

    @Override
    public String part1(List<String> input) {
        return processInput(input, Part1);
    }

    /*private <T extends MyFilter> String processInput(List<String> input, Class<T> clazz) {

        if (!clazz.isInstance(MyFilter.class)) {
            return "0";
        } else {
            return String.valueOf(input.stream()
                    .filter(s -> clazz.filter(s))
                    .collect(toList()).size());
        }
    }*/

    @Override
    public String part2(List<String> input) {
        return String.valueOf(input.stream()
                .filter(Part2::filter)
                .collect(toList()).size());
    }

    //https://www.codementor.io/@eh3rrera/using-java-8-method-reference-du10866vx??
    public String processInput(
            List<String> input, Function<List<String>, String> f) {
        return String.valueOf(input.stream()
                .filter(s -> clazz.filter(s))
                .collect(toList()).size());
    }

    /*private static class Part1 implements MyFilter {

        static boolean filter(String s) {
            PasswordItem passwordItem = new PasswordItem(s).invoke();

            int count = passwordItem.password.chars()
                    .mapToObj(i -> (char) i)
                    .filter(c -> String.valueOf(c).equals(passwordItem.letter))
                    .collect(toList()).size();
            return count >= passwordItem.min && count <= passwordItem.max;
        }
    }*/

    private static class PasswordItem {
        String s;
        int min;
        int max;
        String letter;
        String password;

        PasswordItem(String s) {
            this.s = s;
        }

        PasswordItem invoke() {
            String[] subs1 = s.split("-");
            String[] subs2 = subs1[1].split(" ");

            min = Integer.valueOf(subs1[0]);
            max = Integer.valueOf(subs2[0]);
            letter = subs2[1].split(":")[0];
            password = subs2[2];
            return this;
        }
    }

    private static class Part2 implements MyFilter {

        static boolean filter(String s) {
            PasswordItem passwordItem = new PasswordItem(s).invoke();
            return positionContainsLetter(passwordItem, passwordItem.min) ^ positionContainsLetter(passwordItem, passwordItem.max);
        }

        private static boolean positionContainsLetter(PasswordItem passwordItem, int position) {
            return String.valueOf(letterAtPosition(passwordItem, position)).equals(passwordItem.letter);
        }

        private static char letterAtPosition(PasswordItem passwordItem, int pos) {
            return passwordItem.password.charAt(pos - 1);
        }
    }

    class Part1 {
        boolean filter(String s) {
            PasswordItem passwordItem = new PasswordItem(s).invoke();

            int count = passwordItem.password.chars()
                    .mapToObj(i -> (char) i)
                    .filter(c -> String.valueOf(c).equals(passwordItem.letter))
                    .collect(toList()).size();
            return count >= passwordItem.min && count <= passwordItem.max;
        }
    }
}
