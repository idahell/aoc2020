/**
 * aoc2020
 * Created by Ida Hellkvist on 2020-12-12.
 * <p>
 * Built with ♥ at Frost°, http://frostdigital.se
 */

package aoc.day10;

import aoc.Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static aoc.Utils.formatInputToIntList;

public class Day10 implements Day {
    @Override
    public String part1(String input) {
        List<Integer> formattedInput = formatInputToIntList(input).stream().sorted().collect(Collectors.toList());
        List<Integer> diffs = new ArrayList<>();

        for (int i = 1; i < formattedInput.size(); i++) {
            diffs.add(formattedInput.get(i) - formattedInput.get(i - 1));
        }

        diffs.add(3);
        diffs.add(1);
        return String.valueOf(diffs.stream().filter(d -> d == 1).count() * diffs.stream().filter(d -> d == 3).count());

    }

    @Override
    public String part2(String input) {
        List<Integer> formattedInput = formatInputToIntList(input).stream().sorted().collect(Collectors.toList());
        System.out.println(formattedInput);
        HashMap<Integer, List<Integer>> adapters = new HashMap<>();
        for (int i = 0; i < formattedInput.size() - 1; i++) {
            List<Integer> possibilities = new ArrayList<>();
            for (int j = 1; j < 4; j++) {
                //System.out.println(formattedInput.get(i + j) + " < " + formattedInput.get(i) + " + 4 ? " + (formattedInput.get(i + j) < formattedInput.get(i) + 4));
                if (i + j < formattedInput.size()) {
                    if (formattedInput.get(i + j) < formattedInput.get(i) + 4) {
                        possibilities.add(formattedInput.get(i + j));
                    }
                }
            }
            adapters.put(formattedInput.get(i), possibilities);
        }
        System.out.println(adapters + " + " + adapters.get(formattedInput.get(0)));
        //int sum = 0;
        Integer start = formattedInput.get(0);
        int sum = 0;



        /*for (int way : adapters.get(start)) {
            System.out.println("start: " + start + "-> " + way);
            System.out.println("ways: " + adapters.get(way));
            // if (adapters.get(way) != null) {
            System.out.println("WAY: " + way);
            for (int w : adapters.get(way)) {
                sum += getNumberOfWays(adapters, w);
                System.out.println("SUM: " + sum);
            }
            /*} else {
                sum++;
            }*/
        //}
        return String.valueOf(sum);
    }

    int getNumberOfWays(HashMap<Integer, List<Integer>> adapters, int way) {
        int sum = 0;
        System.out.println("GETT: " + adapters.get(way));
        if (adapters.get(way) != null) {
            for (int w : adapters.get(way)) {
                System.out.println(way + " -> " + w);
                return getNumberOfWays(adapters, w);
            }
        } else {
            sum++;
            System.out.println("s: " + sum);
        }

        //return ways.size();
        return sum;
    }
}
