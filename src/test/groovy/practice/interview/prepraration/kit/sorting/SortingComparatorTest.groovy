package practice.interview.prepraration.kit.sorting

import spock.lang.Specification

import static practice.interview.prepraration.kit.sorting.Player.createPlayer

class SortingComparatorTest extends Specification {

    def "testComparator0"() {
        given:
        Player[] playersArray = new Player[2];
        playersArray[0] = createPlayer("aba", 2)
        playersArray[1] = createPlayer("aaa", 2)

        when:
        Arrays.sort(playersArray, new SortingComparator())
        println(Arrays.toString(playersArray))

        then:
        playersArray[0].name.equals("aaa")
    }

    def "testComparator1"() {
        given:
        Player[] playersArray = new Player[3];
        playersArray[0] = createPlayer("aab", 2)
        playersArray[1] = createPlayer("aaa", 2)
        playersArray[2] = createPlayer("aaaa", 2)

        when:
        Arrays.sort(playersArray, new SortingComparator())
        Arrays.stream(playersArray).forEach{n -> println(n.name)}

        then:
        playersArray[0].name.equals("aaa")
    }

    def "testComparator2"() {
        given:
        Player[] playersArray = new Player[4];
        playersArray[0] = createPlayer("aab", 2)
        playersArray[1] = createPlayer("aaa", 2)
        playersArray[2] = createPlayer("aaab", 2)
        playersArray[3] = createPlayer("aaaa", 2)

        when:
        Arrays.sort(playersArray, new SortingComparator())
        Arrays.stream(playersArray).forEach{n -> println(n.name)}

        then:
        playersArray[0].name.equals("aaa")
    }

    def "testComparator3"() {
        given:
        Player[] playersArray = new Player[4];
        playersArray[0] = createPlayer("aab", 5)
        playersArray[1] = createPlayer("aaa", 2)
        playersArray[2] = createPlayer("aaab", 1)
        playersArray[3] = createPlayer("aaaa", 100)

        when:
        Arrays.sort(playersArray, new SortingComparator())
        Arrays.stream(playersArray).forEach{n -> println(n.name + " " + n.score)}

        then:
        playersArray[0].name.equals("aaaa")
    }

    def "testComparator5"() {
        given:
        Player[] playersArray = new Player[20];
        playersArray[0] = createPlayer("b", 3)
        playersArray[1] = createPlayer("a", 1)
        playersArray[2] = createPlayer("bb", 3)
        playersArray[3] = createPlayer("b", 8)
        playersArray[4] = createPlayer("bba", 0)
        playersArray[5] = createPlayer("bb", 2)
        playersArray[6] = createPlayer("bca", 6)
        playersArray[7] = createPlayer("ccc", 4)
        playersArray[8] = createPlayer("b", 3)
        playersArray[9] = createPlayer("ab", 8)
        playersArray[10] = createPlayer("bb", 3)
        playersArray[11] = createPlayer("bb", 7)
        playersArray[12] = createPlayer("ccb", 8)
        playersArray[13] = createPlayer("bbb", 2)
        playersArray[14] = createPlayer("aab", 8)
        playersArray[15] = createPlayer("b", 6)
        playersArray[16] = createPlayer("ab", 8)
        playersArray[17] = createPlayer("cb", 9)
        playersArray[18] = createPlayer("cbb", 8)
        playersArray[19] = createPlayer("ba", 9)

        when:
        Arrays.sort(playersArray, new SortingComparator())
        Arrays.stream(playersArray).forEach{n -> println(n.name + " " + n.score)}

        then:
        playersArray[12].name.equals("b")
        playersArray[13].name.equals("b")
        playersArray[14].name.equals("bb")
        playersArray[15].name.equals("bb")
    }

    def "testComparator6"() {
        given:
        Player[] playersArray = new Player[20];
        playersArray[0] = createPlayer("b", 3)
        playersArray[1] = createPlayer("a", 1)
        playersArray[2] = createPlayer("bb", 3)
        playersArray[3] = createPlayer("b", 8)
        playersArray[4] = createPlayer("bba", 0)
        playersArray[5] = createPlayer("bb", 2)
        playersArray[6] = createPlayer("bca", 6)
        playersArray[7] = createPlayer("ccc", 4)
        playersArray[8] = createPlayer("b", 3)
        playersArray[9] = createPlayer("ab", 8)
        playersArray[10] = createPlayer("bbc", 3)
        playersArray[11] = createPlayer("bb", 7)
        playersArray[12] = createPlayer("ccb", 8)
        playersArray[13] = createPlayer("bbb", 2)
        playersArray[14] = createPlayer("aab", 8)
        playersArray[15] = createPlayer("b", 6)
        playersArray[16] = createPlayer("ab", 8)
        playersArray[17] = createPlayer("cb", 9)
        playersArray[18] = createPlayer("cbb", 8)
        playersArray[19] = createPlayer("ba", 9)

        when:
        Arrays.sort(playersArray, new SortingComparator())
        Arrays.stream(playersArray).forEach{n -> println(n.name + " " + n.score)}

        then:
        playersArray[12].name.equals("b")
        playersArray[13].name.equals("b")
        playersArray[14].name.equals("bb")
        playersArray[15].name.equals("bbc")
    }

}
