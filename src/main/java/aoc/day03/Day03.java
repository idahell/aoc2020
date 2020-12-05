package aoc.day03;

import aoc.Day;

import java.util.List;

import static aoc.Utils.formatInput;

public class Day03 implements Day {

    @Override
    public String part1(String input) {
        return String.valueOf(getTreesForSlope(formatInput(input), 3, 1));
    }

    @Override
    public String part2(String input) {

        List<String> formattedInput = formatInput(input);

        long sum = getTreesForSlope(formattedInput, 1, 1)
                * getTreesForSlope(formattedInput, 3, 1)
                * getTreesForSlope(formattedInput, 5, 1)
                * getTreesForSlope(formattedInput, 7, 1)
                * getTreesForSlope(formattedInput, 1, 2);

        return String.valueOf(sum);
    }

    private long getTreesForSlope(List<String> input, int right, int down) {
        int sumOfTrees = 0;
        int index = 0;
        for (int i = 0; i < input.size(); i += down) {
            if (String.valueOf(input.get(i).trim().charAt(index)).equals("#")) {
                sumOfTrees++;
            }
            index = (index + right) % input.get(i).trim().length();
        }

        return sumOfTrees;
    }
}
