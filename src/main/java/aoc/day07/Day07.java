package aoc.day07;

import aoc.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day07 implements Day {
    @Override
    public String part1(String input) {
        List<String> rules = Arrays.stream(input.split("\n"))
                .map(s -> s.replaceAll(" ", "").replaceAll("\\.", ""))
                .collect(Collectors.toList());

        String myBag = "shinygold";

        List<String> lookingFor = Collections.singletonList("shinygold");
        List<String> result = new ArrayList<>();
        List<String> searchQueue = new ArrayList<>();

        while (searchQueue.size() > 0) {
            searchQueue = Collections.emptyList();
            for (int i = 0; i < lookingFor.size(); i++) {
                System.out.println("lookingFor " + lookingFor.get(i));
                for (int j = 0; j < rules.size(); j++) {
                    System.out.println("rule " + rules.get(j));
                    if (rules.get(j).contains(lookingFor.get(i))) {
                        System.out.println(rules.get(j).split("bagscontain")[0]);
                        searchQueue.add(rules.get(j).split("bagscontain")[0]);
                        result.add(rules.get(j).split("bagscontain")[0]);
                    }
                }
            }
            lookingFor = searchQueue;
        }

        System.out.println("result.size " + result.size());
        return String.valueOf(result.size());


       /* List<String> rules = Arrays.stream(input.split("\n"))
                .map(s -> s.replaceAll(" ", "").replaceAll("\\.", ""))
                .reduce(0, (acc, value) -> {
                    String[] split = value.split("bagscontain");
                    acc[split[0]] =
                })
*/
        /*
        const rules = input.reduce(function (acc, line) {
        const split = line.split(" bags contain ");
        acc[split[0]] = split[1].split(",").map(function (child) {
            const bag = (/\d+ (\w+ \w+) bags?/g).exec(child);
            return bag ? bag[1] : undefined;
        }).filter(bag => bag);

        return acc;
    }, {});*/

        /*List<String> formattedInput = Arrays.stream(input.split("\n"))
                .map(s -> s.replaceAll(" ", "").replaceAll("\\.", ""))
                .collect(Collectors.toList());

        String myBag = "shinygoldbag";

        //contain myBag?
        //
        System.out.println(myBag);
        List<String> filtered = formattedInput.stream().filter(rule -> checkContains(formattedInput, rule, myBag)).distinct().collect(Collectors.toList());
        System.out.println("FILTERED: " + filtered);
        */

        /*formattedInput.stream().filter(rule -> {
            if (ruleContainsBag(rule, myBag)) {
                return true;
            } else {
                formattedInput.stream().filter(rule2 -> {
                    String bag = rule.split("contain")[0];
                    if (ruleContainsBag(rule2, bag)) {
                        return true;
                    }
                });
            }

        })*/
        /*List<String> firstLevelrules = formattedInput.stream()
                .filter(rule -> {
                    if (!rule.contains("shinygoldbag")) {
                        return false;
                    } else if (rule.split("contain")[0].contains("shiny")) {
                        return false;
                    }
                    return true;
                }).collect(Collectors.toList());
                */

        /*for (String rule : firstLevelrules) {
            String bag = rule.split("contain")[0];
            System.out.println(bag);
        }*/

        /*List<String> secondLevelrules = formattedInput.stream()
                .filter(rule -> {
                    boolean ruleContainsFirstLevelBag = false;
                    for (String firstLevelRule : firstLevelrules) {
                        String firstBag = firstLevelRule.split("contain")[0];
                        firstBag = firstBag.substring(0, firstBag.length() - 1);
                        if (!rule.contains(firstBag)) {
                            ruleContainsFirstLevelBag = false;
                        } else if (rule.split("contain")[0].contains(firstBag)) {
                            ruleContainsFirstLevelBag = false;
                        } else {
                            //System.out.println(firstBag + " :: " + rule);
                            ruleContainsFirstLevelBag = true;
                        }
                    }
                    return ruleContainsFirstLevelBag;
                }).distinct().collect(Collectors.toList());

        System.out.println(firstLevelrules.size() + secondLevelrules.size());*/
        /*System.out.println(filtered.size());

        return String.valueOf(filtered.size());*/

    }

    @Override
    public String part2(String input) {
        return null;
    }

    private boolean checkContains(List<String> formattedInput, String rule, String myBag) {
        if (rule.contains("nootherbags")) {
            return false;
        } else if (ruleContainsBag(rule, myBag)) {
            return true;
        } else {
            boolean contains = false;
            //System.out.println("CHECK: " + rule);
            for (String bag : getBags(rule)) {
                String rule2 = getRuleForBag(formattedInput, bag);
                contains = checkContains(formattedInput, rule2, myBag);
            }
            return contains;
        }
    }

    private String getRuleForBag(List<String> formattedInput, String bag) {
        List<String> filtered = formattedInput.stream()
                .filter(rule -> rule.split("contain")[0].contains(bag))
                .collect(Collectors.toList());
        //System.out.println("get rule: " + filtered);
        return filtered.get(0);
    }

    private String[] getBags(String rule) {
        //String[] bags = new String[0];
        //System.out.println("get bag: " + rule);
        String[] split = rule.split("contain")[1].split(",");
        for (int i = 0; i < split.length; i++) {
            //System.out.println("get bag split: " + split[i]);
            split[i] = split[i].substring(1);
            //System.out.println("get bag split trimmed: " + split[i]);
        }
        return split;
    }

    boolean ruleContainsBag(String rule, String bag) {
        //System.out.println("Rule contains bag ? " + rule + " BAG: " + bag);
        if (!rule.contains(bag)) {
            return false;
        } else {
            return !rule.split("contain")[0].contains(bag);
        }
    }
}
