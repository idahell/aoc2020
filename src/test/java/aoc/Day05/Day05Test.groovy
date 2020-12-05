package aoc.Day05

import spock.lang.Specification

class Day05Test extends Specification {
    def "Should get highest seat number correctly in part 1"() {
        String seatIds = "FBFBBFFRLR\nBFFFBBFRRR\nFFFBBBFRRR\nBBFFBBFRLL"
        expect:
        new Day05().part1(seatIds) == "820"
    }

}
