package aoc.day03


import spock.lang.Specification


class Day03Test extends Specification {

    def "Should count trees correctly in part 1"() {
        String rows = "..##.......\n#...#...#..\n.#....#..#.\n..#.#...#.#\n.#...##..#.\n..#.##.....\n.#.#.#....#\n.#........#\n#.##...#...\n#...##....#\n.#..#...#.#"

        expect:
        new Day03().part1(rows) == "7"
    }

    def "Should count trees correctly in part 2"() {
        String rows = "..##.......\n#...#...#..\n.#....#..#.\n..#.#...#.#\n.#...##..#.\n..#.##.....\n.#.#.#....#\n.#........#\n#.##...#...\n#...##....#\n.#..#...#.#"

        expect:
        new Day03().part2(rows) == "336"
    }

}