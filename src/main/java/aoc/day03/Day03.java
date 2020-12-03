package main.java.aoc.day03;

import main.java.aoc.Day;

import java.util.List;

public class Day03 implements Day {

    @Override
    public String part1(List<String> input) {
        return String.valueOf(getTreesForSlope(input, 3, 1));
    }

    @Override
    public String part2(List<String> input) {
        int sum = getTreesForSlope(input, 1, 1)
                * getTreesForSlope(input, 3, 1)
                * getTreesForSlope(input, 5, 1)
                * getTreesForSlope(input, 7, 1)
                * getTreesForSlope(input, 1, 2);

        return String.valueOf(sum);
    }

    private int getTreesForSlope(List<String> input, int right, int down) {
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
