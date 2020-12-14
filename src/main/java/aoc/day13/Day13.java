/**
 * aoc2020
 * Created by Ida Hellkvist on 2020-12-13.
 * <p>
 * Built with ♥ at Frost°, http://frostdigital.se
 */

package aoc.day13;

import aoc.Day;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Day13 implements Day {
    @Override
    public String part1(String input) {
        List<String> rows = Arrays.stream(input.split("\n")).collect(Collectors.toList());
        long earliest = Long.parseLong(rows.get(0));
        String[] buses = rows.get(1).replaceAll(",x", "").split(",");
        List<Long> busesList = Arrays.stream(buses)
                .map(Long::parseLong)
                .collect(toList());

        HashMap<Long, Long> busTable = new HashMap<>();

        for (Long bus : busesList) {
            busTable.put(bus, closestNumber(earliest, bus));
        }


        Optional<Map.Entry<Long, Long>> min = busTable.entrySet()
                .stream()
                .min(Comparator.comparingLong(Map.Entry::getValue));
        //.map(Map.Entry::getValue);

        //System.out.println("along key: " + min.get().getKey() + "va: " + min.get().getValue());

        return String.valueOf((min.get().getValue() - earliest) * min.get().getKey());
    }

    @Override
    public String part2(String input) {
        List<String> rows = Arrays.stream(input.split("\n")).collect(Collectors.toList());
        //long earliest = Long.parseLong(rows.get(0));
        String[] buses = rows.get(1).split(",");

        /*List<Long> busesList = Arrays.stream(buses)
                .map(Long::parseLong)
                .collect(toList());*/

        System.out.println(85 % 84);
        //7,13,x,x,59,x,31,19
        /*
        7
        12 13
        21 26
        28
        35 39
        42
        49 52
        56
        63 65
        70 72
        77
        84 85

        * */
        long earliest = 0;
        boolean goOn = true;
        int i = 1;
        int index = 0;
        while (goOn) {
            if (Long.valueOf(buses[index * i + 1]) % Long.valueOf(buses[index * i]) == 0) {

            } else {

            }
        }

        return "0";
    }

    private Long closestNumber(long n, Long m) {
        {
            // find the quotient
            long q = n / m;
            // System.out.println("**********");
            //System.out.println("n: " + n);
            //System.out.println("m: " + m);
            //System.out.println("q: " + q);

            // 1st possible closest number
            long n1 = m * q;
            //System.out.println("n1: " + n1);

            // 2nd possible closest number
            long n2 = (n * m) > 0 ? (m * (q + 1)) : (m * (q - 1));
            //System.out.println("n2: " + n2);

            long smallest = 0L;

            // if true, then n1 is the required closest number
            if (Math.abs(n - n1) < Math.abs(n - n2)) {
                //System.out.println("n1");
                smallest = n1;
            } else {
                // else n2 is the required closest number
                //System.out.println("n2");
                smallest = n2;
            }

            //System.out.println("n: " + n + " q: " + q + " smallest: " + getNumber(n, q, smallest));
            return getNumber(n, q, smallest);
        }
    }

    private Long getNumber(long n, long q, long smallest) {
        if (n < smallest) {
            return smallest;
        } else {
            return getNumber(n, q, smallest + q);
        }
    }
}
