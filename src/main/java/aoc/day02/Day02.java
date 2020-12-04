package aoc.day02;

import aoc.Day;

import static java.util.stream.Collectors.toList;


public class Day02 implements Day {
    public static void main(String[] args) {
    }

    @Override
    public String part1(String input) {
        /*return String.valueOf(input.stream()
                .filter(this::filterPredicatePart1)
                .collect(toList()).size());*/
        return "";
    }

    @Override
    public String part2(String input) {
        /*
        return String.valueOf(input.stream()
                .filter(this::filterPredicatePart2)
                .collect(toList()).size());*/
        return "";
    }

    private boolean filterPredicatePart2(String s) {
        PasswordItem passwordItem = new PasswordItem(s).invoke();
        return positionContainsLetter(passwordItem, passwordItem.min) ^ positionContainsLetter(passwordItem, passwordItem.max);
    }

    private boolean positionContainsLetter(PasswordItem passwordItem, int position) {
        return String.valueOf(letterAtPosition(passwordItem, position)).equals(passwordItem.letter);
    }

    private char letterAtPosition(PasswordItem passwordItem, int pos) {
        return passwordItem.password.charAt(pos - 1);
    }

    private boolean filterPredicatePart1(String s) {
        PasswordItem passwordItem = new PasswordItem(s).invoke();

        int count = passwordItem.password.chars()
                .mapToObj(i -> (char) i)
                .filter(c -> String.valueOf(c).equals(passwordItem.letter))
                .collect(toList()).size();
        return count >= passwordItem.min && count <= passwordItem.max;
    }

    private class PasswordItem {
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
}
